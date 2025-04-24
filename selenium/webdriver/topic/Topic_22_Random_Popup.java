package webdriver.topic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_22_Random_Popup {
    WebDriver driver;

    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_Random_Popup_Vnk_In_DOM() throws InterruptedException {
        driver.get("https://vnk.edu.vn/");
        By popupMakeBy = By.cssSelector("div.popmake");

        // Exist popup
        if (driver.findElements(popupMakeBy).size() > 0 && driver.findElement(popupMakeBy).isDisplayed()) {
            System.out.println("-----------GO TO IF------------");
            driver.findElement(By.cssSelector("button.popmake-close")).click();
            Thread.sleep(2000);
            Assert.assertFalse(driver.findElement(popupMakeBy).isDisplayed());
        }
        // Not exist popup -> Continue action
        System.out.println("-----------IGNORE IF------------");
        driver.findElement(By.cssSelector("button.btn-danger")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://vnk.edu.vn/lich-khai-giang/");

    }

    @Test
    public void TC_02_Random_Popup_JavaCodeGeek_In_DOM() throws InterruptedException {
        driver.get("https://www.javacodegeeks.com/");
        Thread.sleep(5000);
        By bookPopupBy = By.xpath("//div[contains(@class,'lepopup-form') and @data-title='Newsletter Free eBooks' and not(contains(@style,'display:none'))]");

        // Exist Popup
        if (driver.findElements(bookPopupBy).size() > 0 && driver.findElement(bookPopupBy).isDisplayed()) {
            System.out.println("-----------GO TO IF------------");
            driver.findElement(By.xpath("//a[contains(@onclick,'lepopup_close')]")).click();
            Thread.sleep(2000);
            Assert.assertFalse(driver.findElement(bookPopupBy).isDisplayed());
        }
        // Not exist popup
        System.out.println("-----------IGNORE IF------------");
        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile vs Waterfall");
        driver.findElement(By.cssSelector("button#search-submit")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.tag-waterfall-model h2 a")).getText(), "Agile vs Waterfall: Can They Coexist?");

    }

    @Test
    public void TC_03_Random_Popup_DeHieu_In_DOM() throws InterruptedException {
        driver.get("https://dehieu.vn/");
        By popupBy = By.cssSelector("div.modal-content");
        // Exist Popup
        if (driver.findElements(popupBy).size() > 0 && driver.findElement(popupBy).isDisplayed()) {
            System.out.println("-----------GO TO IF------------");
            driver.findElement(By.cssSelector("button.close")).click();
            Thread.sleep(2000);
            Assert.assertFalse(driver.findElement(popupBy).isDisplayed());
        }
        // Not exist popup
        System.out.println("-----------IGNORE IF------------");
        driver.findElement(By.cssSelector("input.search-form")).sendKeys("Thiết kế tủ điện");
        driver.findElement(By.cssSelector("button.header-search")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("a[title='Thiết kế tủ điện']>div")).getText(),"Thiết kế tủ điện");
    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

