package tasks.others;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Faker extends TestBase {

    @Test
    public void test01() {
        /*

        Faker Kutuphanesi HOMEWORK
        Faker class'i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
        degerler uretmemize imkan tanir.
        Faker degerler uretmek icin Faker class'indan bir obje uretir ve var olan method'lari kullaniriz.
        "https://facebook.com"  Adresine gidin
        "create new account"  butonuna basin
        "firstName" giris kutusuna bir isim yazin
        "surname" giris kutusuna bir soyisim yazin
        "email" giris kutusuna bir email yazin
        "email" onay kutusuna emaili tekrar yazin
        Bir sifre girin
        Tarih icin gun secin
        Tarih icin ay secin
        Tarih icin yil secin
        Cinsiyeti secin
        Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Sayfayi kapatin

         */


        //  "https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //"create new account"  butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //"firstName" giris kutusuna bir isim yazin
        com.github.javafaker.Faker faker = new com.github.javafaker.Faker();

        driver.findElement(By.xpath("//input[@aria-label='Adın']")).
                sendKeys(faker.name().firstName(), Keys.TAB, faker.name().lastName(),
                Keys.TAB, faker.internet().emailAddress(),
                Keys.TAB, faker.internet().password(), Keys.TAB,
                        Keys.TAB, faker.options().option(),
                        Keys.TAB, faker.options().option());

        System.out.println(faker.number().numberBetween(1,31));

        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin













    }
}
