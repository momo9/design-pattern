package component;

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

}
