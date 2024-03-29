package day09_tp;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {
    @Test
    public void handleCookiesTest() {
//        Amazona git
        driver.get("https://www.github.com");
        waitFor(3);
//        1.toplam cookie sayisini bul
        Set<Cookie> allCookies = driver.manage().getCookies(); // toplam cerez sayisi
        int cookieSayisi = allCookies.size();
        System.out.println("Sayfada " + cookieSayisi + " adet cookie var");
//        3. Bir Cookie yi ismiyle bul
//        tum cokkie leri yazdiralim
//        allCookies.stream().forEach(t -> System.out.println(t.getName()));
        for (Cookie eachCookie : allCookies) {
            System.out.println("COOKIE : " + eachCookie);//COOKIE NIN TAMAMINI YAZDIK
            System.out.println("COOKIE ISIMLERI : " + eachCookie.getName());
        }
        System.out.println("COKKIEYI ISMIYLE CAGIRIYORUM : " + driver.manage().getCookieNamed("preferred_color_mode"));
//        4. Yeni bir cookie ekle
        Cookie favoriCookiem = new Cookie("cikolatam", "antep-fistikli-cikolata");
        driver.manage().addCookie(favoriCookiem);
        waitFor(3);
        for (Cookie eachCookie : allCookies) {
            System.out.println("COOKIE : " + eachCookie);//COOKIE NIN TAMAMINI YAZDIK
            System.out.println("COOKIE ISIMLERI : " + eachCookie.getName());
        }

        System.out.println("Yeni Cookie Sayisi : " + driver.manage().getCookies().size());

//        5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("session-id");
//        6. Tum cookie leri sil
        waitFor(5);
        driver.manage().deleteAllCookies();
        System.out.println("TUM COOKIES LERI SILDIM. YENI COOKIE SAYISI : " + driver.manage().getCookies().size());
    }
}