package decorator;

public abstract class Beverage {
    
    protected String desc = "unknown";
    
    public String getDesc() {
        return desc;
    }
    
    public abstract double cost();
}
