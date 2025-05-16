package javaTester.javaBasic;

import java.util.Scanner;

public class Topic_09_Exercise {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Topic_09_Exercise exercise = new Topic_09_Exercise();
//        exercise.TC_01();
//        exercise.TC_02();
//        exercise.TC_03();
//        exercise.TC_04();
//        exercise.TC_05();
        exercise.TC_06();

    }

    public void TC_01() {
        System.out.print("Input n: ");
        int n = scanner.nextInt();
        System.out.print("Odd list are: ");
        while (n <= 100) {
            if (n % 2 == 0) {
                System.out.print(n + " ");
            }
            n++;
        }
    }

    public void TC_02() {
        System.out.print("Input a: ");
        int a = scanner.nextInt();
        System.out.print("Input b: ");
        int b = scanner.nextInt();
        System.out.print("Number divided by 3 and 5: ");
        while (a < b) {
            if (a % 3 == 0 && a % 5 == 0) {
                System.out.print(a + " ");
            }
            a++;
        }
    }

    public void TC_03() {
        System.out.print("Input n: ");
        int n = scanner.nextInt();
        System.out.print("List of even numbers: ");
        int i = 0;
        int sum = 0;
        while (i <= n) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
                sum += i;
            }
            i++;
        }
        System.out.println("Sum of even list: " + sum);
    }

    public void TC_04() {
        System.out.print("Input a: ");
        int a = scanner.nextInt();
        System.out.print("Input b: ");
        int b = scanner.nextInt();
        System.out.print("Number divided by 3: ");
        while (a < b) {
            if (a % 3 == 0) {
                System.out.print(a + " ");
            }
            a++;
        }
    }

    public void TC_05() {
        System.out.print("Input n: ");
        int n = scanner.nextInt();
        int i = 1;
        long factorial = 1;
        while (i <= n) {
            factorial *= i;
            i++;
        }
        System.out.print(n + "! = " + factorial);
    }

    public void TC_06() {
        System.out.print("Input n: ");
        int n = scanner.nextInt();
        int i = 1;
        int sum = 0;
        while (i <= n) {
            if (i % 2 == 0) {
                sum += i;
            }
            i++;
        }
        System.out.print("Sum of odd numbers: " + sum);
    }
}
