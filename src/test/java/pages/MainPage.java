package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(xpath = "//input")
    private WebElement inputField;

    public MainPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("http://the-internet.herokuapp.com/");
    }

    //Implementation of the JS Executor to get the page title
    public String getPageTitle() {
        String pageTitle = js.executeScript("return document.title;").toString();
        return pageTitle;
    }

    public String getInputValue() {
        String value = inputField.getText();
        return value;
    }

}
