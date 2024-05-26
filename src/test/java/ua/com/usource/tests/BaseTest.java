package ua.com.usource.tests;

import com.microsoft.playwright.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ua.com.usource.actions.AboutActions;
import ua.com.usource.actions.SignInActions;
import ua.com.usource.actions.SignUpActions;
import ua.com.usource.common.core.context.TestContext;
import ua.com.usource.common.listeners.TestListener;

import java.lang.reflect.Method;
import java.nio.file.Paths;

/**
 * Class contains common methods and fields for all tests
 */
@Listeners({TestListener.class})
public abstract class BaseTest {

    protected static Logger logger = LogManager.getLogger(BaseTest.class);
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    private AboutActions aboutActions;
    private SignInActions singInActions;
    private SignUpActions singUpActions;

    public BaseTest() {
    }

    /**
     * Creates and returns AboutPageActions instance
     */
    public AboutActions aboutActions() {
        if (aboutActions == null || aboutActions.getContext() != context) {
            aboutActions = new AboutActions(context, page);
        }
        return aboutActions;
    }

    /**
     * Creates and returns SignInActions instance
     */
    public SignInActions singInActions() {
        if (singInActions == null || singInActions.getContext() != context) {
            singInActions = new SignInActions(context, page);
        }
        return singInActions;
    }

    /**
     * Creates and returns SignUpActions instance
     */
    public SignUpActions singUpActions() {
        if (singUpActions == null || singUpActions.getContext() != context) {
            singUpActions = new SignUpActions(context, page);
        }
        return singUpActions;
    }

    @BeforeSuite
    public void setUp() {
        logger.info("Starting tests execution [Target: '" + TestContext.getTargetUrl() + "', Browser: '" + TestContext.getBrowserName() + "', Scope: '" + TestContext.getTestScope() + "', Debug: '" + TestContext.getDebugging() + "', Threads: '" + TestContext.getThreadCount() + "']...");
    }

    @BeforeClass
    void launchBrowser() {
        playwright = Playwright.create();
        Double delay = TestContext.getDebugging();
        BrowserType.LaunchOptions launchOptions = (delay != null ? new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(delay) : null);
        switch (TestContext.getBrowserName().toLowerCase()) {
            case "firefox" -> browser = playwright.firefox().launch(launchOptions);
            case "webkit" -> browser = playwright.webkit().launch(launchOptions);
            default -> browser = playwright.chromium().launch(launchOptions);
        }
    }

    @BeforeMethod
    protected void startTest(Method method) {
        Browser.NewContextOptions options = new Browser.NewContextOptions();
        options.setViewportSize(1366, 768);
        context = browser.newContext(options);
        page = context.newPage();
        logger.info("Executing test '" + method.getName() + "'...");
    }

    @AfterMethod
    public void finishTest(Method method, ITestResult result) {
        String resultName = switch (result.getStatus()) {
            case ITestResult.SUCCESS -> "PASSED";
            case ITestResult.FAILURE -> {
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(TestContext.getScreenshotPath(result.getTestClass().getName(), method.getName()))).setFullPage(true));
                yield "FAILED";
            }
            case ITestResult.SKIP -> "SKIPPED";
            default -> "UNKNOWN STATE";
        };
        context.close();
        logger.info("Test '" + method.getName() + "' execution has been finished with result: " + resultName);
    }

    @AfterClass
    void closeBrowser() {
        browser.close();
        playwright.close();
    }

    @AfterSuite
    public void tearDown() {
        logger.info("Test execution has been finished!");
    }
}
