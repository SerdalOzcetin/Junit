package tasks.others;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Amazon_Iphone_13_512 extends TestBase {

    @Test
    public void test01() {
        /*
        1) go to 'https://www.amazon.com.tr/'
        2) Search iphone13 512
        3) Check that reesults are listed
        4) Click on iphone 13 at top of the list
        5) Log the following values for each size
        .Size information  .Price .Color .Stock Status
         */

        //1) go to 'https://www.amazon.com.tr/'
        driver.get("https://www.amazon.com.tr/");

        //cerezlerı kabul etmek ıcın
        driver.findElement(By.id("sp-cc-accept")).click();

        //2) Search iphone13 512
        WebElement seachBox = driver.findElement(By.id("twotabsearchtextbox"));
        seachBox.sendKeys("iphone13 512" + Keys.ENTER);


        // 3) Check that reesults are listed
        WebElement resultsList = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(resultsList.isDisplayed());

        //4) Click on iphone 13 at top of the list
        driver.findElement(By.xpath("(//div[@class='a-section a-spacing-base'])[1]")).click();

        // 5) Log the following values for each size
        String size = driver.findElement(By.id("inline-twister-expanded-dimension-text-size_name")).getText();
        String fiyatWhole = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[6]")).getText();
        String fiyatDecimal = driver.findElement(By.xpath("(//span[@class='a-price-fraction'])[6]")).getText();
        String renk = driver.findElement(By.id("inline-twister-dim-title-color_name")).getText();
        String stockStatus = driver.findElement(By.id("availability")).getText();
        String title = driver.getTitle();
        String baslık = title.split(":")[0];

        System.out.print(baslık);
        System.out.println("Size: "+size);
        System.out.print(renk);
        System.out.println(" Fiyat: "+fiyatWhole+"."+fiyatDecimal+"TL");
        System.out.println("Stok durumu: "+stockStatus);

        WebElement ikinciSecenek = driver.findElement(By.xpath("//input[@aria-labelledby='size_name_0-announce']"));
        ikinciSecenek.click();

        String size02 = driver.findElement(By.id("inline-twister-expanded-dimension-text-size_name")).getText();
        String fiyatWhole02 = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[6]")).getText();
        String fiyatDecimal02 = driver.findElement(By.xpath("(//span[@class='a-price-fraction'])[6]")).getText();
        String renk02 = driver.findElement(By.id("inline-twister-dim-title-color_name")).getText();
        String stockStatus02 = driver.findElement(By.id("availability")).getText();
        String title02 = driver.getTitle();
        String baslık02 = title.split(":")[0];

        System.out.print(baslık02);
        System.out.println("Size: "+size02);
        System.out.print(renk02);
        System.out.println(" Fiyat: "+fiyatWhole02+"."+fiyatDecimal02+"TL");
        System.out.println("Stok durumu: "+stockStatus02);


        WebElement ucuncuSecenek = driver.findElement(By.xpath("//input[@aria-labelledby='size_name_1-announce']"));
        ucuncuSecenek.click();

        String size03 = driver.findElement(By.id("inline-twister-expanded-dimension-text-size_name")).getText();
        String fiyatWhole03 = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[6]")).getText();
        String fiyatDecimal03 = driver.findElement(By.xpath("(//span[@class='a-price-fraction'])[6]")).getText();
        String renk03 = driver.findElement(By.id("inline-twister-dim-title-color_name")).getText();
        String stockStatus03 = driver.findElement(By.id("availability")).getText();
        String title03 = driver.getTitle();
        String baslık03 = title.split(":")[0];




        System.out.print(baslık03);
        System.out.println("Size: "+size03);
        System.out.print(renk03);
        System.out.println(" Fiyat: "+fiyatWhole03+"."+fiyatDecimal03+"TL");
        System.out.println("Stok durumu: "+stockStatus03);




    }
}

