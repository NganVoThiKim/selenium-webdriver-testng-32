package javaTester.javaOOP;

public class BaseOOP extends SeleniumWebDriver {
    protected short shortTimeout = 15;
    public long longTimeout = 45;
    // Using "Private" -> Inherited Class can't access although it's using "super"
//    private long longTimeout = 45;

    protected BaseOOP(){
        System.out.println("Constructor of Parent Class");
    }

    protected BaseOOP(String name){
        System.out.println("Constructor of Parent Class " + name);
    }

    protected BaseOOP(int number){
        System.out.println("Constructor of Parent Class " + number);
    }

    protected void clearData(){
        System.out.println("Cleared by Parent Class");
    }
}
