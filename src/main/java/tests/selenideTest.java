package tests;

import com.codeborne.selenide.Configuration;
import init.CustomProviderChrome;
import init.CustomProviderFirefox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

//https://bonigarcia.github.io/selenium-jupiter/
//https://www.browserstack.com/guide/difference-between-selenium-remotewebdriver-and-webdriver
class selenideTest {

    @BeforeEach
    public void setUp() {
        //Configuration.browser = ChromedriverProvider.class.getName();
        Configuration.browser = CustomProviderChrome.class.getName();
        Configuration.browser = CustomProviderFirefox.class.getName();
    }

    @Test
    void testWithRemoteFirefox(RemoteWebDriver driver) throws InterruptedException {
        // use remote Firefox in this test
        open("https://google.com/");
        $(By.name("q")).val("selenide").pressEnter();
        $$("#res .g").shouldHave(sizeGreaterThan(1));
        Thread.sleep(4000);
    }
}
