package day13_tp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {
    /*

    Stale Element= eleman eski , kullanilamaz durumda,kullanima artik elverisli degil
    -Sayfayi yenilediginizde (refresh())
    -Sayfada ileri geri gittigimizde

    COZUM NEDIR???
    -Elemani tekrar bulmak

     */

    @Test
    public void staleElementReferenceException(){
        driver.get("https://www.techproeducation.com");
        waitFor(5);

//        LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        lmsLoginLink.click();//LMS e git
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));//URl in lms kelimesini icerdigini test et
        waitFor(5);

//        Tekrar ana sayfaya gel ve LMS LOGIN sayfasina tekrar git
        driver.navigate().back();//tekrar ana sayfaya gittik
        waitFor(5);
        lmsLoginLink.click();//LMS e git. org.openqa.selenium.StaleElementReferenceException:
        /*
        lmsLoginLink linkini sayfa yenilendikden(back()) sonra kullandigim icin StaleElementReferenceException aldim
         */
    }
    @Test
    public void staleElementReferenceExceptionTest2(){

        driver.get("https://www.techproeducation.com");
        waitFor(5);
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        driver.navigate().refresh();
        waitFor(5);

//        SAYFA YENILENMEDEN ONCE BULDUGUM ELEMENTI, SAYFA YENILENDIKDEN SONRA KULLANMAK ISTEDIM
        lmsLoginLink.click();// org.openqa.selenium.StaleElementReferenceException aldim

//        COZUM ESKI(SLATE ELEMENT) ELEMENTI TEKRAR LOCATE ET
//        driver.findElement(By.linkText("LMS LOGIN")).click();

    }
    }

