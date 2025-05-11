package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.Driver;

public class Topic_02_Assertions {
    WebDriver driver;

    @Test
    public void TC_01_Assert_True() {

        // AssertTrue: check - expected result returns True
        // Selenium: isDisplayed/ isSelected/ isEnabled/ isMultiple
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isDisplayed());
    }

    @Test
    public void TC_02_Assert_False() {

        // AssertFalse: check - expected result returns False
        // Selenium: isDisplayed/ isSelected/ isEnabled/ isMultiple
        Assert.assertFalse(driver.findElement(By.cssSelector("")).isEnabled());
    }

    @Test
    public void TC_03_Assert_Equal() {

        // AssertEquals: check - expected result equals actual result
        // Selenium: getText/ getCss/ getTitle/ getUrl
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getText(),"abc");
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getAttribute("placeholder"),"");
        Assert.assertEquals(driver.findElement(By.cssSelector("")).getSize(),2);

    }


}
