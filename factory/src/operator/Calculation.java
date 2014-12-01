package operator;

import factory.SimpleFactory;

public class Calculation {
    private SimpleFactory factory;
    public Calculation(SimpleFactory factory) {
        this.factory = factory;
    }
    public int calculate(int a, int b, String type) {
        Operator op = factory.createOperator(type);
        return op.operation(a, b);
    }
}
