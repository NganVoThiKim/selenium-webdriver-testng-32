package javaTester.javaBasic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topic_12_String {

    public static void main(String[] args) {
        Topic_12_String str = new Topic_12_String();
//        str.memory();
        str.stringMethods();
    }

    public void memory() {
        String s1 = "Cat";
        String s2 = s1; // Same memory s1
        String s3 = new String("Cat"); //s3 is new memory

        System.out.println(s1 == s2); // True
        System.out.println(s1 == s3); // False
        System.out.println(s2 == s3); // False
        System.out.println(s2.equals(s3)); // True

    }

    public void stringMethods() {

        WebDriver driver = new FirefoxDriver();
        // Methods
        String schoolName = "Automation Testing";
        String courseName = "AUTOMATION TESTING";
        String schoolAddress = "Ho Chi Minh city";

        System.out.println("Length: " + schoolName.length());
        System.out.println("Get character[0]: " + schoolName.charAt(0));
        System.out.println("Get character[1]: " + schoolName.charAt(1));
        System.out.println("Combine by concat: " + schoolName.concat(schoolAddress));
        System.out.println("Combine by plus: " + schoolName + " " + schoolAddress);

        // Absolute compare
        System.out.println("Compare 2 strings equal absolutely: " + schoolName.equals(courseName)); // False
        System.out.println("Compare 2 strings equal absolutely: " + schoolName.equals("Automation Testing")); // True

        // Relative compare -> Apply for "Multiple Browser"
        System.out.println("Compare 2 strings equal relatively: " + schoolName.equalsIgnoreCase(courseName)); // True

        // startsWith/ endsWith/ contains
        System.out.println("Start with 1 character/ a string of characters: " + schoolName.startsWith("A")); // True
        System.out.println("Start with 1 character/ a string of characters: " + schoolName.startsWith("Automation")); // True
        System.out.println("Start with 1 character/ a string of characters: " + schoolName.startsWith("T")); // False

        System.out.println("Contain 1 character/ a string of characters: " + schoolName.contains("T")); // True
        System.out.println("Contain 1 character/ a string of characters: " + schoolName.contains("Automation")); // True
        System.out.println("Contain 1 character/ a string of characters: " + schoolName.contains("Advance")); // False

        System.out.println("End with 1 character/ a string of characters: " + schoolName.endsWith("g")); // True
        System.out.println("End with 1 character/ a string of characters: " + schoolName.endsWith("Testing")); // True
        System.out.println("End with 1 character/ a string of characters: " + schoolName.endsWith("n")); // False

        // Index
        System.out.println("Index of 1 character/ a string of characters: " + schoolName.indexOf("A")); // 0
        System.out.println("Index of 1 character/ a string of characters: " + schoolName.indexOf("Automation")); // 0
        System.out.println("Index of 1 character/ a string of characters: " + schoolName.indexOf("Testing")); // 11

        // Substring
        System.out.println("Split 1 character/ a string of characters: " + schoolName.substring(11)); // Testing
        System.out.println("Split 1 character/ a string of characters: " + schoolName.substring(11, 15)); // Test

        // Split - Split 1 string into array based on character/string of character -> Apply for "Alert/ get result"
        String result = "Viewing 48 of 132 results";
        String[] results = result.split(" ");
        System.out.println("Get 48: " + results[1]);

        // Replace -> Apply for "Automation"
        String productPrice = "$100.00";
        productPrice = productPrice.replace("$","");
        System.out.println("Remove $: " + productPrice);
        float priceF = Float.parseFloat(productPrice);
        System.out.println("Parse string to float: " + priceF);
        productPrice = String.valueOf(priceF);
        System.out.println("Parse float to string: " + "$" + productPrice);

        // UpperCase/ LowerCase -> Apply for handling multiple OS: Mac/Window
        String osName = System.getProperty("os.name");
        System.out.println(osName); // Mac OS X
        if(osName.toLowerCase().contains("windows")){
            Keys key = Keys.CONTROL;
        } else {
            Keys key = Keys.COMMAND;
        }

        // Apply for handling multiple Browser: Chrome/ Firefox
        String driverInstanceName = driver.toString();
        System.out.println(driverInstanceName); // FirefoxDriver: firefox on mac (babbd380-c222-47f1-a19f-18261084dc92)
        if(driverInstanceName.contains("internetexplorer")){
            // Threads.sleep(5000);
        }
        driver.quit();

        // Trim - Remove space
        String helloWorld = "   \n   \t   Hello World!   ";
        System.out.println("After remove space: " + helloWorld.trim());

        helloWorld = " ";
        System.out.println("Empty: " + helloWorld.isEmpty()); // false
        System.out.println("Blank: " + helloWorld.isBlank()); // true
        String helloWorld1 = "";
        System.out.println("helloWorld1 is Empty: " + helloWorld1.isEmpty()); // true

        // Format - Apply for Dynamic Locator
        // Example: Present for string: %s/ %b/ %t
        String dynamicButtonXpath = "//button[@id='%s']";
        System.out.println("Click on Login button = " + dynamicButtonXpath.formatted("login"));
        System.out.println("Click on Register button = " + dynamicButtonXpath.formatted("register"));
        System.out.println("Click on Search button = " + dynamicButtonXpath.formatted("search"));

    }
}
