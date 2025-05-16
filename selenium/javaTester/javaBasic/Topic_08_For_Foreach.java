
package javaTester.javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Topic_08_For_Foreach {

    WebDriver driver;

    @Test
    public void Topic_08_For() {
        // Sprint 2 times
        for (int i = 0; i < 2; i++) {
            System.out.println(i);
        }
        // int i = 0: A temporary variable used to increment the value after each loop iteration
        // i < 2: Compare with total
        // i++: Incremented by 1 after entering the loop body
        /**
         * Iteration 1:
         * i = 0
         * 0 < 2 -> correct
         * System.out.println(i)
         * i++: Incremented by 1 -> (i = 1)
         * **/
        /**
         * Iteration 2:
         * i = 1
         * 1 < 2 -> correct
         * System.out.println(i)
         * i++: Incremented by 1 -> (i = 2)
         * **/
        /**
         * Iteration 3:
         * i = 2
         * 2 < 2 -> Incorrect
         * **/

        for (int i = 1; i <= 2; i++) {
            System.out.println(i);
        }
        // Apply to AUTOMATION
//        List<WebElement> links = driver.findElements(By.cssSelector(""));
//        links.size();


        // Array/ List/ Queue/ Set (Require start index = 0
        String[] cities = {"Ha Noi", "Ho Chi Minh", "Hue", "Da Nang"};
        for (int i = 0; i < cities.length; i++) {
            System.out.println(cities[i]);
        }

        // According to Array -> Index start from 1 -> INCORRECT
//        String[] citiesName = {"Ha Noi", "Ho Chi Minh", "Hue", "Da Nang"};
//        for (int i = 1; i < citiesName.length; i++) {
//            System.out.println(citiesName[i]);
//        }


        // COMPARE For with Foreach

        // For combined with If
        String[] students = {"Hoa", "Mai", "Dao", "Hue"};
        for (int i = 0; i < students.length; i++) {
            if (students[i] == "Mai") {
                System.out.println("Do action!");
                break;
            }
        }
        // Foreach: Loop through all the values
        for (String student : students) {
            System.out.println(student);
        }

        // FOR: Iterate backward/ Run in reverve
        for (int j = 10; j >= 0; j--) {
            System.out.println(j);
        }

    }

    @Test
    public void Topic_08_Foreach() {

        // Array
        String[] cityName = {"Ha Noi", "Ho Chi Minh", "Hue", "Da Nang", "Can Tho", "Hai Phong"};

        // Java Collection
        // Class: ArrayList, LinkedList, Vector,...
        // Interface: List, Set, Queue,...
        List<String> cityAddress = new ArrayList<String>();
        System.out.println(cityAddress.size());

        // Compile (Coding)
        cityAddress.add("Bac Giang");
        cityAddress.add("Ha Giang");
        cityAddress.add("Sa Pa");
        System.out.println(cityAddress.size());

        // Runtime (Running)
        for (String city : cityName) {
            cityAddress.add(city);
        }

        System.out.println(cityAddress.size());


        // Apply to AUTOMATION
        // Java Generic
        List<WebElement> links = driver.findElements(By.cssSelector(""));

        // Using to getText/ getValue/ getAttribute/ getCss
        // NOT using to click() because redirect page/ refresh DOM
        for (WebElement link : links) {
            link.getText();
        }
    }
}
