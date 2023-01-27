package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import pages.HorizontalSliderPage;
import pages.JQueryMenuPage;
import pages.MainPage;
import pages.KeyPressesPage;
import java.time.Duration;
import static org.junit.Assert.*;

public class MainTest {

    public static WebDriver driver;
    public static FluentWait<WebDriver> fluentWait;
    public static HorizontalSliderPage horizontalSliderPage;
    public static KeyPressesPage keyPressesPage;
    public static MainPage mainPage;
    public static JQueryMenuPage jQueryMenuPage;

    //Would be different for each who are running the tests
    private static String downloadPath = "C:\\Users\\Serhii_Veselov\\Downloads";

    @BeforeEach
    public void driverSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        horizontalSliderPage = new HorizontalSliderPage(driver);
        keyPressesPage = new KeyPressesPage(driver);
        mainPage = new MainPage(driver);
        jQueryMenuPage = new JQueryMenuPage(driver);

        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }

    @AfterEach
    public void driverQuit() {
        driver.quit();
        driver = null;
    }

    @Test
    public void sliderTest() {
        horizontalSliderPage.openPage();
        horizontalSliderPage.moveSlider();
        assertEquals("3.5", horizontalSliderPage.getSliderValue());
    }

    @Test
    public void keyPressesTest() {
        keyPressesPage.openPage();
        keyPressesPage.clickBackSpace();
        assertEquals(keyPressesPage.expectedValue(), keyPressesPage.actualValue());
    }

    @Test
    public void titleJsTest() {
        mainPage.openPage();
        mainPage.getPageTitle();
        assertEquals("The Internet", mainPage.getPageTitle());
    }

    @Test
    public void jQueryMenuTest() throws InterruptedException {
        jQueryMenuPage.openPage();
        jQueryMenuPage.selectCSVmenuOption();
        assertTrue(jQueryMenuPage.isFileDownloaded(downloadPath, "menu.csv"));
    }
}
