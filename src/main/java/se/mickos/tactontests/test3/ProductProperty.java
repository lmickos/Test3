package se.mickos.tactontests.test3;

/**
 * A class for items that can participtate in an attribute hierarchy
 * Created by Lars-Erik on 2017-01-11.
 */
public abstract class ProductProperty {
    private String name="";

    /**
     * Default constructor
     */
    public ProductProperty(){
    }

    /**
     * Constructor with data setup
     * @param name Name of the property
     */
    public ProductProperty(String name){
        this.name=name;
    }
    /**
     * Retrieve the name of the property
     * @return Name as a string. May be null.
     */
    public String getName(){
        return name;
    }

    /**
     * Visitor pattern accept method
     * @param  visitor The visiting object
     * @return True if the visit should continue. False if the visit should be aborted ended as fast as possible.
     * Implementations may use this for both error hendling/premature abort situations or non error situations
     * (e.g. when enough data has been collected)
     */
    public abstract boolean accept(ProductPropertyVisitor visitor);
}
