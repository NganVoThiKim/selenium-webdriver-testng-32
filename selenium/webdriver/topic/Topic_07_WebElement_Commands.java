package webdriver.topic;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_WebElement_Commands {
    WebDriver driver;
    WebElement element;
    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
//        driver.get("https://demo.nopcommerce.com/login");
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_WebElement(){
//        element = driver.findElement(By.id("small-searchterms"));

        // Click on element which types: button/ checkbox/ radio/ link/ image/ icon
//        element.click();  //**

        // Input data into types: textbox/ textarea/ dropdown (edit)
//        element.clear(); // Clear data before sendkey //*
//        element.sendKeys("ngan@gmail.com"); //**
//        element.sendKeys(Keys.ENTER);

        // Allow to find element from parent to child
//        driver.findElement(By.cssSelector("div.master-wrapper-page"))
//                .findElement(By.cssSelector("div.header-lower"))
//                .findElement(By.id("small-searchterms")); //**
//
//        driver.findElement(By.cssSelector("div.master-wrapper-page div.header-lower input#small-searchterms"));

        // Only type = FORM (Register/ Login/ Search) -> Using .submit()
//        driver.findElement(By.id("Email")).sendKeys("test.nena@gmail.com");
//        driver.findElement(By.id("Password")).sendKeys("aA123456");
//        driver.findElement(By.id("Password")).submit();
//        driver.findElement(By.xpath("//form[contains(@action,'login')]")).submit();
//        driver.findElement(By.xpath("//button[text()='Log in']")).click();
//        Assert.assertEquals(driver.getTitle(),"nopCommerce demo store. Home page title");


        // Apply for all elements -> Check element is displayed with size > 0 and interact
//        element.isDisplayed(); //**
//        Assert.assertTrue(element.isDisplayed());
//        Assert.assertFalse(element.isDisplayed());

        // Only apply for 3 types: checkbox, radio, dropdown (default) -> Check element is selected?
//        element.isSelected(); //*

        // Apply for all -> Check element is disabled? (read-only)
//        element.isEnabled();

        // Get CSS -> Check GUI (Font/ Size/ Color/ Position/ Location,..)
        element = driver.findElement(By.xpath("//button[text()='Search']"));
        System.out.println(element.getCssValue("font-size")); //*
        System.out.println(element.getCssValue("background-color"));

        // Get text of element (Link/ Button/ Header/ Label,..)
        System.out.println(element.getText()); //**

        // Get attribute (Get placeholder text)
        WebElement searchTextbox = driver.findElement(By.id("small-searchterms"));
        System.out.println(searchTextbox.getAttribute("placeholder")); //**

        // Dimension
        Dimension dimension = searchTextbox.getSize();
        System.out.println("(Width, Height) = " + dimension);

        // Location
        Point location = searchTextbox.getLocation();
        System.out.println("Location = " + location);

        //
        Rectangle rectangle = searchTextbox.getRect();
        System.out.println("Width = " + rectangle.getWidth());
        System.out.println("Height = " + rectangle.getHeight());
        System.out.println("X = " + rectangle.getX());
        System.out.println("Y = " + rectangle.getY());
        System.out.println("Y = " + rectangle.getPoint());

        // Get html tag of element
        // Element A
        String tagname = driver.findElement(By.cssSelector("#FirstName")).getTagName();

        // Element B
        driver.findElement(By.xpath("//" + tagname + "[@id='LastName']"));

        element.getAccessibleName();

        element.getAriaRole();

        element.getDomAttribute("data-val-required");

        element.getDomProperty("formAction"); //*

        // Popup
        element.getShadowRoot(); //**

        // Framework: HTML report
        element.getScreenshotAs(OutputType.FILE); //*
        element.getScreenshotAs(OutputType.BYTES);
        element.getScreenshotAs(OutputType.BASE64); //*
    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

