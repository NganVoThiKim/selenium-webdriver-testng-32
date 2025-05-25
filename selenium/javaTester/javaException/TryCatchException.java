package javaTester.javaException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryCatchException {
    public static void main(String[] args) throws InterruptedException, IOException {
        // Single try...catch
//        int number = 5;
//        try {
//            number = number / 0;
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        }
//        System.out.println(number);
//
//        String[] browserNames = {"Chrome", "Firefox", "Safari"};
//        try {
//            browserNames[0] = "Edge";
//            browserNames[3] = "IE";
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        for (String browser : browserNames){
//            System.out.println(browser);
//        }

        // Multiple try...catch
//        try {
//            int array[] = new int[10];
//            array[10] = 30/0;
//        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e){
//            e.printStackTrace();
//        }

        // Multiple try...catch
//        try {
//            int a[] = new int[5];
//            a[5] = 30/0;
//        } catch (ArithmeticException e){
//            System.out.println("Step 01 finish");
//        } catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("Step 02 finish");
//        } catch (Exception e){
//            System.out.println("Step 03 finish");
//        }
//        System.out.println("Next step");

        // try...finally -> Close browser
        FileOutputStream outputStream = null;
//        try {
//            outputStream = new FileOutputStream("D://automationfc.jpg");
//            outputStream.write(65);
//        } catch (FileNotFoundException e) {
//            System.out.println("Step 01");
//            e.printStackTrace();
//        } catch (IOException e) {
//            System.out.println("Step 02");
//            e.printStackTrace();
//        } finally {
//            try {
//                outputStream.close();
//                System.out.println("Step 03");
//            } catch (IOException e) {
//                System.out.println("Step 04");
//                e.printStackTrace();
//            }
//        }

        // Throws exception for method
//        sleepInSecond(5);
//        findFile();

        // Exception Message - .getMessage()
//        try {
//            outputStream = new FileOutputStream("C://automationfc.jpg");
//            outputStream.write(65);
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

        // Exception Message - .toString()
//        try {
//            outputStream = new FileOutputStream("C://automationfc.jpg");
//            outputStream.write(65);
//        } catch (FileNotFoundException e) {
//            System.out.println(e.toString());
//        } catch (IOException e) {
//            System.out.println(e.toString());
//        }

        // Exception Message - .printStackTrace()
        try {
            outputStream = new FileOutputStream("C://automationfc.jpg");
            outputStream.write(65);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void sleepInSecond(long timeout) throws InterruptedException {
        Thread.sleep(timeout * 1000);
    }

    // throw
    public static void findFile() throws IOException {
        String fileName = "automationfc.jpg";
        File newFile = new File(fileName);
        if(newFile.exists() && !newFile.isDirectory()){
            // Action sth
            System.out.println("Action sth...");
        } else {
            throw new IOException("This file not found: " + fileName);
        }
    }

}
