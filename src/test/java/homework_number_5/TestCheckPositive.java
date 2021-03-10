package homework_number_5;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class TestCheckPositive {

    Calculator calculator;

    @BeforeMethod
    public void create(){
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] calculatorCheckDataProvider(){
        return new Object[][]{
                {2, true},
                {-7, false},
                {3, true},
                {-5, false},
        };
    }

    @Test(dataProvider = "calculatorCheckDataProvider")
    public void calculatorCheckPositiveTest(int a, boolean check){
        boolean check2 = calculator.isPositive(a);
        assertEquals(check, check2);
    }
}


