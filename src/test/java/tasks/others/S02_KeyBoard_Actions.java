package tasks.others;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class S02_KeyBoard_Actions extends TestBase {
    @Test
    public void test01() {
        /*
        Bir Class olusturalim KeyboardActions2
        https://html.com/tags/iframe/ sayfasina gidelim
        video'yu gorecek kadar asagi inin
        videoyu izlemek icin Play tusuna basin
         */

        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get(" https://html.com/tags/iframe/");


        //video'yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);// testbase deki hazır method lar kullanılarak ta yapılabilirdi ama
                                              //scrollToElement() diye bit method buldum onu kullanmak için hazır ahmet hocanın yaptıgı methodları kullanmadan
                                              //yapmaya çalıştım ve code sorunsuz çalıştı



        WebElement iframe = driver.findElement(By.xpath("//iframe[1]"));//oynatılması istenen videoyu locate ederken iframe oldugu göruluyor
        actions.scrollToElement(iframe).perform();                                   //  " //iframe[1]" şeklinde xpath yazarak videonun locatini yaptım.
                                                                                     // suan "iframe" in içine girmedim sadece scroll yaparak sayfada
                                                                                     //video görünene kadar kaydır komutu verdim


        //videoyu izlemek icin Play tusuna basin
        driver.switchTo().frame(iframe);                       //"iframe" in locatini zaten almıştık aynı locati kullanarak iframe geciş yapıldı.
        WebElement oynatButonu = driver.findElement(By.xpath("//button[@aria-label='Oynat']"));//oynat butonu locate edilerek tusa basıldı.
        oynatButonu.click();

        //videonun oynatıldıgını test edın
        Assert.assertTrue(driver.findElement(By.xpath("//a[@aria-label='youtube.com sitesinde izle']")).isDisplayed());
    }
}
