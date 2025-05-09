package webdriver.topic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.time.Duration;
import java.util.Date;

public class Topic_30_Mix_Implicit_Explicit {
    WebDriver driver;
    WebDriverWait explicitWait;

    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_Element_Found_Mix() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        // Wait with explicit
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));

        // Wait with implicit
        driver.findElement(By.cssSelector("input#email"));
    }

    @Test
    public void TC_02_Element_Not_Found_Only_Implicit_Find_Locator() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        // Show error = NoSuchElementException
        driver.findElement(By.cssSelector("input#selenium"));

    }

    @Test
    public void TC_03_Element_Not_Found_Only_Explicit_Find_Locator() {

        // Implicit = 0;
        // Explicit = 2;

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(2));

        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        System.out.println("Start:" + getDateTimeNow());
        // Show error = TimeoutException
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#selenium")));
        } catch (Exception e) {
            System.out.println("End:" + getDateTimeNow());
            throw new RuntimeException(e);
        }

    }

    @Test
    public void TC_03_Element_Not_Found_Only_Explicit_Find_Element() {

        // Implicit = 0;
        // Explicit = 2;

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(2));

        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        System.out.println("Start:" + getDateTimeNow());
        // Show error = NoSuchElementException
        try {
            explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#selenium"))));
        } catch (Exception e) {
            System.out.println("End:" + getDateTimeNow());
            throw new RuntimeException(e);
        }

    }

    @Test
    public void TC_04_Element_Not_Found_Implicit_Less_Than_Explicit() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(8));

        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        System.out.println(getDateTimeNow());

        // Take total time 8s and show error at second = 8 (tried for 4 second(s) with 500 milliseconds interval)
        // Show error = TimeoutException
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#selenium")));
        } catch (Exception e) {
            System.out.println(getDateTimeNow());
            throw new RuntimeException(e);
        }

    }

    @Test
    public void TC_05_Element_Not_Found_Implicit_Greater_Than_Explicit() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(4));

        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        System.out.println(getDateTimeNow());

        // Take total time 8s and show error at second = 8 (tried for 4 second(s) with 500 milliseconds interval)
        // Show error = TimeoutException
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#selenium")));
        } catch (Exception e) {
            System.out.println(getDateTimeNow());
            throw new RuntimeException(e);
        }

    }

    @Test
    public void TC_06_Element_Not_Found_Implicit_Equal_Explicit() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(8));

        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        System.out.println(getDateTimeNow());

        // Take total time 8s and show error at second = 8 (tried for 8 second(s) with 500 milliseconds interval)
        // Show error = TimeoutException
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#selenium")));
        } catch (Exception e) {
            System.out.println(getDateTimeNow());
            throw new RuntimeException(e);
        }

    }


    private String getDateTimeNow() {
        Date date = new Date();
        return date.toString();
    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

