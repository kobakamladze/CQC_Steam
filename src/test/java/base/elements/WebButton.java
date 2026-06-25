package base.elements;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.core.elements.interfaces.IElementStateProvider;
import aquality.selenium.core.elements.interfaces.IElementSupplier;
import aquality.selenium.core.visualization.IVisualStateProvider;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.HighlightState;
import aquality.selenium.elements.actions.JsActions;
import aquality.selenium.elements.actions.MouseActions;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.remote.RemoteWebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class WebButton extends BaseElement implements IButton {

    private static final Logger log = LoggerFactory.getLogger(WebButton.class);
    private static final ElementType elementType = ElementType.BUTTON;

    public WebButton(By by, String name) {
        super(by, name);
    }

    public List<IButton> findAll() {
        log.info("Looking for all elements - {}, {}", by, name);
        return findElements(elementType).stream()
                .map(IButton.class::cast)
                .toList();
    }

    public void click() {
        log.info("Clicking element - {}, {}", by, name);
        findElement(elementType).click();
    }

    @Override
    public boolean isDisplayed() {
        return super.isDisplayed();
    }

    @Override
    public boolean waitForIsDisplayed() {
        return super.waitForIsDisplayed(elementType);
    }

    @Override
    public void type(String s) {}

    @Override
    public void typeSecret(String s) {}

    @Override
    public void clear() {}

    @Override
    public By getLocator() {
        return null;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public IElementStateProvider state() {
        return null;
    }

    @Override
    public IVisualStateProvider visual() {
        return null;
    }

    @Override
    public RemoteWebElement getElement(Duration duration) {
        return null;
    }

    @Override
    public void sendKeys(String s) {}

    @Override
    public void sendKeys(Keys keys) {}

    @Override
    public void clickAndWait() {}

    @Override
    public String getText(HighlightState highlightState) {
        log.info("Getting text of element - {}, {}", by, name);
        return findElement(elementType).getText();
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
    public void setInnerHtml(String s) {

    }

    @Override
    public JsActions getJsActions() {
        return null;
    }

    @Override
    public MouseActions getMouseActions() {
        return null;
    }

    @Override
    public <T extends IElement> T findChildElement(By by, String s, ElementType elementType, ElementState elementState) {
        return null;
    }

    @Override
    public <T extends aquality.selenium.core.elements.interfaces.IElement> T findChildElement(By by, String s, Class<T> aClass, ElementState elementState) {
        return null;
    }

    @Override
    public <T extends aquality.selenium.core.elements.interfaces.IElement> T findChildElement(By by, String s, IElementSupplier<T> iElementSupplier, ElementState elementState) {
        return null;
    }

    @Override
    public <T extends aquality.selenium.core.elements.interfaces.IElement> List<T> findChildElements(By by, String s, Class<T> aClass, ElementState elementState, ElementsCount elementsCount) {
        return List.of();
    }

    @Override
    public <T extends aquality.selenium.core.elements.interfaces.IElement> List<T> findChildElements(By by, String s, IElementSupplier<T> iElementSupplier, ElementState elementState, ElementsCount elementsCount) {
        return List.of();
    }

    @Override
    public SearchContext expandShadowRoot() {
        return null;
    }
}
