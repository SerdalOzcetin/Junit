package practise;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Actions extends TestBase {
    /*
    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
    - Çizimden sonra clear butonuna basalım
    - Son olarak sayfayı temizleyiniz

     */

    @Test
    public void test01() {

        driver.get("http://szimek.github.io/signature_pad/");

        WebElement yazıTahtası = driver.findElement(By.xpath("//canvas"));
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.moveToElement(yazıTahtası).clickAndHold();

        do {
            for (int i = 0; i<10;i++){
                actions.moveByOffset(2,2);
            }
            for (int i = 0; i<10;i++){
                actions.moveByOffset(-2,2);
            }
            for (int i = 0; i<10;i++){
                actions.moveByOffset(-2,-2);
            }
            for (int i = 0; i<10;i++){
                actions.moveByOffset(2,-2);
            }
            for (int i = 0; i<10;i++){
                actions.moveByOffset(0,4);
            }

            actions.perform();
        }while (1==1);




    }
}
