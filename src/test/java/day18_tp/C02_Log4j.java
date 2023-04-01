package day18_tp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C02_Log4j {
//   3. Logger object olustur:
//        private static Logger logger = LogManager.getLogger(Demo1.class.getName());
//   4. Logger fonksiyonuyla istenilen fonksiyonu kullan
//        logger.debug("Debug logger");
//        logger.info("Info logger");
//        logger.error("Error logger");
//        logger.fatal("Fatal logger");

    private static Logger logger= LogManager.getLogger(C02_Log4j.class.getName());
    @Test
    public void test01(){
        //logger objesi ile yazdirma islemini yap
        logger.fatal("Fatal Log!");
        logger.error("Error Log!");
        logger.warn("Warn Log!");
        logger.debug("Debug Log!");
        logger.info("Info Log!");

        /*
        Log4j Nedir?
        loglama yani yazdirma islemi yapmak icin kullanilan bir API dir.
        Cesitli seviyelerde loglama islemi yapilabilir: Uyari(warn), Bilgi(info), Debug(Hata ayiklama), hata mesajlari icin kullanilabilir.
        Javadaki System.out.print e benzer. Ama log4j ile dosyaya detayli sekilde loglama islemi yapabilir

         */

    }
}
