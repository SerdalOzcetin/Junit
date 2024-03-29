package day05_JUnit;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Assertions {
    WebDriver driver;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");//her zaman kullanacagımız ıcın buraya yazıldı.
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


    @Test
    public void test01() {

        // 1) Bir class oluşturun: YoutubeAssertions
        // 2) https://www.amazon.com adresine gidin.

        // 3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        // ○ titleTest => Sayfa başlığının “Amazon” oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    // ○ imageTest => Amazon resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void test02() {
        WebElement sayfaResmi = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(sayfaResmi.isDisplayed());
    }

    // ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
    public void test03() {
        WebElement searchBox = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    // ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test
    public void test04() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "youtube";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
}