package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import state.Machine;

public class StateTest {
    
    private Machine machine = new Machine(50.0);

    @Test
    public void test() {
        
        // preState
        
        String[] expecteds = {
            "20.0 paid, 20.0 in total",
            "10.0 paid, 30.0 in total",
            "25.0 paid, 55.0 in total, enough"
        };
        
        ArrayList<String> al = new ArrayList<String>();
        al.add(machine.pay(20.0));
        al.add(machine.pay(10.0));
        al.add(machine.pay(25.0));
        
        // toConfirmState
        
        assertArrayEquals(expecteds, al.toArray());
        
        assertEquals("refund 55.0", machine.cancel());
        
        // preState
        
        assertEquals("20.0 paid, 20.0 in total", machine.pay(20.0));
        assertEquals("not enough money, need 30.0 more", machine.confirm());
        assertEquals("nothing", machine.get());
        
        assertEquals("35.0 paid, 55.0 in total, enough", machine.pay(35.0));
        
        // toConfirmState
        
        assertEquals("refund 11.0", machine.pay(11.0));
        assertEquals("nothing", machine.get());
        assertEquals("refund 5.0, begin to make", machine.confirm());
        
        // okState
        
    }
    
}
