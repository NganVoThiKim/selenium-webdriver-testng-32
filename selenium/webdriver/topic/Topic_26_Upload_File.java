package webdriver.topic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Topic_26_Upload_File {
    WebDriver driver;
    String uploadFilePath = System.getProperty("user.dir") + File.separator + "uploadFiles" + File.separator;

    String hoiAn = "Hoi An.jpg";
    String hue = "Hue.jpg";
    String haLong = "Ha Long.jpg";

    String hoiAnPath = uploadFilePath + hoiAn;
    String huePath = uploadFilePath + hue;
    String haLongPath = uploadFilePath + haLong;

    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_Upload_Single_File() throws InterruptedException {

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadFileBy = By.xpath("//input[@type='file']");

        // Load file
        driver.findElement(uploadFileBy).sendKeys(hoiAnPath);
        Thread.sleep(2000);

        driver.findElement(uploadFileBy).sendKeys(huePath);
        Thread.sleep(2000);

        driver.findElement(uploadFileBy).sendKeys(haLongPath);
        Thread.sleep(2000);

        // Verify file is loaded
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + hoiAn + "'] ")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + hue + "'] ")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + haLong + "'] ")).isDisplayed());

        // Upload file
        List<WebElement> startBtnList = driver.findElements(By.cssSelector("table button.start"));
        for (WebElement startBtn : startBtnList) {
            startBtn.click();
            Thread.sleep(2000);
        }

        // Verify file is uploaded successfully
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + hoiAn + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + hue + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + haLong + "']")).isDisplayed());


    }

    @Test
    public void TC_02_Upload_Multiple_Files() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By uploadFileBy = By.xpath("//input[@type='file']");

        // Load file
        driver.findElement(uploadFileBy).sendKeys(hoiAnPath + "\n" + huePath + "\n" + haLongPath);
        Thread.sleep(2000);

        // Verify file is loaded
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + hoiAn + "'] ")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + hue + "'] ")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + haLong + "'] ")).isDisplayed());

        // Upload file
        List<WebElement> startBtnList = driver.findElements(By.cssSelector("table button.start"));
        for (WebElement startBtn : startBtnList) {
            startBtn.click();
            Thread.sleep(2000);
        }

        // Verify file is uploaded successfully
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + hoiAn + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + hue + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='" + haLong + "']")).isDisplayed());

    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

