package forms;

import base.BasePage;
import base.elements.WebText;
import models.Game;
import org.openqa.selenium.By;

public class GameInfoPage extends BasePage<WebText> {

    private static final WebText txtGameTitle = new WebText(
            By.xpath("//div[@id='appHubAppName']"), "Game Title text");
    private static final WebText txtDiscountPercent = new WebText(
            By.xpath("(//div[@class='discount_pct'])[1]"),
            "Discount amount of basic edition");
    private static final WebText txtOriginalPrice = new WebText(
            By.xpath("(//div[@class='discount_original_price'])[1]"),
            "Original price of basic edition");
    private static final WebText txtDiscountedPrice = new WebText(
            By.xpath("(//div[@class='discount_final_price'])[1]"),
            "Discounted price of basic edition");

    GameInfoPage() {
        super(new WebText(By.xpath("//div[@id='appHubAppName']"), "Game Title Text"));
    }

    public boolean isGameDiscounted() {
        log.info("Checking if game is discounted with element - {}", txtDiscountPercent.getLocator());
        return txtDiscountPercent.isDisplayed();
    }

    public Game getGame() {
        return new Game(
                txtGameTitle.getText(),
                txtDiscountPercent.getText(),
                txtOriginalPrice.getText(),
                txtDiscountedPrice.getText());
    }
}
