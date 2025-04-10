package webdriver.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Part2_Topic09_Xpath_CSS {
    WebDriver driver;
    // 1 - Setup: OS/ Browser/ Web/ Page/ Data/ Variable/ Object
    @BeforeClass
    public void initialBrowser(){
        driver = new FirefoxDriver();

    }

    // 2 - Action/ Execute: interact with element/ input data/ verify
    @Test
    public void Register_01_Empty_Data(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assert
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");

    }

    @Test
    public void Register_02_Invalid_Email(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        //driver.findElement(By.id("//div[contains(@class,'frmRegister')]//input[@id='txtFirstname']")).sendKeys("John");
        driver.findElement(By.id("txtFirstname")).sendKeys("John");
        driver.findElement(By.id("txtEmail")).sendKeys("123@345@789");
        driver.findElement(By.id("txtCEmail")).sendKeys("123@345@789");
        driver.findElement(By.id("txtPassword")).sendKeys("aA123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("aA123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0866033037");

        //...
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assert
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
    }

    @Test
    public void Register_03_Incorrect_Confirm_Email(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("John");
        driver.findElement(By.id("txtEmail")).sendKeys("a123@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("a124@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("aA123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("aA123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0866033037");

        //...
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assert
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
    }

    @Test
    public void Register_04_Invalid_Password(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("John");
        driver.findElement(By.id("txtEmail")).sendKeys("a123@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("a123@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("aA1");
        driver.findElement(By.id("txtCPassword")).sendKeys("aA1");
        driver.findElement(By.id("txtPhone")).sendKeys("0866033037");

        //...
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assert
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
    }

    @Test
    public void Register_05_Incorrect_Confirm_Password(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("John");
        driver.findElement(By.id("txtEmail")).sendKeys("a123@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("a123@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("aA1234");
        driver.findElement(By.id("txtCPassword")).sendKeys("aA1235");
        driver.findElement(By.id("txtPhone")).sendKeys("0866033037");

        //...
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assert
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");
    }

    @Test
    public void Register_06_Phone_Less_Than_10_Characters(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("John");
        driver.findElement(By.id("txtEmail")).sendKeys("a123@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("a123@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("aA1234");
        driver.findElement(By.id("txtCPassword")).sendKeys("aA1234");

        // < 10 characters
        driver.findElement(By.id("txtPhone")).sendKeys("086603303");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

        // > 11 characters
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("086603303453");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");

        // Start with #09, 08,...
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("1199788993");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
    }

//    @Test
//    public void Register_07_Phone_More_Than_11_Characters() {
//        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
//
//        driver.findElement(By.id("txtFirstname")).sendKeys("John");
//        driver.findElement(By.id("txtEmail")).sendKeys("a123@gmail.com");
//        driver.findElement(By.id("txtCEmail")).sendKeys("a123@gmail.com");
//        driver.findElement(By.id("txtPassword")).sendKeys("aA1234");
//        driver.findElement(By.id("txtCPassword")).sendKeys("aA1234");
//        driver.findElement(By.id("txtPhone")).sendKeys("086603303453");
//
//        //...
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//        // Assert
//        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
//    }
//
//    @Test
//    public void Register_08_Invalid_Phone(){
//        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
//
//        driver.findElement(By.id("txtFirstname")).sendKeys("John");
//        driver.findElement(By.id("txtEmail")).sendKeys("a123@gmail.com");
//        driver.findElement(By.id("txtCEmail")).sendKeys("a123@gmail.com");
//        driver.findElement(By.id("txtPassword")).sendKeys("aA1234");
//        driver.findElement(By.id("txtCPassword")).sendKeys("aA1234");
//        driver.findElement(By.id("txtPhone")).sendKeys("1199788993");
//
//        //...
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//        // Assert
//        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
//    }

    // 3 - Clean: Delete test data/ browser
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}
