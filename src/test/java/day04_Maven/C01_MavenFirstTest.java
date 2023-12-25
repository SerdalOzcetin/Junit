package day04_Maven;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenFirstTest {
    public static <Webdriver> void main(String[] args) {

        WebDriver driver = new ChromeDriver();


        /*
        // Class Work Amazon Search Test
        // 1 https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //2 arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        //3 “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones");
        aramaKutusu.submit();// enter a bastık

        //4 Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazısı = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(sonucYazısı.getText());

        //5 Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

        //6 Sayfadaki tum basliklari yazdiralim
        List<WebElement> sayfaBasliklari = driver.findElements(By.xpath("//h1"));
        for (WebElement w:sayfaBasliklari) {
            System.out.println(w.getText());
        }
        driver.close();

         */

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//i[@class='icon-signin']")).click();

        //3. Login alanine “username” yazdirin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");

        //4. Password alanine “password” yazdirin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@value='Sign in']")).submit();
        driver.navigate().back();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("20000");

        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020-09-10");

        //9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='pay_saved_payees']")).click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement payment= driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        if (payment.isDisplayed()){
            System.out.println("mesaj testi PASSED");
        }else System.out.println("mesaj testi FAILED");

        driver.close();
    }
}
