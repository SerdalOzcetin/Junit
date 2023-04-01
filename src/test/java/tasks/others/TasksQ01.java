package tasks.others;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TasksQ01 {
    WebDriver driver;
    @Before

    public void setUP(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){

        //Amazon sayfasında gidelim
        driver.get("https://www.amazon.com/");

        //sayfa baslıgını title edelim
        String title = driver.getTitle();
        System.out.println(title);

        // sayfa baslıgının "Amazon icerdıgını test edın
        Assert.assertTrue(title.contains("Amazon"));

        // sayfa adresını(url) yazdırın
        String Url = driver.getCurrentUrl();
        System.out.println(Url);

        // sayfa url nin "amazon" ıcerdıgını test edın.
        Assert.assertTrue(Url.contains("amazon"));

        //sayfa handle degerını yazdırın
        String Handle = driver.getWindowHandle();
        System.out.println(Handle);

        //sayfa html code alrında "Gateway" kelımesının gectıgını test edın
        String Page = driver.getPageSource();
        Assert.assertTrue(Page.contains("Gateway"));


    }

    @After

    public void teardown(){
        driver.close();
    }
}
