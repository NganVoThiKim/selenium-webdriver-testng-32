package webdriver.topic;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.sql.Time;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrowser_Commands {
    private static final Logger log = LoggerFactory.getLogger(Topic_06_WebBrowser_Commands.class);
    WebDriver driver;

    // Arrange/Act/Assert(AAA) is a pattern for organizing unit tests. It breaks tests into three clear and distinct steps:
    // 1. Arrange: Perform the setup and initialization required for the test
    // 2. Act: Take action(s) required for the test
    // 3. Assert: Verify the outcome(s) of the test

    @BeforeClass
    public void initialBrowser() throws MalformedURLException {

        // Run with browser (Local)
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
//        driver = new EdgeDriver();
//        driver = new SafariDriver();

        // Remote (Grid/ Docker/ Cloud Testing)
        // Networking (LAN/ WAN/ IP/ Port)
//        ChromeOptions chromeOptions = new ChromeOptions();
//        driver = new RemoteWebDriver(new URL("https://localhost:4444"), chromeOptions);

    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_(){

        // Open any 1 URL (Require start with: http/ https)
        driver.get("https://demo.nopcommerce.com/"); //**

        // Close browser (Only close active tab/ window)
        //driver.close(); //*

        // Close browser (Close all tabs/windows of browser)
        //driver.quit(); //**

        // Get title of page (Title shows on tab name)
        String homepageTitle = driver.getTitle();

        // Compare data
        Assert.assertEquals(driver.getTitle(),"nopCommerce demo store. Home page title");
        //Assert.assertTrue(homepageTitle.contains("demo store"));

        // Get URL of the current page
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");

        // Get page code source
        driver.getPageSource();

        // Get ID of tab/window which active
        driver.getWindowHandle();

        // Get all IDs of all tabs/windows
        driver.getWindowHandles();

        // Find 1 element
        driver.findElement(By.xpath("")); //**

        // Find list of elements
        driver.findElements(By.xpath("")); //**

        // Selenium v3 - Wait (Deprecated)
        WebDriver.Options options = driver.manage();

        options.timeouts().implicitlyWait(15, TimeUnit.DAYS);
        options.timeouts().implicitlyWait(15, TimeUnit.HOURS);

        WebDriver.Timeouts timeouts = driver.manage().timeouts();
        timeouts.implicitlyWait(15, TimeUnit.MINUTES);
        timeouts.implicitlyWait(15, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.MICROSECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.NANOSECONDS);

        // Selenium v4
        // Wait to find element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //**

        // Wait to the completed page loading
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        // Wait to the completed javascript loading
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));

        // Zoom in the screen (still show taskbar)
        WebDriver.Window window = driver.manage().window();
        window.maximize(); //*

        // Zoom out the screen
        window.minimize();

        // Full screen (without taskbar)
        driver.manage().window().fullscreen();

        // Show screen at the left corner
        driver.manage().window().setPosition(new Point(0,0));
        System.out.println((driver.manage().window().getPosition()));

        // Responsive
        driver.manage().window().setSize(new Dimension(1024,1366));
        System.out.println((driver.manage().window().getSize()));

        // Get all cookies
        Set<Cookie> cookies = driver.manage().getCookies(); //*
        for(Cookie cookie : cookies){
            System.out.println("cookie = " + cookie);
        }

        // Get 1 cookie with name
        String cookie = (driver.manage().getCookieNamed(".Nop.Antiforgery")).toString();
        Assert.assertTrue(cookie.startsWith(".Nop.Antiforgery="),cookie);

        // Add 1 cookie
        Cookie addCookie = driver.manage().getCookieNamed(".Nop.Customer");
        driver.manage().addCookie(addCookie);
//        Set<Cookie> cookies = driver.manage().getCookies();
//        for(Cookie cooki : cookies){
//            System.out.println("cookie = " + cooki);
//        }

        // Delete 1 cookie
        driver.manage().deleteCookie(addCookie);

        // Delete all cookies
        driver.manage().deleteAllCookies();


        // Refresh page
        WebDriver.Navigation navigation = driver.navigate();
        navigation.refresh();
        navigation.to("https://www.automatetheplanet.com/");

        // Back to the previous page
        navigation.back();

        // Go to the next page
        navigation.forward();

        // Logs
        Logs logs = driver.manage().logs();
//        LogEntries logEntries = logs.get("CLIENT");
//        for(LogEntry logEntry: logEntries){
//            System.out.println(logEntry);
//        }

        System.out.println(logs.getAvailableLogTypes());

        // Alert/ Iframe/ Windows
        WebDriver.TargetLocator targetLocator = driver.switchTo();

        // Alert
        targetLocator.alert().accept(); //*
        targetLocator.alert().dismiss(); //*

        // Frame/Iframe
        targetLocator.frame(""); //*
        targetLocator.defaultContent(); //*

        // Windows
        targetLocator.window(""); //*
        driver.getWindowHandle(); //*
        driver.getWindowHandles(); //*






    }
    @Test
    public void TC_02_Login(){
    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

