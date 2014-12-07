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
        Component nodeB = new Node("node b");
        Component nodeD = new Node("node d");
        root.addComponent(nodeA);
        root.addComponent(nodeB);
        root.addComponent(new Leaf(true, "leaf c"));
        root.addComponent(nodeD);
        nodeA.addComponent(new Leaf(false, "leaf a-a"));
        nodeA.addComponent(new Leaf(true, "leaf a-b"));
        nodeB.addComponent(new Leaf(false, "leaf b-a"));
        nodeD.addComponent(new Leaf(true, "leaf d-a"));
        nodeD.addComponent(new Leaf(true, "leaf d-b"));
    }
    
    @Test
    public void testBasicIter() {
        String[] expecteds = {
                "node a", 
                "node b",
                "leaf c",
                "node d"
        };
        
        FrameWork frameWork = new FrameWork() {
            @Override
            protected ArrayList<String> getList() {
                ArrayList<String> al = new ArrayList<String>();
                Iterator<Component> it = root.iterator();
                while (it.hasNext()) {
                    al.add(it.next().getString());
                }
                return al;
            }            
        };
        
        frameWork.work(expecteds);        
    }
    
    @Test
    public void testCompIter() {
        String[] expecteds = {
                "node a",
                "leaf a-a",
                "leaf a-b",
                "node b",
                "leaf b-a",
                "leaf c",
                "node d",
                "leaf d-a",
                "leaf d-b"
        };
        
        FrameWork frameWork = new FrameWork() {
            @Override
            protected ArrayList<String> getList() {
                ArrayList<String> ret = new ArrayList<String>();
                Iterator<Component> it = root.componentIterator();
                while (it.hasNext()) {
                    ret.add(it.next().getString());
                }
                return ret;
            }
        };
        
        frameWork.work(expecteds);
    }
    
    private abstract class FrameWork {
        private void work(String[] expecteds) {
            ArrayList<String> al = getList();
            assertArrayEquals(expecteds, al.toArray());
        }
        protected abstract ArrayList<String> getList();
    }

}
