package javaTester.javaException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumException {
    WebDriver driver;
    WebDriverWait explicitWait;

//    @Test
    public void TC_01_NoSuchElementException() {
        driver = new FirefoxDriver();
        driver.get("https://live.techpanda.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.findElement(By.xpath("//a[text()='Automation Testing']")).click();
    }

//    @Test
    public void TC_02_ElementNotInteractableException() {
        driver = new FirefoxDriver();
        driver.get("https://live.techpanda.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.findElement(By.xpath("//header[@id='header']//a[text()='My Account']")).click();
    }

//    @Test
    public void TC_03_StaleElementReferenceException() {
        driver = new FirefoxDriver();
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        explicitWait =  new WebDriverWait(driver, Duration.ofSeconds(10));

        // BEFORE PAGE RENDER
        // Wait and verify calendar is visible
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1"))).isDisplayed());

        // Verify text before selecting date
        WebElement selectedDateText = driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"));
        Assert.assertEquals(selectedDateText.getText(),"No Selected Dates to display.");

        // Click on day
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='22']"))).click();

        // Wait and verify loading is invisible
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id$='RadCalendar1']>div.raDiv"))));

        // AFTER PAGE RENDER AGAIN
        // Wait and verify text after selecting date
        Assert.assertEquals(selectedDateText.getText(),"Thursday, May 22, 2025");
    }

//    @Test
    public void TC_04_NoAlertPresentException() {
        driver = new FirefoxDriver();
        driver.get("https://live.techpanda.org/");
        driver.switchTo().alert().accept();
    }

//    @Test
    public void TC_05_InvalidSelectorException_GivenCssSelectorExpression() {
        driver = new FirefoxDriver();
        driver.get("https://live.techpanda.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.findElement(By.cssSelector("//a[text()='Automation Testing']")).click();
    }

//    @Test
    public void TC_06_ElementNotInteractableException_ElementIsNotReachableByKeyboard() {
        driver = new FirefoxDriver();
        driver.get("https://automationfc.github.io/basic-form/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.findElement(By.cssSelector("#disable_password")).sendKeys("automation");
    }

//    @Test
    public void TC_07_NoSuchFrameException() {
        driver = new FirefoxDriver();
        driver.get("https://automationfc.github.io/basic-form/");
        driver.switchTo().frame(0);
    }

//    @Test
    public void TC_08_NoSuchWindowException() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("https://automationfc.github.io/basic-form/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        System.out.println(driver.getCurrentUrl());
        driver.close();
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void TC_09_NoSuchSessionException() {
        driver = new FirefoxDriver();
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.quit();
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();

    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
