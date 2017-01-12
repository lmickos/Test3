package se.mickos.tactontests.test3;

import java.io.Writer;

/**
 * A class that can make a visit journey through an hierarchy and output the structure to a given Writer "stream"
 * Created by Lars-Erik on 2017-01-11.
 */
public class PrintVisitor implements ProductPropertyVisitor {
    final private Writer out;

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
        return false;
    }

    /**
     * Indicates entering a tree "branch" (an attribute group)
     * @param group The group entered
     * @return True if visiting should continue
     */
    public boolean enter(AttributeGroupProductProperty group) {
        return false;
    }

    /**
     * Indicates leaving a tree "branch" (an attribute group) after handling the contents
     * @param group The group we are about to exit
     * @param interrupted A boolean that indicates if the visit was interrupted (aborted or prematurely finished)
     *                    since entering (the matching enter() for this level).
     * @return True if visiting should continue
     */
    public boolean leave(AttributeGroupProductProperty group, boolean interrupted) {
        return false;
    }
}
