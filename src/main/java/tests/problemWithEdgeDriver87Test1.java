package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

public class problemWithEdgeDriver87Test1 {
    @BeforeEach //имеется проблема с EdgeDriver-ом 87.0.664.60 версии
    public void setUp(){
        Configuration.browser = "edge";
    }

    @Test
    public void searchGoogle() {
        open("http://google.com");
        $(By.name("q")).val("selenide").pressEnter();
        $$("#res .g").shouldHave(sizeGreaterThan(1));
    }
}

// ~/.cache/selenium/msedgedriver/
