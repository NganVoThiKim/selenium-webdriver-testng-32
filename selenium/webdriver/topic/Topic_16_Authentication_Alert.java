package webdriver.topic;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import org.openqa.selenium.devtools.v131.network.Network;
//import org.openqa.selenium.devtools.v131.network.model.Headers;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Topic_16_Authentication_Alert {
    // EXERCISE: https://docs.google.com/document/d/1kPgRirztWIC9R_XiZFNYI3E0KVWfrzf2x_Het5MRj3s/edit?tab=t.0
    WebDriver driver;
    WebDriverWait wait;
    String username, password;
    Alert alert;

    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        username = "admin";
        password = "admin";
    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void TC_01_Authentication_Alert_Url(){
        String url = "http://the-internet.herokuapp.com/basic_auth";
        String[] urlIsDivided = url.split("//");
        String newUrl = urlIsDivided[0] + "//" + username + ":" + password + "@" + urlIsDivided[1];
        driver.get(newUrl);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(),"Congratulations! You must have the proper credentials.");
    }

    @Test
    public void TC_02_Authentication_Navigate(){
        driver.get("https://the-internet.herokuapp.com/");
        String basicAuthLink = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
        driver.get(getAuthenticationUrl(basicAuthLink, username, password));
        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(),"Congratulations! You must have the proper credentials.");
    }

//    @Test
//    public void TC_03_Authentication_CDP(){
//        // Get DevTool object
//        DevTools devTools = ((HasDevTools) driver).getDevTools();
//
//        // Start new session
//        devTools.createSession();
//
//        // Enable the Network domain of devtools
//        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//
//        // Encode username/ password
//        Map<String, Object> headers = new HashMap<String, Object>();
//        String basicAuthen = "Basic " + new String(new Base64().encode(String.format("%s:%s", "admin", "admin").getBytes()));
//        headers.put("Authorization", basicAuthen);
//
//        // Set to Header
//        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
//
//        driver.get("https://the-internet.herokuapp.com/basic_auth");
//    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

    private String getAuthenticationUrl(String url, String username, String password){
        String[] urlIsDivided = url.split("//");
        return urlIsDivided[0] + "//" + username + ":" + password + "@" + urlIsDivided[1];
    }

}

