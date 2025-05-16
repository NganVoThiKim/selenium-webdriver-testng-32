
package javaTester.javaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Topic_07_Switch_Case {

    public static void main(String[] args) {
        boolean status = 5 < 3;
        System.out.println(status);
        if (status) {
            System.out.println("Go to if");
        }

        // Assign
        int numberStudent = 10;
        // == Compare
        status = (numberStudent == 10);
        System.out.println(status);


        WebDriver driver = new ChromeDriver();
        // Element always exists in DOM but show on UI Or not
        WebElement salePopup = driver.findElement(By.id(""));
        if (salePopup.isDisplayed()) {

        }

        // Element not exists in DOM when popup Invisible
        List<WebElement> salePopups = driver.findElements(By.cssSelector(""));
        if (salePopups.size() > 0 && salePopups.get(0).isDisplayed()) {
        }

        // Uncheck to checkbox
        WebElement languageCheckbox = driver.findElement(By.cssSelector(""));
        if(languageCheckbox.isSelected()){
            languageCheckbox.click();
        }
        // Check to checkbox
        if(!languageCheckbox.isSelected()){
            languageCheckbox.click();
        }

    }
}
