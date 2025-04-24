package webdriver.topic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_21_Fixed_Popup {
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

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

