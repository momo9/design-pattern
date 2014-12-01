package decorator;

public class Coke extends Beverage {
    
    public Coke() {
        desc = "coke";
    }

    @Override
    public double cost() {
        return 2.5;
    }

}
