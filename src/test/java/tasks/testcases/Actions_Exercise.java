package tasks.testcases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Actions_Exercise extends TestBase {
    @Test
    public void test01(){

        Actions actions = new Actions(driver);

        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement meFirst = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(meFirst).perform();

        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();

        //4. Popup mesajini yazdirin
        String alert01 = driver.switchTo().alert().getText();
        System.out.println(alert01);

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClick = driver.findElement(By.xpath("//div[@class='div-double-click']"));
        String doubleCliclkClassName = doubleClick.getAttribute("class");
        actions.doubleClick(doubleClick).perform();

        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        String doubleCliclk02ClassName = doubleClick.getAttribute("class");
        Assert.assertFalse(doubleCliclkClassName.equals(doubleCliclk02ClassName));
    }
}
