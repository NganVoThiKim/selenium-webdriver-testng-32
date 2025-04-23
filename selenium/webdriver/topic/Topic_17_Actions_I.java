package webdriver.topic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Actions_I {
    // EXERCISE: https://docs.google.com/document/d/15MqNX4HLiR29Vn2XhFhugTb2AJpAT16tiEGHzQ0GeFo/edit?tab=t.0#heading=h.ziag9o95npet
    WebDriver driver;
    Actions action;
    WebDriverWait wait;
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

    @Test
    public void TC_02_Hover_Myntra() throws InterruptedException {
        driver.get("http://www.myntra.com/");
        driver.manage().window().maximize();
        action.moveToElement(driver.findElement(By.xpath("//div[@class='desktop-navContent']//a[text()='Kids']"))).perform();
        action.click(driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text()='Personal Care']"))).perform();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("span.breadcrumbs-crumb")).getText(),"Kids Wear Online Store");
    }

    @Test
    public void TC_03_Hover_Fahasa(){
        driver.get("https://www.fahasa.com/");
        driver.findElement(By.cssSelector("g#close-popup")).click();
        action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
        action.click(driver.findElement(By.xpath("//div[@class='fhs_column_stretch']/descendant::a[text()='Kỹ Năng Sống']"))).perform();
        Assert.assertEquals(driver.findElement(By.xpath("//ol[@class='breadcrumb']/descendant::strong[text()='Kỹ năng sống']")).getText(),"KỸ NĂNG SỐNG");

    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

