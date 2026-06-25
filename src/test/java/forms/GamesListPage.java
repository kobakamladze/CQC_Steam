package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import base.BasePage;
import base.elements.WebButton;
import base.elements.WebText;
import forms.ageCheck.AgeCheckWithBirthDateForm;
import forms.ageCheck.AgeCheckWithoutBirthDateForm;
import models.Game;
import org.openqa.selenium.By;
import utils.BrowserUtils;
import utils.CustomParser;
import java.util.*;

public class GamesListPage extends BasePage<WebText> {

    private final GameInfoPage gameInfoPage;
    private final AgeCheckWithBirthDateForm ageCheckWithBirthDateForm;
    private final AgeCheckWithoutBirthDateForm ageCheckWithoutBirthDateForm;

    private static final WebButton btnGames = new WebButton(By.xpath(
            "(//div[contains(@class,'LibraryAssetExpandedDisplay')]/div/div/div/div/a)" +
                    "[position() mod 2 = 1]"),
            "Game Element");
    private static final WebButton btnTopSellers = new WebButton(
            By.cssSelector("div.KDLASaMCaASZ6LnF3kQY8.Focusable[tabindex='0']:nth-of-type(4)"),
            "Button 'Top Sellers'");
    private final WebText txtDiscount = new WebText(By.cssSelector(
                    "div._3EdZTDIisUpowxwm6uJ7Iq [class*='discount_pct'], div._3EdZTDIisUpowxwm6uJ7Iq [class*='Discount']"),
            "Discount Elements");

    private final List<Game> discountedGamesList = new ArrayList<>();

    public GamesListPage() {
        super(new WebText(By.xpath("//div[@class='_3EdZTDIisUpowxwm6uJ7Iq']"),
                "List of Games Element"));
        gameInfoPage = new GameInfoPage();
        ageCheckWithBirthDateForm = new AgeCheckWithBirthDateForm();
        ageCheckWithoutBirthDateForm = new AgeCheckWithoutBirthDateForm();
    }

    public void clickOnTopSellers() {
        btnTopSellers.click();
    }

    public Map<String, String> getHighestDiscount() {
        List<String> txtHighestDiscountPriceInfo = txtDiscount.findAll().stream()
                .sorted(Comparator.comparingInt((ITextBox t) ->
                                CustomParser.parsePercentFromStringToInteger(
                                        CustomParser.getPricingInfoAsMap(t.getText()).get("discount")))
                        .reversed())
                .map(ITextBox::getText)
                .toList();
        return CustomParser.getPricingInfoAsMap(txtHighestDiscountPriceInfo.get(0));
    }

    public List<Game> getDiscountedGames() {
        waitForPageLoaded();
        List<IButton> gamesList = btnGames.findAll();
        String originalTab = BrowserUtils.getOriginalTab();
        for (IButton game : gamesList) {
            game.click();
            BrowserUtils.waitForNewTabAndSwitch(originalTab);
            ageCheckWithBirthDateForm.skipIfAppeared();
            ageCheckWithoutBirthDateForm.skipIfAppeared();
            gameInfoPage.waitForPageLoaded();
            if (!gameInfoPage.isGameDiscounted()) {
                BrowserUtils.closeCurrentTabAndSwitchTo(originalTab);
                continue;
            }
            discountedGamesList.add(gameInfoPage.getGame());
            BrowserUtils.closeCurrentTabAndSwitchTo(originalTab);
        }
        return discountedGamesList;
    }
}
