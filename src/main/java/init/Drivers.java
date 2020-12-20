package init;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Drivers {

    public void Initialize(String browser) {
        if (browser.equals("chrome")) {

            //Configuration.browser = CustomProviderChrome.class.getName();
            //capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setBrowserName("chrome");
            capabilities.setVersion("87.0");
            capabilities.setCapability("screenResolution", "1166x768x24");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);
            capabilities.setCapability("enableLog", true);
            //Configuration.browserCapabilities = capabilities; //capabilities.setCapability(ChromeOptions.CAPABILITY, capabilities);
            //Configuration.remote = "http://localhost:4444/wd/hub";
            //open("https://google.com/");
        } else if (browser.equals("firefox")) {

            //Configuration.browser = CustomProviderFirefox.class.getName();
            DesiredCapabilities capabilities1 = new DesiredCapabilities();

            capabilities1.setBrowserName("firefox");
            capabilities1.setVersion("83.0");
            capabilities1.setCapability("screenResolution", "1820x1080x24");
            capabilities1.setCapability("enableVNC", true);
            capabilities1.setCapability("enableVideo", false);
            capabilities1.setCapability("enableLog", false);

            //Configuration.browserCapabilities = capabilities1;
            //Configuration.remote = "http://localhost:4444/wd/hub";
            //open("https://google.com/");
        }
    }
}
