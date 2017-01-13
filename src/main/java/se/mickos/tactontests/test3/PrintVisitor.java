package se.mickos.tactontests.test3;

import java.io.IOException;
import java.io.Writer;

/**
 * A class that can make a visit journey through an hierarchy and output the structure to a given Writer "stream"
 * Created by Lars-Erik on 2017-01-11.
 */
public class PrintVisitor implements ProductPropertyVisitor {
    final private Writer out;
    private String separator="";

    // Allows us to inspect an error later, when visitor finished
    public Exception lastException = null;
    private int currentLevel=0;

    /**
     * Constructor
     * @param out The writer to print to
     */
    public PrintVisitor(Writer out){
        this.out=out;
    }

    /**
     * Indicates a tree leaf visit
     * @param prop The property visited
     * @return True if visiting should continue
     */
    public boolean visit(AttributeProductProperty prop) {
        try {
            // Write the separator, if enabled, before the eol
            out.write(separator);
            out.write("\n");
            // Write the key/value tuple
            indent(); // Make sure we get the right indent
            out.write("{\""+prop.getName()+"\":\""+prop.getValue()+"\"}");
        } catch (IOException e) {
            lastException = e;
            e.printStackTrace();
            return false;
        }
        // Make sure the separator is enabled from here until we enter something again
        separator = ",";
        return true;
    }

    /**
     * Indicates entering a tree "branch" (an attribute group)
     * @param group The group entered
     * @return True if visiting should continue
     */
    public boolean enter(AttributeGroupProductProperty group) {
        try {
            // For all groups except the first start with a newline if it is enabled
            if (currentLevel!=0) {
                out.write(separator);
                out.write("\n");
            }
            // Write the group header
            indent(); // Make sure we get the right indent
            out.write("{\"name\":\""+group.getName()+"\",\n");
            // Write the start of group contents
            indent(); // Make sure we get the right indent
            out.write(" \"properties\":[");
            // Make sure the separator is disabled from here until we have visited or left
            separator="";
        } catch (IOException e) {
            lastException = e;
            e.printStackTrace();
            return false;
        }
        currentLevel++;
        return true;
    }

    private void indent() throws IOException {
        for (int i = 0; i < currentLevel; i++) out.write("   ");
    }

    /**
     * Indicates leaving a tree "branch" (an attribute group) after handling the contents
     * @param group The group we are about to exit
     * @param interrupted A boolean that indicates if the visit was interrupted (aborted or prematurely finished)
     *                    since entering (the matching enter() for this level).
     * @return True if visiting should continue
     */
    public boolean leave(AttributeGroupProductProperty group, boolean interrupted) {
        try {
            currentLevel--;
            out.write("\n");
            indent(); // Make sure we get the right indent
            out.write("]}");
            if (currentLevel==0) out.write("\n");
        } catch (IOException e) {
            lastException = e;
            e.printStackTrace();
            return false;
        }
        // Make sure the separator is enabled from here on until we enter something again
        separator = ",";
        // Abort the higher levels too, if we were interrupted
        return !interrupted;
    }
}
