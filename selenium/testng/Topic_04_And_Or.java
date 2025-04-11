package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_04_And_Or {
    @Test
    public void verifyAnd(){
        String contactInfor = "Testing Automation\n" +
                "fc1003@gmail.com\n" +
                "Change Password";
        Assert.assertTrue(contactInfor.contains("Testing Automation") && contactInfor.contains("Change Password"));
    }
}
