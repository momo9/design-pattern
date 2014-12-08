package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import state.Machine;

public class StateTest {
    
    private Machine machine = new Machine(50.0);

    @Test
    public void testPay() {
        
        String[] expecteds = {
            "20.0 paid, 20.0 in total",
            "10.0 paid, 30.0 in total",
            "25.0 paid, 55.0 in total, enough"
        };
        
        ArrayList<String> al = new ArrayList<String>();
        al.add(machine.pay(20.0));
        al.add(machine.pay(10.0));
        al.add(machine.pay(25.0));
        
        assertArrayEquals(expecteds, al.toArray());
        
        assertEquals("refund 55.0", machine.cancel());
        
        assertEquals("20.0 paid, 20.0 in total", machine.pay(20.0));
        assertEquals("not enough money, need 30.0 more", machine.confirm());
        assertEquals("nothing", machine.get());
    }

}
