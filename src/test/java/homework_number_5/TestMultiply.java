package homework_number_5;

import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class TestMultiply {

    @Test
    public void calculatorMultDoubleTest() {
        Calculator calculator = new Calculator();
        double actualMult = calculator.mult(2, 3);
        assertEquals(actualMult, 6.0, 0.0001);
    }

    @Test
    public void calculatorMultLongTest() {
        Calculator calculator = new Calculator();
        long actualMult = calculator.mult(2L, 2L);
        assertEquals(actualMult, 4L, 0.0001);
    }

}
