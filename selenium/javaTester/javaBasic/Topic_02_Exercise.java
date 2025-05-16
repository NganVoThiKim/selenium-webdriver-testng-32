package javaTester.javaBasic;

import org.testng.annotations.Test;


public class Topic_02_Exercise {

    @Test
    public void topic_03_exercise_1(){

        int a = 6;
        int b = 2;

        int addition  = a + b;
        System.out.println("Addition = " + addition);

        int subtraction  = a - b;
        System.out.println("Subtraction = " + subtraction);

        int multiplication  = a * b;
        System.out.println("Multiplication = " + multiplication);

        int division  = a / b;
        System.out.println("Division = " + division);

    }

    @Test
    public void topic_03_exercise_2(){
        float length = 7.5f;
        float width = 3.8f;
        System.out.println("Area of a rectangle = " + length * width);
    }

    @Test
    public void topic_03_exercise_3(){

        String name = "Automation Testing";
        System.out.println("Hello " + name);
    }
}
