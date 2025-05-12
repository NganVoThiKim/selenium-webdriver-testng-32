package javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Topic_03_Compare_Memory_Area {

    int number = 8;

    public static void main(String[] args) {

        // Primitive
        // x is stored in 1 memory area
        int x = 5;

        // x is stored in 1 memory area
        int y = x;

        // x = 5
        // y = 5
        System.out.println("Before: x = " + x);
        System.out.println("Before: y = " + y);

        y = 10;

        // x = 5
        // y = 10
        System.out.println("After: x = " + x);
        System.out.println("After: y = " + y);

        // NON Primitive
        Topic_03_Compare_Memory_Area firstVariable = new Topic_03_Compare_Memory_Area();
        Topic_03_Compare_Memory_Area secondVariable = firstVariable;
        Topic_03_Compare_Memory_Area thirdVariable = new Topic_03_Compare_Memory_Area();

        System.out.println("Before: firstNumber = " + firstVariable.number);
        System.out.println("Before: secondNumber = " + secondVariable.number);
        System.out.println("Before: thirdNumber = " + thirdVariable.number);

        secondVariable.number = 15;

        System.out.println("After: firstNumber = " + firstVariable.number);
        System.out.println("After: secondNumber = " + secondVariable.number);
        System.out.println("After: thirdNumber = " + thirdVariable.number);

    }
}
