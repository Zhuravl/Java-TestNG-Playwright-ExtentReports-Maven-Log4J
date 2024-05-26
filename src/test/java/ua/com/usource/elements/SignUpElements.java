package ua.com.usource.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SignUpElements extends BaseElements {

    private final Locator emailInput = page.locator("input[name='username']");
    private final Locator passwordInput = page.locator("input[name='password']");
    private final Locator firstNameInput = page.locator("input[name='firstName']");
    private final Locator lastNameInput = page.locator("input[name='lastName']");
    private final Locator languageDropdown = page.locator("xpath=//label[@for='language']/following-sibling::div");
    private final Locator languageList = page.locator("xpath=//div[contains(@id, 'react-select')]");
    private final Locator signUpButton = page.locator("xpath=//button[contains(@class, 'btn-primary')]");
    private final Locator confirmationLabel = page.locator("xpath=//div[contains(@class, 'alert-success')]");

    public SignUpElements(Page page) {
        super(page);
    }

    public void enterEmail(String email) {
        logger.info("Enter email - '" + email + "'");
        emailInput.fill(email);
    }

    public void enterPassword(String password) {
        logger.info("Enter password - '" + password + "'");
        passwordInput.fill(password);
    }

    public void enterFirstName(String firstName) {
        logger.info("Enter first name - '" + firstName + "'");
        firstNameInput.fill(firstName);
    }

    public void enterLastName(String lastName) {
        logger.info("Enter last name - '" + lastName + "'");
        lastNameInput.fill(lastName);
    }

    public void clickLanguageDropdown() {
        logger.info("Click language dropdown");
        languageDropdown.click();
    }

    public void selectLanguage(String language) {
        logger.info("Select language - '" + language + "'");
        languageList.filter(new Locator.FilterOptions().setHasText(language)).click();
    }

    public void clickSignUpButton() {
        logger.info("Click Sign Up button");
        signUpButton.click();
    }

    public String getConfirmationMessage() {
        logger.info("Get confirmation message...");
        String result = confirmationLabel.innerText().replaceAll("\n\n", " ");
        logger.info("Result message: '" + result + "'");
        return result;
    }
}
