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
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ITextBox;
import base.BaseElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.List;

public class WebText extends BaseElement implements ITextBox {

    private static final Logger log = LogManager.getLogger(WebText.class);

    private static final ElementType elementType = ElementType.TEXTBOX;

    public WebText(By by, String name) {
        super(by, name);
    }

    public List<ITextBox> findAll() {
        log.info("Looking for all elements - {}, {}", by, name);
        return findElements(elementType).stream()
                .map(ITextBox.class::cast)
                .toList();
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
    public String getText(HighlightState highlightState) {
        return findElement(elementType).getText();
    }

    @Override
    public void type(String s) {}

    @Override
    public void typeSecret(String s) {}

    @Override
    public void clear() {}

    @Override
    public void clearAndType(String s) {}

    @Override
    public void clearAndTypeSecret(String s) {}

    @Override
    public void submit() {}

    @Override
    public String getValue() {
        return "";
    }

    @Override
    public void sendKeys(Keys keys) {}

    @Override
    public void clickAndWait() {}

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
    public void focus() {}

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
    public void unfocus() {}

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
    public void click() {}

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
