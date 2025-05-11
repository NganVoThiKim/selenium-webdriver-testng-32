package testng;

import org.testng.annotations.*;

public class Topic_05_Priority {

    /**
     * PRIORITY
     * Create New Product
     * View Product
     * Edit Product
     * Delete Product
     * **/

    @Test (priority = 0)
    public void TC_01_ShouldBeCreateNewProduct(){
        System.out.println("1 Create New Product");
    }

    @Test (priority = 2)
    public void TC_02_ShouldBeEditProduct(){
        System.out.println("3 Edit Product");
    }

    @Test (priority = 6)
    public void TC_03_ShouldBeDeleteProduct(){
        System.out.println("5 Delete Product");
    }

    @Test (priority = 1)
    public void TC_04_ShouldBeViewProduct(){
        System.out.println("2 View Product");
    }

    @Test (priority = 3)
    public void TC_05_ShouldBePaymentProduct(){
        System.out.println("4 Payment Product");
    }


}
