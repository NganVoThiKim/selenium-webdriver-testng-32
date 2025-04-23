package webdriver.topic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_20_IFrame_Frame {
    WebDriver driver;
    Select select;
    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_Iframe_ToiDiCodeDao(){
        driver.get("https://toidicodedao.com/");
        WebElement iframeFB = driver.findElement(By.cssSelector("iframe[title='fb:page Facebook Social Plugin']"));
        Assert.assertTrue(iframeFB.isDisplayed());
        driver.switchTo().frame(iframeFB);
        Assert.assertEquals(driver.findElement(By.cssSelector("div._1drq")).getText(),"402,002 followers");

    }
    @Test
    public void TC_02_Iframe_FormSite() throws InterruptedException {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        // Close Cookie Banner
        driver.findElement(By.cssSelector("button.osano-cm-dialog__close")).click();

        // Click on image to show iframe
        driver.findElement(By.cssSelector("img[alt='Campus Safety Survey']")).click();
        Thread.sleep(2000);

        // Switch to Iframe
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe#frame-one85593366")));

        // Interact with elements in Iframe
        select = new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2")));
        select.selectByVisibleText("Junior");
        Thread.sleep(2000);
        select = new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-3")));
        select.selectByVisibleText("South Dorm");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[text()='Female']")).click();
        Thread.sleep(2000);

        // Switch from iframe to homepage
        driver.switchTo().defaultContent();

        // Interact with elements in homepage
        driver.findElement(By.xpath("//div[@class='container']/child::a[text()='Log in']")).click();

        driver.findElement(By.cssSelector("button#login")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(),"Username and password are both required.");
    }

    @Test
    public void TC_03_Frame_OnlyRun_Chrome_Edge(){
        driver.get("https://netbanking.hdfcbank.com/netbanking/");

        // Switch to Frame
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='login_page']")));

        // Interact with elements in frame
        driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("automationfc");
        driver.findElement(By.cssSelector("a.login-btn")).click();

        // Back from frame to homepage
        driver.switchTo().defaultContent();

        // Interact with elements in homepage
        driver.findElement(By.cssSelector("input#keyboard")).sendKeys("123456");
        Assert.assertEquals(driver.findElement(By.cssSelector("a#forgotPassword")).getText(),"Forgot Password / IPIN");


    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

