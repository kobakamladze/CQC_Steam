package utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;

public final class BrowserUtils {

    private BrowserUtils() {
    }

    public static Browser getBrowser() {
        return AqualityServices.getBrowser();
    }

    public static void goTo(String url) {
        getBrowser().goTo(url);
    }

    public static void maximize() {
        getBrowser().maximize();
    }

    public static void waitForPageToLoad() {
        getBrowser().waitForPageToLoad();
    }

    public static String getOriginalTab() {
        return getBrowser().getDriver().getWindowHandle();
    }

    public static void waitForNewTabAndSwitch(String originalTab) {
        try {
            AqualityServices.getConditionalWait().waitForTrue(
                    () -> getBrowser().getDriver().getWindowHandles().size() > 1,
                    "Waiting for new tab to open"
            );
        } catch (java.util.concurrent.TimeoutException e) {
            throw new RuntimeException(e);
        }
        for (String handle : getBrowser().getDriver().getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                getBrowser().getDriver().switchTo().window(handle);
                return;
            }
        }
    }

    public static void closeCurrentTabAndSwitchTo(String targetTab) {
        getBrowser().getDriver().close();
        getBrowser().getDriver().switchTo().window(targetTab);
    }

    public static void quit() {
        getBrowser().quit();
    }
}
