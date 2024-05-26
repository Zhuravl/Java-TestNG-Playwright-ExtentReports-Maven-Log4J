package ua.com.usource.actions;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import ua.com.usource.common.enums.Language;
import ua.com.usource.elements.SignUpElements;

public class SignUpActions extends BaseActions {

    private final SignUpElements signUpElements = new SignUpElements(page);

    public SignUpActions(BrowserContext context, Page page) {
        super(context,page);
    }

    /**
     * Sign in with credentials
     *
     * @param email    email to use
     * @param password password to use
     */
    public void signUp(String email, String password, String firstName, String lastName, Language language) {
        logger.info("Sign up with credentials - email: '" + email + "', password: '" + password + "', firstName: '" + firstName + "', lastName: '" + lastName + "', language: '" + language + "'...");
        signUpElements.enterEmail(email);
        signUpElements.enterPassword(password);
        signUpElements.enterFirstName(firstName);
        signUpElements.enterLastName(lastName);
        if (language != null) {
            //Non-default language case
            signUpElements.clickLanguageDropdown();
            signUpElements.selectLanguage(language.getName());
        }
        signUpElements.clickSignUpButton();
        logger.info("Sign up was successfully done!");
    }

    public String getConfirmationMessage() {
        logger.info("Get confirmation message...");
        String result = signUpElements.getConfirmationMessage();
        logger.info("Result message: '" + result + "'");
        return result;
    }
}
