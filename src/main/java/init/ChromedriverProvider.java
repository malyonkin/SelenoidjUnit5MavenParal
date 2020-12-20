package init;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class ChromedriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        DesiredCapabilities capabilities = new DesiredCapabilities(desiredCapabilities);
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("87.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        try {
            return new RemoteWebDriver(
                URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                capabilities
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //return new ChromeDriver(capabilities);
        return null;
    }
}
