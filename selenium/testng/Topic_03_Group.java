package testng;

import org.testng.annotations.*;

public class Topic_03_Group {

    /**
     * RunTest.xml
     *
     * <!--<suite name="Suite1_Run Class And Group" verbose="1">-->
     *
     * <!--// RUN 1 Group - INCLUDE-->
     * <!--    <test name="selenium -> testng -> Topic_03_Group">-->
     * <!--        <groups>-->
     * <!--            <run>-->
     * <!--                <include name="product"/>-->
     * <!--            </run>-->
     * <!--        </groups>-->
     *
     * <!--        <packages>-->
     * <!--            <package name="product"></package>-->
     * <!--            <package name="payment"></package>-->
     * <!--        </packages>-->
     * <!--    </test>-->
     *
     * <!--// RUN 1 Group - EXCLUDE-->
     * <!--        <test name="selenium -> testng -> Topic_03_Group_Exclude">-->
     * <!--            <groups>-->
     * <!--                <run>-->
     * <!--                    <exclude name="regression"/>-->
     * <!--                </run>-->
     * <!--            </groups>-->
     *
     * <!--            <packages>-->
     * <!--                <package name="product"></package>-->
     * <!--                <package name="payment"></package>-->
     * <!--            </packages>-->
     * <!--        </test>-->
     *
     * <!--</suite>-->
     *
     * ********/

    @Test
    public void TC_01(){
        System.out.println("Run TC_01");
    }

    @Test
    public void TC_02(){
        System.out.println("Run TC_02");
    }

    @Test
    public void TC_03(){
        System.out.println("Run TC_03");
    }


}
