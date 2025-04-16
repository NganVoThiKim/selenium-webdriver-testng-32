package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.*;

public class Topic_09_List {
    public static void main(String[] args) {
        // Java Collection
        /**
         * Collection includes:
         * List: Allow to double case - Includes:
            * ArrayList
            * Vector includes: Stack
            * LinkedList
         * Queue
         * Set: Only single case
         * */

        /**
         * interface SearchContext
         * interface WebDriver extends SearchContext
         * class RemoteWebDriver implement WebDriver
         * class FirefoxDriver extends RemoteWebDriver
         * */

//        FirefoxDriver fdriver = new FirefoxDriver();
//
//        WebDriver driver; // Father
//        driver = new FirefoxDriver(); // Child
//        driver = new ChromeDriver(); // Child
//        driver = new EdgeDriver(); // Child
//
//        ArrayList<String> address = new ArrayList<>();
//        Vector<Float> studentPoint = new Vector<>();
//        LinkedList<Integer> studentAge = new LinkedList<>();
//        Stack<Boolean> status = new Stack<>();
//
//        List<String> studentName = new ArrayList<>();
//        studentName = new Vector<>();

        List<String> addressNew = new ArrayList<>();
        addressNew.add("Ho Chi Minh");
        addressNew.add("Tien Giang");
        addressNew.add("Long An");

        // Get 1 element
        System.out.println(addressNew.get(0));
        System.out.println(addressNew.get(2));

        // Get all elements
        for(String a: addressNew){
            System.out.println(a);
        }
    }
}
