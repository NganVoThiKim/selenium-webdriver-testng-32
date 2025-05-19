package javaTester.javaAccModSecond;

import javaTester.javaAccModFirst.Computer;

public class WorkStation {
    public static void main(String[] args) {
        Computer computer = new Computer();

        // Public
        computer.vgaSize = 6;
        System.out.println(computer.vgaSize);
        computer.setVgaSize(7);
        System.out.println(computer.vgaSize);
    }

}
