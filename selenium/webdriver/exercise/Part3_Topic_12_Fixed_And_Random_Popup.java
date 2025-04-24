package webdriver.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Part3_Topic_12_Fixed_And_Random_Popup {
    WebDriver driver;
    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_Fixed_Popup_NgoaiNgu24h_Not_In_DOM() throws InterruptedException {
        driver.get("https://ngoaingu24h.vn/");
        driver.manage().window().fullscreen();
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        Thread.sleep(3000);
        By popup = By.cssSelector("div.MuiDialog-paper");
        Assert.assertTrue(driver.findElement(popup).isDisplayed());
        driver.findElement(By.cssSelector("input[placeholder='Tài khoản đăng nhập']")).sendKeys("automationfc");
        driver.findElement(By.cssSelector("input[placeholder='Mật khẩu']")).sendKeys("12345678");
        driver.findElement(By.xpath("//div[@class='auth-form']/descendant::button[text()='Đăng nhập']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#notistack-snackbar")).getText(),"Bạn đã nhập sai tài khoản hoặc mật khẩu!");
        driver.findElement(By.cssSelector("button.close-btn")).click();
        Thread.sleep(2000);
        // Assert popup removed from DOM
        Assert.assertEquals(driver.findElements(popup).size(),0);

    }

    @Test
    public void TC_02_Fixed_Popup_Kyna_In_DOM() throws InterruptedException {
        driver.get("https://skills.kynaenglish.vn/dang-nhap");
        driver.manage().window().fullscreen();
        By popupLoginBy = By.cssSelector("div.k-popup-account-mb-content");
        Assert.assertTrue(driver.findElement(popupLoginBy).isDisplayed());

        driver.findElement(By.cssSelector("input#user-login")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#btn-submit-login")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.k-popup-account-mb-content div#password-form-login-message")).getText(),"Sai tên đăng nhập hoặc mật khẩu");

    }

    @Test
    public void TC_03_Fixed_Popup_Tiki_Not_In_DOM() throws InterruptedException {
        driver.get("https://tiki.vn/");
        driver.manage().window().fullscreen();
        // Bundle Popup
        By vipBundlePopupBy = By.cssSelector("div#VIP_BUNDLE");
        Assert.assertTrue(driver.findElement(vipBundlePopupBy).isDisplayed());
        driver.findElement(By.cssSelector("div#VIP_BUNDLE img[alt='close-icon']")).click();
        Thread.sleep(2000);
        // Bundle Popup removed from DOM
        Assert.assertEquals(driver.findElements(vipBundlePopupBy).size(),0);

        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();
        Thread.sleep(2000);

        By loginPopupBy = By.cssSelector("div.ReactModal__Content");
        Assert.assertTrue(driver.findElement(loginPopupBy).isDisplayed());
        driver.findElement(By.cssSelector("div.ReactModal__Content p.login-with-email")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']/descendant::span[@class='error-mess'][1]")).getText(),"Email không được để trống");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']/descendant::span[@class='error-mess'][2]")).getText(),"Mật khẩu không được để trống");

        // Close login popup
        driver.findElement(By.cssSelector("button.btn-close")).click();
        Assert.assertEquals(driver.findElements(loginPopupBy).size(),0);

    }

    @Test
    public void TC_04_Fixed_Popup_Facebook_Not_In_DOM() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        Thread.sleep(2000);
        By createAccPopupBy = By.xpath("//div[text()='Create a new account']/ancestor::div[@class='_52lo']");
        Assert.assertTrue(driver.findElement(createAccPopupBy).isDisplayed());

    }

    @Test
    public void TC_05_Random_Popup_Vnk_In_DOM() throws InterruptedException {
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
    public void TC_06_Random_Popup_JavaCodeGeek_In_DOM() throws InterruptedException {
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
    public void TC_07_Random_Popup_DeHieu_In_DOM() throws InterruptedException {
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

