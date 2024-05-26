package ua.com.usource.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.usource.common.core.helpers.TestDataHelper;
import ua.com.usource.common.enums.AppPage;

/**
 * The class contains test methods for the Web functionality
 */
public class SignInTests extends BaseTest {

    @Test(description = "Sign in using correct credentials test")
    public void signInCorrectCredentials() {
        singInActions().openWebsite();
        singInActions().navigateTo(AppPage.SIGN_IN);
        singInActions().signIn(TestDataHelper.getRandomEmail(), TestDataHelper.getRandomPassword()); //Using the incorrect credentials to show the test failure example
        Assert.assertTrue(singInActions().isOnPage(AppPage.HOME), "Verify that the user can sign in using the correct credentials");
    }
}
