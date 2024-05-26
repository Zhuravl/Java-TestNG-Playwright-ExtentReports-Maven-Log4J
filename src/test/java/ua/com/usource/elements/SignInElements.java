package ua.com.usource.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SignInElements extends BaseElements {

    private final Locator emailInput = page.locator("input[name='username']");
    private final Locator passwordInput = page.locator("input[name=\"password\"]");
    private final Locator signInButton = page.locator("xpath=//button[contains(@class, 'btn-primary')]");

    public SignInElements(Page page) {
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

    public void clickSignInButton() {
        logger.info("Click Sign In button");
        signInButton.click();
    }
}
