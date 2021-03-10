package homework_number_5;

import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class TestSubtraction {

    @Test
    public void calculatorSubDoubleTest() {
        Calculator calculator = new Calculator();
        double actualSub = calculator.sub(3, 2);
        assertEquals(actualSub, 1.0, 0.0001);
    }

    @Test
    public void calculatorSubLongTest() {
        Calculator calculator = new Calculator();
        long actualSub = calculator.sub(2L, 2L);
        assertEquals(actualSub, 0L, 0.0001);
    }

}
