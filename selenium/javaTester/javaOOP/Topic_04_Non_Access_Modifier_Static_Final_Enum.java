package javaTester.javaOOP;

public class Topic_04_Non_Access_Modifier_Static_Final_Enum {

    // Static Variable
    static String browserName = "Chrome";

    // Non-Static Variable
    String serverName = "Testing";

    // Final Variable
    final String colorCar = "Red";

    // Final - Static Variable
    final static String REGISTER_BTN = "#register";

    // Static Method
    static void clickToElement(String elementName) {
        System.out.println(elementName);
    }

    // Non-Static Method
    void sendkeyToElement(String elementName) {
        System.out.println(elementName);
    }

    // Enum
    public enum BrowserList {
        CHROME, FIREFOX, IE, SAFARI, EDGE
    }

    protected void getBrowserDriver(String browserName) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        switch (browser) {
            case CHROME:
                System.out.println("new CHROME");
                break;
            case FIREFOX:
                System.out.println("new FIREFOX");
                break;
            case IE:
                System.out.println("new IE");
                break;
            case SAFARI:
                System.out.println("new SAFARI");
                break;
            case EDGE:
                System.out.println("new EDGE");
                break;
            default:
                System.out.println("Wrong browser!");

        }
    }


    public static void main(String[] args) {
        // Static - Allow to override
        browserName = "Firefox";
        System.out.println(browserName);
        clickToElement("Button");

        // Non-Static
        Topic_04_Non_Access_Modifier_Static_Final_Enum topic = new Topic_04_Non_Access_Modifier_Static_Final_Enum();
        System.out.println(topic.serverName);
        topic.sendkeyToElement("Link");

        // Final
        System.out.println(topic.colorCar);

        // Final + Static
        System.out.println(topic.REGISTER_BTN);

        // Enum
        topic.getBrowserDriver("chrome");

    }
}
