package javaTester.javaException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JavaException {

    public static void main(String[] args) throws IOException {
        // NullPointerException
//        System.out.println("Step 01: NullPointerException");
//        String name = null;
//        System.out.println(name.length());

        // NumberFormatException
//        System.out.println("Step 02: NumberFormatException");
//        String name = "Automation Testing";
//        int number = Integer.parseInt(name);
//        System.out.println(number);

        // ArrayIndexOutOfBoundsException
//        System.out.println("Step 03: ArrayIndexOutOfBoundsException");
//        int price[] = new int[5];
//        price[10] = 50;

        // FileNotFoundException
        System.out.println("Step 04: FileNotFoundException");
        File file = new File("C:\\automation.jpg");
        FileReader reader = new FileReader(file);
        reader.close();

    }


}
