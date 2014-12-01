package test;

import static org.junit.Assert.*;
import observer.Data;
import observer.General;

import org.junit.Test;


public class ObserverTest {

    @Test
    public void testObserver() {
        Data data = new Data();
        General gen = new General(data);

        data.setData(10);
        
        gen.register();
        data.setData(11);
        data.setData(12);
        
        gen.unRegister();
        data.setData(15);
    }

}
