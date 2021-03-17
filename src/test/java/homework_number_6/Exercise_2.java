package homework_number_6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class Exercise_2 extends WebDriverConfiguration {

    @Test
    public void checkMailInPackageTest() {

        String expectedText = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Написать письмо"))).getText().trim();
        Assert.assertEquals(expectedText, "Написать письмо");

        driver.findElement(By.xpath("//*[text()='Отправленные']/..")).click();
        List<WebElement> sortDate = driver.findElements(By.xpath("//div[@class='llc__item llc__item_date']"));


        driver.findElement(By.linkText("Написать письмо")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='container--rp3CE']")));
        WebElement sendTo =
                driver.findElement(By.cssSelector("div[data-name='to'] input"));
        sendTo.sendKeys(eMail + "@mail.ru");
        sendTo.sendKeys(Keys.ENTER);
        String expectedMail = driver.findElement(By.cssSelector("[data-type='to']")).getText();

        WebElement theme = driver.findElement(By.name("Subject"));
        theme.sendKeys("Test");
        String expectedTheme = theme.getAttribute("value");

        WebElement text = driver.findElement(By.cssSelector("[role='textbox']>div"));
        text.click();
        text.sendKeys("Test body write");
        String expectedText2 = text.getText();


        driver.findElement(By.cssSelector("span[title='Отправить']")).click();
//        Date d = new Date();
//        String time = ((d.getTime() / 1000/ 60/ 80 ) % 24 + ":" + (d.getTime() / 1000/60 ) % 60);
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Calendar cal = Calendar.getInstance();
//        String time = dateFormat.format(cal.getTime());
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='Закрыть']"))).click();
        driver.findElement(By.xpath("//*[text()='Отправленные']/..")).click();

        List<WebElement> sortDate2 = driver.findElements(By.xpath("//div[@class='llc__item llc__item_date']"));
        Assert.assertNotEquals(sortDate, sortDate2);
        Assert.assertTrue(driver.findElement(By.cssSelector("[class='llc__subject']")).getText().contains(expectedTheme));

        driver.findElement(By.xpath("//*[text()='Test']/..")).click();
        WebElement markAsReed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='llc__subject llc__subject_unread']")));

        List<WebElement> count = driver.findElements(By.xpath("//*[@class='ll-sj__normal']"));
        for (WebElement element : count) {
            Assert.assertTrue(element.getText().contains(expectedTheme));
        }

        Assert.assertTrue(markAsReed.isDisplayed());
        markAsReed.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("thread__header")));

        String actualTheme = driver.findElement(By.cssSelector("[class='thread__subject']")).getText();
        Assert.assertEquals(actualTheme, expectedTheme);

        String actualMail = driver.findElement(By.className("letter-contact")).getAttribute("title");
        Assert.assertEquals(actualMail, expectedMail);

        String actualText = driver.findElement(By.xpath("//div[@class='js-helper js-readmsg-msg']/div/div/div/div[1]")).getText();
        Assert.assertEquals(actualText, expectedText2);

    }

}
