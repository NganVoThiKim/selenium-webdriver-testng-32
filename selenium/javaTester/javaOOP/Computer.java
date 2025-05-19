package javaTester.javaOOP;

public abstract class Computer {

    // Normal Method
    public void showComputerPerformance(){
        System.out.println("Show computer performance");
    }
    // Abstract Method - It's frame and require child class override
    public abstract void showComputerRam();
}
