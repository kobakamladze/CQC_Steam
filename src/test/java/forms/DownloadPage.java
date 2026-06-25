package forms;

import base.BasePage;
import base.elements.WebButton;
import org.openqa.selenium.By;

public class DownloadPage extends BasePage<WebButton> {

    private static final WebButton btnDownload = new WebButton(
            By.xpath("(//a[contains(@href,'client/installer/steam')])[1]"),
            "Install Steam Button");

    public DownloadPage() {
        super(new WebButton(By.xpath("(//a[contains(@href,'client/installer/steam')])[1]"),
                "install steam button"));
    }

    public void clickInstallSteamButton() {
        btnDownload.click();
    }
}
