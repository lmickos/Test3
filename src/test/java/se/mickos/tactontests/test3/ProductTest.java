package se.mickos.tactontests.test3;

import org.junit.Before;
import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.*;

/**
 * JUnit test for the Product class (and its contained classes)
 * Created by Lars-Erik on 2017-01-11.
 */
public class ProductTest {
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

    StringWriter out;

    @Before
    public void setUp(){
        out = new StringWriter(1000);
    }

    /** Make a print test with no property */
    @Test
    public void print_noContent() throws Exception {
        // Set up data
        AttributeGroupProductProperty props = new AttributeGroupProductProperty(ROOT_NAME);
        Product prod = new Product(props);
        // Execute tested method
        prod.print(out);
        String result = out.toString();
        // Verify results
        assertEquals("Result should be the correct JSON",
                "{\"name\":\""+ ROOT_NAME +"\",\n"
                +" \"properties\":[\n"
                +"]}\n"
                ,result);
    }

    /** Make a print test with one property */
    @Test
    public void print_oneAttribute() throws Exception {
        // Set up data
        AttributeProductProperty prop1 = new AttributeProductProperty(KEY1,VALUE1);
        AttributeGroupProductProperty props = new AttributeGroupProductProperty(ROOT_NAME, prop1);
        Product prod = new Product(props);
        // Execute tested method
        prod.print(out);
        String result = out.toString();
        // Verify results
        assertEquals("Result should be the correct JSON",
                "{\"name\":\""+ ROOT_NAME +"\",\n"
                +" \"properties\":[\n"
                +"   {\""+KEY1+"\":\""+VALUE1+"\"}\n"
                +"]}\n"
                ,result);
    }

    /** Make a print test with one print group containing one property */
    @Test
    public void print_oneGroup() throws Exception {
        // Set up data
        AttributeGroupProductProperty group1 = new AttributeGroupProductProperty(NAME1);
        AttributeGroupProductProperty props = new AttributeGroupProductProperty(ROOT_NAME, group1);
        Product prod = new Product(props);
        // Execute tested method
        prod.print(out);
        String result = out.toString();
        // Verify results
        assertEquals("Result should be the correct JSON",
                "{\"name\":\""+ ROOT_NAME +"\",\n"
                        +" \"properties\":[\n"
                        +"   {\"name\":\""+ NAME1 +"\",\n"
                        +"    \"properties\":[\n"
                        +"   ]}\n"
                        +"]}\n"
                ,result);
    }

    /** Make a print test with one print group containing one property */
    @Test
    public void print_oneGroupOneProperty() throws Exception {
        // Set up data
        AttributeProductProperty prop1 = new AttributeProductProperty(KEY1,VALUE1);
        AttributeGroupProductProperty group1 = new AttributeGroupProductProperty(NAME1);
        AttributeGroupProductProperty props = new AttributeGroupProductProperty(ROOT_NAME, group1,prop1);
        Product prod = new Product(props);
        // Execute tested method
        prod.print(out);
        String result = out.toString();
        // Verify results
        assertEquals("Result should be the correct JSON",
                "{\"name\":\""+ ROOT_NAME +"\",\n"
                        +" \"properties\":[\n"
                        +"   {\"name\":\""+ NAME1 +"\",\n"
                        +"    \"properties\":[\n"
                        +"   ]},\n"
                        +"   {\""+KEY1+"\":\""+VALUE1+"\"}\n"
                        +"]}\n"
                ,result);
    }

    /** Do a print test as defined in the test criteria */
    @Test
    public void print_GivenHierarchy() throws Exception {
        // Set up data
        AttributeProductProperty prop1 = new AttributeProductProperty(KEY1,VALUE1);
        AttributeProductProperty prop2 = new AttributeProductProperty(KEY2,VALUE2);
        AttributeProductProperty prop3 = new AttributeProductProperty(KEY3,VALUE3);
        AttributeProductProperty prop4 = new AttributeProductProperty(KEY4,VALUE4);
        AttributeProductProperty prop5 = new AttributeProductProperty(KEY5,VALUE5);
        AttributeGroupProductProperty group3 = new AttributeGroupProductProperty(NAME3,prop4);
        AttributeGroupProductProperty group2 = new AttributeGroupProductProperty(NAME2,group3,prop5);
        AttributeGroupProductProperty group1 = new AttributeGroupProductProperty(NAME1,prop1,prop2);
        AttributeGroupProductProperty props = new AttributeGroupProductProperty(ROOT_NAME, group1,prop3,group2);
        Product prod = new Product(props);
        // Execute tested method
        prod.print(out);
        String result = out.toString();
        // Verify results
        assertEquals("Result should be the correct JSON",
                "{\"name\":\""+ ROOT_NAME +"\",\n"
                        +" \"properties\":[\n"
                        +"   {\"name\":\""+ NAME1 +"\",\n"
                        +"    \"properties\":[\n"
                        +"      {\""+KEY1+"\":\""+VALUE1+"\"},\n"
                        +"      {\""+KEY2+"\":\""+VALUE2+"\"}\n"
                        +"   ]},\n"
                        +"   {\""+KEY3+"\":\""+VALUE3+"\"},\n"
                        +"   {\"name\":\""+ NAME2 +"\",\n"
                        +"    \"properties\":[\n"
                        +"      {\"name\":\""+ NAME3 +"\",\n"
                        +"       \"properties\":[\n"
                        +"         {\""+KEY4+"\":\""+VALUE4+"\"}\n"
                        +"      ]},\n"
                        +"      {\""+KEY5+"\":\""+VALUE5+"\"}\n"
                        +"   ]}\n"
                        +"]}\n"
                ,result);
    }

}