package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;

public class Topic_07_If_Else {
    public static void main(String[] args) {
        WebDriver driver;
        String osName = System.getProperty("os.name");
        String browserName = "Chrome";

        // If
        if(browserName.equals("IE")){
            System.out.println("Click on SUBMIT button");
        }

        // If - else
        if(osName.contains("Mac")){
            System.out.println("Mac OS");
        } else {
            System.out.println("Windows or Linus OS");
        }
        System.out.println(osName);

        // If-else-if-else
        if (browserName.equals("Chrome")){
            driver = new ChromeDriver();
        } else if (browserName.equals("Firefox")){
            driver = new FirefoxDriver();
        } else {
            driver = new EdgeDriver();
        }

        // Switch-case
        switch (browserName){
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new EdgeDriver();
                break;
        }
    }
}
