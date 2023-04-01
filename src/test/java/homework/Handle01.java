package homework;

import utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class Handle01 extends TestBase {
    @Test
    public void test01(){

        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String baslık = driver.findElement(By.xpath("//*[text()='Opening a new window']")).getText();
        Assert.assertEquals(baslık,"Opening a new window");

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle01 = driver.getTitle();
        String expectedTitle01 = "The Internet";
        Assert.assertEquals(actualTitle01,expectedTitle01);

        //Click Here butonuna basın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String window01Handle = driver.getTitle();
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);

        for (String eachHandles : handles){
            if (!window01Handle.equals(handles)){

                driver.switchTo().window(eachHandles);
            }

        }
        String actualTitle02 = driver.getTitle();
        String expectedTitle02 = "New Window";
        Assert.assertEquals(actualTitle02,expectedTitle02);

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
        //        doğrulayın.
        String window01handle02 = driver.getWindowHandle();
        driver.switchTo().window(window01handle02);
        Assert.assertEquals(actualTitle01,expectedTitle01);


    }
}
