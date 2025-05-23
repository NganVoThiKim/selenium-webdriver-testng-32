package javaTester.javaOOP.polymorphism;

import javaTester.javaOOP.inheritance.Animal;

public class Pig extends Animals {
    @Override
    public void eat() {
        System.out.println("Pig eating...");
    }
}
