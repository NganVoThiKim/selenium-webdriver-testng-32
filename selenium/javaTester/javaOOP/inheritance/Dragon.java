package javaTester.javaOOP.inheritance;

public class Dragon implements Flyable, Runable, Swimable{
    @Override
    public void run() {
        System.out.println("Running...");
    }
}
