package component;

import java.util.Iterator;

public abstract class Component implements Iterable<Component> {
    
    protected String name;
    
    public Component(String name) {
        this.name = name;
    }

    public String getString() {
        return name;
    }
    
    public boolean isRed() {
        throw new UnsupportedOperationException();
    }
    
    public void addComponent(Component component) {
        throw new UnsupportedOperationException();
    }
    
    public abstract Iterator<Component> componentIterator();
        
}
