package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_14_Run_All_Packages {

    @Test
    public void runAllPackage(){
        /**
         * 1. Create RunProductFeature.xml
         *
         * <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
         *
         * <suite name="Suite1 - Run Product" verbose="1">
         *     <test name="Live Guru - Product">
         *         <classes>
         *             <class name="product.Product_01_CRUD"/>
         *         </classes>
         *     </test>
         * </suite>
         *
         *
         * 2. Create RunPaymentFeature.xml
         *
         * <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
         *
         * <suite name="Suite1 - Run Payment" verbose="1">
         *     <test name="Live Guru - Payment">
         *         <classes>
         *             <class name="payment.Payment_01_CRUD"/>
         *         </classes>
         *     </test>
         * </suite>
         *
         * 3. Create RunAllFeatures.xml
         *
         * <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
         *
         * <suite name="Suite1 - Run all features" verbose="1">
         *
         *     <suite-files>
         *         <suite-file path="RunProductFeature.xml"></suite-file>
         *         <suite-file path="RunPaymentFeature.xml"></suite-file>
         *     </suite-files>
         *
         * </suite>
         *
         *
         *
         * */
    }

}



