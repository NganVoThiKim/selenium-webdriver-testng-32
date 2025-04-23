package webdriver.topic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class Topic_18_Actions_II {
    WebDriver driver;
    Actions action;
    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        action = new Actions(driver);
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_ClickAndHold_Select_Multiple_Item() throws InterruptedException {
        // WAY 1:
        driver.get("https://automationfc.github.io/jquery-selectable/");
//        WebElement number1Ele = driver.findElement(By.xpath("//li[text()='1']"));
//        WebElement number4Ele = driver.findElement(By.xpath("//li[text()='4']"));
//        action.clickAndHold(number1Ele).release(number4Ele).perform();
//        Thread.sleep(2000);
//        List<WebElement> selectedElements = driver.findElements(By.cssSelector("li.ui-selected"));
//        Assert.assertEquals(selectedElements.size(),4);

        // WAY 2:
        List<WebElement> allSelectedNumbers = driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(allSelectedNumbers.size(),20);
        action.clickAndHold(allSelectedNumbers.get(0)) // Click and hold left mouse at number 1
                .moveToElement(allSelectedNumbers.get(3)) // Hover to number 4
                .release() // Release left mouse
                .perform(); // Required to action
        List<WebElement> selectedElements = driver.findElements(By.cssSelector("li.ui-selected"));
        Assert.assertEquals(selectedElements.size(),4);

    }
    @Test
    public void TC_02_ClickAndSelect_Select_Random_Item() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        WebElement number1Ele = driver.findElement(By.xpath("//li[text()='1']"));
        WebElement number3Ele = driver.findElement(By.xpath("//li[text()='3']"));
        WebElement number6Ele = driver.findElement(By.xpath("//li[text()='6']"));
        WebElement number11Ele = driver.findElement(By.xpath("//li[text()='11']"));
        action.keyDown(Keys.COMMAND).perform();
        action.click(number1Ele)
                .click(number3Ele)
                .click(number6Ele)
                .click(number11Ele)
                .perform();
        action.keyUp(Keys.COMMAND).perform();
        Thread.sleep(2000);
        List<WebElement> selectedElements = driver.findElements(By.cssSelector("li.ui-selected"));
        Assert.assertEquals(selectedElements.size(),4);

    }

    @Test
    public void TC_03_DoubleClick(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(),"Hello Automation Guys!");
    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

