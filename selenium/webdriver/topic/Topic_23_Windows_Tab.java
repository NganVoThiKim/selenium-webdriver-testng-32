package webdriver.topic;

import com.sun.jdi.ThreadReference;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.thread.TestNGThreadFactory;

import java.time.Duration;
import java.util.Set;

public class Topic_23_Windows_Tab {
    WebDriver driver;
    Actions action;

    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        action = new Actions(driver);
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_Window_Automationfc() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        // Move to Google tab (Driver still exist at Github tab)
        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        Thread.sleep(2000);
        System.out.println("ID of Github: " + driver.getWindowHandle());
        System.out.println("URL of Github: " + driver.getCurrentUrl());
        System.out.println("Title of Github: " + driver.getTitle());
        String githubID = driver.getWindowHandle();
        String githubTitle = driver.getTitle();

        // Switch to Google tab (Driver existed at Google tab)
        switchBetweenTwoWindowsByID(githubID);
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), "Google");
        System.out.println("ID of Google: " + driver.getWindowHandle());
        // Interact with element on google tab
        //driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("automation", Keys.ENTER);

        // Back to Github tab
        switchBetweenTwoWindowsByID(driver.getWindowHandle());
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), "Selenium WebDriver");

        // Switch to FB tab
        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        switchBetweenTwoWindowsByID(githubID);
        System.out.println("ID of Facebook: " + driver.getWindowHandle());
        Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");

        // Back to Github tab
        switchBetweenManyWindowsByTitle(githubTitle);
        Assert.assertEquals(driver.getTitle(), "Selenium WebDriver");

        // Switch to Tiki tab
        driver.findElement(By.xpath("//a[text()='TIKI']")).click();
        switchBetweenTwoWindowsByID(githubID);
        //switchBetweenManyWindowsByTitle("Mua Hàng Trực Tuyến Uy Tín với Giá Rẻ Hơn tại Tiki.vn");
        //Assert.assertEquals(driver.getTitle(), "Mua Hàng Trực Tuyến Uy Tín với Giá Rẻ Hơn tại Tiki.vn");
        System.out.println("ID of Tiki: " + driver.getWindowHandle());

        // Close all tabs without parent tab
        closeAllTabsWithoutParentTab(githubID);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Selenium WebDriver");

    }

    @Test
    public void TC_02_Windows_Techpanda() throws InterruptedException {
        driver.get("http://live.techpanda.org/");
        driver.manage().window().maximize();
        String mobileWindowID = driver.getWindowHandle();
        String mobileWindowTitle = driver.getTitle();

        // Click to view all mobiles
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        Thread.sleep(2000);

        // Add 2 items to compare
        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']/descendant::a[@class='link-compare']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"The product Sony Xperia has been added to comparison list.");

        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/descendant::a[@class='link-compare']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"The product Samsung Galaxy has been added to comparison list.");

        // Switch to Compare window
        driver.findElement(By.cssSelector("button[title='Compare']")).click();
        Thread.sleep(2000);
        switchBetweenTwoWindowsByID(mobileWindowID);
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/catalog/product_compare/index/");
        Assert.assertEquals(driver.getTitle(),"Products Comparison List - Magento Commerce");
        driver.close();

        // Switch driver back to Mobile window
        switchBetweenManyWindowsByTitle(mobileWindowTitle);
        driver.findElement(By.xpath("//a[text()='Clear All']")).click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"The comparison list was cleared.");

    }

    @Test
    public void TC_03_Windows_Cambridge() throws InterruptedException {
        driver.get("https://dictionary.cambridge.org/vi/");
        driver.findElement(By.xpath("//header[@id='header']//span[text()='Đăng nhập']")).click();
        Thread.sleep(2000);
        String cambrigeWindowID = driver.getWindowHandle();

        // Switch to Login window
        switchBetweenTwoWindowsByID(cambrigeWindowID);
        driver.findElement(By.cssSelector("input[value='Log in']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("span#gigya-error-msg-gigya-login-form-loginID")).getText(),"This field is required");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#gigya-error-msg-gigya-login-form-password")).getText(),"This field is required");
        closeAllTabsWithoutParentTab(cambrigeWindowID);

        // Back to Parent tab
        driver.findElement(By.cssSelector("input#searchword")).sendKeys("automation", Keys.ENTER);
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#cald4-1~div.pos-header span.hw.dhw")).getText(),"automation");

    }

    @Test
    public void TC_04_Windows_Harvard() throws InterruptedException{
        driver.get("https://courses.dce.harvard.edu/");
        driver.manage().window().maximize();
        String courseWindowID = driver.getWindowHandle();
        String courseWindowTitle = driver.getTitle();
        driver.findElement(By.cssSelector("div.banner__auth")).click();
        Thread.sleep(2000);

        // Switch to Login window
        switchBetweenTwoWindowsByID(courseWindowID);
        Assert.assertEquals(driver.getTitle(),"Harvard Division of Continuing Education Login Portal");

        // Close Login window -> Back to Course Window
        //closeAllTabsWithoutParentTab(courseWindowID);
        driver.close();
//        switchBetweenTwoWindowsByID(courseWindowID);
        switchBetweenManyWindowsByTitle(courseWindowTitle);
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("p.sam-wait__message")).getText(),"Authentication was not successful. Please try again.");

        driver.findElement(By.cssSelector("button.sam-wait__close")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input#crit-keyword")).sendKeys("Data Science");
        Thread.sleep(2000);
        new Select(driver.findElement(By.cssSelector("select#crit-srcdb"))).selectByVisibleText("Extension Fall Term 2024");
        Thread.sleep(2000);
        new Select(driver.findElement(By.cssSelector("select#crit-session"))).selectByVisibleText("Full Term");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button#search-button")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.panel__info-bar-text")).getText(),"Found 43 courses");


    }

    @Test
    public void TC_05_Windows_Selenium_4x_Techpanda() throws InterruptedException{
        driver.get("http://live.techpanda.org/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        Thread.sleep(2000);
        System.out.println("Driver ID: " + driver.toString());
        System.out.println("Window ID: " + driver.getWindowHandle());
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        String mobileWindowTitle = driver.getTitle();

        System.out.println("-------------NEW WINDOW --------------");
        // Open New Window (Open switch to new window)
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://live.techpanda.org/index.php/customer/account/login/");
        Thread.sleep(2000);

        System.out.println("Driver ID: " + driver.toString());
        System.out.println("Window ID: " + driver.getWindowHandle());
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.cssSelector("button#send2")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(),"This is a required field.");
        driver.close();
        Thread.sleep(2000);

        // Switch to parent window
        switchBetweenManyWindowsByTitle(mobileWindowTitle);

        System.out.println("-------------NEW TAB --------------");
        // Open New Tab
        driver.switchTo().newWindow(WindowType.TAB).get("https://live.techpanda.org/index.php/customer/account/login/");
        Thread.sleep(2000);

        System.out.println("Driver ID: " + driver.toString());
        System.out.println("Window ID: " + driver.getWindowHandle());
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.cssSelector("button#send2")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(),"This is a required field.");
        driver.close();
        Thread.sleep(2000);

        // Switch to parent window
        switchBetweenManyWindowsByTitle(mobileWindowTitle);





    }


    private void closeAllTabsWithoutParentTab(String parentTabID) throws InterruptedException {
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs) {
            driver.switchTo().window(id);
            if (!id.equals(parentTabID)) {
                driver.close();
                Thread.sleep(2000);
            }
        }
        // Closed tab but driver still exists on closed tab -> Need switch back parent tab
        driver.switchTo().window(parentTabID);
    }

    private void switchBetweenManyWindowsByTitle(String titleOfTargetWindow) {
        // Get all windows
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs) {
            // Switch to the specific window
            driver.switchTo().window(id);
            String title = driver.getTitle();
            if (title.equals(titleOfTargetWindow)) {
                driver.switchTo().window(id);
                break;
            }
        }

    }

    private void switchBetweenTwoWindowsByID(String originalTabID) {
        originalTabID = driver.getWindowHandle();
        // Switch to 2nd tab
        Set<String> windowIDs = driver.getWindowHandles();
        for (String id : windowIDs) {
            if (!id.equals(originalTabID)) {
                driver.switchTo().window(id);
            }
        }
    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

