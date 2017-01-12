package se.mickos.tactontests.test3;

import java.io.Writer;

/**
 * Class that represents a product
 * Created by Lars-Erik on 2017-01-11.
 */
public class Product {
    AttributeGroupProductProperty properties;
    AttributeGroupProductProperty name;

    /**
     * Default constructor
     */
    public Product(){

    }

    /**
     * Constructor with data setup
     * @param props The properties to use. The given object is used as is (not coped)
     *              and may be changed by internal implementations any time hereafter
     */
    public Product(AttributeGroupProductProperty props){
        setProperties(props);
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
     *
     * @param props The properties to use. Overrides existing properties. The given object is used as is (not coped)
     *              and may be changed by internal implementations any time hereafter
     */
    public void setProperties(AttributeGroupProductProperty props){
        this.properties=props;
    }

    public AttributeGroupProductProperty getProperties(){
        return properties;
    }
}
