package tasks.others;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Bulutluöz_Example extends TestBase {

    String urunTitleIphone;

    String urunFiyatiIphone;

    String iphoneCartTitle;

    String iphoneCartFiyati;



    String urunTitle;
    String urunFiyati;
    String cartTitle;
    String cartPrice;


    @Test
    public void test01() {

        //Test01 :  1- amazon gidin
        driver.get("https://www.amazon.com");

//Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.xpath("//*[@aria-describedby='searchDropdownDescription']"));
        Select select = new Select(ddm);
        List<WebElement> allDdm = select.getOptions();
        for (WebElement w : allDdm) {
            System.out.println(w.getText() + " - ");
        }

//dropdown menude 28 eleman olduğunu doğrulayın
        int ddmSize = allDdm.size();
        System.out.println("DropDown size : " + allDdm.size());
        Assert.assertEquals(ddmSize, 28);
    }

    @Test
    public void test02() {

        //Test02
//dropdown menuden elektronik bölümü seçin
        driver.get("https://www.amazon.com");
        WebElement ddm2 = driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(ddm2);
        select.selectByVisibleText("Electronics");

//arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("iphone"+ Keys.ENTER);
        WebElement sonucYazisi= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String [] str = sonucYazisi.getText().split(" ");
        System.out.println("iphone sonuc sayisi : " + str[3]);

//sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(sonucYazisi.getText().contains("iphone"));
//ikinci ürüne relative locater kullanarak tıklayin
driver.findElement(By.xpath("//div[@data-csa-c-item-id='amzn1.asin.1.B0BP73DD5S']")).click();
//ürünün title'ni ve fiyatını variable'a  assign edip ürünü sepete ekleyelim
        String urunTitleIphone = driver.findElement(By.xpath("//h1[@id='title']")).getText();
        String urunFiyatiIphone = driver.findElement(By.xpath("(//span[@class='a-offscreen'])[6]")).getText();
        System.out.println(urunTitleIphone + " " + urunFiyatiIphone);

        driver.findElement(By.id("add-to-cart-button")).click();

        driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
        String iphoneCartTitle = driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[5]")).getText();
        String iphoneCartFiyatı = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")).getText();

    }
//Test03

    @Test
    public void test03() {
        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        //dropdown'dan bebek bölümüne secin
        WebElement ddm = driver.findElement(By.xpath("//*[@aria-describedby='searchDropdownDescription']"));
        Select dropDown = new Select(ddm);
        dropDown.selectByVisibleText("Baby");

        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("bebek puset"+Keys.ENTER);
        String sonucYazısı = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();

        String sonucSayı[] = sonucYazısı.split(" ");
        System.out.println(sonucSayı[2]);


        //sonuç yazsının puset içerdiğini test edin
        Assert.assertTrue(sonucYazısı.contains("puset"));

        //5-üçüncü ürüne relative locater kullanarak tıklayin.
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[3]")).click();

        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String urunTitle = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        String urunFiyatı =driver.findElement(By.xpath("//div[@class='a-section a-spacing-none aok-align-center']")).getText();

        System.out.println(urunTitle);
        System.out.println(urunFiyati);
        driver.findElement(By.id("add-to-cart-button")).click();

        driver.findElement(By.xpath("//a[@id='nav-cart']")).click();

        String cartTitle = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base sc-product-title sc-grid-item-product-title']")).
                getText();
        String cartPrice = driver.
                findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")).
                getText();

        System.out.println(cartTitle);
        System.out.println(cartPrice);
    }

    @Test
    public void test04() {
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

    Assert.assertEquals(urunTitle,cartTitle);
    Assert.assertEquals(urunFiyati,cartPrice);

    Assert.assertEquals(urunTitleIphone,iphoneCartTitle);
    Assert.assertEquals(urunFiyatiIphone,iphoneCartFiyati);

    }
}