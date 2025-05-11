package testng;

import org.testng.annotations.Test;

public class Topic_15_Run_All_Classes {

    @Test
    public void runAllPackage(){
        /**
         *
         * 1. Create RunAllClasses.xml
         *
         * <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
         *
         * <suite name="Suite1 - Run all classes" verbose="1">
         *
         *     <packages>
         *         <package name="payment"/>
         *     </packages>
         *
         *     <parameter name="server" value="Production"/>
         *     <test name="Run on Chrome">
         *         <parameter name="browser" value="Chrome"/>
         *         <classes>
         *             <class name="testng.Topic_09_Parameter_Multiple_Browsers"/>
         *             <class name="testng.Topic_10_Optional"/>
         *         </classes>
         *     </test>
         *
         *
         * </suite>
         *
         * */
    }

}



