package javaTester.javaAccModSecond;

import javaTester.javaAccModFirst.Computer;

public class PC extends Computer {
    public void showCpuProductName(){

        // Protected
        cpuProductName = "Intel_1";
        System.out.println(cpuProductName);
        setCpuProductName("ADM_1");
        System.out.println(cpuProductName);


    }
    public void showVgaSize(){

        // Public
        vgaSize = 6;
        System.out.println(vgaSize);
        setVgaSize(7);
        System.out.println(vgaSize);
    }
}
