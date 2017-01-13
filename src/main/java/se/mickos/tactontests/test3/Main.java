package se.mickos.tactontests.test3;

import java.io.PrintWriter;

/**
 * A main class with a main method to demonstrate the results of the given task
 * Created by Lars-Erik on 2017-01-12.
 */
public class Main {
    private static final String ROOT_NAME = "Product Attributes";
    private static final String NAME1 = "Attributes 1";
    private static final String NAME2 = "Attributes 2";
    private static final String NAME3 = "Attributes 3";
    private static final String KEY1 = "Attribute 1";
    private static final String VALUE1 = "Value 1";
    private static final String KEY2 = "Attribute 2";
    private static final String VALUE2 = "Value 2";
    private static final String KEY3 = "Attribute 3";
    private static final String VALUE3 = "Value 3";
    private static final String KEY4 = "Attribute 4";
    private static final String VALUE4 = "Value 4";
    private static final String KEY5 = "Attribute 5";
    private static final String VALUE5 = "Value 5";

    public static void main (String[] arg) {
        AttributeProductProperty prop1 = new AttributeProductProperty(KEY1, VALUE1);
        AttributeProductProperty prop2 = new AttributeProductProperty(KEY2, VALUE2);
        AttributeProductProperty prop3 = new AttributeProductProperty(KEY3, VALUE3);
        AttributeProductProperty prop4 = new AttributeProductProperty(KEY4, VALUE4);
        AttributeProductProperty prop5 = new AttributeProductProperty(KEY5, VALUE5);
        AttributeGroupProductProperty group3 = new AttributeGroupProductProperty(NAME3, prop4);
        AttributeGroupProductProperty group2 = new AttributeGroupProductProperty(NAME2, group3, prop5);
        AttributeGroupProductProperty group1 = new AttributeGroupProductProperty(NAME1, prop1, prop2);
        AttributeGroupProductProperty props = new AttributeGroupProductProperty(ROOT_NAME, group1, prop3, group2);
        Product prod = new Product(props);
        PrintWriter outWriter = new PrintWriter(System.out, true);
        prod.print(outWriter);
        outWriter.flush();
    }
}
