package base.elements;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.core.elements.interfaces.IElementStateProvider;
import aquality.selenium.core.elements.interfaces.IElementSupplier;
import aquality.selenium.core.visualization.IVisualStateProvider;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.actions.CheckBoxJsActions;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IElement;
import base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.remote.RemoteWebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;


public class WebCheckbox extends BaseElement implements ICheckBox {

    private static final Logger log = LoggerFactory.getLogger(WebButton.class);
    private static final ElementType elementType = ElementType.CHECKBOX;

    public WebCheckbox(By by, String name) {
        super(by, name);
    }

    @Override
    public boolean waitForIsDisplayed() {
        return super.waitForIsDisplayed(elementType);
    }

    @Override
    public void check() {
        log.info("Clicking element - {}, {}", by, name);
        findElement(elementType).click();
    }

    @Override
    public void type(String s) {}

    @Override
    public void typeSecret(String s) {}

    @Override
    public void clear() {}

    @Override
    public boolean isChecked() {
        return false;
    }

    @Override
    public void toggle() {}

    @Override
    public void uncheck() {}

    @Override
    public CheckBoxJsActions getJsActions() {
        return null;
    }

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
    public String getText() {
        return super.getText();
    }

    @Override
    public String getAttribute(String attr) {
        return super.getAttribute(attr);
    }

    @Override
    public void sendKeys(String s) {

    }

    @Override
    public void click() {

    }

    @Override
    public String getCssValue(String propertyName) {
        return super.getCssValue(propertyName);
    }

    @Override
    public void focus() {
        super.focus();
    }

    @Override
    public <T extends IElement> T findChildElement(By childLoc, ElementType elementType, ElementState state) {
        return super.findChildElement(childLoc, elementType, state);
    }

    @Override
    public <T extends IElement> T findChildElement(By childLoc, ElementType elementType) {
        return super.findChildElement(childLoc, elementType);
    }

    @Override
    public <T extends IElement> T findChildElement(By childLoc, String name, ElementType elementType) {
        return super.findChildElement(childLoc, name, elementType);
    }

    @Override
    public <T extends IElement> List<T> findChildElements(By childLoc, ElementType elementType) {
        return super.findChildElements(childLoc, elementType);
    }

    @Override
    public <T extends IElement> List<T> findChildElements(By childLoc, ElementType elementType, ElementsCount count) {
        return super.findChildElements(childLoc, elementType, count);
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
