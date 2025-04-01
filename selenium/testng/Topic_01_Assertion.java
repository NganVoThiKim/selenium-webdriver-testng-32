package testng;

import org.testng.Assert;

public class Topic_01_Assertion {

    public static void main(String[] args) {
        // 3 main methods to compare data
        boolean operate = 3 < 5;

        // Check data is TRUE
        Assert.assertTrue(operate);

        // Check data is FALSE
        Assert.assertFalse(3 > 5);

        // Check data = expect (ACTUAL = EXPECTED)
        Assert.assertEquals(3,5-2);
        Assert.assertEquals("NAME","NAME");
    }
}
