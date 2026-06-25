package steps;

import forms.DownloadPage;
import forms.WelcomePage;
import org.testng.Assert;

public class WelcomeSteps {

    private static final WelcomePage welcomePage = new WelcomePage();
    private static final DownloadPage downloadPage = new DownloadPage();

    public void assertThatScreenIsOpened() {
        Assert.assertTrue(welcomePage.waitForPageLoaded(), "Welcome page was not opened");
    }

    public void goToBrowseAllCategoriesPreviewPage() {
        welcomePage.categoriesDropdownController.expand();
        welcomePage.categoriesDropdownController.clickViewAll();
    }

    public void downloadSteam() {
        welcomePage.openSteamDownloadPage();
        downloadPage.waitForPageLoaded();
        downloadPage.clickInstallSteamButton();
    }
}
