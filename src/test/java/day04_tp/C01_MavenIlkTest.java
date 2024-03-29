package day04_tp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        1 https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

//        2 arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

//        3 “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"); // Keys.ENTER dA yapabilirdik
        aramaKutusu.submit(); //Enter a bastik

//        4 Bulunan sonuc sayisini yazdiralim
        WebElement sonucSayisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(sonucSayisi.getText());


//        5 Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

//        6 Sayfadaki tum basliklari yazdiralim
        List<WebElement> sayfaBasliklariListesi = driver.findElements(By.xpath("//h1"));
        // for (WebElement w:sayfaBasliklariListesi) {
        //     System.out.println(w.getText());
        // }

        sayfaBasliklariListesi.forEach(t -> System.out.println(t.getText()));


    }
}
