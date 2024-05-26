package ua.com.usource.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ua.com.usource.common.enums.Language;

/**
 * Class contains element-level methods for the navigation functionality
 */
public class NavigationElements extends BaseElements {

    private final Locator aboutPageLink = page.locator("xpath=//a[@href='/about']");
    private final Locator signInPageLink = page.locator("xpath=//a[@href='/login']");
    private final Locator signUpPageLink = page.locator("xpath=//a[@href='/register']");

    public NavigationElements(Page page) {
        super(page);
    }

    public void clickAboutLink() {
        logger.info("Clicking the About link");
        aboutPageLink.click();
    }

    public void clickSignInLink() {
        logger.info("Clicking the Sign In link");
        signInPageLink.click();
    }

    public void clickSignUpLink() {
        logger.info("Clicking the Sign Up link");
        signUpPageLink.click();
    }

    public void selectLanguage(Language language) {
        logger.info("Clicking the language '" + language + "' option");
        page.locator("xpath=//*[contains(@class, 'navbar-nav')]//select").selectOption(language.getValue());
    }
}
