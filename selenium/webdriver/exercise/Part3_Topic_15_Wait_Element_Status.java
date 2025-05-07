package webdriver.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Part3_Topic_15_Wait_Element_Status {
    // EXERCISE: https://docs.google.com/document/d/1YHmFR2m0aPi29TQJm67_DAUXGUajm5qF7qpCdyACyxg/edit?tab=t.0
    WebDriver driver;
    WebDriverWait explicitWait;
    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(20));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_Visible(){
        driver.get("https://www.facebook.com/");

        // Condition 1: Wait to show on UI and DOM
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));

    }

    @Test
    public void TC_01_Invisible(){
        driver.get("https://www.facebook.com/");

        // Click on "Create new account" to show "First name"
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();

        // Wait to "First name" visible
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='firstname']")));

        // Condition 2: Wait to show on DOM but NOT show on UI
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("select#preferred_pronoun")));

        // Click "Already have an acc?" to close screen
        driver.findElement(By.cssSelector("a[aria-label='Already have an account?']")).click();

        // Condition 3: Wait to NOT show on UI and DOM
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("select#preferred_pronoun")));
    }

    @Test
    public void TC_01_Presence(){
        driver.get("https://www.facebook.com/");

        // Click on "Create new account" to show "First name"
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();

        // Wait to "First name" visible
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='firstname']")));

        // Click on "Custom" checkbox to show "Select your pronoun"
        driver.findElement(By.xpath("//label[text()='Custom']/input")).click();

        // Condition 1: Wait to show on UI and DOM
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("select#preferred_pronoun")));

        // Click on "Female" to hide "Select your pronoun"
        driver.findElement(By.xpath("//label[text()='Female']/input")).click();

        // Condition 2: Wait to show on DOM but NOT show on UI
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("select#preferred_pronoun")));


    }

    @Test
    public void TC_01_Staleness(){
        driver.get("https://www.facebook.com/");

        // Click on "Create new account" to show "First name"
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();

        // Wait to "First name" visible
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='firstname']")));

        // Find "Select your pronoun" still shows in DOM without UI
        WebElement customSex = driver.findElement(By.cssSelector("select#preferred_pronoun"));

        // Click "Already have an acc?" to close screen
        driver.findElement(By.cssSelector("a[aria-label='Already have an account?']")).click();

        // Condition 3: Wait to NOT show on UI and DOM
        explicitWait.until(ExpectedConditions.stalenessOf(customSex));
    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

