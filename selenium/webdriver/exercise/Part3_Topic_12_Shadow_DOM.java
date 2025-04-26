package webdriver.exercise;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Part3_Topic_12_Shadow_DOM {
    // EXERCISE: https://docs.google.com/document/d/1IZn3_cDV95SRT7RuEl8NWjxw4IPmjwMpd38-HmXfgYM/edit?tab=t.0#heading=h.u6kg46gmbr14
    WebDriver driver;
    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_08_ShadowDOM_Automationfc(){
        driver.get("https://automationfc.github.io/shadow-dom");

        // Find "some text"

        WebElement shadowHost = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        // NOTE: Shadow only use "By.cssSelector()"
        WebElement shadowContent = shadowRoot.findElement(By.cssSelector("span#shadow_content>span"));
        Assert.assertEquals(shadowContent.getText(),"some text");

        // Find "nested text"

        shadowHost = shadowRoot.findElement(By.cssSelector("div#nested_shadow_host"));
        shadowRoot = shadowHost.getShadowRoot();
        shadowContent = shadowRoot.findElement(By.cssSelector("div#nested_shadow_content>div"));
        Assert.assertEquals(shadowContent.getText(),"nested text");

        // Find "checkbox"
        WebElement checkboxShadowHost = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext checkboxShadowRoot = checkboxShadowHost.getShadowRoot();
        WebElement checkboxShadowContent = checkboxShadowRoot.findElement(By.cssSelector("input[type='checkbox']"));
        Assert.assertFalse(checkboxShadowContent.isSelected());

        // Find "nested scroll.html
        WebElement nestedScrollShadowHost = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext nestedScrollShadowRoot = nestedScrollShadowHost.getShadowRoot();
        WebElement nestedScrollShadowContent = nestedScrollShadowRoot.findElement(By.cssSelector("a[href='scroll.html']"));
        Assert.assertFalse(nestedScrollShadowContent.isSelected());

        // Find "scroll.httml"
        WebElement scrollEle = driver.findElement(By.cssSelector("a[href='scroll.html']"));
        Assert.assertEquals(scrollEle.getText(),"scroll.html");



    }

    @Test
    public void TC_09_Shadow_Books() throws InterruptedException {
        driver.get("https://books-pwakit.appspot.com/");
        WebElement shadowHost = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement shadowContext = shadowRoot.findElement(By.cssSelector("input#input"));
        shadowContext.sendKeys("harry potter", Keys.ENTER);
        Thread.sleep(2000);

        WebElement mainContentShadowHost = shadowRoot.findElement(By.cssSelector("book-explore._page"));
        SearchContext mainContentShadowRoot = mainContentShadowHost.getShadowRoot();
//        List<WebElement> mainContentShadowTitles = mainContentShadowRoot.findElements(By.cssSelector("section>ul.books>li>book-item"));
//        System.out.println(mainContentShadowTitles.size());

        List<WebElement> titleShadowHosts = mainContentShadowRoot.findElements(By.cssSelector("book-item"));
        for (WebElement titleShadowHost : titleShadowHosts){
            SearchContext titleShadowRoot = titleShadowHost.getShadowRoot();
            WebElement titleShadowContext = titleShadowRoot.findElement(By.cssSelector("h2.title"));
            System.out.println("Title = " + titleShadowContext.getText());
        }
    }


    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}

