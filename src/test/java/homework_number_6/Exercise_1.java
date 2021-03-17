package homework_number_6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class Exercise_1 extends WebDriverConfiguration {


    @Test
    public void openMailPageTest() {

        String expectedText = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Написать письмо"))).getText().trim();
        Assert.assertEquals(expectedText, "Написать письмо");
        driver.findElement(By.linkText("Написать письмо")).click();
        WebElement sendTo = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-name='to'] input")));

        sendTo.sendKeys(eMail + "@mail.ru");
        sendTo.sendKeys(Keys.ENTER);
        String expectedMail = driver.findElement(By.cssSelector("[data-type='to']")).getText();

        WebElement theme = driver.findElement(By.name("Subject"));
        theme.sendKeys("Exercise 1");
        String expectedTheme = theme.getAttribute("value");

        WebElement text = driver.findElement(By.cssSelector("[role='textbox']>div"));
        text.sendKeys("Test body write");
        String expectedMailText = text.getText();

        driver.findElement(By.cssSelector("span[title='Сохранить']")).click();

        driver.findElement(By.cssSelector("button[title='Закрыть']")).click();
        driver.findElement(By.partialLinkText("Черновики")).click();
        WebElement draft = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='llc__subject']")));

        Assert.assertTrue(draft.getText().contains(expectedTheme), "Черновик должен быть виден");
        draft.click();

        String actualMail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-type='to']"))).getText();
        Assert.assertEquals(actualMail, expectedMail);

        String actualTheme = driver.findElement(By.name("Subject")).getAttribute("value");
        Assert.assertEquals(actualTheme, expectedTheme);

        String actualMailText = driver.findElement(By.xpath("//div[@class='js-helper js-readmsg-msg']/div/div/div/div[1]")).getText();
        Assert.assertEquals(actualMailText, expectedMailText);

        driver.findElement(By.cssSelector("span[title='Отправить']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='Закрыть']"))).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='У вас нет незаконченных']/..")).isDisplayed());

        driver.findElement(By.xpath("//*[text()='Отправленные']/..")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("llc__container")));

        List<WebElement> elements = driver.findElements(By.cssSelector("[class='llc__item llc__item_title']"));
        Assert.assertTrue(elements.get(0).getText().contains(expectedTheme));

    }

}
