package javaTester.javaOOP.inheritance;

public class Animal {
    public Animal() {
        System.out.println("Constructor of Parent Class");
    }

    public Animal(String name) {
        System.out.println("Constructor of Parent Class: " + name);
    }

    public Animal(String name, int age) {
        System.out.println("Constructor of Parent Class: " + name + ", " + age);
    }

    protected void eat(){
        System.out.println("Eating...");
    }
}
