package webdriver.topic;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.SequenceOfUint8;
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

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Topic_30_Explicit_Ajax {
    WebDriver driver;
    WebDriverWait explicitWait;
    String uploadFilePath = System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator;

    String hoiAn = "Hoi An.jpg";
    String hue = "Hue.jpg";
    String haLong = "Ha Long.jpg";

    String hoiAnPath = uploadFilePath + hoiAn;
    String huePath = uploadFilePath + hue;
    String haLongPath = uploadFilePath + haLong;
    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(30));
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_Explicit_Telerik(){

        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        // Wait and verify calendar is visible
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1"))).isDisplayed());

        // Verify text before selecting date
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),"No Selected Dates to display.")));

        // Click on day
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='22']"))).click();

        // Wait and verify loading is invisible
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id$='RadCalendar1']>div.raDiv"))));

        // Wait and verify text after selecting date
        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),"Thursday, May 22, 2025")));

    }

    @Test
    public void TC_02_Explicit_Telerik_Has_Error_StaleElementReferenceException(){

        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        // Wait and verify calendar is visible
        Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1"))).isDisplayed());

        // Verify text before selecting date
//        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),"No Selected Dates to display.")));
        WebElement selectedDateText = driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"));
        Assert.assertEquals(selectedDateText.getText(),"No Selected Dates to display.");

        // Click on day
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='22']"))).click();

        // Wait and verify loading is invisible
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id$='RadCalendar1']>div.raDiv"))));

        // Wait and verify text after selecting date
//        Assert.assertTrue(explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"),"Thursday, May 22, 2025")));
        Assert.assertEquals(selectedDateText.getText(),"Thursday, May 22, 2025");

    }

    @Test
    public void TC_02_Explicit_GoFile() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://gofile.io/?t=uploadFiles");

        // Wait and verify loading is invisible
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.animate-spin"))));

        // Upload file
        By uploadFileBy = By.xpath("//input[@type='file']");

        // Load file
        driver.findElement(uploadFileBy).sendKeys(hoiAnPath + "\n" + huePath + "\n" + haLongPath);

        // Wait and verify loading in upload is invisible
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.animate-spin"))));

        // Wait progress bar of image loaded done
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.file-item div.progress-container")))));

        // Wait loading of progress bar is invisible
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.animate-spin")))));

        // Wait link can be clicked
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.grid-cols-1 div.text-sm>a"))).click();

        // Wait loading after upload successfully is invisible
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("main#index_main div#filemanager_loading>div.animate-spin"))));

        // Wait images are loaded
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("main#index_main div.truncate img"))));

        // Verify show icon "Download and Play"
        List<WebElement> playBtns = explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("div.flex-row button.item_play"))));
        Assert.assertEquals(playBtns.size(),3);
        Assert.assertEquals(explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("div.flex-row button.item_download")))).size(),3);


    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

