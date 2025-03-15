package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_Template{
    WebDriver driver;
    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_Register(){

    }
    @Test
    public void TC_02_Login(){
    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

