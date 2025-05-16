package javaTester.javaBasic;

public class Topic_09_While_Do_While {
    public static void main(String[] args) {
        int a = 0;

        // For
        for (int i = 0; i < 5; i++) {
            System.out.println("For: " + i);
        }

        // While
        int j = 0;
        while (j < 5) {
            System.out.println("While: " + j);
            j++;
        }

        // Do-While
        int k = 0;
        do {
            System.out.println("Do-While: " + k);
            k++;
        } while (k < 5);


        // Combine with condition
        for (a = 0; a < 5; a++) {
            System.out.println("For with condition: " + a);
            if (a == 3) {
                break;
            }
        }
        while (a < 5) {
            System.out.println("While with condition: " + a);
            a++;
            if (a == 3) {
                break;
            }
        }

        do {
            System.out.println("Do-While with condition: " + a);
            a++;
            if (a == 3) {
                break;
            }
        } while (a < 5);
    }

}
