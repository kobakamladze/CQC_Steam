package base;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.waitings.IConditionalWait;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.WaitHelper;

public class BasePage<T extends BaseElement>{

    protected static final IConditionalWait wait = AqualityServices.getConditionalWait();
    protected static final Logger log = LoggerFactory.getLogger(BasePage.class);

    private final T screenElement;

    protected BasePage(T element) {
        screenElement = element;
    }

    public boolean waitForPageLoaded() {
        try {
            log.info("Looking for element - {} to ensure page is opened", screenElement.by);
            wait.waitFor(ExpectedConditions.visibilityOfElementLocated(screenElement.by),
                    String.format("Element - %s could not be found", screenElement.name));
            WaitHelper.smallWait();
            return true;
        } catch(TimeoutException e) {
            log.info("Element - {} was not found. Page not loaded.", screenElement);
            return false;
        }
    }
}
