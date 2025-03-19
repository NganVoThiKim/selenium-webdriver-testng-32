package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Topic_02_Selenium_Locator {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser(){
        // Open browser
        driver = new ChromeDriver();
        // Open web - go to login page
        driver.get("https://demo.nopcommerce.com/register");
    }
    /** RULE to select locator
     * 1. Unique
     *      //input[@name='login[username]']
     *      //input[@id='email']
     *      //input[@title='Email Address']
     *
     * 2. Attribute: High priority if id/ class/ name
     *      //input[@name='login[username]']
     *      //input[@id='email']
     *
     * 3. Attribute non: If no have id/ class/ name -> Using any other attributes
     *
     * 4. Meaning: Value of the attribute must be meaningful - relevant to that element
     *      //input[@title='Email Address']
     *
     * 5. Link: Not use attribute = href (Only using Text/ Title)
     *
     * NOTE:
     *
     * 1. Not replace "tagName" = "*"
     *    Ex: //*[@id='login_username']
     *
     * 2. Not put attribute value into ""
     *    Ex: //input[@id="login_username"]
     * **/


    @Test
    public void TC_00_() {
        //<input class="email" autofocus="" type="email" data-val="true" data-val-regex="Wrong email"
        // data-val-regex-pattern="^(([^<>()\[\]\\.,;:\s@&quot;]+(\.[^<>()\[\]\\.,;:\s@&quot;]+)*)|(&quot;.+&quot;))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$"
        // data-val-required="Please enter your email"
        // id="Email" name="Email">

        // HTML source code
        // tagName - attribute - value

        // Xpath:  //tagName[@attribute='value']
        // CSS:    tagName[attribute='value']

        // Find 1 element
        driver.findElement(By.id(""));

        // 1- Interact directly on element (single use)
        driver.findElement(By.cssSelector("")).click();
        driver.findElement(By.cssSelector("")).sendKeys();

        // 2- Save value (Reusable)
        WebElement emailTextbox = driver.findElement(By.id(""));
        emailTextbox.clear();
        emailTextbox.sendKeys();
        emailTextbox.isDisplayed();

        // Find a lot of elements
        List<WebElement> textBoxs = driver.findElements(By.cssSelector(""));
    }

    @Test
    public void TC_01_ID(){
        driver.findElement(By.id("small-searchterms"));

        driver.findElement(By.id("gender-male"));
        driver.findElement(By.id("gender-female"));
        driver.findElement(By.id("FirstName"));
        driver.findElement(By.id("LastName"));
        driver.findElement(By.id("Email"));

        driver.findElement(By.id("Company"));

        driver.findElement(By.id("Newsletter"));

        driver.findElement(By.id("Password"));
        driver.findElement(By.id("ConfirmPassword"));

        driver.findElement(By.id("register-button"));
    }

    @Test
    public void TC_02_Class(){
        // value of class = without spacing
        driver.findElement(By.className("ico-register"));
        driver.findElement(By.className("ico-login"));
        driver.findElement(By.className("wishlist-label"));
        driver.findElement(By.className("cart-label"));

        driver.findElement(By.className("search-box-text"));
        driver.findElement(By.className("search-box-button"));

        driver.findElement(By.className("register-next-step-button"));



    }

    @Test
    public void TC_03_Name(){
        driver.findElement(By.name("customerCurrency"));

        driver.findElement(By.name("q"));

        driver.findElement(By.name("Gender")).click();
        driver.findElement(By.name("FirstName")).click();
        driver.findElement(By.name("LastName")).click();
        driver.findElement(By.name("Email")).click();

        driver.findElement(By.name("Company")).click();

        driver.findElement(By.name("Newsletter")).click();

        driver.findElement(By.name("Password")).click();
        driver.findElement(By.name("ConfirmPassword")).click();
        driver.findElement(By.name("register-button")).click();
    }

    @Test
    public void TC_04_LinkTest(){
        // Tagname = a and include href
        driver.findElement(By.linkText("Register"));
        driver.findElement(By.linkText("Log in"));
        driver.findElement(By.linkText("Wishlist"));
        driver.findElement(By.linkText("Shopping cart"));

        driver.findElement(By.linkText("Facebook"));
        driver.findElement(By.linkText("Twitter"));
        driver.findElement(By.linkText("RSS"));
        driver.findElement(By.linkText("YouTube"));
        driver.findElement(By.linkText("Instagram"));

    }

    @Test
    public void TC_05_Partial_LinkTest(){
        driver.findElement(By.partialLinkText("Log"));
        driver.findElement(By.partialLinkText("in"));
        driver.findElement(By.partialLinkText("Shopping"));
        driver.findElement(By.partialLinkText("cart"));
    }

    @Test
    public void TC_06_TagName(){
        driver.findElements(By.tagName("a"));
        driver.findElements(By.tagName("select"));
        driver.findElements(By.tagName("input"));
        driver.findElements(By.tagName("button"));
    }

    @Test
    public void TC_07_CssSelector(){
        // ID
        driver.findElement(By.cssSelector("#customerCurrency"));
        driver.findElement(By.cssSelector("select#customerCurrency"));
        driver.findElement(By.cssSelector("select[id='customerCurrency']"));

        driver.findElement(By.cssSelector("input[id='small-searchterms']"));

        driver.findElement(By.cssSelector("input[id='gender-male']"));
        driver.findElement(By.cssSelector("input[id='gender-female']"));
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input[id='LastName']"));
        driver.findElement(By.cssSelector("input[id='Email']"));

        driver.findElement(By.cssSelector("input[id='Company']"));

        driver.findElement(By.cssSelector("input[id='Newsletter']"));

        driver.findElement(By.cssSelector("input[id='Password']"));

        driver.findElement(By.cssSelector("input[id='ConfirmPassword']"));
        driver.findElement(By.cssSelector("button[id='register-button']"));

        // Class
        driver.findElement(By.cssSelector(".ico-register"));
        driver.findElement(By.cssSelector("a.ico-register"));
        driver.findElement(By.cssSelector("a[class='ico-register']"));

        driver.findElement(By.cssSelector("input[class='search-box-text ui-autocomplete-input']"));
        driver.findElement(By.cssSelector("button[class='button-1 search-box-button']"));

        // Name
        driver.findElement(By.cssSelector("select[name='customerCurrency']"));

        driver.findElement(By.cssSelector("input[name='FirstName']"));
        driver.findElement(By.cssSelector("input[name='LastName']"));
        driver.findElement(By.cssSelector("input[name='Email']"));

        driver.findElement(By.cssSelector("button[name='register-button']"));

        // Link Test
        driver.findElement(By.cssSelector("a[href='/register?returnUrl=%2Fregister']"));
        driver.findElement(By.cssSelector("a[href='/login?returnUrl=%2Fregister']"));

        // Partial link test
        driver.findElement(By.cssSelector("a[href*='register?']"));
        driver.findElement(By.cssSelector("a[href*='login?']"));

        // Tag name
        driver.findElement(By.cssSelector("select"));
        driver.findElement(By.cssSelector("a"));
        driver.findElement(By.cssSelector("input"));

    }

    @Test
    public void TC_08_Xpath(){
        // Id
        driver.findElement(By.xpath("//select[@id='customerCurrency']"));
        driver.findElement(By.xpath("//input[@id='small-searchterms']"));

        driver.findElement(By.xpath("//input[@id='gender-male']"));
        driver.findElement(By.xpath("//input[@id='gender-female']"));

        // Class
        driver.findElement(By.xpath("//a[@class='ico-register']"));
        driver.findElement(By.xpath("//a[contains(@class,'register')]"));
        driver.findElement(By.xpath("//a[@class='ico-login']"));
        driver.findElement(By.xpath("//a[@class='ico-wishlist']"));

        driver.findElement(By.xpath("//input[@class='search-box-text ui-autocomplete-input']"));
        driver.findElement(By.xpath("//input[contains(@class,'search-box-text')]"));
        driver.findElement(By.xpath("//button[@class='button-1 search-box-button']"));

        // Name
        driver.findElement(By.xpath("//select[@name='customerCurrency']"));
        driver.findElement(By.xpath("//select[@name='customerCurrency']"));

        // Link Test
        driver.findElement(By.xpath("//a[@href='/register?returnUrl=%2Fregister']"));
        driver.findElement(By.xpath("//a[text()='Register']"));

        driver.findElement(By.xpath("//a[@href='/register?returnUrl=%2Fregister']"));
        driver.findElement(By.xpath("//a[@href='/login?returnUrl=%2Fregister']"));

        // Partial Link Test
        driver.findElement(By.xpath("//a[contains(text(),'Log')]"));

        // Tag Name
        driver.findElement(By.xpath("//select"));
        driver.findElement(By.xpath("//a"));
        driver.findElement(By.xpath("//input"));
    }

    @Test
    public void TC_09_Relative_Locator(){
        // 1. Can choose 1 in many positions (above, below, left, right,..) -> find
        // 2. Using to check GUI
        driver.get("https://demo.nopcommerce.com/login");
        By passwordTextBy = By.id("Password");
        By rememberCheckboxBy = By.cssSelector("input#RememberMe");
        By forgetLinkBy = By.linkText("Forgot password?");
        By loginBtnBy = By.cssSelector("button.login-button");

        driver.findElement(RelativeLocator.with(By.tagName("label"))
                .below(passwordTextBy)
//                .above(loginBtnBy)
//                .toRightOf(rememberCheckboxBy)
//                .toLeftOf(forgetLinkBy)
        );
    }

    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

