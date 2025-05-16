package javaTester.javaBasic;

public class Topic_10_Break_Continue {
    public static void main(String[] args) {

        // Break - Exit the loop
        for (int i = 0; i < 5; i++) {
            System.out.println("i of break = " + i);
            if (i == 3) {
                break;
            }
        }

        // Continue - By pass block code which exist "continue"
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println("i of continue = " + i);
        }
    }
}
