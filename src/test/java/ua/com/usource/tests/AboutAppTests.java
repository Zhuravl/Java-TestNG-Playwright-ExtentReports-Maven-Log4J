package ua.com.usource.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.com.usource.common.core.helpers.TestDataHelper;
import ua.com.usource.common.enums.Language;
import ua.com.usource.common.enums.AppPage;

/**
 * The class contains test methods for the Web functionality
 */
public class AboutAppTests extends BaseTest {

    @Test(description = "The About page content test", dataProvider = "Available languages")
    public void aboutPageContent(Language language) {
        aboutActions().openWebsite();
        aboutActions().navigateTo(AppPage.ABOUT);
        aboutActions().setLanguage(language);
        Assert.assertEquals(aboutActions().getAboutText(), TestDataHelper.getAboutPageText(language), "Verify that the About page has the correct content based on the selected language");
    }

    @DataProvider(name = "Available languages")
    private Object[][] availableLanguages() {
        return new Object[][]{{Language.UKRAINIAN}, {Language.ENGLISH}};
    }
}
