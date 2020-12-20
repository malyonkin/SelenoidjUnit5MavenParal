package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
//https://www.toolsqa.com/testng/testng-parallel-execution/
//https://docs.microsoft.com/ru-ru/microsoft-edge/webdriver-chromium/?tabs=c-sharp
//@Execution(ExecutionMode.CONCURRENT)
public class seleniumjUnit5ParalMethodTest1 { //ПАРАЛЛЕЛЬНЫЙ ЗАПУСК ТЕСТОВ В РАЗНЫХ БРАУЗЕРАХ - КАЖДЫЙ ТЕСТ ЗАПУСКАЕТСЯ В СВОЁМ БРАУЗЕРЕ

    //private URL url;
    public WebDriver driver;
    public WebDriver driver1;
    public WebDriver driver2;
    public WebDriver driver3;
    public WebDriver driver4;
    public WebDriver driver5;

    @BeforeAll
    public static void setupClass(){
        ChromeDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.operadriver().setup();
        WebDriverManager.getInstance(DriverManagerType.SAFARI).setup();
        FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        //ChromeDriverManager.operadriver().setup();
        //WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
        /*System.setProperty("webdriver.edge.driver2","/usr/local/bin/msedgedriver"); //edge
        System.setProperty("webdriver.geckodriver.driver","/usr/local/bin/geckodriver"); //firefox
        System.setProperty("webdriver.chrome.driver3","/usr/local/bin/chromedriver");
        System.setProperty("webdriver.safaridriver.driver1","/usr/local/bin/safaridriver");
        System.setProperty("webdriver.operadriver.driver4","/usr/local/bin/operadriver");*/
    }

    @BeforeEach
    public void setUp() throws MalformedURLException {
        //url = new URL("http://localhost:4444/wd/hub");
    }

    @Test
    public void FireFoxGoogleSearch() throws InterruptedException { //https://experitest.com/selenium-testing/selenium-parallel-execution-for-dummies/
        //RemoteWebDriver driver;
        driver = new FirefoxDriver(); //Initialize the driver
        //FirefoxOptions options = new FirefoxOptions();
        //options = new FirefoxOptions();
        //options.setBinary("/usr/local/bin/geckodriver");
        //WebDriver driver = new FirefoxDriver(options);
        //System.setProperty("webdriver.geckodriver.driver","/usr/local/bin/geckodriver");
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
        dc.setCapability("testName", "Quick Start Firefox Browser Demo");
        //driver = new RemoteWebDriver(url, dc);
        driver.get("https://www.google.com");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.click();
        searchBar.sendKeys("Experitest");
        searchBar.sendKeys(Keys.ENTER);
        //Thread.sleep(4000);
        System.out.print("Firefox TestCase is running in Thread  " + Thread.currentThread().getId());
        driver.quit();
    }

