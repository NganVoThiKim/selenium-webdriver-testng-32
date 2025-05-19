package javaTester.javaAccModFirst;

public class Laptop {
    public static void main(String[] args) {

        Computer computer = new Computer();

        // Default
        computer.ramProductName = "Kington_1";
        System.out.println(computer.ramProductName);
        computer.setRamProductName("Kingmax_1");
        System.out.println(computer.ramProductName);

        // Protected
        computer.cpuProductName = "Intel";
        System.out.println(computer.cpuProductName);
        computer.setCpuProductName("ADM");
        System.out.println(computer.cpuProductName);

        // Public
        computer.vgaSize = 6;
        System.out.println(computer.vgaSize);
        computer.setVgaSize(7);
        System.out.println(computer.vgaSize);

    }
}
