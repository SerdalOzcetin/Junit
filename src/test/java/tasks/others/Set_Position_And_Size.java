package tasks.others;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Set_Position_And_Size {
    WebDriver driver;
    @Before

    public void setUp(){

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test04(){

        //amazon sayfasına gıdelım
        driver.get("https://ww.amazon.com/");

        //sayfanın boyutşarını ve konmunu yazdurun
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        //sayfanın konumunu ve boyutlarını ıstedıgınız sekılde ayarlayın
        driver.manage().window().setPosition(new Point(30,30));
        driver.manage().window().setSize(new Dimension(600,600));

        // sayfanın sızın ıstedıgınız boyut ve konuma geldıgını test edın
       Point curentPosıtıon = driver.manage().window().getPosition();
       Dimension currentDimension = driver.manage().window().getSize();



        Assert.assertTrue((curentPosıtıon.getX()==30) && (curentPosıtıon.getY()==30));

        Assert.assertTrue((currentDimension.getHeight()==600) && (currentDimension.getWidth()==600));


    }
    @After
    public void tearDown(){
        driver.close();
    }
}
