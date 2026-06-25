package base;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.HighlightState;
import aquality.selenium.elements.actions.MouseActions;
import aquality.selenium.elements.interfaces.IElement;
import org.openqa.selenium.*;
import java.util.List;
import java.util.concurrent.TimeoutException;

public abstract class BaseElement implements IElement {

    protected By by;
    protected String name;

    protected BaseElement(By by, String name) {
        this.by = by;
        this.name = name;
    }

    protected IElement findElement(ElementType elementType) {
        try {
            AqualityServices.getConditionalWait().waitForTrue(
                    () -> !AqualityServices.getElementFactory().findElements(this.by, this.name, elementType).isEmpty(),
                    "Waiting for element to be present: " + name
            );
            return AqualityServices.getElementFactory().get(elementType, by, name);
        } catch (TimeoutException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected List<IElement> findElements(ElementType elementType) {
        try {
            AqualityServices.getConditionalWait().waitForTrue(
                    () -> !AqualityServices.getElementFactory().findElements(this.by, this.name, elementType).isEmpty(),
                    "Waiting for elements to be present: " + name
            );
            return AqualityServices.getElementFactory().findElements(by, elementType);
        } catch (TimeoutException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected boolean isDisplayed() {
        try {
            return !AqualityServices.getBrowser().getDriver().findElements(this.by).isEmpty() &&
                    AqualityServices.getBrowser().getDriver().findElement(this.by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForIsDisplayed(ElementType elementType) {
        return findElement(elementType).state().waitForDisplayed();
    }

    @Override
    public void sendKeys(Keys keys) {}

    @Override
    public void clickAndWait() {}

    @Override
    public String getText(HighlightState highlightState) {
        return "";
    }

    @Override
    public String getAttribute(String s, HighlightState highlightState) {
        return "";
    }

    @Override
    public String getCssValue(String s, HighlightState highlightState) {
        return "";
    }

    @Override
    public void setInnerHtml(String s) {}

    @Override
    public MouseActions getMouseActions() {
        return null;
    }

    @Override
    public <T extends IElement> T findChildElement(By by, String s, ElementType elementType, ElementState elementState) {
        return null;
    }

    public abstract boolean waitForIsDisplayed();

    public abstract void type(String s);

    public abstract void typeSecret(String s);

    public abstract void clear();

}
