package webdriver.topic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_10_Textbox_TextArea {
    // EXERCISE: https://docs.google.com/document/d/1QRI6jdKoCiMB3K7s16f3jEtAVHICdROpw_t30RD8gac/edit?tab=t.0
    WebDriver driver;
    Random random;
    String firstName, lastName, emailAddress, password, confirmPass, prefixMail, postfixMail, reviewTextArea, summaryReview, nickName;


    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
        firstName = "Automation";
        lastName = "FC";
        prefixMail = "automation";
        postfixMail = "@gmail.com";
        random = new Random();
        emailAddress = prefixMail + random.nextInt(999999) + postfixMail;
        password = "123456";
        confirmPass = "123456";
        reviewTextArea = "Good application\nPretty\nEasy to navigate";
        summaryReview = "Very good";
        nickName = firstName;
    }

    @Test
    public void TC_01_TechpandaWithTextboxTextarea() throws InterruptedException {
        // Register
        driver.get("https://live.techpanda.org/");
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
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Thank you for registering with Main Website Store.");
        String contactInformation = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(contactInformation.contains(firstName + " " + lastName) && contactInformation.contains(emailAddress));

        // Add review
        driver.findElement(By.xpath("//div[@id='header-nav']//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();
        driver.findElement(By.cssSelector("input[id='Quality 1_5']")).click();
        driver.findElement(By.cssSelector("textarea#review_field")).sendKeys(reviewTextArea);
        driver.findElement(By.cssSelector("input#summary_field")).sendKeys(summaryReview);
        driver.findElement(By.xpath("//span[text()='Submit Review']")).click();

        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div.nav-wrapper button[id='proceed-button']")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),"Your review has been accepted for moderation.");

        // Logout
        driver.findElement(By.cssSelector("div.account-cart-wrapper>a")).click();
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();
        Thread.sleep(6000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/");
    }

    @Test
    public void TC_02_() {
    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

