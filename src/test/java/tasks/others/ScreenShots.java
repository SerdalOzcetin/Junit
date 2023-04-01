package tasks.others;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShots extends TestBase {

    @Test
    public void test01() throws IOException {

        driver.get("https://www.amazon.com/");

        File goruntu = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        String currentTime = new SimpleDateFormat("yyyy;MM;dd;hh;mm;ss").format(new Date());

        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";

        FileUtils.copyFile(goruntu,new File(path));

        WebElement aramaCubugu = driver.findElement(By.id("twotabsearchtextbox"));
        File aramaCubuguGoruntu = aramaCubugu.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(aramaCubuguGoruntu,new File(path));



    }
}
