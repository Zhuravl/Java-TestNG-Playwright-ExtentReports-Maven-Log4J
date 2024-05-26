package ua.com.usource.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.usource.common.core.helpers.TestDataHelper;
import ua.com.usource.common.enums.AppPage;
import ua.com.usource.common.enums.Language;

/**
 * The class contains test methods for the Web functionality
 */
public class SignUpTests extends BaseTest {

    @Test(description = "Sign up using correct credentials test")
    public void signUpCorrectCredentials() {
        Language language = Language.UKRAINIAN;

        singUpActions().openWebsite();
        singUpActions().setLanguage(language);
        singUpActions().navigateTo(AppPage.SIGN_UP);
        singUpActions().signUp(TestDataHelper.getRandomEmail(), TestDataHelper.getRandomPassword(), TestDataHelper.getRandomString(), TestDataHelper.getRandomString(), language);
        Assert.assertEquals(singUpActions().getConfirmationMessage(), TestDataHelper.getConfirmationMessage(language), "Verify that the user can sign up using the correct credentials");
    }

    @Test(description = "Sign up using default language test")
    public void signUpDefaultLanguage() {
        Language language = Language.ENGLISH;

        singUpActions().openWebsite();
        singUpActions().navigateTo(AppPage.SIGN_UP);
        singUpActions().signUp(TestDataHelper.getRandomEmail(), TestDataHelper.getRandomPassword(), TestDataHelper.getRandomString(), TestDataHelper.getRandomString(), null);
        Assert.assertEquals(singUpActions().getConfirmationMessage(), TestDataHelper.getConfirmationMessage(language), "Verify that the user can sign up using the default language");
    }
}
