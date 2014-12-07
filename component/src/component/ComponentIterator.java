package component;

import java.util.Iterator;
import java.util.Stack;

public class ComponentIterator implements Iterator<Component> {
    
    private Stack<Iterator<Component>> stack = new Stack<Iterator<Component>>();
    
    public ComponentIterator(Component component) {
        stack.push(component.iterator());
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator<Component> cur = stack.peek();
            if (!cur.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

    @Override
    public Component next() {
        if (!hasNext()) {
            return null;
        }
        Iterator<Component> curIter = stack.peek();
        Component curComp = curIter.next();
        stack.push(curComp.componentIterator());
        return curComp;
    }

}
