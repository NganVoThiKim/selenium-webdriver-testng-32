package javaTester.javaOOP;

import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_05_Super extends BaseOOP {

    // Global Variable
    private WebDriver driver;
    private short shortTimeout = 15;
//    private long longTimeout = 45;

    // "super" to access to variable of parent class (Require: Access Modifier must be "Protected/ Public)
    public void setImplicitWait(){
        // Local Variable
        short shortTimeout = 15;

        // Refer Local Variable
        driver.manage().timeouts().implicitlyWait(shortTimeout, TimeUnit.SECONDS);

        // Refer Global/ Instance Variable
        driver.manage().timeouts().implicitlyWait(this.shortTimeout, TimeUnit.SECONDS);

        // Refer Variable of Parent Class
        driver.manage().timeouts().implicitlyWait(super.shortTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(super.longTimeout, TimeUnit.SECONDS);
    }

    protected void clearData(){
        System.out.println("Cleared by Child Class");
    }

    private void sendkeyData(){
        // Call Method of Child Class
        clearData();

        // Call Method of Parent Class
        super.clearData();

        // Multiple inheritance
        System.out.println(super.browserName);
    }

    protected Topic_05_Super(){
        // Super(): Refer to constructor of Parent Class
        super("Ngan");
        System.out.println("Constructor of Child Class");
    }

    public static void main(String[] args) {
        Topic_05_Super topic = new Topic_05_Super();
        topic.sendkeyData();
    }
}
