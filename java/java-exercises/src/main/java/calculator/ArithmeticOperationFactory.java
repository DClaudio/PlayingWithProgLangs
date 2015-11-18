package calculator;

import calculator.operations.AddOperation;
import calculator.operations.ApplyOperation;
import calculator.operations.ArithmeticOperation;
import calculator.operations.MultiplyOperation;

/**
 * Created by claudio.david on 03/03/2015.
 */
public class ArithmeticOperationFactory {
    public static ArithmeticOperation getArithmeticOperation(String operation, int operand) throws IllegalArgumentException{
        if("add".equals(operation.toLowerCase())){
            return new AddOperation(operand);
        }else if("apply".equals(operation.toLowerCase())) {
            return new ApplyOperation(operand);
        }else if("multiply".equals(operation.toLowerCase())) {
            return new MultiplyOperation(operand);
        }else{
            throw new IllegalArgumentException("Unknown operation type");
        }
    }
}
