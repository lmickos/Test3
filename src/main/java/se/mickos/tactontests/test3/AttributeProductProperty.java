package se.mickos.tactontests.test3;

/**
 * Class that represents an attribute
 * Created by Lars-Erik on 2017-01-11.
 */
public class AttributeProductProperty extends ProductProperty {
    private String value="";
//    /**
//     * Default Constructor
//     */
//    public AttributeProductProperty(){
//
//    }

    /**
     * Constructor with initial data
     * @param name Name of the property
     * @param value Value of the property
     */
    public AttributeProductProperty(String name, String value){
        super(name);
    }

    /**
     * Getter for the property value
     */
    public String getValue(){
        return value;
    }

    /**
     * Visitor pattern accept method
     * @param  visitor The visiting object
     * @return True if the visit should continue. False if the visit should be aborted
     */
    public boolean accept(ProductPropertyVisitor visitor){
        return visitor.visit(this);
    }
}
