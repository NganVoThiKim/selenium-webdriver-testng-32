package javaTester.javaOOP.abstraction;

public abstract class Computer {

    // Non-Abstract method
    public void showCPU(){
        System.out.println("Intel CPU");
    }

    // Abstract method
    public abstract void setRam();

}
