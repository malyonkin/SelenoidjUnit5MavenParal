package com.holi;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

public class selenidejUnit5Paral {
    @BeforeEach
    public void setUp(){
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.baseUrl = "https://google.com/ncr";
        Configuration.fastSetValue = true;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("87.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        capabilities.setCapability("enableLog", false);
        Configuration.browserCapabilities = capabilities;
    }

    @Test
    @DisplayName("test №1")
    public void searchgoogle1() throws InterruptedException {
        open("https://google.com/");
        Thread.currentThread().setName("ForkJoinPool-1-worker-1");
        $(By.name("q")).val("selenide").pressEnter();
        $$("#res .g").shouldHave(sizeGreaterThan(1));
        Thread.sleep(4000);
        System.out.println("Тест1: " + Thread.currentThread().getName());
    }
    @Test
    @DisplayName("test №2")
    public void searchgoogle2() throws InterruptedException {
        //drivers.Initialize("chrome");
        open("https://google.com/");
        $(By.name("q")).val("selenium").pressEnter();
        Thread.sleep(4000);
        $$("#res .g").shouldHave(sizeGreaterThan(1));
        System.out.println("Тест2: " + Thread.currentThread().getName());
    }
}
