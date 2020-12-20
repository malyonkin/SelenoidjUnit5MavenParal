package init;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CustomProviderFirefox implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setBrowserName("firefox");
        capabilities.setVersion("83.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("videoFrameRate", 24);
        capabilities.setCapability("enableVideo", false);
        capabilities.setCapability("enableLog", false);
        capabilities.setCapability("screenResolution", "1024x768x24");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.merge(capabilities);
        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
        } catch (final MalformedURLException e) {
            throw new RuntimeException("Unable to create driver", e);
        }
    }
}
