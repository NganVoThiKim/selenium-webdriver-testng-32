package javaTester.javaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topic_11_Array_ArrayList {

    // Object Array
    String name;
    int age;

    public Topic_11_Array_ArrayList(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {

        // Object Array
        Topic_11_Array_ArrayList[] students = new Topic_11_Array_ArrayList[3];

        students[0] = new Topic_11_Array_ArrayList("Tuan", 24);
        students[1] = new Topic_11_Array_ArrayList("Cuong", 19);
        students[2] = new Topic_11_Array_ArrayList("Dung", 20);

        System.out.println("Object Array: ");
        for (int i = 0; i < 3; i++ ) {
            students[i].display();
        }

        // 2 ways to declare 1 array (Define value)
        int number[] = {12, 7, 5, 61, 15};
        int[] number2 = {12, 7, 5, 61, 15};

        System.out.println("Number[0] = " + number[0]);
        System.out.println("Number[1] = " + number[1]);

        // Declare 1 array without define value
        int a[] = new int[5]; //5 = length of array
        a[0] = 10;
        System.out.println("a[0] = " + a[0]);
        System.out.println("a[1] = " + a[1]);
        System.out.println("a[4] = " + a[4]);


        // Array - Defined with a fixed number of elements when writing code (Compile)
        // Static
        String studentName[] = {"Nam", "Long", "An"};
        studentName[0] = "Hoa";
        for (int i = 0; i < studentName.length; i++) {
            if (studentName[i].equalsIgnoreCase("Long")) {
                System.out.println("Student of for: " + studentName[i]);
            }
        }
        // Foreach
        for (String student : studentName) {
            if (student.equalsIgnoreCase("Long")) {
                System.out.println("Student of foreach: " + student);
            }
        }

        // Array List - Elements are added only when the code is executed
        // Dynamic
        ArrayList<String> stdName = new ArrayList<>();
        stdName.add("Ngan");
        stdName.add("Nam");
        System.out.println("Size of stdName = " + stdName.size());
        stdName.remove("Ngan");
        for (int i = 0; i < stdName.size(); i++) {
            System.out.println("stdName = " + stdName);
        }

        List<String> names = Arrays.asList("Tom", "Jerry", "Donald");
        for (String name : names) {
            System.out.println("Name = " + name);
        }

        // Sort array
        int[] years = new int[]{2001, 1995, 1996, 2000, 2017};
        Arrays.sort(years);
        System.out.print("Sorted years: ");
        for (int year : years) {
            System.out.print(year + " ");
        }


    }


}
