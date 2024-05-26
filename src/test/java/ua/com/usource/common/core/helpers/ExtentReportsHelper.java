package ua.com.usource.common.core.helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.com.usource.common.core.context.TestContext;

import java.io.File;

/**
 * The class contains methods for the `Extent Report` file creation
 */
public class ExtentReportsHelper {

    private static final ExtentReports extentReports = new ExtentReports();
    private static final String reportFileName = "report.html";
    private static final String macPath = System.getProperty("user.dir") + "/target/test-report";
    private static final String windowsPath = System.getProperty("user.dir") + "\\target\\test-report";
    private static final String macReportFileLoc = macPath + "/" + reportFileName;
    private static final String winReportFileLoc = windowsPath + "\\" + reportFileName;
    private static final Logger logger = LogManager.getLogger(ExtentReportsHelper.class);

    public synchronized static ExtentReports createExtentReports() {
        String fileName = getReportFileLocation();
        ExtentSparkReporter reporter = new ExtentSparkReporter(fileName);
        reporter.config().setReportName("Test Execution Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Target URL", TestContext.getTargetUrl());
        extentReports.setSystemInfo("Test Scope", TestContext.getTestScope());
        extentReports.setSystemInfo("Browser Name", TestContext.getBrowserName());
        extentReports.setSystemInfo("Browser Version", TestContext.getBrowserVersion());
        return extentReports;
    }

    /**
     * Selects the extent report file location based on the OS name (from the System properties)
     */
    private static String getReportFileLocation() {
        String reportFileLocation = null;
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            reportFileLocation = winReportFileLoc;
            createReportPath(windowsPath);
            logger.info("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
        }
        else if (os.contains("mac")) {
            reportFileLocation = macReportFileLoc;
            createReportPath(macPath);
            logger.info("ExtentReport Path for MAC: " + macPath + "\n");
        }
        else {
            logger.info("ExtentReport path has not been set! There is a problem!\n");
        }
        return reportFileLocation;
    }

    /**
     * Creates the report path if it does not exist
     * @param path target path for the report
     */
    private static void createReportPath(String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                logger.info("Directory: " + path + " is created!");
            } else {
                logger.info("Failed to create directory: " + path);
            }
        } else {
            logger.info("Directory already exists: " + path);
        }
    }
}
