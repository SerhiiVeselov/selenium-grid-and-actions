package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HorizontalSliderPage extends AbstractPage {

    @FindBy(xpath = "//input[@type='range']")
    private WebElement slider;

    @FindBy(id = "range")
    private WebElement sliderValue;

    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("http://the-internet.herokuapp.com/horizontal_slider");
    }

    //Implementation of the mouse Action
    public void moveSlider() {
        new Actions(driver).dragAndDropBy(slider, 20, 0).build().perform();
    }

    public String getSliderValue() {
       return sliderValue.getText();
    }

}
