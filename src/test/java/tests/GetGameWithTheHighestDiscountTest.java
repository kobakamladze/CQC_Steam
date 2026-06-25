package tests;

import base.BaseTest;
import forms.CategoryPreviewPage;
import models.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.GamesListSteps;
import steps.WelcomeSteps;
import utils.WaitHelper;

import java.util.Map;

public class GetGameWithTheHighestDiscountTest extends BaseTest {

    private static final WelcomeSteps welcomeSteps = new WelcomeSteps();
    private static final CategoryPreviewPage categoryPreviewPage = new CategoryPreviewPage();
    private static final GamesListSteps gamesListSteps = new GamesListSteps();
    private static final Logger log = LoggerFactory.getLogger(GetGameWithTheHighestDiscountTest.class);

    @Test
    public void getGameWithTheHighestDiscountTest() {
        welcomeSteps.assertThatScreenIsOpened();
        welcomeSteps.goToBrowseAllCategoriesPreviewPage();
        categoryPreviewPage.clickActions();
        categoryPreviewPage.clickBrowseAll();
        gamesListSteps.assertThatScreenIsOpened();
        Map<String, String> pricingInfo = gamesListSteps.getHighestDiscountInfoFromList();
        gamesListSteps.clickOnTopSellers();
        Game game = gamesListSteps.getMostDiscountedGame();
        Assert.assertEquals(game.getDiscount(), pricingInfo.get("discount"), "Discounts are not equal");
        Assert.assertEquals(game.getPrice(), pricingInfo.get("originalPrice"),
                "Discounted prices are not equal");
        Assert.assertTrue(game.getDiscountedPrice().contains(pricingInfo.get("discountedPrice")),
                "Discounted prices are not equal");
        log.info("Game with the highest discount is - {}", game.getName());
    }

    @Test
    public void downloadTest() {
        welcomeSteps.assertThatScreenIsOpened();
        welcomeSteps.downloadSteam();
        Assert.assertTrue(WaitHelper.waitForFileDownloaded("steam."),
                "Steam file should be downloaded");
    }
}
