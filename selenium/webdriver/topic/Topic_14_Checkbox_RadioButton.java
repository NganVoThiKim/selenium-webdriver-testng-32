package webdriver.topic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Topic_14_Checkbox_RadioButton {
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
    public void TC_01_Telerik_Default_CheckboxRadio() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        driver.manage().window().fullscreen();
        WebElement dualCheckboxEle = driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input"));
        // Select on checkbox
        if (dualCheckboxEle.isEnabled() && !dualCheckboxEle.isSelected()) {
            dualCheckboxEle.click();
        }
        Assert.assertTrue(dualCheckboxEle.isSelected());
        // De-select on checkbox
        if (dualCheckboxEle.isEnabled() && dualCheckboxEle.isSelected()) {
            dualCheckboxEle.click();
        }
        Assert.assertFalse(dualCheckboxEle.isSelected());

        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        //driver.manage().window().fullscreen();
        //driver.manage().window().maximize();
        WebElement radio2Dot0BtnEle = driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input"));
        if (radio2Dot0BtnEle.isEnabled() && !radio2Dot0BtnEle.isSelected()) {
            radio2Dot0BtnEle.click();
        }
        Assert.assertTrue(radio2Dot0BtnEle.isSelected());
        if (radio2Dot0BtnEle.isEnabled() && radio2Dot0BtnEle.isSelected()) {
            radio2Dot0BtnEle.click();
        }
        Assert.assertTrue(radio2Dot0BtnEle.isSelected());

        WebElement radio2Dot0103kwEle = driver.findElement(By.xpath("//label[text()='2.0 Diesel, 103kW']/preceding-sibling::span/input"));
        // Scroll before clicking
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
        Thread.sleep(3000);
        if (radio2Dot0103kwEle.isEnabled() && !radio2Dot0103kwEle.isSelected()) {
            radio2Dot0103kwEle.click();
            Thread.sleep(2000);
        }
        Assert.assertTrue(radio2Dot0103kwEle.isSelected());

    }

    @Test
    public void TC_02_Material_Default_CheckboxRadio() throws InterruptedException {
        driver.get("https://material.angular.io/components/radio/examples");
        //((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
        driver.manage().window().fullscreen();
        Thread.sleep(1000);
        WebElement summerRadioEle = driver.findElement(By.cssSelector("input[Value='Summer']"));
        if (summerRadioEle.isEnabled() && !summerRadioEle.isSelected()) {
            summerRadioEle.click();
        }
        Assert.assertTrue(summerRadioEle.isSelected());

        driver.get("https://material.angular.io/components/checkbox/examples");
        WebElement checkedCheckboxEle = driver.findElement(By.xpath("//label[text()='Checked']/preceding-sibling::div/input"));
        WebElement indeterminateCheckboxEle = driver.findElement(By.xpath("//label[text()='Indeterminate']/preceding-sibling::div/input"));
        if(checkedCheckboxEle.isEnabled() && !checkedCheckboxEle.isSelected()){
            checkedCheckboxEle.click();
        }
        Assert.assertTrue(checkedCheckboxEle.isSelected());

        if(indeterminateCheckboxEle.isEnabled() && !indeterminateCheckboxEle.isSelected()){
            indeterminateCheckboxEle.click();
        }
        Assert.assertTrue(indeterminateCheckboxEle.isSelected());

        if(checkedCheckboxEle.isEnabled() && checkedCheckboxEle.isSelected()){
            checkedCheckboxEle.click();
        }
        Assert.assertFalse(checkedCheckboxEle.isSelected());

        if(indeterminateCheckboxEle.isEnabled() && indeterminateCheckboxEle.isSelected()){
            indeterminateCheckboxEle.click();
        }
        Assert.assertFalse(indeterminateCheckboxEle.isSelected());

    }

    @Test
    public void TC_03_Automationfc_SelectAll_CheckboxRadio() throws InterruptedException {
        driver.get("https://automationfc.github.io/multiple-fields/");

        // Select all checkboxs
        List<WebElement> allCheckboxs = driver.findElements(By.cssSelector("div.form-input-wide span[class='form-checkbox-item']>input"));
        for (WebElement checkbox : allCheckboxs){
            if(checkbox.isEnabled() && !checkbox.isSelected()){
                checkbox.click();
            }
        }

        // Verify all checkboxs selected
        for(WebElement checkbox : allCheckboxs){
            Assert.assertTrue(checkbox.isSelected());
        }

        // Deselect all checkboxs
        for (WebElement checkbox : allCheckboxs){
            if(checkbox.isEnabled() && checkbox.isSelected()){
                checkbox.click();
            }
        }

        // Verify all checkboxs deselected
        for(WebElement checkbox : allCheckboxs){
            Assert.assertFalse(checkbox.isSelected());
        }

        // Select 1 checkbox " Heart Attack " in all
        // Way 1:
        WebElement heartAttackCheckboxEle = driver.findElement(By.cssSelector("input[value='Heart Attack']"));
        if(heartAttackCheckboxEle.isEnabled() && !heartAttackCheckboxEle.isSelected()){
            heartAttackCheckboxEle.click();
        }
        Assert.assertTrue(heartAttackCheckboxEle.isSelected());

        // Way 2:
        for(WebElement checkbox : allCheckboxs){
            if(!checkbox.isSelected() && checkbox.getAttribute("value").equals("Emphysema")){
                checkbox.click();
            }
        }
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Emphysema']")).isSelected());
    }

    @Test
    public void TC_04_Ubuntu_Custom_CheckboxRadio(){
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
    public void TC_05_Docs_Custom_CheckboxRadio() {
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

