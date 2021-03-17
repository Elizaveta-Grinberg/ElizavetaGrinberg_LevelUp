package homework_number_5;



import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class TestSum {

    Calculator calculator;

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
        calculator = new Calculator();
    }


    @Test
    public void calculatorSumDoubleTest() {
        double actualSum = calculator.sum(15, 5);
        assertEquals(actualSum, 20.0, 0.0001);

    }

    @Test
    public void calculatorSumLongTest() {
        long actualSum = calculator.sum(8L, 9L);
        assertEquals(actualSum, 17L, 0.0001);
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite");
    }
}
