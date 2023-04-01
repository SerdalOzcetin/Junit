package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Deneme01 extends TestBase {

    public void amazonArama(String aranacakKelime, int urunsirasi){
        driver.get("https://www.amazon.com.tr/");

        driver.findElement(By.id("sp-cc-accept")).click();

        WebElement seachBox = driver.findElement(By.id("twotabsearchtextbox"));
        seachBox.sendKeys(aranacakKelime + Keys.ENTER);
        List<String> urunler = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            String yazi = "data-cel-widget='search_result_" + i;
            String xpath = "//div[@" + yazi + "']";

            urunler.add(xpath);

        }
        WebElement urun = driver.findElement(By.xpath(urunler.get(urunsirasi-1)));
        System.out.println(urun.getText());
        urun.click();
    }

    @Test
    public void test01() {

       amazonArama("iphone13 512",1 );
    }
}
