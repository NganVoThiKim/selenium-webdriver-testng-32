package javaTester.javaOOP.overriding;

public class Testing {
    public static void main(String[] args) {

        // OPTIONAL
//        Person person = new Person();
//        person.eat();
//
//        Student student = new Student();
//        student.eat();
//
//        Employee employee = new Employee();
//        employee.eat();

        // REQUIRE - Abstract Class - Interface
        Student student = new Student();
        student.eat();
        student.sleep();
        student.workingTime();

        Employee employee = new Employee();
        employee.eat();
        employee.sleep();
        employee.workingTime();
    }
}
