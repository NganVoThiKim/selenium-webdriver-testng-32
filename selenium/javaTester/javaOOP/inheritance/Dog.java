package javaTester.javaOOP.inheritance;

public class Dog extends Animal implements Runable{
    public Dog(){
        super("Nena",10);
        System.out.println("Constructor of Child Class");
    }

    @Override
    public void run() {
        System.out.println("Running...");
    }
}
