package javaTester.javaOOP;

public class Topic_03_Method {

    // Non-static method
    void showCarName(){
        System.out.println("Toyota");
    }

    // Static method
    static void showCarColor(){
        System.out.println("White");
    }

    public static void main(String[] args) {
        Topic_03_Method topic = new Topic_03_Method();
        topic.showCarName();
        showCarColor();

    }
}
