package calculator.operations;

/**
 * Created by claudio.david on 03/03/2015.
 */
public class AddOperation implements ArithmeticOperation {

    private int rightOperand;

    public AddOperation(int rightOperand) {
        this.rightOperand = rightOperand;
    }

    public int operate(int leftOperand){
        return leftOperand + rightOperand;
    }
}
