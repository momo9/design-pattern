package test;

import static org.junit.Assert.*;

import org.junit.Test;

import proxy.ConfigItem;
import proxy.ConfigItemFactory;
import proxy.ConfigItemImpl;

public class ProxyTest {

    @Test
    public void accessProxyTest() {
        ConfigItem ownerCi = ConfigItemFactory.createOwnerProxy("ip", "1.1.1.1");
        ConfigItem normalCi = ConfigItemFactory.createNormalProxy("user", "chi.lchenchi");
        
        assertEquals("1.1.1.1", ownerCi.getContent());
        assertEquals("chi.lchenchi", normalCi.getContent());
        
        ownerCi.setContent("2.2.2.2");
        assertEquals("2.2.2.2", ownerCi.getContent());
        
        boolean exception = false;
        try {
            normalCi.setContent("wugu");
        } catch (Exception e) {
            exception = true;
        }
        
        assertTrue(exception);
        
    }

}
