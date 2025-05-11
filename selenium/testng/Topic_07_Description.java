package testng;

import org.testng.annotations.Test;

public class Topic_07_Description {

    @Test (description = "Create new product and verify")
    public void TC_01_ShouldBeCreateNewProduct(){
        System.out.println("1 Create New Product");
    }

    @Test
    public void TC_02_ShouldBeEditProduct(){
        System.out.println("2 Edit Product");
    }

    @Test
    public void TC_03_ShouldBeDeleteProduct(){
        System.out.println("3 Delete Product");
    }



}
