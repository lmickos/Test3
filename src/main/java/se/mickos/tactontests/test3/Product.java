package se.mickos.tactontests.test3;

import java.io.Writer;

/**
 * Class that represents a product
 * Created by Lars-Erik on 2017-01-11.
 */
public class Product {
    final AttributeGroupProductProperty properties;

    /**
     * Default constructor
     */
    public Product(){
        properties=new AttributeGroupProductProperty();
    }

    /**
     * Constructor with data setup
     * @param props The properties to use. The given object is used as is (not copied)
     *              and may be changed by internal implementations any time hereafter
     */
    public Product(AttributeGroupProductProperty props){
        properties=props;
    }

    /**
     * Print the product to a given output writer stream
     * @param out The writer to print output to
     */
    public void print(Writer out){
        PrintVisitor printWriter = new PrintVisitor(out);
        properties.accept(printWriter);
    }

    /**
     * Adds the properties of this product using a given property group.
     * The name of the product is set to the name of the given property, if not null
     * @param props The properties to use. Overrides existing properties. The given object is used as is (not coped)
     *              and may be changed by internal implementations any time hereafter
     */
    public void copyProperties(AttributeGroupProductProperty props){
        copyProperties(props,props.getName()!=null);
    }

    /**
     * Adds the properties of this product using a given property group.
     * @param props The properties to use. Overrides existing properties. The given object is used as is (not coped)
     *              and may be changed by internal implementations any time hereafter
     * @param copyName Indicate whether to copy the name and overwrite the current name.
     */
    public void copyProperties(AttributeGroupProductProperty props, boolean copyName){
        this.properties.copyFrom(props,copyName);
    }

    /** Get the product name */
    public String getName(){
        return properties.getName();
    }

    /** Get the product name */
    public void setName(String name){
        properties.setName(name);
    }

    /** Get the complete set of product properties */
    AttributeGroupProductProperty getProperties(){
        return properties;
    }

}
