package day05_JUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_ClassWork {
    WebDriver driver;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

    @Test

    public void teat01() throws InterruptedException {
        // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        //       - https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //- Cookies’i kabul edin

        // - “Create an Account” button’una basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

        //- “radio buttons” elementlerini locate edin
        WebElement kadin = driver.findElement(By.xpath("(//*[@class='_8esa'])[1]"));
        WebElement erkek = driver.findElement(By.xpath("(//*[@class='_58mt'])[2]"));
        WebElement ozel = driver.findElement(By.xpath("(//*[@class='_58mt'])[3]"));

        // - Secili degilse cinsiyet butonundan size uygun olani secin
        if (!erkek.isSelected()) {
            erkek.click();
        }
        Thread.sleep(1000);
        kadin.click();
        Thread.sleep(1000);
        ozel.click();
        Thread.sleep(1000);
        erkek.click();

    }

}
