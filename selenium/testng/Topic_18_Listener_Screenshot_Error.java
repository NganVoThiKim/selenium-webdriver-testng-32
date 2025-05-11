package testng;

import listener.ScreenshotListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(ScreenshotListener.class)
public class Topic_18_Listener_Screenshot_Error {
    public WebDriver getDriver() {
        return driver;
    }

    WebDriver driver;
    By emailTextbox = By.cssSelector("input#email");
    By passwordTextbox = By.cssSelector("input#pass");
    By loginButton = By.cssSelector("button#send2");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void listener_Screenshot_Error() {

        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(emailTextbox).sendKeys("selenium_11_01@gmail.com");
        driver.findElement(passwordTextbox).sendKeys("111111");
        driver.findElement(loginButton).click();

        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
        driver.findElement(By.xpath("//a[text()='Log Out1']")).click();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}



