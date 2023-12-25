package day05_JUnit;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ClassWork {

    WebDriver driver;
    @Before
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

      //  a. Verilen web sayfasına gidin.
      //  https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

      //  b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox01 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkbox02 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

      //  c. Checkbox1 seçili değilse onay kutusunu tıklayın
        Thread.sleep(3000);
        if (!checkbox01.isSelected()){//secılı degılse
            checkbox01.click();
        }


        //  d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkbox02.isSelected()){
            checkbox02.click();
        }


    }



}
