package homework;

import utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Alerts extends TestBase {
    @Test
    public void test01(){
        /*
        ● Bir class olusturun: Alerts
        ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        ● Bir metod olusturun: acceptAlert
        ○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        “You successfully clicked an alert” oldugunu test edin.
        ● Bir metod olusturun: dismissAlert
        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        “successfuly” icermedigini test edin.
        ● Bir metod olusturun: sendKeysAlert
        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
         */

        //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //● Bir metod olusturun: acceptAlert
        //        ○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //        “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(result,"You successfully clicked an alert");


        //● Bir metod olusturun: dismissAlert
        //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //        “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().accept();
        String result02 = driver.findElement(By.id("result")).getText();
        Assert.assertFalse(result02.contains("successfuly"));

        //● Bir metod olusturun: sendKeysAlert
        //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("serdal");
        driver.switchTo().alert().accept();
        String resultIsim = driver.findElement(By.id("result")).getText();

        Assert.assertTrue(resultIsim.contains("serdal"));
    }
}
