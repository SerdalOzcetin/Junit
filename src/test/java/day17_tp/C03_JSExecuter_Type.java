package day17_tp;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_JSExecuter_Type extends TestBase {
    /*
    1)typeTest metotu olustur
	2)Techpro education ana sayfasina git
	3)Arama kutusuna QA yaz
     */

    @Test
    public void typeTest() {

        driver.get("https://www.techproeducation.com/");
        waitFor(3);

        typewithJS(driver.findElement(By.xpath("//input[@type='search']")),"QA");

    }
}
