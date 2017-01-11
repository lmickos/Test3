package se.mickos.tactontests.test3;

/**
 * A class that can make a visit journey through an hierarchy and output the structure to a given Writer "stream"
 * Created by Lars-Erik on 2017-01-11.
 */
public class PrintVisitor implements ProductPropertyVisitor {
    public boolean visit(AttributeProductProperty prop) {
        return false;
    }

    public boolean enter(AttributeGroupProductProperty group) {
        return false;
    }

    public boolean leave(AttributeGroupProductProperty group) {
        return false;
    }
}
