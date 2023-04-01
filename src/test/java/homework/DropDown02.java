package homework;

import utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown02 extends TestBase {
    @Test
    public void test01(){
        /*
        1. http://zero.webappsecurity.com/ Adresine gidin
        2. Sign in butonuna basin
        3. Login kutusuna “username” yazin
        4. Password kutusuna “password.” yazin
        5. Sign in tusuna basin
        6. Pay Bills sayfasina gidin
        7. “Purchase Foreign Currency” tusuna basin
        8. “Currency” drop down menusunden Eurozone’u secin
        9. “amount” kutusuna bir sayi girin
        10. “US Dollars” in secilmedigini test edin
        11. “Selected currency” butonunu secin
        12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
                 */

        // 1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();

        //3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");

        //4. Password kutusuna “password.” yazin
        driver.findElement(By.id("user_password")).sendKeys("password");

        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.navigate().back();

        //  6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency"));

        //8. “Currency” drop down menusunden Eurozone’u secin
        driver.findElement(By.xpath("//a[@href='#ui-tabs-3']")).click();
        WebElement dropDownButton = driver.findElement(By.id("pc_currency"));

        Select dropDown = new Select(dropDownButton);
        dropDown.selectByVisibleText("Eurozone (euro)");

        // 9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("2000");

        //10. “US Dollars” in secilmedigini test edin
        WebElement radıoButon = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(radıoButon.isSelected());

        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();

        // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

        // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        WebElement yazı = driver.findElement(By.id("alert_content"));
        Assert.assertTrue(yazı.isDisplayed());





    }
}
