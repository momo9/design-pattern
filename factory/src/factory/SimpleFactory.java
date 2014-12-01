package factory;

import operator.MinusOperator;
import operator.Operator;
import operator.PlusOperator;

public class SimpleFactory {
    public Operator createOperator(String type) {
        if (type.equals("plus")) {
            return new PlusOperator();
        } else if (type.equals("minus")) {
            return new MinusOperator();
        } else {
            throw new RuntimeException("Not supported operator.");
        }
    }
}
