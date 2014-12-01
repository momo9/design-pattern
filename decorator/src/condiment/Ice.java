package condiment;

import decorator.Beverage;

public class Ice extends CondimentDecorator {

    public Ice(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDesc() {
        return beverage.getDesc() + ", ice";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.1;
    }

}
