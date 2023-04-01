package day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    @Test

    public void test01() throws InterruptedException {

        //https://testcenter.techproeducation.com/index.php?page=iframe"
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //ana sayfadaki "An iframe with a thin black border:" metninde "blavk order" yazısının olup olmadıgını test edın
        String anaMetin = driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();

        String expectedText = "black border";
        Assert.assertTrue(anaMetin.contains(expectedText));

        //"Applications lists" yazısının oldugunu test edın.
        //"Applications lists iframe in içinde iframe switch yapmamaız lazım"
        driver.switchTo().frame(0);// index 0 dan baslar ilk iframe switch yapıyoruz.
        Thread.sleep(3000);
        String içmetin = driver.findElement(By.xpath("//h1[.='Applications lists']")).getText();
        String expectedText1 = "Applications lists";

        Assert.assertTrue(içmetin.contains(expectedText1));


        // son olarak footer dakı "Powered By" yazısının varlıgını test edın
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        WebElement footer = driver.findElement(By.xpath("//p[text()='Povered By']"));

        Assert.assertTrue(footer.isDisplayed());
    }
}
