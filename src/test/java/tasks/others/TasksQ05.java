package tasks.others;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TasksQ05 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Search "city bike"
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("city bike");
        searchbox.submit();

        //amazonda görüntülenen ilgili sonuçları yazdırın
        String sonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String[] arr =  sonuc.split(" ");
        System.out.println(arr[2]);

        //sonra karsınıza cıkan ilk resme tıklayın
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        driver.close();


    }
}
