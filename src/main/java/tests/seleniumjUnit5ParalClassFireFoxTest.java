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

public class seleniumjUnit5ParalClassFireFoxTest {
    public WebDriver driver;

    @BeforeAll
    public static void setupClass() throws MalformedURLException {
        //FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "firefox");
        capabilities.setCapability("browserVersion", "83.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", false
        ));
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub").toURL(),
                capabilities
        );
    }

    @Test
    public void FireFoxGoogleSearch() throws InterruptedException {
        /*driver = new FirefoxDriver(); //Initialize the driver
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);*/

        driver.get("https://www.google.com");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.click();
        searchBar.sendKeys("Fire 1");
        searchBar.sendKeys(Keys.ENTER);
        //Thread.sleep(4000);
        System.out.print("Firefox TestCase is running in Thread  " + Thread.currentThread().getId());
        driver.quit();
    }

    @Test
    public void FireFoxGoogleSearch1() throws InterruptedException {
        /*driver = new FirefoxDriver(); //Initialize the driver
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);*/

        driver.get("https://www.google.com");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.click();
        searchBar.sendKeys("Fire 2");
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        System.out.print("Firefox TestCase is running in Thread  " + Thread.currentThread().getId());
        driver.quit();
    }
}
