package forms;

import base.BasePage;
import base.elements.WebButton;
import base.elements.WebText;
import org.openqa.selenium.By;

public class CategoryPreviewPage extends BasePage {

    private static final WebButton btnAction = new WebButton(
            By.xpath("//div[@data-tagid='19']"), "Action Category Button ");
    private static final WebButton btnBrowseAll = new WebButton(
            By.xpath("//a[@class='btnv6_blue_hoverfade btn_medium']"), "'Browse All' Button");

    public CategoryPreviewPage() {
        super(new WebText(By.xpath("//h2[@class='pageheader tag_browseheader']"), "Header Text"));
    }

    public void clickActions() {
        btnAction.click();
    }

    public void clickBrowseAll() {
        btnBrowseAll.click();
    }
}
