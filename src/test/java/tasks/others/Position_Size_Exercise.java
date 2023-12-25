package tasks.others;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Position_Size_Exercise {

    WebDriver driver;
    @Before

    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test

    public void test03() throws InterruptedException {
        // amaon sayfasına gıdelim
        driver.get("https://www.amazon.com");
        //sayfanın konumu ve boyutlarını yazdırın
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        //simge durumunda 3 sn bekleyıp maxımızıe edın
        driver.manage().window().minimize();
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //sayfanın konumunu ve boyutlarını fullscreen durumunda yazdırın
        driver.manage().window().fullscreen();
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

    }
    @After
    public void tearDown(){
        driver.close();
    }

}
