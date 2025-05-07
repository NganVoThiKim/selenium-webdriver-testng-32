package webdriver.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Part3_Topic_15_Wait_Find_Element {
    // EXERCISE: https://docs.google.com/document/d/1YHmFR2m0aPi29TQJm67_DAUXGUajm5qF7qpCdyACyxg/edit?tab=t.0
    WebDriver driver;

    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();

        // Total wait time = 2s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_FindElement_ImplicitWait(){
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        // FOUND ONLY 1 ELEMENT
        // Return 1 element
        // Not wait to 2s
        driver.findElement(By.cssSelector("input#FirstName"));


        // FOUND MANY ELEMENTS
        // Return the first element
        // Not wait to 2s
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("automation");

        // NOT FOUND ELEMENT
        // If not found element -> After 0.5s -> Re-find element
        // After wait max time = 2s -> Not found element -> Show "EXCEPTION"
        // EXCEPTION = .NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":"input#selenium"}
        driver.findElement(By.cssSelector("input#selenium"));

    }

    @Test
    public void TC_01_FindElements_ImplicitWait(){
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        List<WebElement> elements = null;

        // FOUND ONLY 1 ELEMENT
        // Return 1 element
        // Not wait to 2s
        elements = driver.findElements(By.cssSelector("input#FirstName"));
        System.out.println(elements.size());

        // FOUND MANY ELEMENTS
        // Return list of elements
        // Not wait to 2s
        elements = driver.findElements(By.cssSelector("input[type='text']"));
        System.out.println(elements.size());

        // NOT FOUND ELEMENTS
        // If not found element -> After 0.5s -> Re-find element
        // After wait max time = 2s -> Not found element
        // -> Return list = 0
        // -> Testcase = PASS
        elements = driver.findElements(By.cssSelector("input[type='selenium']"));
        System.out.println(elements.size());
    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

