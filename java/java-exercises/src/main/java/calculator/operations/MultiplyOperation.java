package calculator.operations;

/**
 * Created by claudio.david on 03/03/2015.
 */
public class MultiplyOperation implements ArithmeticOperation{

    private int rightOperand;

    public MultiplyOperation(int rightOperand) {
        this.rightOperand = rightOperand;
    }

    @Override
    public int operate(int leftOperand) {
        return rightOperand*leftOperand;
    }
}
