package homework_number_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public abstract class WebDriverConfiguration {

    protected static final String url = "https://mail.ru";
    protected static final String eMail = "tlevelup";
    protected static final String passwort = "AccountTest23";

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 20);
        WebElement login = driver.findElement(By.cssSelector("[name='login']"));
        login.sendKeys(eMail);
        driver.findElement(By.cssSelector("[data-testid='enter-password']")).click();
        driver.findElement(By.cssSelector("[name='password']")).sendKeys(passwort);
        driver.findElement(By.cssSelector("[data-testid='login-to-mail']")).click();
    }

    @AfterMethod
    public void exit() {
        driver.findElement(By.partialLinkText("выход")).click();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
