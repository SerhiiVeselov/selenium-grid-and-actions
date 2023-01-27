package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class KeyPressesPage extends AbstractPage {

    @FindBy(id = "result")
    private WebElement enteredValue;

    public KeyPressesPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("http://the-internet.herokuapp.com/key_presses");
    }

    //Implementation of the keyboard Action
    public void clickBackSpace() {
        new Actions(driver).keyDown(Keys.BACK_SPACE).perform();
    }

    public String expectedValue() {
        String expectedValue = "You entered: BACK_SPACE";
        return expectedValue;
    }

    public String actualValue() {
        String actualValue = enteredValue.getText();
        return actualValue;
    }

}
