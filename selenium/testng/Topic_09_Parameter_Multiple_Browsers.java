package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_09_Parameter_Multiple_Browsers {

    /**
     * RunTest.xml
     *
     * <!--<suite name="Suite2_Run Multiple Browser_Live_Guru" verbose="1">-->
     * <!--    <parameter name="server" value="dev"/>-->
     * <!--    <test name="Run on Chrome">-->
     * <!--        <parameter name="browser" value="Chrome"/>-->
     * <!--        <classes>-->
     * <!--            <class name="testng.Topic_09_Parameter_Multiple_Browsers"/>-->
     * <!--        </classes>-->
     * <!--    </test>-->
     *
     * <!--    <test name="Run on Firefox">-->
     * <!--        <parameter name="browser" value="Firefox"/>-->
     * <!--        <classes>-->
     * <!--            <class name="testng.Topic_09_Parameter_Multiple_Browsers"/>-->
     * <!--        </classes>-->
     * <!--    </test>-->
     *
     * <!--    <test name="Run on Edge">-->
     * <!--        <parameter name="browser" value="Edge"/>-->
     * <!--        <classes>-->
     * <!--            <class name="testng.Topic_09_Parameter_Multiple_Browsers"/>-->
     * <!--        </classes>-->
     * <!--    </test>-->
     * <!--</suite>-->
     *
     * ****/

    WebDriver driver;
    By emailTextbox = By.cssSelector("input#email");
    By passwordTextbox = By.cssSelector("input#pass");
    By loginButton = By.cssSelector("button#send2");

    String username = "selenium_11_01@gmail.com";
    String password = "111111";

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        // .equalsIgnoreCase(): Compare value without upper or lower case

        // If - Else
//        if(browserName.equalsIgnoreCase("Chrome")) {
//            driver = new ChromeDriver();
//        } else if (browserName.equalsIgnoreCase("Firefox")) {
//            driver = new FirefoxDriver();
//        } else if (browserName.equalsIgnoreCase("Edge")) {
//            driver = new EdgeDriver();
//        } else if (browserName.equalsIgnoreCase("Safari")) {
//            driver = new SafariDriver();
//        } else {
//            throw new RuntimeException("Browser name is invalid");
//        }

        // Switch - Case
        switch (browserName){
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is invalid");

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void loginOnMultipleBrowser() {

        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(emailTextbox).sendKeys(username);
        driver.findElement(passwordTextbox).sendKeys(password);
        driver.findElement(loginButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains(username));
        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}



