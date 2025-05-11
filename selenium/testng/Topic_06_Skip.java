package testng;

import org.testng.annotations.Test;

public class Topic_06_Skip {

    /**
     * Run TC:  @Test (enabled = true)
     * Skip TC: @Test (enabled = false)  OR
     *          //@Test
     * **/

    @Test (enabled = true)
    public void TC_01_ShouldBeCreateNewProduct(){
        System.out.println("1 Create New Product");
    }

    @Test (enabled = false)
    public void TC_02_ShouldBeEditProduct(){
        System.out.println("2 Edit Product");
    }

    @Test (priority = 0)
    public void TC_03_ShouldBeDeleteProduct(){
        System.out.println("3 Delete Product");
    }


}
