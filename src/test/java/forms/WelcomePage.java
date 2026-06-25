package forms;

import base.BasePage;
import base.elements.WebButton;
import forms.controllers.CategoriesDropdownController;
import org.openqa.selenium.By;

public class WelcomePage extends BasePage<WebButton> {

    public CategoriesDropdownController categoriesDropdownController = new CategoriesDropdownController();

    private static final WebButton btnInstallSteam = new WebButton(
            By.xpath("//a[@class='header_installsteam_btn header_installsteam_btn_green']"),
            "Install Steam Button from header");

    public WelcomePage() { super(new WebButton(By.cssSelector("div.logo"), "Steam logo")); }

    public void openSteamDownloadPage() {
        btnInstallSteam.click();
    }
}
