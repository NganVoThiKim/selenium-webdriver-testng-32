package webdriver.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Part3_Topic_09_Custom_Checkbox_RadioButton {
    WebDriver driver;
    private WebElement summerRadioEle;
    WebDriverWait wait;
    JavascriptExecutor jsExecute;
    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        jsExecute = (JavascriptExecutor) driver;
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify

    @Test
    public void TC_05_Ubuntu_Custom_CheckboxRadio(){
        driver.get("https://login.ubuntu.com/");

        // Way 1:
        /**
         * Using <label> tag to .click()
         * Using <input> tag to verify
         **/
        By newUserLabelTag = By.cssSelector("label[for='id_new_user']");
        By newUserInputTag = (By.cssSelector("input#id_new_user"));
//        driver.findElement(newUserLabelTag).click();
//        Assert.assertTrue(driver.findElement(newUserInputTag).isSelected());

        // Way 2:
        /**
         * Using (JavascriptExecutor)
         * Only use <input> tag to .click() and verify
         * */
        jsExecute.executeScript("arguments[0].click()", driver.findElement(newUserInputTag));
        Assert.assertTrue(driver.findElement(newUserInputTag).isSelected());

        By termCheckboxInputTag = By.cssSelector("input#id_accept_tos");
        jsExecute.executeScript("arguments[0].click()",driver.findElement(termCheckboxInputTag));
        Assert.assertTrue(driver.findElement(termCheckboxInputTag).isSelected());

    }

    @Test
    public void TC_06_Docs_Custom_CheckboxRadio() {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        By canThoRadio = By.xpath("//div[@data-value='Cần Thơ']");
        driver.findElement(canThoRadio).click();
        //Assert.assertTrue(driver.findElement(By.xpath("//div[@data-value='Cần Thơ' and @aria-checked='true']")).isDisplayed());
        Assert.assertEquals(driver.findElement(canThoRadio).getAttribute("aria-checked"),"true");

        By quangTriCheckbox = By.cssSelector("div[aria-label='Quảng Trị']");
        driver.findElement(quangTriCheckbox).click();
        Assert.assertEquals(driver.findElement(quangTriCheckbox).getAttribute("aria-checked"),"true");
    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

