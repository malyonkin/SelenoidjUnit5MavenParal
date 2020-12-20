package init;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class YandexBrowser implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities)
    {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.setBinary("/System/Volumes/Data/Applications/Yandex.app");
        return new ChromeDriver(options);
    }
}
