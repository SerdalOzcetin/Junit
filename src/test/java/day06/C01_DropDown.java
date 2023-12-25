package day06;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {
    WebDriver driver;

    // eger test sınıfında birden fazla method olusturulmusssa @Before kullanılır.
    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void selectByIndexTest() {
        //Given kullanıcı https://testcenter.techproeducation.com/index.php?page=dropdown  sayfasındayken

        //1. LOCATE Dropdown element
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));

        //2. Select objesı olusturun.
        Select yearDropDown = new Select(year);

        // Select objesını kullanarak 3 farklı sekılde secım yapalım.
        yearDropDown.selectByIndex(22);//secenek sırası secenekler "0" dan baslar.2000 yılı 23. sırada.

        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        Select monthDropDown = new Select(month);
        monthDropDown.selectByIndex(0);

        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select dayDropDown = new Select(day);
        dayDropDown.selectByVisibleText("10"); // case sensitive


        // doğum yılını ayını ve gününü su sekılde scer 2000, january, 10
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void printAllTest() {

        // tüm eyalet isimlerini konsola yazdır.
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
        List<WebElement> stateList = stateDropdown.getOptions();

        // for (WebElement eachState : stateList){
        //     System.out.println(eachState.getText());
        //     }

        stateList.stream().forEach(t -> System.out.println(t.getText()));


    }

    /*
     what is dropdown
     dropdown liste olusturmak icin kullanılır.

    2. how to handle dropdown element?
    -dropdown u locate ederim
    -selecct objesi olustururum.
    -slect objesı ıle ıstedigim secenegi secerim
    not: select objesı olusturma nedenim, dropdownların Select class ı ileolusturulması.
    3. tüm dropdown elementlerini nasıl print ederiz.
    - tüm dropdown elemanlarını getOptions() methodu ile listeye koyarız
    -sonra secenekleri loop ile yazdırabiliriz.
    4. bir secenegin secilioldugunu otomate etmek ıcın ne yapılır.
    getFirstSelectedOption() secili olan secenegıreturn eder.

     */
    @Test
    public void getSelectedOptionsTest() {
        //state dropdown nundaki secili secenegin Select a state oldugunu verify edelim.

        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
        String varsayılanTesxt = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State", varsayılanTesxt);

    }
}
