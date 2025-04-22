package webdriver.topic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_13_Button {
    WebDriver driver;
    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_Fahasa(){
        // Step 01: Open page
        driver.get("https://www.fahasa.com/customer/account/create");

        // Step 02: Nevigate to "Dang nhap" tab
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        WebElement loginBtnEle = driver.findElement(By.cssSelector("button.fhs-btn-login")) ;
        // Step 03: Verify "Dang nhap" button is disabled
        Assert.assertFalse(loginBtnEle.isEnabled());

        // Step 04: Verify background color of "Dang nhap" = grey color
        //Assert.assertEquals(loginBtnEle.getCssValue("background-color"),"rgba(0, 0, 0, 0)");
        String loginBtnBackgroundColor = loginBtnEle.getCssValue("background-color");
        Color loginBtnColor = Color.fromString(loginBtnBackgroundColor);
        String loginBtnHexColor = loginBtnColor.asHex().toUpperCase();
        Assert.assertEquals(loginBtnHexColor,"#000000");

        // Step 05: Input valid data into User, Pass
        driver.findElement(By.cssSelector("input#login_username")).sendKeys("a@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");

        // Step 06: Verify "Dang nhap" button is enabled
        Assert.assertTrue(loginBtnEle.isEnabled());

        // Step 07: Verify background color = red
        Assert.assertEquals((Color.fromString(driver.findElement(By.cssSelector("button.fhs-btn-login")).getCssValue("background-color"))).asHex().toUpperCase(),"#C92127");
    }

    @Test
    public void TC_02_Goconsensus(){
        // Can't open this page
    }

    @Test
    public void TC_03_Huawei(){
        // Step 01: Open page
//        driver.get("https://id5.cloud.huawei.com/CAS/portal/userRegister/regbyemail.html");
//
//        // Step 02: Verify "Register" button is disabled
//        WebElement registerBtnEle = driver.findElement(By.xpath("//span[text()='Register']/ancestor::div[contains(@class,'hwid-btn')]"));
//        Assert.assertFalse(registerBtnEle.isEnabled());
//
//        // Step 03: Verify background color of button = red
//        Assert.assertEquals((Color.fromString(registerBtnEle.getCssValue("background-color"))).asHex().toUpperCase(),"#CA141D");

        // Step 04: Input with valid data into all fields

    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

