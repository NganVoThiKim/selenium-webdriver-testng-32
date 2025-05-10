package webdriver.topic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_33_Page_Ready {
    WebDriver driver;
    WebDriverWait explicitWait;

    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    // This testcase can't run because can't by pass captcha
    @Test
    public void TC_01_PageReady_Loading_Icon_Invisible() {

        driver.get("https://admin-demo.nopcommerce.com");

        // Fill data and login
        WebElement emailEle = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#Email")));
        emailEle.clear();
        emailEle.sendKeys("admin@yourstore.com");

        WebElement passEle = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#Password")));
        passEle.clear();
        passEle.sendKeys("admin");

        driver.findElement(By.cssSelector("button.login-button")).click();

        // Wait loading is invisible
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ajaxBusy>span"))));

        // Click "Logout"
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']"))).click();
        System.out.println("aa");

        // Verify back to login page
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#main form"))).isDisplayed());


    }

    @Test
    public void TC_02_PageReady_Function(){
        isPageLoadedSuccess();
    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

    public boolean isPageLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }
}



