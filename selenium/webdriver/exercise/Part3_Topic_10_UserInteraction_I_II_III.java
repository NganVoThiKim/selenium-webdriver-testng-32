package webdriver.exercise;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Part3_Topic_10_UserInteraction_I_II_III {
    // EXERCISE: https://docs.google.com/document/d/15MqNX4HLiR29Vn2XhFhugTb2AJpAT16tiEGHzQ0GeFo/edit?tab=t.0#heading=h.ziag9o95npet
    WebDriver driver;
    Actions action;
    WebDriverWait wait;
    Alert alert;
    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_Hover_Tooltip_Automationfc(){
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        action.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(),"We ask for your age only for statistical purposes.");

    }

//    @Test
//    public void TC_02_Hover_Myntra() throws InterruptedException {
//        driver.get("http://www.myntra.com/");
//        driver.manage().window().maximize();
//        action.moveToElement(driver.findElement(By.xpath("//div[@class='desktop-navContent']//a[text()='Kids']"))).perform();
//        action.click(driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text()='Personal Care']"))).perform();
//        Thread.sleep(2000);
//        Assert.assertEquals(driver.findElement(By.cssSelector("span.breadcrumbs-crumb")).getText(),"Kids Wear Online Store");
//    }

    @Test
    public void TC_03_Hover_Fahasa(){
        driver.get("https://www.fahasa.com/");
        driver.findElement(By.cssSelector("g#close-popup")).click();
        action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
        action.click(driver.findElement(By.xpath("//div[@class='fhs_column_stretch']/descendant::a[text()='Kỹ Năng Sống']"))).perform();
        Assert.assertEquals(driver.findElement(By.xpath("//ol[@class='breadcrumb']/descendant::strong[text()='Kỹ năng sống']")).getText(),"KỸ NĂNG SỐNG");

    }

    @Test
    public void TC_04_ClickAndHold_Select_Multiple_Item() throws InterruptedException {
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
    public void TC_05_ClickAndSelect_Select_Random_Item() throws InterruptedException {
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
    public void TC_06_DoubleClick(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(),"Hello Automation Guys!");
    }

    @Test
    public void TC_07_RightClick() throws InterruptedException {
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        // Right click
        action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
        WebElement quitOptionEle = driver.findElement(By.cssSelector("li.context-menu-icon-quit"));
        Assert.assertTrue(quitOptionEle.isDisplayed());
        // Hover
        action.moveToElement(quitOptionEle).perform();
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-visible.context-menu-hover")).isDisplayed());
        // Click
        action.click(quitOptionEle).perform();
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"clicked: quit");
        alert.accept();
        Thread.sleep(2000);
        // Verify "Quit" menu is closed
        Assert.assertFalse(quitOptionEle.isDisplayed());

    }

    @Test
    public void TC_08_DragAndDrop_HTML4(){
        driver.get("https://automationfc.github.io/kendo-drag-drop/");
        WebElement dragEle = driver.findElement(By.cssSelector("div#draggable"));
        WebElement dropEle = driver.findElement(By.cssSelector("div#droptarget"));
        action.dragAndDrop(dragEle,dropEle).perform();
        Assert.assertEquals(dropEle.getText(),"You did great!");
        String colorBackgroundValue = dropEle.getCssValue("background-color");
        Color color = Color.fromString(colorBackgroundValue);
        String colorAsHex = color.asHex();
        Assert.assertEquals(colorAsHex,"#03a9f4");
    }


    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

