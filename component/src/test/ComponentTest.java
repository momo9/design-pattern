package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import component.Component;
import component.Leaf;
import component.Node;

public class ComponentTest {

    private Component root = new Node("root");
    
    @Before
    public void setUp() throws Exception {
        Component nodeA = new Node("node a");
        root.addComponent(nodeA);
        root.addComponent(new Leaf(true, "leaf b"));
        root.addComponent(new Leaf(true, "leaf c"));
        nodeA.addComponent(new Leaf(false, "leaf a-a"));
        nodeA.addComponent(new Leaf(true, "leaf a-b"));
    }

    @Test
    public void testBasicIter() {
        String[] expecteds = {
                "node a", 
                "leaf b",
                "leaf c"
        };
        
        ArrayList<String> al = new ArrayList<String>();
        Iterator<Component> it = root.iterator();
        while (it.hasNext()) {
            al.add(it.next().getString());
        }
        assertArrayEquals(expecteds, al.toArray());
    }

}
