package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_17_Dependencies {

    /**
     * TC_01_ShouldBeCreateNewProduct -> Failed
     * SKIP
     * TC_03_ShouldBeEditProduct
     * TC_04_ShouldBeDeleteProduct
     * **/

    @Test
    public void TC_01_ShouldBeCreateNewProduct(){
        System.out.println("1 Create New Product");
        Assert.assertTrue(false);
    }

    @Test
    public void TC_02_ShouldBeViewProduct(){
        System.out.println("2 View Product");
    }

    @Test (groups = "edit", dependsOnMethods = "TC_01_ShouldBeCreateNewProduct")
    public void TC_03_ShouldBeEditProduct(){
        System.out.println("3 Edit Product");
    }

    @Test (dependsOnGroups = "edit")
    public void TC_04_ShouldBeDeleteProduct(){
        System.out.println("4 Delete Product");
    }

}
