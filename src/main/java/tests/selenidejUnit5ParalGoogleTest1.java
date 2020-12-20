package tests;

import com.codeborne.selenide.Configuration;
import init.Drivers;
import init.GooglePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

/*Настройка параллельной работы в разных браузерах - https://www.lambdatest.com/blog/selenium-grid-setup-tutorial/
        mvn clean test -Dthreads=3
        -Dbrowser=chrome -Dselenide.browserVersion=87.0*/
//@Execution(ExecutionMode.CONCURRENT) //параллельный запуск тестов
public class selenidejUnit5ParalGoogleTest1 {
    Drivers drivers = new Drivers();
    GooglePage googlePage = new GooglePage();

    @BeforeEach
    public void setUp(){
        //Configuration.browser = CustomProviderFirefox.class.getName();
        //Configuration.browser = CustomProviderChrome.class.getName();
        //Configuration.driverManagerEnabled = false;
        Configuration.fastSetValue = true;
        //Configuration.browser = YandexBrowser.class.getName(); //для использования яндекса со своими настройками


        /*Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.baseUrl = "https://google.com/ncr";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("87.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        capabilities.setCapability("enableLog", false);
        Configuration.browserCapabilities = capabilities;
       */
    }

    @Test
    @DisplayName("test №1")
    @Tag("search") //группировка тестов по функционалу
    //@Execution(ExecutionMode.CONCURRENT)
    public void searchgoogle1() throws InterruptedException {
        //drivers.Initialize("firefox");
        open("https://google.com/");
        Thread.currentThread().setName("ForkJoinPool-1-worker-1");
        $(By.name("q")).val("selenide").pressEnter();
        $$("#res .g").shouldHave(sizeGreaterThan(1));
        Thread.sleep(14000);
        System.out.println("Тест1: " + Thread.currentThread().getName());
        //Selenide.closeWebDriver();
    }
    @RepeatedTest(3)
    @DisplayName("test №2")
    //@Execution(ExecutionMode.SAME_THREAD)
    public void searchgoogle2() throws InterruptedException {
        //drivers.Initialize("chrome");
        open("https://google.com/");
        $(By.name("q")).val("selenium").pressEnter();
        Thread.sleep(14000);
        $$("#res .g").shouldHave(sizeGreaterThan(1));
        System.out.println("Тест2: " + Thread.currentThread().getName());
        //Selenide.closeWebDriver();
    }

    /*@Test
    @DisplayName("test №3")
    //@Execution(ExecutionMode.SAME_THREAD)
    public void searchgoogle3() throws InterruptedException {
        //GooglePage searchPage = open("https://google.com/ncr", GooglePage.class);
        drivers.Initialize("chrome");
        //open("https://google.com/");
        googlePage.search("test");
        googlePage.results().shouldHave(sizeGreaterThan(1));
        Thread.sleep(4000);
        System.out.println("Тест3: " + Thread.currentThread().getName());
        Selenide.closeWebDriver();
    }*/
}
