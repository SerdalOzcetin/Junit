package tasks.others;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IsDisplayed_Exercise {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // add butonna basın
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        Thread.sleep(3000);

        //delete butonunun görünür oldugunu test edın
        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        if (deleteButton.isDisplayed()){
            System.out.println("test passed");
        }else System.out.println("test faıled");

        //delete tusuna basın
        driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();

        //Add/Remove tusunun gorunur olıp olmaıgını test edın
        WebElement baslık = driver.findElement(By.xpath("//h3[text()='Add/Remove Elements']"));

        if (baslık.isDisplayed()){
            System.out.println("test passed");
        }else System.out.println("test faıled");


    }


}
