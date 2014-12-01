package test;

import static org.junit.Assert.*;
import operator.Calculation;
import operator.Operator;

import org.junit.Test;

import factory.MinusFactory;
import factory.OperatorFactory;
import factory.PlusFactory;
import factory.SimpleFactory;

public class FactoryTest {

    private Calculation cal = new Calculation(new SimpleFactory());
    private int a = 5;
    private int b = 3;
    
    private OperatorFactory plusFac = new PlusFactory();
    private OperatorFactory minusFac = new MinusFactory();
    
    @Test
    public void testFactory() {
        assertEquals(8, cal.calculate(a, b, "plus"));
        assertEquals(2, cal.calculate(a, b, "minus"));
        assertEquals(8, plusFac.createOperator().operation(a, b));
        assertEquals(2, minusFac.createOperator().operation(a, b));
    }
    
    @Test
    public void testUnsupported() {
        boolean res = true;
        try {
            cal.calculate(a, b, "un");
        } catch (RuntimeException e) {
            res = false;
        }
        assertFalse(res);
        
        res = true;
        try {
            cal.calculate(a, b, "plus");
        } catch (RuntimeException e) {
            res = false; 
        }
        assertTrue(res);
    }

}
