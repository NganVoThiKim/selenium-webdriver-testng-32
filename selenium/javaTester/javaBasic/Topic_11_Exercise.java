package javaTester.javaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Topic_11_Exercise {

    public static void main(String[] args) {

//        Topic_11_Exercise exercise = new Topic_11_Exercise();
//        exercise.TC_01_Find_Max_Element();
//        exercise.TC_02_Total_Of_First_And_End_Element();
//        exercise.TC_03_Odd_Numbers();
//        exercise.TC_04_Sum_Of_Even_Numbers_Greater_Than_0();
//        exercise.TC_05_Sprint_Numbers_Greater_Than_0_And_Lesser_Than_10();
//        exercise.TC_06_Sum_And_Average();
    }

    public void TC_01_Find_Max_Element() {
        int[] arr = {2, 7, 6, 8, 9};
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.print("Max = " + max);
    }

    public void TC_02_Total_Of_First_And_End_Element() {
        int[] arr = {2, 7, 6, 8, 9};
        System.out.println("Sum of first and end element = " + (arr[0] + arr[arr.length - 1]));
    }

    public void TC_03_Odd_Numbers() {
        int[] arr = {2, 7, 6, 8, 9, 16, 17, 20};
        System.out.print("Odd numbers: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public void TC_04_Sum_Of_Even_Numbers_Greater_Than_0() {
        int[] arr = {3, -7, 2, 5, 9, -6, 10, 12};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i] % 2 != 0) {
                sum += arr[i];
            }
        }
        System.out.print("Sum of even numbers and greater than 0: " + sum);
    }

    public void TC_05_Sprint_Numbers_Greater_Than_0_And_Lesser_Than_10() {
        int[] arr = {3, -7, 2, 5, 9, -6, 10, 12};
        System.out.print("Numbers >= 0 and <= 10: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && arr[i] <= 10) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public void TC_06_Sum_And_Average() {
        int[] arr = {3, 5, 7, 30, 10, 5, 8, 23, 0, -5};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + (float) sum / arr.length);
    }

    public void TC_07_Sprint_Student_Information(){

    }
    String id;
    String name;
    int age;
    float score;

    public Topic_11_Exercise(String id, String name, int age, float score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public void displayed() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Score: " + score);
    }

}
