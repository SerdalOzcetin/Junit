package homework;

import utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownAmazon extends TestBase {
    @Test
    public void test01(){
        /*
                Bir class oluşturun: C3_DropDownAmazon

                - Test 1





         */

        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");

        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
        WebElement drop = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select dropDown = new Select(drop);

        int kategorıSayısı = dropDown.getOptions().size();
        System.out.println(kategorıSayısı);

        Assert.assertEquals(kategorıSayısı,28);
        //-Test 2
        //1. Kategori menusunden Books secenegini secin
        dropDown.selectByVisibleText("Books");

        //2. Arama kutusuna Java yazin ve aratin
        WebElement aramaCubugu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaCubugu.sendKeys("Java");
        aramaCubugu.submit();

        // 3. Bulunan sonuc sayisini yazdirin
        String sonuc = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();

        System.out.println(sonuc);

        // 4. Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(sonuc.contains("Java"));
    }


}
