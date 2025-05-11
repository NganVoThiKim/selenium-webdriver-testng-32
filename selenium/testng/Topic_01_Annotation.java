package testng;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Topic_01_Annotation {

    /**
     * RunTest.xml
     *
     * <!--<suite name="Suite1_Run Class And Group" verbose="1">-->
     *
     * <!--// RUN 1 Class-->
     * <!--    <test name="selenium -> testng -> Topic_01_Annotation">-->
     * <!--        <classes>-->
     * <!--            <class name="testng.Topic_01_Annotation"/>-->
     * <!--        </classes>-->
     * <!--    </test>-->
     *
     * <!--</suite>-->
     *
     * ***/

    /****
     * PRIORITY:
     * Run Before Suite
     *      Run Before Test
     *          Run Before Class
     *
     *              Run Before Method
     *                  Run Test TC_01
     *              Run After Method
     *
     *              Run Before Method
     *                  Run Test TC_02
     *              Run After Method
     *
     *              Run Before Method
     *                  Run Test TC_03
     *              Run After Method
     *
     *          Run After Class
     *      Run After Test
     * Run After Suite
     *
     * NOTE: Don't run Before - After Group
     */

    @BeforeGroups
    public void beforeGroup(){
        System.out.println("Run Before Group");
    }

    @AfterGroups
    public void afterGroup() {
        System.out.println("Run After Group");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Run Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Run After Suite");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Run Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Run After Class");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Run Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Run After Test");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Run Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Run After Method");
    }

    @Test
    public void TC_01(){
        System.out.println("Run Test TC_01");
    }

    @Test
    public void TC_02(){
        System.out.println("Run Test TC_02");
    }

    @Test
    public void TC_03(){
        System.out.println("Run Test TC_03");
    }


}
