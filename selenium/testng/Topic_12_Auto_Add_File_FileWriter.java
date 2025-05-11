package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;
import java.util.Random;

public class Topic_12_Auto_Add_File_FileWriter {
    WebDriver driver;
    Random random;
    String firstName, lastName, emailAddress, password, confirmPass, prefixMail, postfixMail, reviewTextArea, summaryReview, nickName;
    Properties prop = new Properties();
    String projectPath = System.getProperty("user.dir");
    FileOutputStream outputStream;


    @BeforeClass
    public void initialBrowser() throws FileNotFoundException {
        driver = new ChromeDriver();
        firstName = "Automation";
        lastName = "FC";
        prefixMail = "automation";
        postfixMail = "@gmail.com";
        random = new Random();

        password = "123456";
        confirmPass = "123456";
        reviewTextArea = "Good application\nPretty\nEasy to navigate";
        summaryReview = "Very good";
        nickName = firstName;
        driver.get("https://live.techpanda.org/");

    }

    @Test
    public void CreateManyAccounts() throws InterruptedException, IOException {
        // Register

        emailAddress = prefixMail + random.nextInt(999999) + postfixMail;
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        driver.findElement(By.xpath("//div[@class='buttons-set']//span[text()='Create an Account']")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.cssSelector("#confirmation")).sendKeys(confirmPass);
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector("div.buttons-set button[title='Register']")).click();

        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div.nav-wrapper button[id='proceed-button']")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Thank you for registering with Main Website Store.");

        System.out.println("Email Address:" + emailAddress);
        System.out.println("Password:" + password);

        FileWriter writer = new FileWriter("dataTest/example.txt", true);
        writer.write("Email Address:" + emailAddress);
        writer.write("Password:" + password);
        writer.close();

        // Logout
        driver.findElement(By.cssSelector("div.account-cart-wrapper>a")).click();
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();
        Thread.sleep(6000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/");
    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() throws IOException {

        driver.quit();
    }

}