    @Test
    public void SafariGoogleSearch() throws InterruptedException {
        //RemoteWebDriver driver1;
        driver1 = new SafariDriver(); //ВАЖНО: Отключение защиты запуска автотестов в браузере Сафари - sudo /usr/bin/safaridriver --enable
        //System.setProperty("webdriver.safaridriver.driver1","/usr/local/bin/safaridriver");
        DesiredCapabilities dc1 = new DesiredCapabilities();
        dc1.setCapability(CapabilityType.BROWSER_NAME, BrowserType.SAFARI);
        dc1.setCapability("testName", "Quick Start Safari Browser Demo");
        //driver1 = new RemoteWebDriver(url, dc1);
        driver1.get("https://www.google.com");
        new WebDriverWait(driver1, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        WebElement searchBar1 = driver1.findElement(By.name("q"));
        searchBar1.click();
        searchBar1.sendKeys("SeeTest");
        searchBar1.sendKeys(Keys.ENTER);
        //Thread.sleep(4000);
        System.out.print("Safari TestCase is running in Thread  " + Thread.currentThread().getId());
        driver1.quit();
    }

    @Test
    public void OperaGoogleSearch() throws InterruptedException {
        //RemoteWebDriver driver3;
        driver3 = new OperaDriver();
        DesiredCapabilities dc3 = new DesiredCapabilities();
        dc3.setCapability(CapabilityType.BROWSER_NAME, BrowserType.OPERA_BLINK);
        dc3.setCapability("testName", "Quick Start Edge Browser Demo");
        //driver2 = new EdgeDriver(dc2);
        //driver2 = new RemoteWebDriver(url, dc2);
        driver3.get("https://www.google.com");
        new WebDriverWait(driver3, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        WebElement searchBar1 = driver3.findElement(By.name("q"));
        searchBar1.click();
        searchBar1.sendKeys("SeeTest");
        searchBar1.sendKeys(Keys.ENTER);
        //Thread.sleep(4000);
        System.out.print("Edge TestCase is running in Thread  " + Thread.currentThread().getId());
        driver3.quit();
    }

    @Test
    public void ChromeGoogleSearch() throws InterruptedException {
        //RemoteWebDriver driver2;
        driver4 = new ChromeDriver();
        //EdgeOptions options = new EdgeOptions();
        //WebDriver driver2 = new EdgeDriver(options);
        //options.BinaryLocation = @"/usr/local/bin/msedge";
        //driver2 = new EdgeDriver(options);

        //System.setProperty("webdriver.edge.driver2","/usr/local/bin/msedgedriver");
        //options.AddArgument("headless");
        //options.BinaryLocation = @"/usr/local/bin/msedge";
        //System.setProperty("webdriver.edge.driver2","/usr/local/bin/msedge");
        DesiredCapabilities dc4 = new DesiredCapabilities();
        //DesiredCapabilities dc2 = DesiredCapabilities.edge();
        dc4.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        dc4.setCapability("testName", "Quick Start Chrome Browser Demo");
        //driver2 = new EdgeDriver(dc2);
        //driver2 = new RemoteWebDriver(url, dc2);
        driver4.get("https://www.google.com");
        new WebDriverWait(driver4, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        WebElement searchBar1 = driver4.findElement(By.name("q"));
        searchBar1.click();
        searchBar1.sendKeys("SeeTest");
        searchBar1.sendKeys(Keys.ENTER);
        //Thread.sleep(4000);
        System.out.print("Edge TestCase is running in Thread  " + Thread.currentThread().getId());
        driver4.quit();
    }

    /*@Test
    public void YandexGoogleSearch() throws InterruptedException { //https://webdriver.ru/blog/2015-05-19-operachromiumdriver/
        driver5 = new OperaDriver(); //https://stackoverflow.com/questions/30707783/java-selenium-webdriver-with-yandex
        OperaOptions options = new OperaOptions();
        options.setBinary("/System/Volumes/Data/Applications/Yandex.app");
        WebDriver driver5 = new OperaDriver(options);

        DesiredCapabilities capabilities5 = new DesiredCapabilities();
        capabilities5.setCapability(CapabilityType.BROWSER_NAME, BrowserType.OPERA_BLINK);
        capabilities5.setCapability("testName", "Quick Start Yandex Browser Demo");
        driver5.get("https://www.google.com");
        new WebDriverWait(driver5, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        WebElement searchBar1 = driver5.findElement(By.name("q"));
        searchBar1.click();
        searchBar1.sendKeys("SeeTest");
        searchBar1.sendKeys(Keys.ENTER);
        //Thread.sleep(4000);
        System.out.print("Edge TestCase is running in Thread  " + Thread.currentThread().getId());
        driver5.quit();
    }

    @Test
    public void EdgeGoogleSearch() throws InterruptedException {
        //RemoteWebDriver driver2;
        driver2 = new EdgeDriver();
        //EdgeOptions options = new EdgeOptions();
        //WebDriver driver2 = new EdgeDriver(options);
        //options.BinaryLocation = @"/usr/local/bin/msedge";
        //driver2 = new EdgeDriver(options);

        //System.setProperty("webdriver.edge.driver2","/usr/local/bin/msedgedriver");
        //options.AddArgument("headless");
        //options.BinaryLocation = @"/usr/local/bin/msedge";
        //System.setProperty("webdriver.edge.driver2","/usr/local/bin/msedge");

        DesiredCapabilities dc2 = new DesiredCapabilities();
        //DesiredCapabilities dc2 = DesiredCapabilities.edge();
        dc2.setCapability(CapabilityType.BROWSER_NAME, BrowserType.EDGE);
        dc2.setCapability("testName", "Quick Start Edge Browser Demo");
        //driver2 = new EdgeDriver(dc2);
        //driver2 = new RemoteWebDriver(url, dc2);

        driver2.get("https://www.google.com");
        new WebDriverWait(driver2, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        WebElement searchBar1 = driver2.findElement(By.name("q"));
        searchBar1.click();
        searchBar1.sendKeys("SeeTest");
        searchBar1.sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        System.out.print("Edge TestCase is running in Thread  " + Thread.currentThread().getId());
        driver2.quit();
    }*/
}
