package javaTester.javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Topic_02_Data_Type {

    // Primitive data type
    boolean bStatus = false;

    char cText = 'a';

    byte bNumber = 1;

    short sNumber = 127;

    int iNumber = 100;

    long lNumber = 10000000L;

    float fNumber = 0.01f;

    double dNumber = 0.01d;

    // Non Primitive Type/ Reference Type

    // String
    String address = "Ha Noi";

    // Array
    String[] studentAddress = {address, "Hue"};
    Integer[] studentNumber = {11,20};

    // Class
    Topic_02_Data_Type classVar;

    // Interface
    WebDriver driver;

    // Object
    Object aObject;

    // Collection - List/ Set/ Queue/ Map

    // List/ Arraylist - Allow duplicate data
    List<WebElement> homepageLink = driver.findElements(By.cssSelector(""));
    List<String> productName = new ArrayList<String>();

    // Set - NOT duplicate data
    Set<String> allWindows = driver.getWindowHandles();

    public void clickToElement(){
        address.equals("");
        studentAddress.toString();

    }

    public static void main(String[] args) {

    }
}
