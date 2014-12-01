package factory;

import operator.Operator;
import operator.PlusOperator;

public class PlusFactory extends OperatorFactory {

    @Override
    public Operator createOperator() {
        return new PlusOperator();
    }

}
