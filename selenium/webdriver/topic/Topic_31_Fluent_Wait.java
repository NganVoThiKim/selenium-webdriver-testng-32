package webdriver.topic;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_31_Fluent_Wait {
    WebDriver driver;
    FluentWait<WebDriver> driverFluentWait;

    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();

    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_Dynamic_Loading() {

        driver.get("https://automationfc.github.io/dynamic-loading/");
        findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(getElementText(By.cssSelector("div#finish>h4")), "Hello World!");

    }

    @Test
    public void TC_02_Dynamic_Loading() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        findElement(By.cssSelector("div#start>button")).click();

        Assert.assertTrue(isElementDisplayed(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")));
    }

    @Test
    public void TC_03_Count_Down() {

        driver.get("https://automationfc.github.io/fluent-wait/");
        Assert.assertTrue(isEndMatching(By.cssSelector("div#javascript_countdown_time")));

    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

    // Find element
    public WebElement findElement(By by) {

        driverFluentWait = new FluentWait<>(driver);

        driverFluentWait.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                System.out.println("1s runs 10 times");
                return driver.findElement(by);
            }
        });
    }

    // Check element is display
    public boolean isElementDisplayed(By by) {

        driverFluentWait = new FluentWait<>(driver);

        driverFluentWait.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElement(by).isDisplayed();
            }
        });
    }

    // Get text
    public String getElementText(By by) {

        driverFluentWait = new FluentWait<>(driver);

        driverFluentWait.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebDriver, String>() {
            @Override
            public String apply(WebDriver driver) {
                return driver.findElement(by).getText();
            }
        });
    }

    // End with specified condition
    public boolean isEndMatching(By by) {

        driverFluentWait = new FluentWait<>(driver);

        driverFluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.findElement(by).getText().endsWith("00");
            }
        });
    }

}

