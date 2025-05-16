package javaTester.javaBasic;

public class Topic_04_Exercise {

    public static void main(String[] args) {

        /**
         * PROCESS Math = / or %
         * **/

        int number = 10;
        number += 5;
        System.out.println(number);

        // 15 / 3 = 5
        System.out.println(number / 3);
        System.out.println(number);

        // 15 % 4 = 3 dư 3
        System.out.println(number / 4);
        System.out.println(number);


        /**
         * PROCESS Math = ++/ --
         * **/

        int a = 10;

        System.out.println(a++);
        // Sprint a before: 10
        // Increase a: 11

        System.out.println(++a);
        // Increase a: 12
        // Sprint a: 12

        System.out.println(a--);
        // Sprint a: 12
        // Descrease a: 11

        System.out.println(--a);
        // Descrease a: 10
        // Sprint a: 10

        /**
         * EXERCISE
         * 1. PRIORITY: process PREFIX
         * 2. Handle the remaining operations
         * 3. Assign value for variable on the left of equal sign
         * 4. Process POSTFIX
         * **/

        int firstVar = 5;
        int secondVar = 7;
        int result = firstVar++ + ++secondVar - 8;

        // second = 8
        // 5 + 8 - 8 = 5
        // result = 5
        // first = 6

        System.out.println("firstVar = " + firstVar);
        System.out.println("secondVar = " + secondVar);
        System.out.println("result = " + result);

        /**
         * PRACTISE in For
         **/
        for (int i = 0; i < 3; i++) {
            int abc = 10;
            System.out.println(abc += i);
            System.out.println("i++ = " + i);
        }

        System.out.println("\n");

        for (int j = 0; j < 3; ++j) {
            int xyz = 10;
            System.out.println(xyz += j);
            System.out.println("++j = " + j);
        }

        /****
         *
         */
        int num = 10;
        System.out.println(num + 1);
        // 10 + 1 = 11
        System.out.println(num - 1);
        // 10 - 1 = 9

        int value = 10;
        System.out.println(value++);
        // Sprint 10
        System.out.println(++value);
        // 12

    }
}
