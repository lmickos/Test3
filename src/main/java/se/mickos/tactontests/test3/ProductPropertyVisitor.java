package se.mickos.tactontests.test3;

/**
 * Created by Lars-Erik on 2017-01-11.
 */
public interface ProductPropertyVisitor {
    /**
     * The visitor is visiting a "property leaf" in the hierartchy tree
     * @param prop The property visited
     */
    void visit(AttributeProductProperty prop);

    /**
     * The visitor is entering a property group
     * @param group The group entered
     */
    void enter(AttributeGroupProductProperty group);

    /**
     * The visitor is leaving a property group
     * @param group The group we are about to exit
     */
    void leave(AttributeGroupProductProperty group);
}
