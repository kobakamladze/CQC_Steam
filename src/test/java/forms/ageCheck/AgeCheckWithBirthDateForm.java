package forms.ageCheck;

import base.BasePage;
import base.elements.WebButton;
import base.elements.WebDropdown;
import base.elements.WebText;
import org.openqa.selenium.By;

public class AgeCheckWithBirthDateForm extends BasePage<WebText> {

    private static final String VALID_BIRTH_DATE_YEAR = "1990";

    private static final WebDropdown dropdownBirthYear = new WebDropdown(
            By.xpath("//select[@id='ageYear']"), "Birth Year Dropdown Element");
    private static final WebButton btnSubmit = new WebButton(
            By.xpath("//a[@id='view_product_page_btn']"), "Submit Button");

    public AgeCheckWithBirthDateForm() {
        super(new WebText(By.xpath("//div[contains(@class,'agegate_birthday_selector')]"),
                "Date Form Title Text Element"));
    }

    public void chooseValidYear() {
        log.info("Choosing - {} - birth year in element - {}", VALID_BIRTH_DATE_YEAR, dropdownBirthYear.getLocator());
        dropdownBirthYear.click();
        dropdownBirthYear.selectByText(VALID_BIRTH_DATE_YEAR);
    }

    public void clickSubmitButton() {
        log.info("Clicking on element - {}", btnSubmit.getLocator());
        btnSubmit.click();
    }

    public void skipIfAppeared() {
        if (waitForPageLoaded()) {
            chooseValidYear();
            clickSubmitButton();
        }
    }
}
