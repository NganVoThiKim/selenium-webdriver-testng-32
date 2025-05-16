
package javaTester.javaBasic;

import java.util.Scanner;


public class Topic_06_Exercise {
    // EXERCISE: https://docs.google.com/document/d/1sybMVpQ0yFRtOh_kqo79m40zELpA0f5GFLTVIIuvOBc/edit?tab=t.0

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Topic_06_Exercise exercise = new Topic_06_Exercise();
//        exercise.TC_01();
//        exercise.TC_02();
//        exercise.TC_03();
//        exercise.TC_04();
//        exercise.TC_05();
//        exercise.TC_06();
        exercise.TC_07();
    }

    public void TC_01() {
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        if (number % 2 == 0) {
            System.out.println("Number " + number + " is even");
        } else {
            System.out.println("Number " + number + " is odd");
        }
    }

    public void TC_02() {
        System.out.print("Input a: ");
        int a = scanner.nextInt();
        System.out.print("Input b: ");
        int b = scanner.nextInt();
        if (a >= b) {
            System.out.print("a greater than or equal b");
        } else {
            System.out.print("a less than b");
        }

    }

    public void TC_03() {
        System.out.print("First Name: ");
        String first = scanner.nextLine();
        System.out.print("Second Name: ");
        String second = scanner.nextLine();
        if (first.equalsIgnoreCase(second)) {
            System.out.print("Same name");
        } else {
            System.out.print("Different name");
        }

        // String can't use "==" to compare
//        if (first == second) {
//            System.out.print("Same name");
//        } else {
//            System.out.print("Different name");
//        }

    }

    public void TC_04() {
        System.out.print("Input a: ");
        int a = scanner.nextInt();
        System.out.print("Input b: ");
        int b = scanner.nextInt();
        System.out.print("Input c: ");
        int c = scanner.nextInt();
        if (a > b && a > c) {
            System.out.println("Max = " + a);
        } else if (b > c) {
            System.out.println("Max = " + b);
        } else {
            System.out.println("Max = " + c);
        }
    }

    public void TC_05() {
        System.out.print("Input a: ");
        int a = scanner.nextInt();

        if (a >= 10 && a <= 100) {
            System.out.print(a + " existed in [10,100]");
        } else {
            System.out.print(a + " NOT exist in [10,100]");
        }

    }

    public void TC_06() {
        System.out.print("Input point: ");
        float point = scanner.nextFloat();
        if (point >= 0 && point < 5) {
            System.out.print("D");
        } else if (point < 7.5) {
            System.out.print("C");
        } else if (point < 8.5) {
            System.out.print("B");
        } else if (point <= 10) {
            System.out.print("A");
        } else {
            System.out.print("Valid point");
        }
    }

    public void TC_07() {
        System.out.print("Input month: ");
        int month = scanner.nextInt();
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            System.out.print("Month " + month + " has 31 days");
        } else if (month == 2) {
            System.out.print("Month " + month + " has 28/29 days");
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            System.out.print("Month " + month + " has 30 days");
        } else {
            System.out.print("Month is invalid");
        }

    }
}


