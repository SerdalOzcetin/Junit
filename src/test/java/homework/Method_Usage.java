package homework;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class Method_Usage extends TestBase {

    @Test
    public void testDeneme(){

        driver.get("https://www.amazon.com/");          //Amazon.com. Spend less. Smile more.
        System.out.println(driver.getTitle());          // Techpro Education | Online It Courses & Bootcamps
                                                        // Facebook - Giriş Yap veya Kaydol
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com/");
        System.out.println(driver.getTitle());

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());

        switchToWindow("Amazon.com. Spend less. Smile more.");
        switchToWindow(" // Techpro Education | Online It Courses & Bootcamps");
        switchToWindow("Amazon.com. Spend less. Smile more.");
        switchToWindow("Facebook - Giriş Yap veya Kaydol");



    }



}
