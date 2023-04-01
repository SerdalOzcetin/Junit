package tasks.testcases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Login_User_With_Correct_Email_And_Password extends TestBase {
    @Test
    public void test01(){
        /*
        1. Launch browser
         */

        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        WebElement homaPage = driver.findElement(By.xpath("//section[@id='slider']"));
        Assert.assertTrue(homaPage.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // 5. Verify 'Login to your account' is visible
        WebElement logınText = driver.findElement(By.xpath("//div[@class='login-form']"));
        Assert.assertTrue(logınText.isDisplayed());

        //6. Enter correct email address and password //7. Click 'login' button// tabla yaptım!!!!!!!!!!!!!!!!!
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("abc12345678988888@gmail.com",
                Keys.TAB, "123456789888", Keys.TAB, Keys.ENTER);

        //8. Verify that 'Logged in as username' is visible
        WebElement  loggedText = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(loggedText.isDisplayed());

        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        // 10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement accountDeleteText = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(accountDeleteText.isDisplayed());
    }
}
