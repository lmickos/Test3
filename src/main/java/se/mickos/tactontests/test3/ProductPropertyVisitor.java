package se.mickos.tactontests.test3;

/**
 * Created by Lars-Erik on 2017-01-11.
 */
public interface ProductPropertyVisitor {
    /**
     * The visitor is visiting a "property leaf" in the hierartchy tree
     * @param prop The property visited
     * @return True if the visit should continue. False if the visit should be aborted ended as fast as possible.
     * Implementations may use this for both error hendling/premature abort situations or non error situations
     * (e.g. when enough data has been collected)
     */
    boolean visit(AttributeProductProperty prop);

    /**
     * The visitor is entering a property group
     * @param group The group entered
     * @return True if the visit should continue. False if the visit should be aborted ended as fast as possible.
     * If true is returned, leave() MAY NOT BE EXECUTED for this visit
     * Implementations may use this for both error hendling/premature abort situations or non error situations
     * (e.g. when enough data has been collected)
     */
    boolean enter(AttributeGroupProductProperty group);

    /**
     * The visitor is leaving a property group
     * @param group The group we are about to exit
     * @param interrupted A boolean that indicates if the visit was interrupted (aborted or prematurely finished)
     *                    since entering (the matching enter() for this level).
     * @return True if the visit should continue. False if the visit should be aborted ended as fast as possible.
     * Implementations may use this for both error hendling/premature abort situations or non error situations
     * (e.g. when enough data has been collected)
     */
    boolean leave(AttributeGroupProductProperty group, boolean interrupted);
}
