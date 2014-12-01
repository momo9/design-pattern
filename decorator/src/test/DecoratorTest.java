package test;

import static org.junit.Assert.*;

import org.junit.Test;

import condiment.Ice;
import condiment.Sugar;
import decorator.Beverage;
import decorator.Coke;
import decorator.Milk;

public class DecoratorTest {
    
    private Beverage milk = new Milk();
    private Beverage coke = new Coke();

    private Beverage milkWithIce = new Ice(milk);
    private Beverage milkWithSugar = new Sugar(milk);
    private Beverage cokeWithIce = new Ice(coke);
    
    private Beverage milkWithIceSugar = new Sugar(milkWithIce);
    
    @Test
    public void testNormal() {
        assertEquals("milk", milk.getDesc());
        assertEquals("coke", coke.getDesc());
        assertEquals(4.3, milk.cost(), 0.01);
        assertEquals(2.5, coke.cost(), 0.01);
    }
    
    @Test
    public void testOneCond() {
        assertEquals("milk, ice", milkWithIce.getDesc());
        assertEquals("milk, sugar", milkWithSugar.getDesc());
        assertEquals("coke, ice", cokeWithIce.getDesc());
        assertEquals(4.4, milkWithIce.cost(), 0.01);
        assertEquals(4.8, milkWithSugar.cost(), 0.01);
        assertEquals(2.6, cokeWithIce.cost(), 0.01);
    }
    
    @Test
    public void testTwoCond() {
        assertEquals("milk, ice, sugar", milkWithIceSugar.getDesc());
        assertEquals(4.9, milkWithIceSugar.cost(), 0.01);
    }
}
