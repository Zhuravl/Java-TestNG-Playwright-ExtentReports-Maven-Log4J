package ua.com.usource.actions;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import ua.com.usource.elements.AboutElements;

public class AboutActions extends BaseActions {

    private final AboutElements aboutElements = new AboutElements(page);

    public AboutActions(BrowserContext context, Page page) {
        super(context,page);
    }

    /**
     * Returns the text of the About page
     */
    public String getAboutText() {
        logger.info("Get the text of the About page...");
        String result = aboutElements.getAboutText();
        logger.info("Result text: '" + result + "'");
        return result;
    }
}
