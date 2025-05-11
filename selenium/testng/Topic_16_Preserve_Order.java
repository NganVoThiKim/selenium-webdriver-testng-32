package testng;

import org.testng.annotations.Test;

public class Topic_16_Preserve_Order {

    @Test
    public void runAllPackage(){
        /**
         *
         * 1. preserve-order="false" -> Sort from 0-9, a-z
         *
         * <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
         *
         * <suite name="Suite1 - Run Preserve Order" verbose="1">
         *
         *     <parameter name="server" value="Production" />
         *     <test name="Run on Chrome" preserve-order="false">
         *         <parameter name="browser" value="Chrome"/>
         *         <classes>
         *             <class name="testng.Topic_10_Optional"/>
         *             <class name="testng.Topic_09_Parameter_Multiple_Browsers"/>
         *             <class name="testng.Topic_07_Description"/>
         *         </classes>
         *     </test>
         *
         *
         * </suite>
         *
         *
         * 2. preserve-order="true" -> Stay order same as <classes></classes>
         *
         * <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
         *
         * <suite name="Suite1 - Run Preserve Order" verbose="1">
         *
         *     <parameter name="server" value="Production" />
         *     <test name="Run on Chrome" preserve-order="true">
         *         <parameter name="browser" value="Chrome"/>
         *         <classes>
         *             <class name="testng.Topic_10_Optional"/>
         *             <class name="testng.Topic_09_Parameter_Multiple_Browsers"/>
         *             <class name="testng.Topic_07_Description"/>
         *         </classes>
         *     </test>
         *
         *
         * </suite>
         *
         * */
    }

}



