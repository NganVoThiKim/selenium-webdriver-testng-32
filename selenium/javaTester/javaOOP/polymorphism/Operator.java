package javaTester.javaOOP.polymorphism;

public class Operator {

    // Overloading - Compile
    void sum(int a, int b){
        System.out.println(a+b);
    }

    void sum(float a, float b){
        System.out.println(a+b);
    }

    void sum(long a, long b){
        System.out.println(a+b);
    }

    void sum(double a, double b){
        System.out.println(a+b);
    }

    public static void main(String[] args) {
        Operator operator = new Operator();
        operator.sum(1,2);
        operator.sum(1.1,2.2);
        operator.sum(1L,2L);
        operator.sum(1d,2d);

    }
}
