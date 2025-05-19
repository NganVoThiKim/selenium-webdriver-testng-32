package javaTester.javaAccModFirst;

public class Computer {

    // Property
    private int ssdSize;
    String ramProductName;
    protected String cpuProductName;
    public int vgaSize;

    // Method
    private void setSsdSize(int ssd_size){
        ssdSize = ssd_size;
    }
    void setRamProductName(String ramName){
        ramProductName = ramName;
    }
    protected void setCpuProductName(String cpuName){
        cpuProductName = cpuName;
    }
    public void setVgaSize(int vgaSize){
        this.vgaSize = vgaSize;
    }

    public static void main(String[] args) {

        Computer computer = new Computer();

        // Private
        computer.ssdSize = 500;
        System.out.println(computer.ssdSize);
        computer.setSsdSize(600);
        System.out.println(computer.ssdSize);

        // Default
        computer.ramProductName = "Kington";
        System.out.println(computer.ramProductName);
        computer.setRamProductName("Kingmax");
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
