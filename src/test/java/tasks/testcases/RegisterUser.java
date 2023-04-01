package tasks.testcases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class RegisterUser extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        /*
        1. Launch browser
         */

        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homaPage = driver.findElement(By.xpath("//section[@id='slider']"));
        Assert.assertTrue(homaPage.isDisplayed());

        // Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement userSignUp = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(userSignUp.isDisplayed());

        //6. Enter name and email address
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("abcdef");
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("abc12345678988888@gmail.com");


        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();


        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement textEnterAccountİnformation = driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        Assert.assertTrue(textEnterAccountİnformation.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
            driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456789888");

        WebElement daySelect = driver.findElement(By.xpath("//select[@id='days']"));
        Select day = new Select(daySelect);
        day.selectByVisibleText("11");


        WebElement monthSelect = driver.findElement(By.xpath("//select[@id='months']"));
        Select month = new Select(monthSelect);
        month.selectByVisibleText("May");

        WebElement yearSelect = driver.findElement(By.xpath("//select[@id='years']"));
        Select year = new Select(yearSelect);
        year.selectByVisibleText("2012");

        // 10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//*[@data-qa='first_name']")).sendKeys("abcdef",
                Keys.TAB, "abcdef10", Keys.TAB, "techpro.ltd", Keys.TAB, "izmir, buca, güven",Keys.TAB, "izmir2, buca2,güven2");

        //driver.findElement(By.xpath("//*[@data-qa='last_name']")).sendKeys("");
        //driver.findElement(By.xpath("//*[@data-qa='company']")).sendKeys("");
        //driver.findElement(By.xpath("//*[@data-qa='address']")).sendKeys("");
        //driver.findElement(By.xpath("//*[@data-qa='address2']")).sendKeys("");

        WebElement countrySelect = driver.findElement(By.xpath("//select[@id='country']"));
        Select country = new Select(countrySelect);
        country.selectByVisibleText("Australia");

        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Amerika", Keys.TAB, "Balıkesir", Keys.TAB, "1250", Keys.TAB, "05679876789");
        //driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("");
        //driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("");
        //driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("");

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountText = driver.findElement(By.xpath("//h2[@data-qa='account-created']"));
        Assert.assertTrue(accountText.isDisplayed());

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();


        // 16. Verify that 'Logged in as username' is visible
        //once reklamı kapatalım
        //driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();

        WebElement  loggedText = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(loggedText.isDisplayed());

        //17. Click 'Delete Account' button
        //driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        //WebElement accountDeleteText = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        //Assert.assertTrue(accountDeleteText.isDisplayed());

        //driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();



    }
}
