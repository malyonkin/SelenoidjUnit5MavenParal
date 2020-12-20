package init;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class GooglePage {
    //private static final String URL = "http://google.com/";

    private static final By SEARCH_INPUT = By.name("q");
    private static final SelenideElement SEARCH_BTN = $(By.name("btnK"));

    /*public void open(){
        Selenide.open("https://google.com");
    }*/

    public GooglePage search(String name){
        $(SEARCH_INPUT).val(name).pressEnter();
        //$(SEARCH_BTN).click();
        return page(GooglePage.class);
    }

    public ElementsCollection results() {
        return $$("#res .g");
    }
}

 /*public GooglePage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        toPage(URL);
    }
    */