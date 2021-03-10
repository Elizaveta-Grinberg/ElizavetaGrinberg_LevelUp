package homework_number_5;

import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class TestCos {

    @Test
        public void calculatorCosDoubleTest() {
        Calculator calculator = new Calculator();
        double actualCos = calculator.cos(5);
        assertEquals(actualCos, 0.99619, 0.0001);
    }
}
