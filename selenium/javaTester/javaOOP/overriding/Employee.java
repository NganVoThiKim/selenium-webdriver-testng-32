package javaTester.javaOOP.overriding;

public class Employee extends Person implements IWork{

    // OPTIONAL
    @Override
    public void eat() {
        System.out.println("Rice pack of Employee = 25,000 VND");
    }

    // REQUIRE - Abstract Class
    @Override
    public void sleep() {
        System.out.println("Sleep time of Employee = 6 Hours");
    }

    // REQUIRE - Interface
    @Override
    public void workingTime() {
        System.out.println("Working time of Employee = 8 Hours");
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
