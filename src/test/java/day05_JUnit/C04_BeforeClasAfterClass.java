package day05_JUnit;


import org.junit.*;


import java.time.Duration;

public class C04_BeforeClasAfterClass {
    /*

    @BeforeClass ve @AfterClass method ları sadece static method lar için çalışır.

   @BeforeClass ve @AfterClass kullanırsak olusturdugumuz test methodlarının  hepsunı aynı anda calıstırıp
   en son @AfterClass ı calıstırırız.
   Ama sadece @Before ve @After kullanırsak her test icin @Before ve @After ı kullanır.

     */

    @BeforeClass

    public static void setUp(){
        System.out.println("butun testlerden once calıstı");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("butun testlerden sonra calıstı");
    }
    @Before
    public void setUp2(){
        System.out.println("her testten once calısır");
    }
    @After
    public void tearDown2(){
        System.out.println("her testten sonra calsır");
    }

    @Test
    public void test01(){
        System.out.println("fist test");
    }
    @Test
    public void test02(){
        System.out.println("secondTest");
    }
    @Test
    @Ignore // eger bır testı calıstırmak ıstemezsek bu seklıde kullanabılırız
    public void test03(){
        System.out.println("test03");
    }
}
