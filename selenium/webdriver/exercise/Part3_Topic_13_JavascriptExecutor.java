package webdriver.exercise;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Part3_Topic_13_JavascriptExecutor {
    // EXERCISE: https://docs.google.com/document/d/1tjHswRo2ovMrT20YCVXEfidTk0yK9OcR67BQ5kG7I3s/edit?tab=t.0#heading=h.3fh4kr3unw6t
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    String email;
    Random random;
    Alert alert;

    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        jsExecutor = (JavascriptExecutor) driver;
        random = new Random();
        email = "test" + random.nextInt(9999) + "@gmail.com";

    }

    // 2 - Action/ Execute: interact with element/ input data/ verify

    @Test
    public void TC_01_JavaScript_Techpanda() throws InterruptedException {
        // Navigate to URL
        jsExecutor.executeScript("window.location='https://live.techpanda.org/'");

        // Get domain
        String domain = (String) jsExecutor.executeScript("return document.domain");
        Assert.assertEquals(domain, "live.techpanda.org");

        // Get URL
        String url = (String) jsExecutor.executeScript("return document.URL");
        Assert.assertEquals(url, "https://live.techpanda.org/");

        // Open Mobile page
        jsExecutor.executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[@id='header-nav']//a[text()='Mobile']")));
        Thread.sleep(2000);

        // Add item to card
        jsExecutor.executeScript("arguments[0].click()", driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//button")));
        Thread.sleep(5000);

        // Compare data
        String innerText = (String) jsExecutor.executeScript("return document.documentElement.innerText;");
        Assert.assertTrue(innerText.contains("Samsung Galaxy was added to your shopping cart."));
        Thread.sleep(2000);

        // Clicking on Customer Service and verify
        jsExecutor.executeScript("arguments[0].click()", driver.findElement(By.xpath("//a[text()='Customer Service']")));
        Thread.sleep(2000);
        Assert.assertEquals(jsExecutor.executeScript("return document.title"), "Customer Service");

        // Scroll to Newsletter textbox
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("input#newsletter")));
        Thread.sleep(2000);

        // Sendkey to element
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + email + "')", driver.findElement(By.cssSelector("input#newsletter")));
        Thread.sleep(2000);

        // Click "Subscribe"
        jsExecutor.executeScript("arguments[0].click()", driver.findElement(By.cssSelector("button[title='Subscribe']")));
        Thread.sleep(3000);

        jsExecutor.executeScript("arguments[0].click()", driver.findElement(By.cssSelector("button#proceed-button")));
        Thread.sleep(5000);

        String subscriptionText = (String) jsExecutor.executeScript("return document.documentElement.innerText;");
        Assert.assertTrue(subscriptionText.contains("Thank you for your subscription."));
        Thread.sleep(2000);

        // Redirect to FB
        jsExecutor.executeScript("window.location='https://www.facebook.com/'");

        // Get domain and compare
        String domainFB = (String) jsExecutor.executeScript("return document.domain");
        Assert.assertEquals(domainFB, "www.facebook.com");


    }

    @Test
    public void TC_01_JavaScript_Techpanda_Using_Functions() {
        // Navigate to URL
        navigateToUrlByJS("https://live.techpanda.org/");

        // Get domain
        Assert.assertEquals(getDomain(),"live.techpanda.org");

        // Get URL
        Assert.assertEquals(getURL(),"https://live.techpanda.org/");

        // Open Mobile page
        clickToElementByJS("//div[@id='header-nav']//a[text()='Mobile']");

        // Add item to card
        clickToElementByJS("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']//button");

        // Compare data
        Assert.assertTrue(isExpectedTextInInnerText("Samsung Galaxy was added to your shopping cart."));

        // Clicking on Customer Service and verify
        clickToElementByJS("//a[text()='Customer Service']");
        Assert.assertEquals(getTitle(),"Customer Service");

        // Scroll to Newsletter textbox
        scrollToElementOnTop("input#newsletter");

        // Sendkey to element
        sendkeyToElementByJS("input#newsletter",email);

        // Click "Subscribe"
        clickToElementByJSWithCss("button[title='Subscribe']");

        clickToElementByJSWithCss("button#proceed-button");
        Assert.assertTrue(isExpectedTextInInnerText("Thank you for your subscription."));

        // Redirect to FB
        navigateToUrlByJS("https://www.facebook.com/");
        Assert.assertEquals(getDomain(),"www.facebook.com");


    }

    @Test
    public void TC_02_HTML5_JS_Automationfc() throws InterruptedException {
        driver.get("https://automationfc.github.io/html5/index.html");
        WebElement submitBtnEle = driver.findElement(By.cssSelector("input[name='submit-btn']"));
        WebElement nameEle = driver.findElement(By.cssSelector("input#fname"));
        WebElement passEle = driver.findElement(By.cssSelector("input#pass"));
        WebElement emailEle = driver.findElement(By.cssSelector("input#em"));

        // Empty data -> Click "Submit"
        submitBtnEle.click();
        String validateName = getElementValidationMessage("//input[@id='fname']");
        if(driver.toString().contains("Chrome")){
            Assert.assertEquals(validateName,"Please fill in this field." );
        } else {
            Assert.assertEquals(validateName,"Please fill out this field." );

        }

        // Only fill Name -> Click "Submit"
        nameEle.sendKeys("nena");
        submitBtnEle.click();
        String validatePass = getElementValidationMessage("//input[@id='pass']");
        if(driver.toString().contains("Chrome")){
            Assert.assertEquals(validatePass,"Please fill in this field." );
        } else {
            Assert.assertEquals(validatePass,"Please fill out this field." );

        }

        // Fill Name, Pass -> Click "Submit"
        passEle.sendKeys("123456");
        submitBtnEle.click();
        String validateEmail = getElementValidationMessage("//input[@id='em']");
        if(driver.toString().contains("Chrome")){
            Assert.assertEquals(validateEmail,"Please fill in this field." );
        } else {
            Assert.assertEquals(validateEmail,"Please fill out this field." );

        }

        // Input "Invalid Email" = "123!@#$" -> Click "Submit"
        String emailText = "123!@#$";
        emailEle.sendKeys(emailText);
        submitBtnEle.click();
        validateEmail = getElementValidationMessage("//input[@id='em']");
        if(driver.toString().contains("Chrome")){
            Assert.assertEquals(validateEmail,"A part following '@' should not contain the symbol '#'.");
        } else {
            Assert.assertEquals(validateEmail,"Please enter an email address.");
        }
        Thread.sleep(3000);

        // Input "Invalid Email" = "123@" -> Click "Submit"
        emailEle.clear();
        String emailText2 = "456@";
        emailEle.sendKeys(emailText2);
        submitBtnEle.click();
        validateEmail = getElementValidationMessage("//input[@id='em']");
        if(driver.toString().contains("Chrome")){
            Assert.assertEquals(validateEmail,"Please enter a part following '@'. '"+ emailText2 +"' is incomplete.");
        } else {
            Assert.assertEquals(validateEmail,"Please enter an email address.");
        }
        Thread.sleep(3000);

        // Input valid email -> Click "Submit"
        emailEle.clear();
        emailText = "nena@gmail.com";
        emailEle.sendKeys(emailText);
        submitBtnEle.click();
        String validateAddress = getElementValidationMessage("//b[text()='✱ ADDRESS ']/parent::label/following-sibling::select");
        if(driver.toString().contains("Chrome")){
            Assert.assertEquals(validateAddress,"Please select an item in the list.");
        } else {
            Assert.assertEquals(validateAddress,"Please select an item in the list.");
        }



    }

    @Test
    public void TC_03_HTML5_JS_Many_Pages(){

        // Ubuntu
        driver.get("https://login.ubuntu.com/");
        String locatorEmail = "//form[@id='login-form']//input[@id='id_email']";
        By emailBy = By.xpath(locatorEmail);
        By loginBtnBy = By.cssSelector("button[data-qa-id='login_button']");

        driver.findElement(emailBy).sendKeys("a");
        driver.findElement(loginBtnBy).click();
        String validateEmail = getElementValidationMessage(locatorEmail);
        if(driver.toString().contains("Chrome")){
            Assert.assertEquals(validateEmail,"Please include an '@' in the email address. 'a' is missing an '@'." );
        } else {
            Assert.assertEquals(validateEmail,"Please enter an email address." );

        }

        // SieuThiMayMocThietBi
        driver.get("https://sieuthimaymocthietbi.com/account/register");
        String lastNameLoc = "//input[@id='lastName']";
        String registerLoc = "//button[text()='Đăng ký']";

        driver.findElement(By.xpath(registerLoc)).click();
        String validateLastName = getElementValidationMessage(lastNameLoc);
        if(driver.toString().contains("Chrome")){
            Assert.assertEquals(validateLastName,"Please fill in this field." );
        } else {
            Assert.assertEquals(validateLastName,"Please fill out this field." );

        }

        // Rode
        driver.get("https://account.rode.com/login");
        String emailLoc = "//input[@id='email']";
        String loginBtnLoc = "//button[text()=' Log in ']";

        driver.findElement(By.xpath(loginBtnLoc)).click();
        String validateEmailRode = getElementValidationMessage(emailLoc);
        if(driver.toString().contains("Chrome")){
            Assert.assertEquals(validateEmailRode,"Please fill in this field." );
        } else {
            Assert.assertEquals(validateEmailRode,"Please fill out this field." );

        }

    }

    @Test
    public void TC_04_JavaScript_Create_An_Account() throws InterruptedException {
        String firstName = "Nena";
        String lastName = "Vo";
        String passWord = "aA123456";


        // Navigate to page
        navigateToUrlByJS("http://live.techpanda.org/");

        // Click on "My Account"
        clickToElementByJS("//div[@id='header-account']//a[@title='My Account']");

        // Click on "Create an account"
        clickToElementByJS("//a[@title='Create an Account']");

        // Input valid data -> Register
        sendkeyToElementByJS("input#firstname", firstName);
        sendkeyToElementByJS("input#lastname",lastName);
        sendkeyToElementByJS("input#email_address",email);
        sendkeyToElementByJS("input#password",passWord);
        sendkeyToElementByJS("input#confirmation",passWord);
        clickToElementByJSWithCss("button[title='Register']");
        Thread.sleep(2000);

        // Redirect to process page
        clickToElementByJSWithCss("button#proceed-button");
        Thread.sleep(3000);

        // Redirect to dashboard and verify
        isExpectedTextInInnerText("Thank you for registering with Main Website Store.");

        // Click "Log Out"
        clickToElementByJSWithCss("a[title='Log Out']");
//        Thread.sleep(6000);

        // Back to homepage
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
//        WebElement homeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("html#top")));

        WebElement homeElement = driver.findElement(By.cssSelector("html#top"));
        Assert.assertTrue(homeElement.isDisplayed());


    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

    public Object executeForBrowser(String javaScript) {
        return jsExecutor.executeScript(javaScript);
    }

    public Object getDomain () {
        return jsExecutor.executeScript("return document.domain");
    }

    public Object getURL () {
        return jsExecutor.executeScript("return document.URL");
    }

    public Object getTitle () {
        return jsExecutor.executeScript("return document.title");
    }

    public String getInnerText() {
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(String textExpected) {
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void sleepInSecond(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateToUrlByJS(String url) {
        jsExecutor.executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void hightlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
        sleepInSecond(3);
    }

    public void clickToElementByJSWithCss(String locator) {
        jsExecutor.executeScript("arguments[0].click();", getElementByCss(locator));
        sleepInSecond(3);
    }

    public String getElementTextByJS(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].textContent;", getElement(locator));
    }

    public void scrollToElementOnTop(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElementByCss(locator));
    }

    public void scrollToElementOnDown(String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElementByCss(locator));
    }

    public void sendkeyToElementByJSUsingXpath(String locator, String value) {
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public String getAttributeInDOM(String locator, String attributeName) {
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(locator));
    }

    public String getElementValidationMessage(String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
        return status;
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public WebElement getElementByCss(String locator) {
        return driver.findElement(By.cssSelector(locator));
    }
}

