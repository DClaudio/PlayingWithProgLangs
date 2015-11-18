package calculator;

import calculator.Calculator;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * Created by claudio.david on 02/03/2015.
 */


public class CalculatorTest {

    LinkedList<String> input;
    Calculator calculator = new Calculator();

    @Before
    public void setUp(){
        this.input = new LinkedList<String>();
    }

    @Test(expected=Exception.class)
    public void emptyInputTest()throws Exception{
        input.add("");
        calculator.calculate(input);
    }

    @Test
     public void testApplyStatement()throws Exception{
        input.add("apply 2");
        assertEquals(2, calculator.calculate(input));
    }

    @Test
    public void testAddStatement()throws Exception{
        input.add("add 2");
        input.add("apply 2");
        assertEquals(4, calculator.calculate(input));
    }

    @Test
    public void testMultiplyStatement()throws Exception{
        input.add("multiply 2");
        input.add("apply 2");
        assertEquals(4, calculator.calculate(input));
    }

    @Test
    public void testMultipleOperations()throws Exception{
        input.add("add 2");
        input.add("multiply 2");
        input.add("add 2");
        input.add("apply 2");
        assertEquals(10, calculator.calculate(input));
    }

    @Test(expected = IllegalArgumentException.class)
    public void edgeCasesTest(){
        input.add("apply s");
        calculator.calculate(input);
    }

}
