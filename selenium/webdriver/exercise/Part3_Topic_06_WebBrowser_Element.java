package webdriver.exercise;

import net.bytebuddy.dynamic.scaffold.TypeWriter;
import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.SequenceOfUint8;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;

public class Part3_Topic_06_WebBrowser_Element {
    // Exercise: https://docs.google.com/document/d/1G0QsiVDI5KfhNGKxE6a03bhn6KpvgDh69BTx2ttCO94/edit?tab=t.0#heading=h.nzntsc59ou1g
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new ChromeDriver();
    }

    @Test
    public void Browser_TC_01_VerifyURL() {
        // Using getCurrentUrl
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.cssSelector(".footer a[title='My Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/create/");

    }

    @Test
    public void Browser_TC_02_VerifyTitle() {
        // Using getTitle
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.cssSelector(".footer a[title='My Account']")).click();
        Assert.assertEquals(driver.getTitle(), "Customer Login");
        driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

    }

    @Test
    public void Browser_TC_03_NavigateFunction() {
        // Using Back/ Forward
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.cssSelector(".footer a[title='My Account']")).click();
        driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/create/");
        driver.navigate().back();
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/login/");
        driver.navigate().forward();
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

    }

    @Test
    public void Browser_TC_04_GetPageSourceCode() {
        // Using getPageSource
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.cssSelector(".footer a[title='My Account']")).click();
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
        driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));

    }

    @Test
    public void Element_TC_01_CheckElementIsDisplayed() {
        // Using isDisplayed
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement emailEle = driver.findElement(By.cssSelector("#mail"));
        Assert.assertTrue(emailEle.isDisplayed());

        if (emailEle.isDisplayed()) {
            emailEle.sendKeys("Automation Testing");
            System.out.println("Email is displayed");
        } else {
            System.out.println("Email is not displayed");
        }

        WebElement ageUnder18Ele = driver.findElement(By.cssSelector("#under_18"));
        Assert.assertTrue(ageUnder18Ele.isDisplayed());

        if (ageUnder18Ele.isDisplayed()) {
            ageUnder18Ele.click();
            System.out.println("Age under 18 is displayed");
        } else {
            System.out.println("Age under 18 is not displayed");

        }
        WebElement educationEle = driver.findElement(By.cssSelector("#edu"));
        Assert.assertTrue(educationEle.isDisplayed());

        if (educationEle.isDisplayed()) {
            educationEle.sendKeys("Automation Testing");
            System.out.println("Education is displayed");
        } else {
            System.out.println("Education is not displayed");

        }

        WebElement nameUser5Ele = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
        Assert.assertFalse(nameUser5Ele.isDisplayed());

        if (nameUser5Ele.isDisplayed()) {
            System.out.println("Name: User5 is displayed");
        } else {
            System.out.println("Name: User5 is not displayed");

        }

    }

    @Test
    public void Element_TC_02_CheckElementEnabledOrDisabled() {
        // Using isEnabled
        driver.get("https://automationfc.github.io/basic-form/index.html");
        System.out.println("ELEMENTS ARE ENABLED: ");
        WebElement emailEle = driver.findElement(By.cssSelector("#mail"));
        if (emailEle.isEnabled()) {
            System.out.println("Email is enabled");
        } else {
            System.out.println("Email is disabled");

        }

        WebElement ageUnder18Ele = driver.findElement(By.cssSelector("#under_18"));
        if (ageUnder18Ele.isEnabled()) {
            System.out.println("Age under 18 is enabled");
        } else {
            System.out.println("Age under 18 is disabled");

        }

        WebElement educationEle = driver.findElement(By.cssSelector("#edu"));
        if (educationEle.isEnabled()) {
            System.out.println("Education is enabled");
        } else {
            System.out.println("Education is disabled");

        }

        WebElement jobRole01Ele = driver.findElement(By.cssSelector("#job1"));
        if (jobRole01Ele.isEnabled()) {
            System.out.println("Job Role 01 is enabled");
        } else {
            System.out.println("Job Role 01 is disabled");

        }

        WebElement jobRole02Ele = driver.findElement(By.cssSelector("#job2"));
        if (jobRole02Ele.isEnabled()) {
            System.out.println("Job Role 02 is enabled");
        } else {
            System.out.println("Job Role 02 is disabled");

        }

        WebElement interestDevelopmentEle = driver.findElement(By.cssSelector("#development"));
        if (interestDevelopmentEle.isEnabled()) {
            System.out.println("Interest (Development) Checkbox is enabled");
        } else {
            System.out.println("Interest (Development) Checkbox is disabled");

        }

        WebElement slider01Ele = driver.findElement(By.cssSelector("#slider-1"));
        if (slider01Ele.isEnabled()) {
            System.out.println("Slider 01 is enabled");
        } else {
            System.out.println("Slider 01 is disabled");

        }
        System.out.println("ELEMENTS ARE DISABLED:");

        WebElement disabledPasswordEle = driver.findElement(By.cssSelector("#disable_password"));
        if (disabledPasswordEle.isEnabled()) {
            System.out.println("Password is enabled");
        } else {
            System.out.println("Password is disabled");

        }

        WebElement disabledAgeRadioButtonEle = driver.findElement(By.cssSelector("#radio-disabled"));
        if (!disabledAgeRadioButtonEle.isEnabled()) {
            System.out.println("Age - Radio Button is disabled");
        } else {
            System.out.println("Age - Radio Button is enabled");

        }

        WebElement disabledBiographyEle = driver.findElement(By.cssSelector("#bio"));
        if (!disabledBiographyEle.isEnabled()) {
            System.out.println("Biography is disabled");
        } else {
            System.out.println("Biography is enabled");

        }

        WebElement disabledJobRole3Ele = driver.findElement(By.cssSelector("#job3"));
        if (!disabledJobRole3Ele.isEnabled()) {
            System.out.println("Job Role 03 is disabled");
        } else {
            System.out.println("Job Role 03 is enabled");

        }

        WebElement disabledInterestCheckboxEle = driver.findElement(By.cssSelector("#check-disbaled"));
        if (!disabledInterestCheckboxEle.isEnabled()) {
            System.out.println("Interest - Checkbox is disabled");
        } else {
            System.out.println("Interest - Checkbox is enabled");

        }

        WebElement disabledSlider2Ele = driver.findElement(By.cssSelector("#slider-2"));
        if (!disabledSlider2Ele.isEnabled()) {
            System.out.println("Slider 02 is disabled");
        } else {
            System.out.println("Slider 02 is enabled");

        }

    }

    @Test
    public void Element_TC_03_CheckElementIsSelected() {
        // Using isSelected
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement ageUnder18Ele = driver.findElement(By.cssSelector("#under_18"));
        ageUnder18Ele.click();
        WebElement javaLanguageEle = driver.findElement(By.cssSelector("#java"));
        javaLanguageEle.click();
        System.out.println("AFTER STEP 02:");
        if (ageUnder18Ele.isSelected()) {
            System.out.println("Age under 18 is selected");
        } else {
            System.out.println("Age under 18 is de-selected");
        }

        if (javaLanguageEle.isSelected()) {
            System.out.println("Language: Java is selected");
        } else {
            System.out.println("Language: Java is de-selected");
        }

        javaLanguageEle.click();
        System.out.println("AFTER STEP 04:");
        if (ageUnder18Ele.isSelected()) {
            System.out.println("Age under 18 is selected");
        } else {
            System.out.println("Age under 18 is de-selected");
        }

        if (javaLanguageEle.isSelected()) {
            System.out.println("Language: Java is selected");
        } else {
            System.out.println("Language: Java is de-selected");
        }


    }

    @Test
    public void Element_TC_04_RegisterFunctionAtMailChimp() {
        // Combine all displayed/ enabled/ selected
        driver.get("https://login.mailchimp.com/signup/");
        WebElement emailEle = driver.findElement(By.cssSelector("#email"));
        WebElement usernameEle = driver.findElement(By.cssSelector("#new_username"));
        WebElement passwordEle = driver.findElement(By.cssSelector("#new_password"));

        if(emailEle.isDisplayed() && emailEle.isEnabled()){
            emailEle.sendKeys("test@gmail.com");
            emailEle.sendKeys(Keys.TAB);
        }

        if (usernameEle.isDisplayed() && usernameEle.isEnabled()){
            usernameEle.click();
            Assert.assertEquals(usernameEle.getText(),emailEle.getText());
        }

        if(passwordEle.isDisplayed() && passwordEle.isEnabled()) {
            passwordEle.sendKeys("1");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//            WebElement oneNumberOptionEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul li.number-char.completed")));
//            String rgbaFormat = oneNumberOptionEle.getCssValue("color");
//            String hexColor = Color.fromString(rgbaFormat).asHex();
//            System.out.println(hexColor);
//            Assert.assertEquals(hexColor,"#008547");
            WebElement oneNumberOptionEle = driver.findElement(By.xpath("//span[text()='One number']/parent::li"));
            String classOneNumberAttr = oneNumberOptionEle.getAttribute("class");
            Assert.assertTrue(classOneNumberAttr.contains("completed"));

            WebElement notContainUserNameOptionEle = driver.findElement(By.xpath("//span[text()='Must not contain username']/parent::li"));
            String classNotContainUserNameAttr = notContainUserNameOptionEle.getAttribute("class");
            Assert.assertTrue(classNotContainUserNameAttr.contains("completed"));

            passwordEle.sendKeys("23456a");

            WebElement oneLowercaseOptionEle = driver.findElement(By.xpath("//span[text()='One lowercase character']/parent::li"));
            String classOneLowercaseAttr = oneLowercaseOptionEle.getAttribute("class");
            Assert.assertTrue(classOneLowercaseAttr.contains("completed"));

            passwordEle.sendKeys("A");

            WebElement oneUppercaseOptionEle = driver.findElement(By.xpath("//span[text()='One uppercase character']/parent::li"));
            String classOneUppercaseAttr = oneUppercaseOptionEle.getAttribute("class");
            Assert.assertTrue(classOneUppercaseAttr.contains("completed"));

            WebElement characterMinimumOptionEle = driver.findElement(By.xpath("//span[text()='8 characters minimum']/parent::li"));
            String classCharacterMinimumAttr = characterMinimumOptionEle.getAttribute("class");
            Assert.assertTrue(classCharacterMinimumAttr.contains("completed"));

            passwordEle.sendKeys("@");

            WebElement oneSpecialOptionEle = driver.findElement(By.xpath("//span[text()='One special character']/parent::li"));
            String classOneSpecialAttr = oneSpecialOptionEle.getAttribute("class");
            Assert.assertTrue(classOneSpecialAttr.contains("completed"));

            WebElement cookieDismissBtn = driver.findElement(By.xpath("//div[@id='onetrust-close-btn-container']/button"));
            if (cookieDismissBtn.isDisplayed()) {
                cookieDismissBtn.click();
            }

            WebElement marketingNewsletterCheckboxEle = driver.findElement(By.cssSelector("#marketing_newsletter"));
            if(marketingNewsletterCheckboxEle.isEnabled() && marketingNewsletterCheckboxEle.isDisplayed()){
                marketingNewsletterCheckboxEle.click();
                Assert.assertTrue(marketingNewsletterCheckboxEle.isSelected());
            }

            WebElement signupBtnEle = driver.findElement(By.cssSelector("#create-account-enabled"));
            signupBtnEle.click();
//            Assert.assertEquals(driver.getTitle(),"Success | Mailchimp");


        }

    }

    @Test
    public void Login_TC_01_LoginWithEmptyEmailPassword() {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.cssSelector(".footer a[title='My Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.cssSelector("#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#advice-required-entry-email")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("#advice-required-entry-pass")).getText(), "This is a required field.");

    }

    @Test
    public void Login_TC_02_LoginWithInvalidEmail() {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.cssSelector(".footer a[title='My Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.id("email")).sendKeys("123434234@12345.123456");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");

    }

    @Test
    public void Login_TC_03_LoginWithPasswordLessThan6Characters() {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.cssSelector(".footer a[title='My Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123");
        driver.findElement(By.cssSelector("#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");

    }

    @Test
    public void Login_TC_04_LoginWithIncorrectEmailOrPassword() throws InterruptedException {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.cssSelector(".footer a[title='My Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/login/");
        driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123123123");
        driver.findElement(By.cssSelector("#send2")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".nav-wrapper #proceed-button")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='messages']//li[@class='error-msg']//span")));
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(),"Invalid login or password.");

    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

