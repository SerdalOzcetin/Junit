package tasks.testcases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Login_With_Incorrect_Email_And_Password extends TestBase {
    @Test
    public void test01(){
        /*
        1. Launch browser






        8. Verify error 'Your email or password is incorrect!' is visible
         */
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homaPage = driver.findElement(By.xpath("//section[@id='slider']"));
        Assert.assertTrue(homaPage.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'Login to your account' is visible
        WebElement logınText = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(logınText.isDisplayed());

        //6. Enter incorrect email address and password
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("abcdef123");
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("abc123456789888880000@gmail.com");

        // 7. Click 'login' button


    }
}
