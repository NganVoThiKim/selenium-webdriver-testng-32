
package javaTester.javaBasic;

import java.util.Scanner;

public class Topic_07_Exercise {
    // EXERCISE: https://docs.google.com/document/d/1X0VdORa79QhaI8UEXqlT3GlU0C2CNa7iBS4_6GQ02uI/edit?tab=t.0#heading=h.gzwfcmyfl82b
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Topic_07_Exercise exercise = new Topic_07_Exercise();
//        exercise.TC_01();
//        exercise.TC_02();
        exercise.TC_03();

    }

    public void TC_01() {
        System.out.print("Input number: ");
        int number = scanner.nextInt();
        switch (number) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 9:
                System.out.println("Nine");
                break;
            case 10:
                System.out.println("Ten");
                break;
            default:
                System.out.println("Pls input from 1-10");
        }
    }

    public void TC_02() {
        System.out.print("Input a: ");
        int a = scanner.nextInt();
        System.out.print("Input b: ");
        int b = scanner.nextInt();
        System.out.print("Input operation: ");
        String operation = scanner.next();
        switch (operation) {
            case "+":
                System.out.print("A + B = " + (a + b));
                break;
            case "-":
                System.out.print("A - B = " + (a - b));
                break;
            case "*":
                System.out.print("A * B = " + (a * b));
                break;
            case "/":
                System.out.print("A / B = " + (a / b));
                break;
            case "%":
                System.out.print("A % B = " + (a % b));
                break;
            default:
                System.out.print("Pls input operation = +, -, *, /, %");
        }

    }

    public void TC_03(){
        System.out.print("Input month: ");
        int month = scanner.nextInt();
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.print("Month " + month + " has 31 days");
                break;
            case 2:
                System.out.print("Month " + month + " has 28/29 days");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.print("Month " + month + " has 30 days");
                break;
            default:
                System.out.print("This month is invalid");
        }

    }

}
