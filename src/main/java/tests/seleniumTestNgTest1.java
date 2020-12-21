
package tests;

import init.GooglePage;

//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;

public class seleniumTestNgTest1 {
    GooglePage googlePage = new GooglePage();

    //@Parameters({"browserName"})
    //@BeforeClass
    /*public void setUp(@Optional String browserName) {
        Configuration.remote = "http://localhost:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        Configuration.browserCapabilities = capabilities;

        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);*/

/*capabilities.setCapability("browserName", "crome");
            capabilities.setCapability("browserVersion", "87.0");*//*

        }
        else if(browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            capabilities.setCapability(CapabilityType.BROWSER_NAME,BrowserType.FIREFOX);
            */
/*capabilities.setCapability("browserName", "firefox");
            capabilities.setCapability("browserVersion", "83.0");
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        driver.get("https://www.freshworks.com/");
            *//*

        }
        open("http://google.com");
    }

    @Test
    public void test1() {
        //open("http://google.com");
        $(By.name("q")).val("selenide").pressEnter();
        $$("#res .g").shouldHave(sizeGreaterThan(1));
    }

    @Test
    public void test2() {
        //open("http://google.com");
        $(By.name("q")).val("selenide").pressEnter();
        $$("#res .g").shouldHave(sizeGreaterThan(1));
    }

    @Test
    public void test3() {
        //googlePage.open();
        //open("http://google.com");
        googlePage.search("selenide");
    }
}
//mvn clean -Dtest=testNgParal -Dtestng.dtd.http=true
*/
}
