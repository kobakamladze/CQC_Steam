package steps;

import forms.ageCheck.AgeCheckWithBirthDateForm;
import forms.ageCheck.AgeCheckWithoutBirthDateForm;

public class VerificationSteps {

    private static final AgeCheckWithBirthDateForm ageCheckWithBirthDateForm = new AgeCheckWithBirthDateForm();
    private static final AgeCheckWithoutBirthDateForm ageCheckWithoutBirthDateForm = new AgeCheckWithoutBirthDateForm();

    public void skipVerificationIfAppeared() {
        if (ageCheckWithBirthDateForm.waitForPageLoaded()) {
            ageCheckWithBirthDateForm.chooseValidYear();
            ageCheckWithBirthDateForm.clickSubmitButton();
        }
        if (ageCheckWithoutBirthDateForm.waitForPageLoaded()) {
            ageCheckWithoutBirthDateForm.toggleVerificationCheckbox();
            ageCheckWithoutBirthDateForm.clickSubmitButton();
        }
    }
}
