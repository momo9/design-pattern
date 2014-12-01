package factory;

import operator.MinusOperator;
import operator.Operator;

public class MinusFactory extends OperatorFactory {

    @Override
    public Operator createOperator() {
        return new MinusOperator();
    }

}
