package webdriver.topic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_28_Implicit_Wait {
    WebDriver driver;
    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_Implicit_No_Set(){
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        // Show err = "NoSuchElementException"
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

    }
    @Test
    public void TC_02_Implicit_Less_Than(){
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        // Wait 4s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        // Show err = "NoSuchElementException"
        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");
    }

    @Test
    public void TC_03_Implicit_Equal(){
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        // Wait 5s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");
    }

    @Test
    public void TC_04_Implicit_Greater_Than(){
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        // Wait 5s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");
    }

    @Test
    public void TC_05_Implicit_Combine(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        // Show err = "ElementNotInteractableException" -> Element shows in DOM but can't show on UI to click

        driver.findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

