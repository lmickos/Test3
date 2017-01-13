package se.mickos.tactontests.test3;

import java.util.*;

/**
 * Class that represents an attribute group.
 * Mostly implements a compatible subset of the List<ProductProperty> interface
 * Created by Lars-Erik on 2017-01-11.
 */
public class AttributeGroupProductProperty extends ProductProperty {
    List<ProductProperty> subProps = new ArrayList<ProductProperty>();

    /**
     * Default Constructor
     */
    public AttributeGroupProductProperty(){
        // Do nothing
    }

    /**
     * Constructor with initial list data
     * @param properties A list of properties to add
     */
    public AttributeGroupProductProperty(String name, List<ProductProperty> properties){
        super(name);
        subProps.addAll(properties);
    }

    /**
     * Constructor with initial array data
     * @param properties A list of properties to add
     */
    public AttributeGroupProductProperty(String name, ProductProperty... properties){
        super(name);
        for (ProductProperty prop:properties) subProps.add(prop);
    }

    /**
     * Visitor pattern accept method
     * @param  visitor The visiting object
     * @return True if the visit should continue. False if the visit should be aborted
     */
    public boolean accept(ProductPropertyVisitor visitor){
        boolean interrupted=false;
        // Indicate to visitor tha we are entering a tree branch
        if (visitor.enter(this)){
            // Loop all sub properties in correct order and accept, but abort if any call returns false
            for (ProductProperty prop:subProps){
                if (!prop.accept(visitor)) { // In case the visitor want to it can abort the looping of subproperties
                    // Forward the information that we aborted. Although it was initiated from the visitor,
                    // it may not be a stateful visitor and it could have been aborted by the host
                    interrupted = true;
                    break;
                }
            }
        }
        // Indicate to visitor that we are leaving a tree branch
        return visitor.leave(this, interrupted);
    }

    /** Size of the group */
    public int size() {
        return subProps.size();
    }

    /** Add a new property at the end of the group */
    public boolean add(ProductProperty productProperty) {
        return subProps.add(productProperty);
    }

    /** Get the property at the given position */
    public ProductProperty get(int index) {
        return null;
    }

    /** Adda a collection of preperties */
    public boolean addAll(Collection<? extends ProductProperty> c){
        return subProps.addAll(c);
    }

    /** Add a property at a given position */
    public void add(int index, ProductProperty element) {
        subProps.add(index, element);
    }

    /**
     * Copy the properties from another group into this
     * @param group The group to copy from
     * @param copyName Indicate whether to copy the name and overwrite the current name.
     */
    public void copyFrom(AttributeGroupProductProperty group, boolean copyName){
        addAll(group.subProps);
        if (copyName) setName(group.getName());
    }

/*
The following methods are candidates for future implementation

    public ProductProperty set(int index, ProductProperty element) {
        return null;
    }


    public ProductProperty remove(int index) {
        return null;
    }
*/

}
