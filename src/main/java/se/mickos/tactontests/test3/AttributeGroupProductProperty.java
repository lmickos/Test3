package se.mickos.tactontests.test3;

import java.util.*;

/**
 * Class that represents an attribute group.
 * Implements a compatible subset of the List<ProductProperty> interface
 * Created by Lars-Erik on 2017-01-11.
 */
public class AttributeGroupProductProperty extends ProductProperty {
    List<ProductProperty> subProps = new ArrayList();

    /**
     * Default Constructor
     */
    public AttributeGroupProductProperty(){

    }

    /**
     * Constructor with initial data
     * @param properties A list of properties to add
     */
    public AttributeGroupProductProperty(List<ProductProperty> properties){

    }

    /**
     * Visitor pattern accept method
     * @param  visitor The visiting object
     * @return True if the visit should continue. False if the visit should be aborted
     */
    public boolean accept(ProductPropertyVisitor visitor){
        if (visitor.enter(this)){
            // Loop all sub propoerties in correct order and accept, but abort if any call returns false
            for (ProductProperty prop:subProps){
                if (!prop.accept(visitor)) return false;
            }
            return visitor.leave(this);
        } else return false;
    }

    /** Size of the group */
    public int size() {
        return 0;
    }

    /** Add a new property at the end of the group */
    public boolean add(ProductProperty productProperty) {
        return false;
    }

    /** Get the property at the given position */
    public ProductProperty get(int index) {
        return null;
    }

/*
The following methods are candidates for future implementation

    public ProductProperty set(int index, ProductProperty element) {
        return null;
    }

    public void add(int index, ProductProperty element) {

    }

    public ProductProperty remove(int index) {
        return null;
    }
*/

}
