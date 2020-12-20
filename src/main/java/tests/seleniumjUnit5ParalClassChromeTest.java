package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

public class seleniumjUnit5ParalClassChromeTest {

    protected static WebDriver driver;

    @BeforeAll
    public static void setupClass() throws MalformedURLException {

        //ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "87.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", false,
                "enableLog", true,
                "screenResolution", "1280x720x24"
        ));
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub").toURL(),
                capabilities
        );
    }

    @Test
    public void ChromeGoogleSearch() throws InterruptedException {
        driver.get("https://www.google.com");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        WebElement searchBar1 = driver.findElement(By.name("q"));
        searchBar1.click();
        searchBar1.sendKeys("Chrome 1");
        searchBar1.sendKeys(Keys.ENTER);
        //Thread.sleep(4000);
        System.out.print("Chrome TestCase is running in Thread  " + Thread.currentThread().getId());
        driver.quit();
    }

    @Test
    public void ChromeGoogleSearch1() throws InterruptedException {
        driver.get("https://www.google.com");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        WebElement searchBar1 = driver.findElement(By.name("q"));
        searchBar1.click();
        searchBar1.sendKeys("Chrome 2");
        searchBar1.sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        System.out.print("Chrome TestCase is running in Thread  " + Thread.currentThread().getId());
        driver.quit();
    }
}
