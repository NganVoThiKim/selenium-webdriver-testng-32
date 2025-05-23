package javaTester.javaOOP.polymorphism;

import javaTester.javaOOP.inheritance.Animal;

public class Test {
    public static void main(String[] args) {
        Animals ani = new Animals();
        ani.eat();

        ani = new Pig();
        ani.eat();

        ani = new Bird();
        ani.eat();
    }

}
