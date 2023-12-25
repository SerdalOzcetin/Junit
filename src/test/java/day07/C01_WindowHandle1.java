package day07;

import utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class C01_WindowHandle1 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
        //ilk sayfanın ıd sını alalım
        String window1Handle = driver.getWindowHandle();

        WebElement text01 = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        Assert.assertTrue(text01.isDisplayed());

        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualTitle, expectedTitle);

        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        //bu nktada ıkı pencere acık ve 2. sine gecıs yapmak ıstıyorum
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);

        for (String eachHandle : allWindowHandles) {
            if (!eachHandle.equals(window1Handle)) {
                driver.switchTo().window(eachHandle);
            }
        }
        // bu noktada driver 2. pencerede

        String window2Title = driver.getTitle();
        Assert.assertEquals("New Window", window2Title);

        String window2Handle = driver.getWindowHandle();

        driver.switchTo().window(window1Handle);//1i windowa geciş yapıyoruz.
        Thread.sleep(3000);
        driver.switchTo().window(window2Handle);
        Thread.sleep(3000);
        driver.switchTo().window(window1Handle);


    }


}


