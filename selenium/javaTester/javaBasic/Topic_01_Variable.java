package javaTester.javaBasic;

public class Topic_01_Variable {

    static String staticVariable = "staticVariable";
    int globalVariable = 1;

    public static void main(String[] args) {
        double localVariable = 0.1;
        Topic_01_Variable staticType = new Topic_01_Variable();

        System.out.println(staticVariable);
        System.out.println(staticType.globalVariable);
        System.out.println(localVariable);
    }
}
