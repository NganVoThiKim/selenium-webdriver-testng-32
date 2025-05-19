package javaTester.javaOOP;

public class Topic_02_Variable_Property_Method {
    /*
    * Declare Variable:
    * 1. Access Modifier
    * 2. Data Type
    * 3. Variable Name
    * 4. Variable Value
    * */


    // Global Variable
    private String studentName = "Automation FC";
    // Access Modifier = default
    int studentID = 1000;

    // Static Variable
    // Static - Using all
    public static String studentAddress = "Ho Chi Minh";
    // Static - Only inside class
    private static String studentPhone = "0866177228";

    // Final Variable - Can't assign/override
    final String country = "Viet Nam";

    // Static Final Variable - Constant
    static final float PI_NUMBER = 3.14f;

    // Method - Static
    public static void main(String[] args) {
        Topic_02_Variable_Property_Method topic02 = new Topic_02_Variable_Property_Method();
        // Local Variable in function
        String studentName = "Automation FC";
        if(topic02.studentName.startsWith("Automation")){
            // Local Variable in block code
            int number = 100;
        }
        // Static Variable
        studentAddress = "Da Nang";
        studentPhone = "0866177229";

    }

    // Constructor
    public Topic_02_Variable_Property_Method() {
        // Local Variable in constructor
        this.studentName = "Automation FC";

    }

    // Method - Non-static
    public void display(){
        this.studentName = "Automation FC";
    }

    // Property
    private int number;
    public int getNumber(){
        return this.number;
    }
    public void setNumber(int number){
        this.number = number;
    }
}
