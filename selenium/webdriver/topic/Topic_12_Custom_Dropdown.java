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

public class Topic_12_Custom_Dropdown {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    // Behavior to interact with dropdown
    /* 1. Wait to visible dropdown which can interact (clickable)
     * 2. Click on dropdown to show all items
     * 3. Wait to presence all items (presence)
     * 4. Find item which map with expectation
     * 5. Click on that item
     */
    //

    @Test
    public void TC_01_JQuery(){
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        selectItemInCustomDropdown("span#speed-button", "ul#speed-menu>li>div", "Medium");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span[class='ui-selectmenu-text']")).getText(),"Medium");

        selectItemInCustomDropdown("span#speed-button", "ul#speed-menu>li>div", "Slower");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span[class='ui-selectmenu-text']")).getText(),"Slower");

        selectItemInCustomDropdown("span#speed-button", "ul#speed-menu>li>div", "Faster");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span[class='ui-selectmenu-text']")).getText(),"Faster");

        selectItemInCustomDropdown("span#files-button", "ul#files-menu>li[class='ui-menu-item']>div", "Some other file with a very long option text");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button>span[class='ui-selectmenu-text']")).getText(),"Some other file with a very long option text");

        selectItemInCustomDropdown("span#number-button", "ul#number-menu>li", "18");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button")).getText(),"18");

        selectItemInCustomDropdown("span#salutation-button", "ul#salutation-menu>li[class='ui-menu-item']>div", "Prof.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button")).getText(),"Prof.");
    }

    @Test
    public void TC_02_ReactJS(){
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectItemInCustomDropdown("div.dropdown","div.dropdown>div.menu>div","Stevie Feliciano");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.dropdown>div.text")).getText(),"Stevie Feliciano");

        selectItemInCustomDropdown("div.dropdown","div.dropdown>div.menu>div","Matt");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.dropdown>div.divider.text")).getText(),"Matt");
    }

    @Test
    public void TC_03_VueJS(){
        driver.get("https://mikerodham.github.io/vue-dropdowns/");

        selectItemInCustomDropdown("li.dropdown-toggle","ul.dropdown-menu>li>a","Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Third Option");

    }

    @Test
    public void TC_04_Editable(){
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

        searchItemInCustomDropdown("input.search","div.menu>div>span","Australia");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.dropdown>div.text")).getText(),"Australia");

        searchItemInCustomDropdown("input.search","div.menu>div>span","Belgium");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.dropdown>div.text")).getText(),"Belgium");

        searchItemInCustomDropdown("input.search","div.menu>div>span","Benin");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.dropdown>div.text")).getText(),"Benin");

    }

    private void selectItemInCustomDropdown(String dropdownSel, String optionListSel, String optionTextSel) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(dropdownSel))).click();
        List<WebElement> allOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(optionListSel)));
        for(WebElement option : allOptions){
            if(option.getText().equals(optionTextSel)){
                option.click();
                break;
            }
        }
    }

    // Behavior to interact with dropdown which allow to SEARCH
    /* 1. Wait to visible dropdown which can input (visibility)
     * 2. Sendkey on dropdown
     * 3. Wait to presence all items (presence)
     * 4. Find item which map with expectation
     * 5. Click on that item
     */
    //

    private void searchItemInCustomDropdown(String dropdownSel, String optionListSel, String optionTextSel) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(dropdownSel))).sendKeys(optionTextSel);
        List<WebElement> allOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(optionListSel)));
        for(WebElement option : allOptions){
            if(option.getText().equals(optionTextSel)){
                option.click();
                break;
            }
        }
    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

