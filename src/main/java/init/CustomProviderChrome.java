package init;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CustomProviderChrome implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("87.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("videoFrameRate", 24);
        capabilities.setCapability("enableVideo", false);
        capabilities.setCapability("enableLog", false);
        capabilities.setCapability("screenResolution", "1324x768x24");

        ChromeOptions chromeDriver = new ChromeOptions();
        chromeDriver.merge(capabilities);
        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeDriver);
        } catch (final MalformedURLException e) {
            throw new RuntimeException("Unable to create driver", e);
        }
    }
}
