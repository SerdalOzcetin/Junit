package tasks.others;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TasksQ02 {
    WebDriver driver;

    @Before
    public void setUp(){


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test

    public void test02(){

        // youtube sayfasında gidekım
        driver.get("https://www.youtube.com/");

        //amazon sayfasına gıdelım
        driver.get("https://www.amazon.com/");

        //tekrar youtube sayfasına gideşim
        driver.navigate().back();

        //yenıden amazon sayfasına gıdelım
        driver.navigate().forward();

        //sayfayı refresh edelım
        driver.navigate().refresh();

    }
    @After

    public void tearDown(){

        driver.close();
    }
}
