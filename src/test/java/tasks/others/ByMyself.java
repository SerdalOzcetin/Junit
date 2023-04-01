package tasks.others;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class ByMyself extends TestBase {
    @Test
    public void test01() {

        driver.get("https://www.w3schools.com/");

        WebElement learnJavaText = driver.findElement(By.xpath("(//a[@class='w3-button tut-button black-color w3-margin-bottom'])[3]"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(learnJavaText);
        learnJavaText.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement darkModeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='javascript:void(0);'])[4]")));

        darkModeButton.click();
       // actions.moveToElement(darkModeButton).build().perform();//javascript kullanılmış!!!!!!!!!!! bu code calışmıyo ???

        WebElement darkModeClick = driver.findElement(By.xpath("//input[@onclick='click_darkpage()']"));
        darkModeClick.click();

        driver.findElement(By.xpath("//a[@onclick='gSearch(this)']")).click();
        driver.findElement(By.id("gsc-i-id1")).sendKeys("java"+ Keys.ENTER);

        driver.findElement(By.id("//div[@id='e4']")).click();
    }
}
