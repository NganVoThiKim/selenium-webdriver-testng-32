package javaTester.javaOOP;

public class Topic_05_This_Constructor {

    private int firstNumber;
    private int secondNumber;

    // This constructor access to the other constructor -> Must use "this"
    public Topic_05_This_Constructor(){
        // Using "this" to access from this constructor to the other constructor
        this(10,15);
        System.out.println("<this> must put at the first statement in constructor body");
        // ERROR if this constructor this access to the other constructor
//        this.Topic_05_This_Super(10,15);
    }

    // Global and Local Variable same name
    // This: Access to global variable
    public Topic_05_This_Constructor(int firstNumber, int secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public void sumNumber(){
        System.out.println(firstNumber + secondNumber);
    }

    public void showNumber(){
        this.sumNumber();
        // OR
//        sumNumber();
    }

    public static void main(String[] args) {
        // Check Variable
//        Topic_05_This_Super topic = new Topic_05_This_Super(1,2);
//        topic.showNumber();

        // Check Method
        Topic_05_This_Constructor topic = new Topic_05_This_Constructor();
        topic.showNumber();
    }
}
