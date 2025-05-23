package javaTester.javaOOP.overriding;

public class Student extends Person implements IWork{

    // OPTIONAL
    // Override from Parent Class
    public void eat() {
        System.out.println("Rice pack of Student = 15,000 VND");
    }

    // REQUIRE - Abstract Class
    @Override
    public void sleep() {
        System.out.println("Sleep time of Student = 12 Hours");
    }

    // REQUIRE - Interface
    @Override
    public void workingTime() {
        System.out.println("Working time of Student = 2 Hours");
    }

    // Can't override "Final Method"
//    @Override
//    public void walk() {
//        System.out.println("Walk");
//    }

    // Can't override "Static Method"
//    @Override
//    public void run() {
//        System.out.println("Run");
//    }

    // Can't override "Private Method"
//    @Override
//    public void dating() {
//        System.out.println("Dating");
//    }
}
