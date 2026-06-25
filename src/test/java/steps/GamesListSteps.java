package steps;

import forms.GamesListPage;
import models.Game;
import org.testng.Assert;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GamesListSteps {

    private final GamesListPage gamesListPage = new GamesListPage();

    public Game getMostDiscountedGame() {
        List<Game> games = gamesListPage.getDiscountedGames();
        Collections.sort(games);
        return games.get(0);
    }

    public void clickOnTopSellers() {
        gamesListPage.clickOnTopSellers();
    }

    public Map<String, String> getHighestDiscountInfoFromList() {
        return gamesListPage.getHighestDiscount();
    }

    public void assertThatScreenIsOpened() {
        Assert.assertTrue(gamesListPage.waitForPageLoaded(), "Lobby is not opened");
    }
}
