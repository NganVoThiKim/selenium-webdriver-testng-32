package javaTester.javaSDET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Topic_01_DataType {
    private static final Logger log = LoggerFactory.getLogger(Topic_01_DataType.class);

    public static void main(String[] args) {
        // Primitive data type

        // char
        char cZip = 'a';

        // byte/ short/ int/ long
        byte bNumber = 120;
        short sNumber = 1200;
        int iNumber = 350000;
        long lNumber = 2437436;

        // float/ double
        float fNumber = 15.7f;
        double dNumber = 15.7d;

        // boolean
        boolean gender = false;

        // Preference data type = Non-primitive data type

        // String
        String fullName = "Automation FC";

        // Class
//        FirefoxDriver fDriver = new FirefoxDriver();
//        Actions actions = new Actions(fDriver);
//        Topic_01_DataType topic01 = new Topic_01_DataType();


        // Interface
//        WebDriver driver;
//        JavascriptExecutor jsExecutor;

        // Array
        String[] studentName = {"Nam","Ngan",};
        Integer[] num1 = {1,2,null};
        Integer[] num2 = {1,2,};
        //int[] iNum2 = null;
        int[] iNum3 = {1,2,};

        // List/ Set/ Queue
        List<String> studentNamelist = new ArrayList<String>();
        List<String> studentCityList = new LinkedList<>();

        // Map
        Map<String, Integer> zip = new HashMap<>();

        // Object
        Object name = "Nam";
        Object phone = 1234;
        Object isDisplayed = true;

    }
}
