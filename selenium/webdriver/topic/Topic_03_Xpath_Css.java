package webdriver.topic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_Xpath_Css {
    WebDriver driver;
    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_Parent_Xpath_Attribute(){
        driver.get("https://live.techpanda.org/");
        //driver.findElement(By.xpath("//a[text()='My Account']")).click();
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
    }

    @Test
    public void TC_02_Parent_Xpath_Function(){
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
    }

    @Test
    public void TC_03_Xpath_Text(){
        driver.get("https://automationfc.github.io/basic-form/");

        // Text on 1 line with the main node (tagname)
        Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Selenium WebDriver API']")).getText(),driver.findElement(By.xpath("//h1")).getText());

        // Not exist in child node
        //driver.findElement(By.xpath("//h5[@id='hacker' and text()='- 18 years old']"));

        // Not exist in nested text
        //driver.findElement(By.xpath("//h5[text()='I'm a Hacker]"));

        // Text has index in start, between, end (Based on the other child tagnames same line)
        driver.findElement(By.xpath("//h5[@id='four' and text()='Michael Jackson']"));
        driver.findElement(By.xpath("//h5[@id='six' and text()='Michael Jackson']"));
        driver.findElement(By.xpath("//h5[@id='five' and text()='Michael Jackson']"));

        // Get absolute text -> Not space, enter, tab in start or end
        //driver.findElement(By.xpath("//h5[@id='nested' and text()='Hello World!']"));
    }

    @Test
    public void TC_04_Xpath_Contains_Text(){
        driver.get("https://automationfc.github.io/basic-form/");

        // Text on the main node (ok with space/tab)
        driver.findElement(By.xpath("//h5[contains(text(),'Hello World!')]"));

        // Nested text but text must exist in the first index
        driver.findElement(By.xpath("//h5[contains(text(),'Hello World!')]"));

        // Contains(.,'')
        driver.findElement(By.xpath("//h5[contains(.,'- 18 years old')]"));
        driver.findElement(By.xpath("//h5[contains(.,'- living in Viet Nam')]"));

        // Contains(string(),'')
        driver.findElement(By.xpath("//h5[contains(string(),'- 18 years old')]"));
        driver.findElement(By.xpath("//h5[contains(string(),'- living in Viet Nam')]"));

    }

    @Test
    public void TC_05_Xpath_Concat() {
        driver.get("https://automationfc.github.io/basic-form/");

        driver.findElement(By.xpath("//span[text()=concat('Hello \"John\", What',\"'s happened?\")]"));
    }

    @Test
    public void TC_06_Xpath_And() {
    }

    @Test
    public void TC_07_Xpath_Or() {
    }

    @Test
    public void TC_08_Xpath_Not() {
    }

    @Test
    public void TC_09_Xpath_Inside_Parent() {
        driver.get("https://automationfc.github.io/basic-form/");

        String text2 = driver.findElement(By.xpath("//div[@class='container']/h5[2]")).getText();
        System.out.println(text2);

        String text3 = driver.findElement(By.xpath("//div[@class='container']/h5[3]")).getText();
        System.out.println(text3);
    }

    @Test
    public void TC_10_Xpath_Position() {
        driver.get("https://automationfc.github.io/basic-form/");

        String text1 = driver.findElement(By.xpath("//div[@class='container']/h5[position()=1]")).getText();
        System.out.println(text1);

    }

    @Test
    public void TC_11_Xpath_Last() {
        driver.get("https://automationfc.github.io/basic-form/");

        String text13 = driver.findElement(By.xpath("//div[@class='container']/h5[last()-1]")).getText();
        System.out.println(text13);

        String text14 = driver.findElement(By.xpath("//div[@class='container']/h5[last()]")).getText();
        System.out.println(text14);

    }

    @Test
    public void TC_11_Xpath_Outside_Parent_Axes() {
        driver.get("https://live.techpanda.org/index.php/mobile.html");

        // Ancestor
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/ancestor::li"));

        // Parent
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/parent::div/parent::li/descendant::button"));

        // Preceding-sibling
        driver.findElement(By.xpath("//button[@title='Add to Cart']/parent::div/preceding-sibling::h2/a[text()='Samsung Galaxy']"));

        // Following-sibling
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button"));

        // Child
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div/child::button"));

        // Descendant
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/ancestor::li/descendant::button"));

    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

