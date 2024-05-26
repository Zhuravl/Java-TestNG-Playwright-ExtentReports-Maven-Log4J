package ua.com.usource.actions;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import ua.com.usource.elements.SignInElements;

public class SignInActions extends BaseActions {

    private final SignInElements singInElements = new SignInElements(page);

    public SignInActions(BrowserContext context, Page page) {
        super(context,page);
    }

    /**
     * Sign in with credentials
     *
     * @param email    email to use
     * @param password password to use
     */
    public void signIn(String email, String password) {
        logger.info("Sign in with credentials email: '" + email + "', password: '" + password + "'...");
        singInElements.enterEmail(email);
        singInElements.enterPassword(password);
        singInElements.clickSignInButton();
        logger.info("Sign in was successfully done!");
    }
}
