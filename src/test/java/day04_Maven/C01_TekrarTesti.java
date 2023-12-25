package day04_Maven;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.image.Kernel;
import java.time.Duration;

public class C01_TekrarTesti {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        //1-C01_TekrarTesti isimli bir class olusturun

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin
        //4 Sayfa basliginin “Google” ifadesi icerdigini test edin
        String title = driver.getTitle();
        if (title.contains("Google")) {
            System.out.println("title testi passed");
        } else System.out.println("title testi faıled");

        //5 Arama cubuguna “Nutella” yazip aratin
        WebElement aramaMotoru = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        aramaMotoru.sendKeys("Nutella");
        aramaMotoru.sendKeys(Keys.ENTER);

        //6 Bulunan sonuc sayisini yazdirin
        String aramaSonucu = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        System.out.println(aramaSonucu);
        System.out.println(aramaSonucu);

        //7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        double sonuc = Integer.parseInt(aramaSonucu);

        if (sonuc > 10000000) {
            System.out.println("on milyondan büyük.");
        } else System.out.println("on milyondan küçük.");


        //8 Sayfayi kapatin
        driver.close();

    }
}
