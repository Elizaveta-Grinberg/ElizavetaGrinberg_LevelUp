package homework_number_5;

import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class TestSin {

    @Test
    public void calculatorSinDoubleTest() {
        Calculator calculator = new Calculator();
        double actualSin = calculator.sin(5);
        assertEquals(actualSin, 0.087155, 0.0001);
    }
}
