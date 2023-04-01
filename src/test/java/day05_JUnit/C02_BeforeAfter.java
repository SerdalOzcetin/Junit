package day05_JUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {

    @Before
    public  void  setUp(){
        System.out.println("her test method undan önce çalışır.");
    }

    @After
    public void tearDown(){
        System.out.println("her test method undan sonra çalışır.");
    }

    @Test
    public  void Test1(){
        System.out.println("ilk test");
    }
    @Test
    public void test2 (){
        System.out.println("ikinci test");
    }



}
