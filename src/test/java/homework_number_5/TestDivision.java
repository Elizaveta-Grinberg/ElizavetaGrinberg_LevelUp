package homework_number_5;

import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class TestDivision {

    @Test
    public void calculatorDivDoubleTest() {
        Calculator calculator = new Calculator();
        double actualDiv = calculator.div(8, 2);
        assertEquals(actualDiv, 4.0, 0.0001);
    }

    @Test
    public void calculatorDivLongTest() {
        Calculator calculator = new Calculator();
        long actualDiv = calculator.div(16L, 4L);
        assertEquals(actualDiv, 4L, 0.0001);
    }
}
