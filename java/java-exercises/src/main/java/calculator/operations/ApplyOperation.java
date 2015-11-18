package calculator.operations;

/**
 * Created by claudio.david on 03/03/2015.
 */
public class ApplyOperation implements ArithmeticOperation {
    private int operand;

    public ApplyOperation(int operand) {
        this.operand = operand;
    }
    public int operate(int operand){
        return this.operand;
    }
}
