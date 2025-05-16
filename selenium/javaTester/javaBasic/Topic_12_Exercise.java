package javaTester.javaBasic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.*;

public class Topic_12_Exercise {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Topic_12_Exercise exercise = new Topic_12_Exercise();
//        exercise.TC_01();
//        exercise.TC_01_Way_2();
//        exercise.TC_02();
//        exercise.TC_02_Way_2();
//        exercise.TC_03();
        exercise.TC_03_Way_2();

    }

    public void TC_01() {
        System.out.print("Input string: ");
        String input = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        System.out.println("Amount of uppercase characters: " + count);
    }

    public void TC_01_Way_2() {
        System.out.print("Input string: ");
        String input = scanner.nextLine();
        int countUpper = 0;
        int countLower = 0;
        int countNumber = 0;
        char charList[] = input.toCharArray();
        for (char character : charList)
        {
            if(character >= 'A' && character <= 'Z'){
                countUpper++;
            }
            if(character >= 'a' && character <= 'z'){
                countLower++;
            }
            if(character >= '0' && character <= '9'){
                countNumber++;
            }
        }
        System.out.println("WAY 2: Amount of uppercase characters: " + countUpper);
        System.out.println("WAY 2: Amount of lower characters: " + countLower);
        System.out.println("WAY 2: Amount of number: " + countNumber);
    }

    public void TC_02() {
        String str = "Automation Testing 345 Tutorials Online 789";
        char target = 'a';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.toLowerCase(str.charAt(i)) == target) {
                count++;
            }
        }
        System.out.println("Amount of 'a' characters: " + count);

        if (str.contains("Testing")) {
            System.out.println("True: String exists 'Testing'");
        } else {
            System.out.println("False: String not exists 'Testing'");
        }

        if (str.endsWith("Online")) {
            System.out.println("True: String end with 'Online'");
        } else {
            System.out.println("False: String not start with 'Online'");
        }

        System.out.println("Index of 'Tutorials': " + str.indexOf("Tutorials"));
        System.out.println("Replace 'Online'  by 'Offline': " + str.replace("Online", "Offline"));

        int countNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                countNum++;
            }
        }
        System.out.println("Amount of digital characters: " + countNum);

    }

    public void TC_02_Way_2() {
        String str = "Automation Testing 345 Tutorials Online 789";
        int count = 0;
        char[] charList = str.toCharArray();
        for (char character : charList ){
            if(character == 'a' || character == 'A'){
                count++;
            }
        }
        System.out.println("Way 2: Amount of 'a' characters: " + count);

        if (str.contains("Testing")) {
            System.out.println("True: String exists 'Testing'");
        } else {
            System.out.println("False: String not exists 'Testing'");
        }

        if (str.endsWith("Online")) {
            System.out.println("True: String end with 'Online'");
        } else {
            System.out.println("False: String not start with 'Online'");
        }

        System.out.println("Index of 'Tutorials': " + str.indexOf("Tutorials"));
        System.out.println("Replace 'Online'  by 'Offline': " + str.replace("Online", "Offline"));

        int countNum = 0;
        for (char character : charList)
        {
            if(character >= '0' && character <= '9'){
                countNum++;
            }
        }
        System.out.println("Way 2: Amount of digital characters: " + countNum);

    }

    public void TC_03() {
        System.out.print("Input string: ");
        String str = scanner.nextLine();
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i) + "");
        }
    }

    public void TC_03_Way_2() {
        System.out.print("Input string: ");
        String str = scanner.nextLine();
        char charArr[] = str.toCharArray();
        List<Character> charList = new ArrayList<>();

        for(char character : charArr){
            charList.add(character);
        }
        Collections.reverse(charList);
        System.out.println("Reversed: " + charList);


    }
}
