package homework_number_5;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

import static org.testng.Assert.assertEquals;

public class TestCheckNegative {

    Calculator calculator;


    @BeforeMethod
    public void create(){
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] calculatorCheckDataProvider(){
        return new Object[][]{
                {2, false},
                {-7, true},
                {3, false},
                {-5, true},
        };
    }

    @Test(dataProvider = "calculatorCheckDataProvider")
    public void calculatorCheckNegativeTest(int a, boolean check){
        boolean check2 = calculator.isNegative(a);
        assertEquals(check, check2);
    }
}


