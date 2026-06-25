package base;

import aquality.selenium.browser.AqualityServices;
import utils.BrowserUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertiesReader;

public abstract class BaseTest {

    @BeforeMethod
    public void setUp() {
        BrowserUtils.maximize();
        BrowserUtils.goTo(PropertiesReader.get("base.properties", "base.url"));
        BrowserUtils.waitForPageToLoad();
    }

    @AfterMethod
    public void tearDown() {
        if (AqualityServices.isBrowserStarted()) {
            BrowserUtils.quit();
        }
    }
}
