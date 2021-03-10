package homework_number_5;

import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class TestTg {

    @Test
    public void calculatorTgDoubleTest() {
        Calculator calculator = new Calculator();
        double actualTg = calculator.tg(5);
        assertEquals(actualTg, 0.087488, 0.0001);
    }
}
