package javaBasic;


import org.testng.annotations.Test;

public class Topic_04_Operator {

    @Test
    public void Topic_04_Operator_Exercise_1() {

        String name = "Tuan";
        int age = 23;

        System.out.println("After 15 years, age of " + name + " will be " + (age + 15));
    }

    @Test
    public void Topic_04_Operator_Exercise_2() {

        int a = 3;
        int b = 4;

        System.out.println("Before swap: a = " + a);
        System.out.println("Before swap: b = " + b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("After swap: a = " + a);
        System.out.println("After swap: b = " + b);
    }

    @Test
    public void Topic_04_Operator_Exercise_3() {
        int a = 3;
        int b = 4;

        if (a > b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
