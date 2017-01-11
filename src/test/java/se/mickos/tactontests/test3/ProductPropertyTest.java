package se.mickos.tactontests.test3;

import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 * Created by Lars-Erik on 2017-01-11.
 */
public class ProductPropertyTest {
    private static final String KEY1 = "key1";
    private static final String VALUE1 = "value1";

    @Test
    public void visitHierarchy_with_OneAttribute(){
        // Set up data
        AttributeProductProperty prop1 = new AttributeProductProperty(KEY1,VALUE1);
        ProductPropertyVisitor visitor = mock(ProductPropertyVisitor.class);
        when(visitor.visit(prop1)).thenReturn(true);
        // Execute tested method
        boolean result = prop1.accept(visitor);
        // Verify results
        assertEquals("accept should return true for normal executions",true,result);
        verify(visitor,only()).visit(prop1);
    }

    @Test
    public void visitHierarchy_with_MultipleAttributes(){
        // Set up data
        // Execute tested method
        // Verify results
    }

    @Test
    public void visitHierarchy_with_OneAttributeAndOneGroup(){
        // Set up data
        // Execute tested method
        // Verify results
    }

    @Test
    public void visitHierarchy_with_OneOneGroupContainingOneAttribute(){
        // Set up data
        // Execute tested method
        // Verify results
    }

    @Test
    public void visitHierarchy_with_complexHierarchy(){
        // Set up data
        // Execute tested method
        // Verify results
    }

}