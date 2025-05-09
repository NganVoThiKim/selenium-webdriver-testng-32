package webdriver.topic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class Topic_30_Explicit_Functions {
    WebDriver driver;
    WebDriverWait explicitWait;

    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();

        // Default "Polling Time" = 0.5s (After 0.5s -> Re-find element)
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));

        // Allow to edit "Polling Time" = 0.2s
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofMillis(200));
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_Explicit_Wait_Functions(){

        // Wait element doesn't show on UI and DOM (Before that: Element exists)
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(""))));

        // Wait element shows in DOM (Any show or not on UI)
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));

        // Wait element doesn't show on UI (Any show or not in DOM)
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        // Wait element shows on UI and DOM
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("")));

        // Wait element can click (Button/ Checkbox/ Radio Button=,..)
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));

        // Wait URL of absolute page
        explicitWait.until(ExpectedConditions.urlToBe("https://facebook.com/login"));

        // Wait URL of relative page
        explicitWait.until(ExpectedConditions.urlContains("login"));

        // Wait URL satisfies the REGEX condition
        explicitWait.until(ExpectedConditions.urlMatches("!@#...."));

        // Wait JS returns String data type
        explicitWait.until(ExpectedConditions.jsReturnsValue("return argument[0].validationMessage"));

        // Wait alert presents in DOM
        explicitWait.until(ExpectedConditions.alertIsPresent());

        // Wait title of absolute page
        explicitWait.until(ExpectedConditions.titleIs("Dynamic loading to demo wait in Selenium"));

        //Wait title of relative page
        explicitWait.until(ExpectedConditions.titleContains("Dynamic loading"));

        // Wait satisfies 2 conditions (AND)
        explicitWait.until(ExpectedConditions.and(
                ExpectedConditions.urlContains(""),
                ExpectedConditions.titleContains("")));

        // Wait satisfies 1 of 2 conditions (OR)
        explicitWait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains(""),
                ExpectedConditions.titleContains("")));

        // Wait element with an attribute that equals a specific value
        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector(""),"class","email"));

        // Wait element with an attribute that contains a specific value
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector(""),"class","email"));

        // Wait element with an attribute is different from empty/null
        explicitWait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.cssSelector("")),"class"));

        // Wait element has attribute in DOM = value
        explicitWait.until(ExpectedConditions.domAttributeToBe(driver.findElement(By.cssSelector("")),"innerText","Start"));

        // Wait element has property in DOM = value
        explicitWait.until(ExpectedConditions.domPropertyToBe(driver.findElement(By.cssSelector("")),"innerText","Start"));

        // Wait element selected (Checkbox/ Radio/ Dropdown/,..)
        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));

        // Wait element selected successfully
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""),true));

        // Wait element de-selected successfully
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""),false));

        // Wait frame/iframe presents and switch to
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("")));

        // Wait JS executes but not return "Exception"
        explicitWait.until(ExpectedConditions.javaScriptThrowsNoExceptions("return argument[0].validationMessage"));

        // Negation of wait
        explicitWait.until(ExpectedConditions.not(ExpectedConditions.javaScriptThrowsNoExceptions("return argument[0].validationMessage")));

        // Wait 1 list elements
        List<WebElement> allNumberSelected = explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(""),3));
        Assert.assertEquals(allNumberSelected.size(),3);

        explicitWait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector(""),3));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(""),3));

        // Wait amount of window/tab
        explicitWait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Wait text = absolute value
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector(""),""));
        explicitWait.until(ExpectedConditions.textMatches(By.cssSelector(""), Pattern.compile("a*b")));

        // Wait refresh page
        explicitWait.until(ExpectedConditions.refreshed(ExpectedConditions.numberOfWindowsToBe(2)));


    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

