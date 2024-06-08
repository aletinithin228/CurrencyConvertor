import org.junit.Test;

import static org.junit.Assert.*;


public class CalculatorTest {


    @Test
    public void testAddition() {

        Calculator calculator = new Calculator();

        int result = calculator.add(3, 5);

        assertEquals(8, result);

    }


    @Test
    public void testSubtraction() {

        Calculator calculator = new Calculator();

        int result = calculator.subtract(10, 4);

        assertEquals(6, result);

    }


    @Test
    public void testMultiplication() {

        Calculator calculator = new Calculator();

        int result = calculator.multiply(2, 6);

        assertEquals(12, result);

    }


    @Test
    public void testDivision() {

        Calculator calculator = new Calculator();

        double result = calculator.divide(10, 2);

        assertEquals(5.0, result, 0.0001);

    }

}


