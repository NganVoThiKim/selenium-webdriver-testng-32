package javaTester.javaSDET;

import org.testng.annotations.Test;

import java.util.Random;

public class Topic_05_Random {
    String prefixEmail = "joebiden";
    String postfixEmail = "@gmail.com";

    @Test
    public void testEmail(){
        Random random = new Random();

        System.out.println(prefixEmail + random.nextInt(999999) + postfixEmail);
        System.out.println(prefixEmail + random.nextInt(999999) + postfixEmail);
    }
}
