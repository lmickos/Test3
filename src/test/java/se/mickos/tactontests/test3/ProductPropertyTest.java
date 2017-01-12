package se.mickos.tactontests.test3;

import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 * Created by Lars-Erik on 2017-01-11.
 */
public class ProductPropertyTest {
    private static final String KEY1 = "key1";
    private static final String VALUE1 = "value1";
    private static final String KEY2 = "key2";
    private static final String VALUE2 = "value2";
    private static final String KEY3 = "key3";
    private static final String VALUE3 = "value3";

    @Test
    public void visit_with_OneAttribute(){
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
    public void visit_with_OneEmptyGroup(){
        // Set up data
        AttributeGroupProductProperty group1 = new AttributeGroupProductProperty();
        ProductPropertyVisitor visitor = mock(ProductPropertyVisitor.class);
        when(visitor.enter(group1)).thenReturn(true);
        when(visitor.leave(group1,false)).thenReturn(true);
        // Execute tested method
        boolean result = group1.accept(visitor);
        // Verify results
        assertEquals("accept should return true for normal executions",true,result);
        InOrder order = inOrder(visitor);
        order.verify(visitor,times(1)).enter(group1);
        order.verify(visitor,times(1)).leave(group1,false);
        order.verifyNoMoreInteractions();
    }

    @Test
    public void visitHierarchy_with_MultipleAttributes(){
        // Set up data
        AttributeProductProperty prop1 = new AttributeProductProperty(KEY1,VALUE1);
        AttributeProductProperty prop2 = new AttributeProductProperty(KEY2,VALUE2);
        AttributeProductProperty prop3 = new AttributeProductProperty(KEY3,VALUE3);
        AttributeGroupProductProperty group1 = new AttributeGroupProductProperty(prop1,prop2,prop3);
        ProductPropertyVisitor visitor = mock(ProductPropertyVisitor.class);
        when(visitor.visit(any(AttributeProductProperty.class))).thenReturn(true);
        when(visitor.enter(group1)).thenReturn(true);
        when(visitor.leave(group1,false)).thenReturn(true);
        // Execute tested method
        boolean result = group1.accept(visitor);
        // Verify results
        assertEquals("accept should return true for normal executions",true,result);
        InOrder order = inOrder(visitor);
        order.verify(visitor).enter(group1);
        order.verify(visitor).visit(prop1);
        order.verify(visitor).visit(prop2);
        order.verify(visitor).visit(prop3);
        order.verify(visitor).leave(group1,false);
        order.verifyNoMoreInteractions();
    }

    @Test
    public void visitHierarchy_with_OneAttributeAndOneGroup(){
        // Set up data
        AttributeProductProperty prop1 = new AttributeProductProperty(KEY1,VALUE1);
        AttributeGroupProductProperty group2 = new AttributeGroupProductProperty();
        AttributeGroupProductProperty group1 = new AttributeGroupProductProperty(prop1,group2);
        ProductPropertyVisitor visitor = mock(ProductPropertyVisitor.class);
        when(visitor.visit(prop1)).thenReturn(true);
        when(visitor.enter(any(AttributeGroupProductProperty.class))).thenReturn(true);
        when(visitor.leave(any(AttributeGroupProductProperty.class),eq(false))).thenReturn(true);
        // Execute tested method
        boolean result = group1.accept(visitor);
        // Verify results
        assertEquals("accept should return true for normal executions",true,result);
        InOrder order = inOrder(visitor);
        order.verify(visitor).enter(group1);
        order.verify(visitor).visit(prop1);
        order.verify(visitor).enter(group2);
        order.verify(visitor).leave(group2,false);
        order.verify(visitor).leave(group1,false);
        order.verifyNoMoreInteractions();
    }

    @Test
    public void visitHierarchy_with_OneGroupContainingOneAttribute(){
        // Set up data
        AttributeProductProperty prop1 = new AttributeProductProperty(KEY1,VALUE1);
        AttributeGroupProductProperty group2 = new AttributeGroupProductProperty(prop1);
        AttributeGroupProductProperty group1 = new AttributeGroupProductProperty(group2);
        ProductPropertyVisitor visitor = mock(ProductPropertyVisitor.class);
        when(visitor.visit(prop1)).thenReturn(true);
        when(visitor.enter(any(AttributeGroupProductProperty.class))).thenReturn(true);
        when(visitor.leave(any(AttributeGroupProductProperty.class),eq(false))).thenReturn(true);
        // Execute tested method
        boolean result = group1.accept(visitor);
        // Verify results
        assertEquals("accept should return true for normal executions",true,result);
        InOrder order = inOrder(visitor);
        order.verify(visitor).enter(group1);
        order.verify(visitor).enter(group2);
        order.verify(visitor).visit(prop1);
        order.verify(visitor).leave(group2,false);
        order.verify(visitor).leave(group1,false);
        order.verifyNoMoreInteractions();
    }

    @Test
    public void visitHierarchy_with_OneAttribute_AbortBefore(){
        // Set up data
        AttributeProductProperty prop1 = new AttributeProductProperty(KEY1,VALUE1);
        AttributeGroupProductProperty group1 = new AttributeGroupProductProperty(prop1);
        ProductPropertyVisitor visitor = mock(ProductPropertyVisitor.class);
        when(visitor.visit(prop1)).thenReturn(true);
        when(visitor.enter(group1)).thenReturn(false);
        when(visitor.leave(group1,false)).thenReturn(false);
        // Execute tested method
        boolean result = group1.accept(visitor);
        // Verify results
        assertEquals("accept should return false for abnormal executions",false,result);
        InOrder order = inOrder(visitor);
        order.verify(visitor).enter(group1);
        order.verify(visitor).leave(group1,false);
        order.verifyNoMoreInteractions();
    }

    @Test
    public void visitHierarchy_with_OneAttribute_AbortAfter(){
        // Set up data
        AttributeProductProperty prop1 = new AttributeProductProperty(KEY1,VALUE1);
        AttributeGroupProductProperty group1 = new AttributeGroupProductProperty(prop1);
        ProductPropertyVisitor visitor = mock(ProductPropertyVisitor.class);
        when(visitor.visit(prop1)).thenReturn(true);
        when(visitor.enter(group1)).thenReturn(true);
        when(visitor.leave(group1,false)).thenReturn(false);
        // Execute tested method
        boolean result = group1.accept(visitor);
        // Verify results
        assertEquals("accept should return false for abnormal executions",false,result);
        InOrder order = inOrder(visitor);
        order.verify(visitor).enter(group1);
        order.verify(visitor).visit(prop1);
        order.verify(visitor).leave(group1,false);
        order.verifyNoMoreInteractions();
    }

    @Test
    public void visitHierarchy_with_OneAttribute_AbortIn(){
        // Set up data
        AttributeProductProperty prop1 = new AttributeProductProperty(KEY1,VALUE1);
        AttributeGroupProductProperty group1 = new AttributeGroupProductProperty(prop1);
        ProductPropertyVisitor visitor = mock(ProductPropertyVisitor.class);
        when(visitor.visit(prop1)).thenReturn(false);
        when(visitor.enter(group1)).thenReturn(true);
        when(visitor.leave(group1,false)).thenReturn(true);
        // Execute tested method
        boolean result = group1.accept(visitor);
        // Verify results
        assertEquals("accept should return false for abnormal executions",false,result);
        InOrder order = inOrder(visitor);
        order.verify(visitor).enter(group1);
        order.verify(visitor).visit(prop1);
        order.verify(visitor).leave(group1,true);
        order.verifyNoMoreInteractions();
    }


}