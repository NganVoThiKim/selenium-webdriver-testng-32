package webdriver.topic;

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

public class Topic_30_Explicit_Loading {
    WebDriver driver;
    WebDriverWait explicitWait;
    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_Explicit_Less_Than(){

        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(3));

        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4"))).getText(),"Hello World!");

    }
    @Test
    public void TC_02_Explicit_Equal(){
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));

        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4"))).getText(),"Hello World!");

    }

    @Test
    public void TC_03_Explicit_Greater_Than(){
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15));

        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4"))).getText(),"Hello World!");

    }

    @Test
    public void TC_04_Explicit_Invisible_Loading(){

        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15));

        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        // Invisible loading
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));

        // Verify text
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div#finish>h4"),"Hello World!")));

    }

    @Test
    public void TC_05_Explicit_Visible_Text(){

        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(15));

        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        // Wait and verify loading is invisibled
        Boolean loadingStatus = explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));
        Assert.assertTrue(loadingStatus);

        // Wait and verify text is visibled
        WebElement helloTextEle = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));
        Assert.assertTrue(helloTextEle.isDisplayed());

        // Wait and verify text is correct
        Boolean textStatus = explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div#finish>h4"),"Hello World!"));
        Assert.assertTrue(textStatus);
    }


    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

