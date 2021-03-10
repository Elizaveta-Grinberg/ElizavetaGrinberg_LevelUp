package homework_number_5;

import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class TestCtg {

    @Test
    public void calculatorCtgDoubleTest() {
        Calculator calculator = new Calculator();
        double actualCtg = calculator.ctg(5);
        assertEquals(actualCtg, -0.3, 0.0001);
    }
}
