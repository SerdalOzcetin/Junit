package tasks.testcases;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Actions_Exercise_Fill_The_Capitals_ByCountry extends TestBase {

    @Test
    public void test01(){
         /*
          #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
         #Fill in capitals by country
        */
          /*
           #url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
          #Ülkeye göre başkentleri doldurun
         */
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        Actions actions = new Actions(driver);
        for (int i =1;i<8;i++){
            WebElement kaynak = driver.findElement(By.id("box"+i));
            WebElement hedef = driver.findElement(By.id("box10"+i));
            actions.dragAndDrop(kaynak,hedef).perform();
        }
    }
}
