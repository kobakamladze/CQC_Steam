package forms.ageCheck;

import base.BasePage;
import base.elements.WebButton;
import base.elements.WebCheckbox;
import org.openqa.selenium.By;

public class AgeCheckWithoutBirthDateForm extends BasePage<WebCheckbox> {

    private static final WebCheckbox checkboxVerification = new WebCheckbox(
            By.xpath("//div[@class='agegate_text_container checkbox']"),
            "Verification Checkbox Element");
    private static final WebButton btnSubmit = new WebButton(
            By.xpath("(//a[@class='btn_grey_white_innerfade btn_medium'])[1]"),
            "Submit Button Element");

    public AgeCheckWithoutBirthDateForm() {
        super(checkboxVerification);
    }

    public void toggleVerificationCheckbox() {
        log.info("Toggling verification checkbox - {}", checkboxVerification.getLocator());
        checkboxVerification.check();
    }

    public void clickSubmitButton() {
        log.info("Clicking on submit button - {}", btnSubmit.getLocator());
        btnSubmit.click();
    }

    public void skipIfAppeared() {
        if(waitForPageLoaded()) {
            toggleVerificationCheckbox();
            clickSubmitButton();
        }
    }
}
