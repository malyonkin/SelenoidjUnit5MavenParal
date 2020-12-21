package com.holi.selenide1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

public class selenidejUnit5ParalTest {
    @BeforeEach
    public void setUp(){
        //Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.baseUrl = "https://google.com/ncr";
        Configuration.fastSetValue = true;

        /*DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("87.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        capabilities.setCapability("enableLog", false);
        Configuration.browserCapabilities = capabilities;*/
    }

    @Test
    @Tag("smoke")
    @DisplayName("test №1")
    public void searchgoogle1() throws InterruptedException {
        open("");
        //Thread.currentThread().setName("ForkJoinPool-1-worker-1");
        $(By.name("q")).val("selenide").pressEnter();
        $$("#res .g").shouldHave(sizeGreaterThan(1));
        //Thread.sleep(4000);
        //System.out.println("Тест1: " + Thread.currentThread().getName());
        String fileName = System.getProperty("Browser");
        System.out.println(fileName);
    }
    @Test
    @Tag("smoke")
    @DisplayName("test №2")
    public void searchgoogle2() throws InterruptedException {
        open("");
        $(By.name("q")).val("selenium").pressEnter();
        //Thread.sleep(4000);
        $$("#res .g").shouldHave(sizeGreaterThan(1));
        //System.out.println("Тест2: " + Thread.currentThread().getName());
        String fileName = System.getProperty("Browser");
        System.out.println(fileName);
    }
}

//mvn -Dtag=smoke test
