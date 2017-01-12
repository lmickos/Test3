package se.mickos.tactontests.test3;

import org.junit.Before;
import org.junit.Test;

import java.io.StringWriter;
import java.io.Writer;

import static org.junit.Assert.*;

/**
 * Created by Lars-Erik on 2017-01-11.
 */
public class ProductTest {
    private static final String NAME1 = "Product";
    private static final String KEY1 = "key1";
    private static final String VALUE1 = "value1";
    StringWriter out;

    @Before
    public void setUp(){
        out = new StringWriter(1000);
    }

    /** Make a print test with no property */
    @Test
    public void print_noAttribute() throws Exception {
        // Set up data
        AttributeGroupProductProperty props = new AttributeGroupProductProperty();
        Product prod = new Product(props);
        // Execute tested method
        prod.print(out);
        String result = out.toString();
        // Verify results
        assertEquals("Result should be the correct JSON",
                "{\"name\":P\"roduct Attributes\",\n"
                +"properties:[\n"
                +"]"
                ,result);
    }

    /** Make a print test with one property */
    @Test
    public void print_oneAttribute() throws Exception {
        AttributeProductProperty prop1 = new AttributeProductProperty(KEY1,VALUE1);
        AttributeGroupProductProperty group1 = new AttributeGroupProductProperty(prop1);
        // Set up data
        AttributeGroupProductProperty props = new AttributeGroupProductProperty();
        Product prod = new Product(props);
        // Execute tested method
        prod.print(out);
        String result = out.toString();
        // Verify results
        assertEquals("Result should be the correct JSON",
                "{\"name\":P\"roduct Attributes\",\n"
                        +"properties:[\n"
                        +"\""+KEY1+"\":\""+VALUE1+"\"\n"
                        +"]"
                ,result);
    }

    /** Make a print test with one print group containing one property */
    @Test
    public void print_oneGroup() throws Exception {

    }

    /** Make a print test with one print group containing one property */
    @Test
    public void print_oneGroupOneProperty() throws Exception {

    }

    /** Do a print test as defined in the test criteria */
    @Test
    public void print_GivenHierarchy() throws Exception {

    }

}