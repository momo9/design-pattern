package decorator;

public class Milk extends Beverage {
    
    public Milk() {
        desc = "milk";
    }

    @Override
    public double cost() {
        return 4.3;
    }

}
