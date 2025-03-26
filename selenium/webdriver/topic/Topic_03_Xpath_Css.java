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
    public void TC_12_Xpath_Outside_Parent_Axes() {
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

    @Test
    public void TC_13_Different_Xpath_Css() {
        driver.get("https://live.techpanda.org/index.php/customer/account/login/");

        // Direct child (Go 1 node)
        driver.findElement(By.xpath("//div/input[@id='email']"));
        driver.findElement(By.cssSelector("div>input[id='email']"));

        // Sub-child (Go to a lot of child - node)
        driver.findElement(By.xpath("//ul[@class='form-list']//input[@id='email']"));
        driver.findElement(By.cssSelector("ul[class='form-list'] input[id='email']"));

        // ID
        driver.findElement(By.xpath("//input[@id='email']"));
        driver.findElement(By.cssSelector("input[id='email']"));
        driver.findElement(By.cssSelector("input#email"));
        driver.findElement(By.cssSelector("#email"));

        // Class
        driver.findElement(By.xpath("//ul[@class='form-list']"));
        driver.findElement(By.cssSelector("ul[class='form-list']"));
        driver.findElement(By.cssSelector("ul.form-list"));
        driver.findElement(By.cssSelector(".form-list"));

        // NOTE: If class value is separated by spacing -> Allow to use a part or all
        driver.findElement(By.xpath("//div[@class='col-2 registered-users']"));
        driver.findElement(By.xpath("//div[contains(@class,'registered-users')]"));

        driver.findElement(By.cssSelector("div.registered-users"));
        driver.findElement(By.cssSelector("div.registered-users.col-2"));
        driver.findElement(By.cssSelector("div.col-2.registered-users"));
        driver.findElement(By.cssSelector("div[class='col-2 registered-users']"));

        // Combine "AND" attribute
        driver.findElement(By.xpath("//div[@class='col-2 registered-users']"));
        driver.findElement(By.cssSelector("input[id='email'][name='login[username]']"));

        // Combine "OR" attribute
        driver.findElement(By.xpath("//input[@id='email' or @id='pass']"));
        driver.findElement(By.cssSelector("input[id='email'],[id='pass']"));

        // Not attribute
        driver.findElement(By.xpath("//input[not(@id='email')]"));
        driver.findElement(By.cssSelector("input:not([id='email'])"));
        driver.findElement(By.cssSelector("input:not(#email)"));

        // Contains
        driver.findElement(By.xpath("//input[contains(@placeholder,'entire stor')]"));
        driver.findElement(By.cssSelector("input[placeholder*='entire stor']"));

        // Starts-with
        driver.findElement(By.xpath("//input[starts-with(@placeholder,'Search entire')]"));
        driver.findElement(By.cssSelector("input[placeholder^='Search entire']"));

        // End-with (Xpath isn't support "End-with")
        driver.findElement(By.cssSelector("input[placeholder$='store here...']"));

        // Following-sibling (All the sibling nodes)
        driver.findElement(By.xpath("//div[contains(@class,'block-subscribe')]/following-sibling::*"));
        driver.findElement(By.cssSelector("div.block-subscribe~*"));

        // Following-sibling (All the sibling nodes which same name)
        driver.findElement(By.xpath("//div[contains(@class,'block-subscribe')]/following-sibling::div"));
        driver.findElement(By.cssSelector("div.block-subscribe~div"));

        // Following-sibling (Get the next sibling node)
        driver.findElement(By.xpath("//div[contains(@class,'block-subscribe')]/following-sibling::div/descendant::a[text()='About Us']"));
        driver.findElement(By.cssSelector("div.block-subscribe+div a[href='http://live.techpanda.org/index.php/contacts/']"));

        // Preceding-sibling (CSS isn't supported)

    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

