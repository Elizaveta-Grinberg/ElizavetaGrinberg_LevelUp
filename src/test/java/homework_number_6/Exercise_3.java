package homework_number_6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class Exercise_3 extends WebDriverConfiguration{


    @Test
    public void deleteMessage() {

        String expectedText = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Написать письмо"))).getText().trim();
        Assert.assertEquals(expectedText, "Написать письмо");
        driver.findElement(By.linkText("Написать письмо")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='container--rp3CE']")));
        WebElement sendTo =
                driver.findElement(By.cssSelector("div[data-name='to'] input"));
        sendTo.sendKeys(eMail + "@mail.ru");
        sendTo.sendKeys(Keys.ENTER);
        String expectedMail = driver.findElement(By.cssSelector("[data-type='to']")).getText();

        WebElement theme = driver.findElement(By.name("Subject"));
        theme.sendKeys("Exercise 3");
        String expectedTheme = theme.getAttribute("value");

        WebElement text = driver.findElement(By.cssSelector("[role='textbox']>div"));
        text.sendKeys("Test body write");
        String expectedText2 = text.getText();

        driver.findElement(By.cssSelector("span[title='Отправить']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='Закрыть']"))).click();

        driver.findElement(By.xpath("//*[text()='Входящие']/..")).click();
        WebElement reedMail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='llc__subject llc__subject_unread']")));
        Assert.assertTrue(reedMail.isDisplayed());
        reedMail.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("thread__header")));

        String actualTheme = driver.findElement(By.cssSelector("[class='thread__subject']")).getText();
        Assert.assertEquals(actualTheme, expectedTheme);

        String actualMail = driver.findElement(By.className("letter-contact")).getAttribute("title");
        Assert.assertEquals(actualMail, expectedMail);

        String actualText = driver.findElement(By.xpath("//div[@class='js-helper js-readmsg-msg']/div/div/div/div[1]")).getText();
        Assert.assertEquals(actualText, expectedText2);

        driver.findElement(By.xpath("//*[text()='Вернуться']/..")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='dataset-letters']")));

        WebElement element = driver.findElement(By.cssSelector("[class='checkbox__box checkbox__box_disabled']"));
        Actions action = new Actions(driver);
        action.click(element).perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Удалить']/.."))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Корзина']/.."))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='dataset-letters']")));
        driver.findElement(By.cssSelector("[class='llc__item llc__item_title']")).getText().contains(expectedTheme);
    }

}
