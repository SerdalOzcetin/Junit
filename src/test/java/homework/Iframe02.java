package homework;

import utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Iframe02 extends TestBase {
    @Test
    public void test01(){
        /*
        ● Bir class olusturun: IframeTest02





                 */

        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> ıframeSayısı = driver.findElements(By.xpath("//iframe"));
        System.out.println(ıframeSayısı.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement frame = driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(frame);
        WebElement play = driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
        play.click();

        // 4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //        tıklayınız
        WebElement iframe02 = driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
        driver.switchTo().frame(iframe02);
        WebElement JmeterIframe = driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']"));
        JmeterIframe.click();


    }
}
