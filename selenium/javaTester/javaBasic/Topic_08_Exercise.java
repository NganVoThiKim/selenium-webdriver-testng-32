
package javaTester.javaBasic;

import java.util.Scanner;

public class Topic_08_Exercise {
    // EXERCISE: https://docs.google.com/document/d/1iQOVsLyKaTpw5L1055jXaDR36Kzx6_MS17Kzm7r5LzQ/edit?tab=t.0#heading=h.1o4r359lkeb2

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Topic_08_Exercise exercise = new Topic_08_Exercise();
//        exercise.TC_01();
//        exercise.TC_02();
//        exercise.TC_03();
//        exercise.TC_04();
//        exercise.TC_05();
//        exercise.TC_06();
        exercise.TC_07();

    }

    public void TC_01() {
        System.out.print("Input: ");
        int number = scanner.nextInt();
        for (int i = 1; i <= number; i++) {
            System.out.print(i + " ");
        }
    }

    public void TC_02() {
        System.out.print("Input a: ");
        int a = scanner.nextInt();
        System.out.print("Input b: ");
        int b = scanner.nextInt();
        for (int i = a; i <= b; i++) {
            System.out.print(i + " ");
        }
    }

    public void TC_03() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.print("Sum = " + sum);
    }

    public void TC_04() {
        int sum = 0;
        System.out.print("Input a: ");
        int a = scanner.nextInt();
        System.out.print("Input b: ");
        int b = scanner.nextInt();
        for (int i = a; i <= b; i++) {
            sum += i;
        }
        System.out.print("Sum =  " + sum);
    }

    public void TC_05() {
        int sum = 0;
        System.out.print("Input n: ");
        int n = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        System.out.print("Sum = " + sum);
    }

    public void TC_06() {
        System.out.print("Input a: ");
        int a = scanner.nextInt();
        System.out.print("Input b: ");
        int b = scanner.nextInt();
        System.out.print("A number divisible by 3: ");
        for (int i = a; i <= b; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public void TC_07() {
        System.out.print("Input n: ");
        int n = scanner.nextInt();
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.print(n + "! = " + factorial);
    }

}
