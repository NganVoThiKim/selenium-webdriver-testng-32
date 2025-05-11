package java;

import java.util.ArrayList;
import java.util.List;

public class Topic_08_For {
    public static void main(String[] args) {
        int number = 100;
        // for (classic)
        for (int i = 0; i < number; i++) {
            //System.out.println(i);
        }

        // Collection: List/ Set/ Queue/ Map
        List<String> name = new ArrayList<String>();
        name.add("Manual Testing");
        name.add("Automation Testing");
        name.add("Smoke Testing");
        name.add("Regression Testing");
        name.add("Stress Testing");
        name.add("Performance Testing");

        // Foreach
        for (String a : name) {
            if (a.equals("Manual Testing")) {
                //System.out.println(a);
            }
        }

        // While
        int i = 0;
        while (i < number) {
            System.out.println(i);
            i++;
        }

        // Do - While
        int j = 1000;
        do {
            System.out.println(j);
            j++;
        }
        while (j < number);

    }
}
