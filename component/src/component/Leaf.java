package component;

import java.util.Iterator;

public class Leaf extends Component {
    
    private boolean red;

    public Leaf(boolean red, String name) {
        super(name);
        this.red = red;
    }

    @Override
    public boolean isRed() {
        return red;
    }

    @Override
    public Iterator<Component> componentIterator() {
        return new NullIterator();
    }

    @Override
    public Iterator<Component> iterator() {
        return new NullIterator();
    }

}
