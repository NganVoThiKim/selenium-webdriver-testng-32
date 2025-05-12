
package javaBasic;

public class Topic_05_Primitive_Casting {

    public static void main(String[] args) {

        // Primitive
        // Implicit
        byte bNumber = 126;
        System.out.println(bNumber);

        short sNumber = bNumber;
        System.out.println(sNumber);

        int iNumber = sNumber;
        System.out.println(iNumber);

        long lNumber = iNumber;
        System.out.println(lNumber);

        float fNumber = lNumber;
        System.out.println(fNumber);

        double dNumber = fNumber;
        System.out.println(dNumber);

        // Explicit
        double dValue = 4387653487d;
        System.out.println(dValue);

        float fValue = (float) dValue;
        System.out.println(fValue);

        long lValue = (long) fValue;
        System.out.println(lValue);

        int iValue = (int) lValue;
        System.out.println(iValue);


        // Non - Primitive
    }
}
