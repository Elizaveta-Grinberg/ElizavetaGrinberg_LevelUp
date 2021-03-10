package homework_number_5;

import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class TestExponent {

    @Test
    public void calculatorPowDoubleTest() {
        Calculator calculator = new Calculator();
        double actualPow = calculator.pow(5, 3);
        assertEquals(actualPow, 125.0, 0.0001);
    }

    @Test
    public void calculatorSqrtDoubleTest() {
        Calculator calculator = new Calculator();
        double actualSqrt = calculator.sqrt(5);
        assertEquals(actualSqrt, 25.0, 0.0001);
    }

}
