package tasks.others;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TasksQ07 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5 Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String baslık = driver.getTitle();
        if (baslık.contains("Spend less")){
            System.out.println("test passed");
        }else System.out.println("test faıled");

        //6 Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[@data-csa-c-id='dyb5e3-mujdcj-y3a6dl-wz5v0k']")).click();

        //7 Birthday butonuna basin
        driver.findElement(By.xpath("//img[@alt='Birthday']"));

        //8 Best Seller bolumunden ilk urunu tiklayin
        //9- Gift card details’den 25 $’i secin
        //10-Urun ucretinin 25$ oldugunu test edin
        //10-Sayfayi kapatin

    }

}
