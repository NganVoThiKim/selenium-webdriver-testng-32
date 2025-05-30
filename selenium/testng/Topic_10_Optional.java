package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Topic_10_Optional {

    /**
     * RunTest.xml
     *
     * <suite name="Suite4_Optional_Live_Guru" verbose="1">
     *     <parameter name="server" value="Production"/>
     *
     *     <test name="Run on Firefox">
     * <!--        <parameter name="browser" value="Firefox"/>-->
     *         <classes>
     *             <class name="testng.Topic_10_Optional"/>
     *         </classes>
     *     </test>
     * </suite>
     *
     * ******/

    WebDriver driver;
    By emailTextbox = By.cssSelector("input#email");
    By passwordTextbox = By.cssSelector("input#pass");
    By loginButton = By.cssSelector("button#send2");

    String domainURL;
    String username = "selenium_11_01@gmail.com";
    String password = "111111";

    @Parameters({"server","browser"})
    @BeforeClass
    public void beforeClass(String serverName, @Optional("Firefox") String browserName) {
        if(serverName.equalsIgnoreCase("Dev")){
            domainURL = "http://dev.techpanda.org";
        } else if (serverName.equalsIgnoreCase("Testing")) {
            domainURL = "http://testing.techpanda.org";
        } else if (serverName.equalsIgnoreCase("UAT")) {
            domainURL = "http://uat.techpanda.org";
        } else if (serverName.equalsIgnoreCase("Production")) {
            domainURL = "http://live.techpanda.org";
        }

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

        driver.get(domainURL + "/index.php/customer/account/login/");

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



