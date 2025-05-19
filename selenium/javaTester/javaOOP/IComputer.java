package javaTester.javaOOP;

public interface IComputer {

    // Normal Method but inside Interface: It is still abstract method without "abstract" keyword
    public void showComputerPerformance();

    // Abstract Method - It's frame and require child class override
    public abstract void showComputerRam();
}
