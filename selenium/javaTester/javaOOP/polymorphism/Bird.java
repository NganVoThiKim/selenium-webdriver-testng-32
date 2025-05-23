package javaTester.javaOOP.polymorphism;

import javaTester.javaOOP.inheritance.Animal;

public class Bird extends Animals {
    @Override
    public void eat() {
        System.out.println("Bird eating...");
    }
}
