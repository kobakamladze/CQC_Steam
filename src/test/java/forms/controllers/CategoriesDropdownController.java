package forms.controllers;

import base.BasePage;
import base.elements.WebButton;
import org.openqa.selenium.By;

public class CategoriesDropdownController extends BasePage<WebButton> {

    private static final WebButton btnDropdownCategories = new WebButton(
            By.xpath("//button[@aria-expanded and contains(@class,'Focusable')][3]"),
            "categories Dropdown Button");
    private static final WebButton btnViewAll = new WebButton(
            By.xpath("//a[contains(@href, 'browse')]"), "View All Button");

    public CategoriesDropdownController() {
        super(new WebButton(By.xpath("//a[contains(@href, 'browse')]"), "View All Button"));
    }

    private boolean isExpanded() {
        String isExpandedText = btnDropdownCategories.getAttribute("aria-expanded");
        return isExpandedText.equals("true");
    }

    public void expand() {
        if (isExpanded()) {
            return;
        }
        btnDropdownCategories.click();
    }

    public void clickViewAll() {
        btnViewAll.click();
    }
}
