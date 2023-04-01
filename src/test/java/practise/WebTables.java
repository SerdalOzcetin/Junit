package practise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class WebTables extends TestBase {

    @Test
    public void webTables() {
//    Create a class: WebTables






        //    https://the-internet.herokuapp.com/tables
        driver.get(" https://the-internet.herokuapp.com/tables");

        //    Task 1 : Table1’i print edin
        WebElement table01 = driver.findElement(By.id("table1"));
        System.out.println(table01.getText());

        System.out.println();

        //    Task 2 : 3. Row’ datalarını print edin
        WebElement row03 = driver.findElement(By.xpath("//table[@id='table1']//tr[3]"));
        System.out.println(row03.getText());

        System.out.println();


        //    Task 3 : Son row daki dataları print edin
        WebElement lastRow = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[last()]"));
        System.out.println(lastRow.getText());

        //    Task 4 : 5. Column datalarini print edin
        List<WebElement> coloumn05 = driver.findElements(By.xpath("//table[@id='table1']//tbody//td[6]"));

        for (WebElement w:coloumn05){
            System.out.println(w.getText());
        }


    }
    //    Task 5 : Iki parametreli bir Java metot oluşturalım: printData
    //    Parameter 1 = row numarasi
    //    Parameter 2 = column numarasi
    //    printData(2,3);  => 2nd row, 3rd column daki datayı print etsin


    public void tableMethod(int row, int column){

        driver.get(" https://the-internet.herokuapp.com/tables");

        String a = "//table[@id='table1']//tbody//tr["+row+"]//td["+column+"]";

        WebElement tableElement = driver.findElement(By.xpath(a));
        System.out.println(tableElement.getText());

    }


    @Test

    public void table() {
        tableMethod(2,3);
    }
}
