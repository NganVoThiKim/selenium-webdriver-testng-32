package webdriver.topic;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.*;
import java.nio.charset.Charset;
import java.time.Duration;

public class Topic_19_Actions_III {
    WebDriver driver;
    Actions action;
    Alert alert;
    JavascriptExecutor jsExecutor;
    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        action = new Actions(driver);
        jsExecutor = (JavascriptExecutor) driver;
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_RightClick() throws InterruptedException {
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
    public void TC_02_DragAndDrop_HTML4(){
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

    @Test
    public void TC_03_DragAndDrop_HTML5_JQuery() throws InterruptedException, IOException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");

        // WAY 1:
//        WebElement aColumn = driver.findElement(By.cssSelector("div#column-a"));
//        WebElement bColumn = driver.findElement(By.cssSelector("div#column-b"));
//        // Drag A -> B
//        action.dragAndDrop(aColumn,bColumn).perform();
//        Thread.sleep(1000);
//        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"B");
//        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"A");
//
//        // Drag B -> A
//        action.dragAndDrop(bColumn,aColumn).perform();
//        Thread.sleep(1000);
//        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"A");
//        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"B");

        // WAY 2: Javascrip/JQuery (Only work with CSS)
        String projectPath = System.getProperty("user.dir");
        String jQueryDragDropContent = getContentFile(projectPath + File.separator + "dragDrop" + File.separator + "dragAndDrop.js");
        jsExecutor.executeScript(jQueryDragDropContent);
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"B");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"A");
        jsExecutor.executeScript(jQueryDragDropContent);
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"A");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"B");
    }

    @Test
    public void TC_04_DragAndDrop_HTML5_Without_JQuery() throws InterruptedException, IOException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");
        // Site doesn't support jQuery
        String projectPath = System.getProperty("user.dir");
        String jQueryLibrary = getContentFile(projectPath + File.separator + "dragDrop" + File.separator + "jQueryLib.js");
        jsExecutor.executeScript(jQueryLibrary);
        // Run code of jquery
        String jQueryDragDropContent = getContentFile(projectPath + File.separator + "dragDrop" + File.separator + "dragAndDrop.js");
        jsExecutor.executeScript(jQueryDragDropContent);
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"B");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"A");
        jsExecutor.executeScript(jQueryDragDropContent);
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"A");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"B");

    }

    @Test
    public void TC_05_DragAndDrop_HTML5_Java_Robot() throws AWTException, InterruptedException {
        driver.get("https://automationfc.github.io/drag-drop-html5/");
        driver.manage().window().fullscreen();
        dragAndDropHTML5ByXpath("//div[@id='column-a']","//div[@id='column-b']");
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(),"B");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(),"A");


    }


    public String getContentFile(String filePath) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(filePath);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            stream.close();
        }
    }

    public void dragAndDropHTML5ByXpath(String sourceLocator, String targetLocator) throws AWTException {

        WebElement source = driver.findElement(By.xpath(sourceLocator));
        WebElement target = driver.findElement(By.xpath(targetLocator));

        // Setup robot
        Robot robot = new Robot();
        robot.setAutoDelay(500);

        // Get size of elements
        Dimension sourceSize = source.getSize();
        Dimension targetSize = target.getSize();

        // Get center distance
        int xCentreSource = sourceSize.width / 2;
        int yCentreSource = sourceSize.height / 2;
        int xCentreTarget = targetSize.width / 2;
        int yCentreTarget = targetSize.height / 2;

        Point sourceLocation = source.getLocation();
        Point targetLocation = target.getLocation();

        // Make Mouse coordinate center of element
        sourceLocation.x += 20 + xCentreSource;
        sourceLocation.y += 110 + yCentreSource;
        targetLocation.x += 20 + xCentreTarget;
        targetLocation.y += 110 + yCentreTarget;

        // Move mouse to drag from location
        robot.mouseMove(sourceLocation.x, sourceLocation.y);

        // Click and drag
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x, ((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);

        // Move to final position
        robot.mouseMove(targetLocation.x, targetLocation.y);

        // Drop
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }


    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

