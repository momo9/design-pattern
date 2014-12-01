package condiment;

import decorator.Beverage;

public class Sugar extends CondimentDecorator {

    public Sugar(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDesc() {
        return beverage.getDesc() + ", sugar";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.5;
    }

}
