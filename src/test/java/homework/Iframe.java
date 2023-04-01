package homework;

import utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Iframe extends TestBase {
    @Test
    public void test01(){
        /*
        ● Bir class olusturun: IframeTest

        ● Bir metod olusturun: iframeTest



         */
        //● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement yazı = driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(yazı.isDisplayed());

        //○Text Box’a “Merhaba Dunya!” yazin.
        WebElement frame =driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//body[@id='tinymce']")).clear();
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("merhaba dunya");


        //○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //        dogrulayin ve konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement footer = driver.findElement(By.xpath("//*[@id='page-footer']"));
        Assert.assertTrue(footer.isDisplayed());
        System.out.println(footer.getText());

    }
}
