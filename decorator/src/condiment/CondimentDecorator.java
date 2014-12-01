package condiment;

import decorator.Beverage;

public abstract class CondimentDecorator extends Beverage {
    
    protected Beverage beverage; 

    @Override
    public abstract String getDesc();
    
}
