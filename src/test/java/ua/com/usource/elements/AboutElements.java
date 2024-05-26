package ua.com.usource.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AboutElements extends BaseElements {

    private final Locator aboutPageDescription = page.locator("xpath=//*[contains(@class, 'text-left')]");

    public AboutElements(Page page) {
        super(page);
    }

    public String getAboutText() {
        logger.info("Get the text of the About page...");
        String result = aboutPageDescription.innerText().replaceAll("\n\n", " ");
        logger.info("Result text: '" + result + "'");
        return result;
    }
}
