package base.elements;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.core.elements.interfaces.IElementStateProvider;
import aquality.selenium.core.elements.interfaces.IElementSupplier;
import aquality.selenium.core.visualization.IVisualStateProvider;
import aquality.selenium.elements.ComboBox;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.actions.ComboBoxJsActions;
import aquality.selenium.elements.actions.JsActions;
import aquality.selenium.elements.interfaces.IComboBox;
import base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.remote.RemoteWebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class WebDropdown extends BaseElement implements IComboBox {

    private static final Logger log = LoggerFactory.getLogger(WebDropdown.class);
    private static final ElementType elementType = ElementType.COMBOBOX;

    public WebDropdown(By by, String name) {
        super(by, name);
    }

    @Override
    public boolean isDisplayed() {
        return super.isDisplayed();
    }

    public boolean waitForIsDisplayed() {
        return waitForIsDisplayed(elementType);
    }

    @Override
    public void type(String s) {}

    @Override
    public void typeSecret(String s) {}

    @Override
    public void clear() {}

    @Override
    public void sendKeys(Keys keys) {}

    @Override
    public void clickAndWait() {}

    @Override
    public String getText() {
        return super.getText();
    }

    @Override
    public void selectByIndex(int index) {}

    @Override
    public void selectByText(String text) {
        log.info("Clicking element - {}, {}", by, name);
        ((ComboBox) findElement(elementType)).selectByText(text);
    }

    @Override
    public void clickAndSelectByText(String value) {

    }

    @Override
    public void selectByContainingText(String text) {

    }

    @Override
    public void selectByContainingValue(String value) {

    }

    @Override
    public void selectByValue(String value) {

    }

    @Override
    public void clickAndSelectByValue(String value) {

    }

    @Override
    public String getSelectedValue() {
        return "";
    }

    @Override
    public String getSelectedText() {
        return "";
    }

    @Override
    public List<String> getValues() {
        return List.of();
    }

    @Override
    public List<String> getTexts() {
        return List.of();
    }

    @Override
    public ComboBoxJsActions getJsActions() {
        return new ComboBoxJsActions(((ComboBox) findElement(elementType)), "ComboBox");
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
    public void sendKeys(String s) {

    }

    @Override
    public void click() {

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
