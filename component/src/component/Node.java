package component;

import java.util.ArrayList;
import java.util.Iterator;

public class Node extends Component 
                  implements Iterable<Component> {
    
    private ArrayList<Component> components = new ArrayList<Component>();
    
    public Node(String name) {
        super(name);
    }
    
    @Override
    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public Iterator<Component> iterator() {
        return components.iterator();
    }

    @Override
    public Iterator<Component> componentIterator() {
        return new ComponentIterator(this);
    }
    
}
