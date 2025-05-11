package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Always_Run {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        Assert.assertTrue(false);
    }

    @Test
    public void TC_01(){
        System.out.println("Run TC_01");
    }

    @Test
    public void TC_02(){
        System.out.println("Run TC_02");
    }

    @Test
    public void TC_03(){
        System.out.println("Run TC_03");
    }

    @AfterClass (alwaysRun = true)
    public void afterClass(){
        driver.quit();

    }


}
