package webdriver.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Part3_Topic_07_Default_Dropdown {
    //EXERCISE: https://docs.google.com/document/d/1QRI6jdKoCiMB3K7s16f3jEtAVHICdROpw_t30RD8gac/edit?tab=t.0#heading=h.85dnvumg7p9
    WebDriver driver;
    Select select;
    String countryOption, cityValue ;
    WebDriverWait wait;

    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        countryOption = "Vietnam";
        cityValue = "HO CHI MINH";
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void TC_01_Facebook_Register(){
        driver.get("http://facebook.com/reg/");
        select = new Select(driver.findElement(By.cssSelector("select#day")));

        // Select option
        select.selectByValue("27");

        // Verify selected option
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"27");

        // Verify dropdown is multiple/single
        // Multiple -> Return true
        // Single -> Return false
        Assert.assertFalse(select.isMultiple());

        // Verify item amount total
        Assert.assertEquals(select.getOptions().size(),31);

    }
    @Test
    public void TC_02_NopCommerce(){
        driver.get("https://demo.nopcommerce.com");
        // By pass this exercise because dropdown on site is removed.

    }

    @Test
    public void TC_03_Rode(){
        driver.get("https://www.rode.com/wheretobuy");
        select = new Select(driver.findElement(By.cssSelector("select#country")));
        Assert.assertFalse(select.isMultiple());
        select.selectByVisibleText(countryOption);
        driver.findElement(By.cssSelector("input#map_search_query")).sendKeys(cityValue);
        driver.findElement(By.cssSelector("div.location_filter>button")).click();
        List<WebElement> dealers = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h3[text()='Dealers']/following-sibling::div/div/descendant::h4")));
        Assert.assertEquals(dealers.size(),16);
        for (WebElement dealer : dealers){
            System.out.println(dealer.getText());
        }

    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

