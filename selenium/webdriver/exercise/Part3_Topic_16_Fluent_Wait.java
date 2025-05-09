package webdriver.exercise;

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

public class Part3_Topic_16_Fluent_Wait {

    // EXERCISE: https://docs.google.com/document/d/1YHmFR2m0aPi29TQJm67_DAUXGUajm5qF7qpCdyACyxg/edit?tab=t.0#heading=h.7x0a584f2g4u
    WebDriver driver;
    FluentWait<WebDriver> driverFluentWait;

    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();

    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_08_Count_Down() {

        driver.get("https://automationfc.github.io/fluent-wait/");
        Assert.assertTrue(isEndMatching(By.cssSelector("div#javascript_countdown_time")));

    }

    @Test
    public void TC_09_Dynamic_Loading() {

        driver.get("https://automationfc.github.io/dynamic-loading/");
        findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(getElementText(By.cssSelector("div#finish>h4")), "Hello World!");

    }

    @Test
    public void TC_09_Dynamic_Loading_() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        findElement(By.cssSelector("div#start>button")).click();

        Assert.assertTrue(isElementDisplayed(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")));
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

