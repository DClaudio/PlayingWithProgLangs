package calculator;

import calculator.operations.ArithmeticOperation;
import java.util.*;

/**
 * Created by claudio.david on 02/03/2015.
 */
public class Calculator {

    public int calculate(LinkedList<String> input) throws IllegalArgumentException{
        if(input == null && input.size()==0){
            throw new IllegalArgumentException("bad input from user!");
        }else{
            List<ArithmeticOperation> operationList = getOprationsList(input);
            int result = operationList.get(operationList.size()-1).operate(0);
            for(int i=0; i < operationList.size()-1; i++){
                result = operationList.get(i).operate(result);
            }
            return result;
        }
    }

    private List<ArithmeticOperation> getOprationsList(List<String> inputList){
        List<ArithmeticOperation> operationList = new LinkedList<ArithmeticOperation>();
        int index = 0;
        for(String line : inputList){
            index ++;
            String[] splitLine = line.split(" ");
            if(splitLine.length == 2){
                try{
                    operationList.add(ArithmeticOperationFactory.getArithmeticOperation(splitLine[0],
                            Integer.parseInt(splitLine[1])));
                }catch(NumberFormatException e){
                    throw new IllegalArgumentException("Not a number on line "+ index);
                }
            }else{
                throw new IllegalArgumentException("Wrong number of arguments exception for line "+ index);
            }
        }
        return operationList;
    }
}