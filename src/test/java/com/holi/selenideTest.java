package com.holi;

import com.codeborne.selenide.Configuration;
import init.CustomProviderChrome;
import init.CustomProviderFirefox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

public class selenideTest { //https://www.browserstack.com/guide/difference-between-selenium-remotewebdriver-and-webdriver

    @BeforeEach
    public void setUp() {
        //Configuration.browser = ChromedriverProvider.class.getName();
        Configuration.browser = CustomProviderChrome.class.getName();
        Configuration.browser = CustomProviderFirefox.class.getName();
    }

    @Test
    public void GoogleHome() throws InterruptedException {
        open("https://google.com");
        $(By.name("q")).val("selenide").pressEnter();
        $$("#res .g").shouldHave(sizeGreaterThan(1));
        Thread.sleep(3000);
    }
    @Test
    public void GoogleHome1() throws InterruptedException {
        open("https://google.com");
        $(By.name("q")).val("selenide").pressEnter();
        $$("#res .g").shouldHave(sizeGreaterThan(1));
        Thread.sleep(3000);
    }
}
