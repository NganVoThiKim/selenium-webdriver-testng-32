package javaTester.javaOOP;

public class Topic_04_Overloading {

    static int plusMethod(int a, int b){
        return a + b;
    }
    // Same name, Same amount of parameters -> Different data type
    static double plusMethod(double a, double b){
        return a + b;
    }
    static int plusMethod(int a, int b, int c){
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println(plusMethod(5,5));
        System.out.println(plusMethod(5.5, 5.5));
        System.out.println(plusMethod(1,2,3));
    }
}
