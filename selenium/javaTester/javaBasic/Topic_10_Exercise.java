package javaTester.javaBasic;

import java.util.List;
import java.util.Scanner;

public class Topic_10_Exercise {

    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Topic_10_Exercise exercise = new Topic_10_Exercise();
//        exercise.TC_01();
        exercise.TC_02();
    }
    public void TC_01(){
        System.out.print("Input browser: ");
        String browserName = scanner.nextLine();
        switch (browserName) {
            case "IE":
                // Bỏ qua nếu là IE
                System.out.println("IE is not supported. Skipping...");
                break;
            case "Chrome":
            case "Firefox":
            case "Safari":
                System.out.println("Opening " + browserName + "...");
                break;
            default:
                System.out.println("Trình duyệt không được hỗ trợ: " + browserName);
        }
    }

    public void TC_02(){
        System.out.print("Input month: ");
        int month = scanner.nextInt();
        switch (month){
            case 1:
                System.out.println("JAN");
                break;
            case 2:
                System.out.println("FEB");
                break;
            case 3:
                System.out.println("MAR");
                break;
            case 4:
                System.out.println("APR");
                break;
            case 5:
                System.out.println("MAY");
                break;
            case 6:
                System.out.println("JUN");
                break;
            case 7:
                System.out.println("JUL");
                break;
            case 8:
                System.out.println("AUG");
                break;
            case 9:
                System.out.println("SEP");
                break;
            case 10:
                System.out.println("OCT");
                break;
            case 11:
                System.out.println("NOV");
                break;
            case 12:
                System.out.println("DEC");
                break;
            default:
                System.out.println("Month is invalid");
        }
    }
}
