package ua.com.usource.common.core.context;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class contains test context methods
 */
public class TestContext {

    protected static Logger logger = LogManager.getLogger(TestContext.class);

    /**
     * Returns Browser name from context
     */
    public static String getBrowserName() {
        return getProperty("browser", "Browser name");
    }

    /**
     * Returns a browser version from context
     */
    public static String getBrowserVersion() {
        return getProperty("version", "Browser version");
    }

    /**
     * Returns Debugging value from context
     */
    public static Double getDebugging() {
        String value = getProperty("delay", "Delay value");
        return (value == null ? null : Double.parseDouble(value));
    }

    /**
     * Returns Current test scope from context
     */
    public static String getTestScope() {
        return getProperty("test", "Current test scope");
    }

    /**
     * Returns target URL from context
     */
    public static String getTargetUrl() {
        return getProperty("url", "Target URL");
    }

    /**
     * Returns Thread count from context
     */
    public static String getThreadCount() {
        return getProperty("threadCount", "Thread count");
    }

    /**
     * Returns File system separator
     */
    public static String getSystemSeparator() {
        return getProperty("file.separator", "File system separator");
    }

    /**
     * Returns Filepath for screenshots
     *
     * @param className class name
     * @param methodName method name
     */
    public static String getScreenshotPath(String className, String methodName) {
        return System.getProperty("user.dir") + TestContext.getSystemSeparator() + "target" + TestContext.getSystemSeparator() + "screenshots" + TestContext.getSystemSeparator() + className + TestContext.getSystemSeparator() + methodName + ".png";
    }

    /**
     * Returns the system property
     *
     * @param property property key for getting from a system
     * @param comment  comment for logging
     */
    private static String getProperty(String property, String comment) {
        String result;
        logger.info("Get " + comment + " from context...");
        String value = System.getProperty(property);
        result = (value == null || value.equals("") ? null : value);
        logger.info(comment + ": '" + result + "'");
        return result;
    }

    /**
     * Sets and Returns the system property
     *
     * @param key     property key for setting to a system
     * @param value   property value for setting to a system
     * @param comment comment for logging
     */
    private static String setProperty(String key, String value, String comment) {
        logger.info("Set " + comment + " to context...");
        System.setProperty(key, value);
        logger.info(comment + ": '" + value + "'");
        return value;
    }
}
