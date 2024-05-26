package ua.com.usource.actions;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.com.usource.common.core.context.TestContext;
import ua.com.usource.common.enums.AppPage;
import ua.com.usource.common.enums.Language;
import ua.com.usource.elements.NavigationElements;

/**
 * Class contains common fields and methods for all actions
 */
public abstract class BaseActions {

    protected static Logger logger = LogManager.getLogger(BaseActions.class);
    protected NavigationElements navigationElements;
    protected BrowserContext context;
    protected Page page;

    public BaseActions(BrowserContext context, Page page) {
        this.context = context;
        this.page = page;
        navigationElements = new NavigationElements(page);
    }

    /**
     * Returns the class context
     */
    public BrowserContext getContext() {
        return context;
    }

    /**
     * Opens the target Website
     */
    public void openWebsite() {
        page.navigate(TestContext.getTargetUrl());
    }

    /**
     * Navigates to the defined page if it has not opened yet
     *
     * @param page page name to navigate on
     */
    public void navigateTo(AppPage page) {
        logger.info("Navigate to the page '" + page + "'...");
        if (!isOnPage(page)) {
            switch (page) {
                case ABOUT -> navigationElements.clickAboutLink();
                case SIGN_IN -> navigationElements.clickSignInLink();
                case SIGN_UP -> navigationElements.clickSignUpLink();
                default -> throw new IllegalArgumentException("Can not recognize the page with name: '" + page + "'!");
            }
            waitForPageLoadComplete();
        }
    }

    /**
     * Sets the selected language
     *
     * @param language selected language
     */
    public void setLanguage(Language language) {
        logger.info("Set the language '" + language + "'...");
        navigationElements.selectLanguage(language);
    }

    /**
     * Checks if on the defined page
     *
     * @param appPage expected page
     * @return True if the current URL contains the prefix of the target page, otherwise - false
     */
    public boolean isOnPage(AppPage appPage) {
        boolean result;
        logger.info("Checking is on the '" + appPage + "' page...");
        if (appPage == AppPage.HOME) {
            result = page.url().equals(TestContext.getTargetUrl());
        } else {
            result = page.url().contains(appPage.getPrefix());
        }
        logger.info("Is on '" + appPage + "' page? - " + result);
        return result;
    }

    /**
     * Waits while loading will be completed
     */
    protected void waitForPageLoadComplete() {
        logger.info("Waiting while loading...");
        context.waitForCondition(() -> page.locator("xpath=//*[contains(text(), 'Loading')]").isHidden());
    }
}
