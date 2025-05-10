package webdriver.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Part3_Topic_16_Page_Ready {
    // EXERCISE: https://docs.google.com/document/d/1YHmFR2m0aPi29TQJm67_DAUXGUajm5qF7qpCdyACyxg/edit?tab=t.0#heading=h.xoe64s2flshl
    WebDriver driver;
    WebDriverWait explicitWait;

    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_10_PageReady_Loading_Icon_Invisible() {

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

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

