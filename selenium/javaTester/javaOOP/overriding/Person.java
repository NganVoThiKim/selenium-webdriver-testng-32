package javaTester.javaOOP.overriding;

public abstract class Person {

    public void eat(){
        System.out.println("Rice pack = 20,000 VND");
    }

    public abstract void sleep();

    // Child class can't override if method contains "Final"
    public final void walk(){
        System.out.println("Walk");
    }

    // Child class can't override if method contains "Static"
    public static void run(){
        System.out.println("Run");
    }

    // Child class can't override if method contains "private"
    private void dating(){
        System.out.println("Dating");
    }


}
