package pages;

import com.sun.source.tree.IfTree;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.time.Duration;

public class JQueryMenuPage extends AbstractPage {

    FluentWait fluentWait = new FluentWait(driver);

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(id = "ui-id-7")
    private WebElement cSvFileType;

    public JQueryMenuPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("http://the-internet.herokuapp.com/jqueryui/menu#");
    }

    //Implementation of the JS Executor to select an element inside the JQuery menu
    public void selectCSVmenuOption() throws InterruptedException {
        js.executeScript("arguments[0].click();", cSvFileType);
        Thread.sleep(5000);
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                return flag = true;
        }

        return flag;
    }


}
