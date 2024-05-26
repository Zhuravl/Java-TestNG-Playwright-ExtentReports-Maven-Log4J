# Java-TestNG-Playwright-ExtentReports-Maven-Log4J
The example of Test Automation Framework on Java, TestNG, Playwright, ExtentReports, Maven and Log4J.

## To launch tests, execute command (from the project root directory):
```
mvn clean test site -Durl=TARGET_URL -Dbrowser=BROWSER_NAME -Dversion=BROWSER_VERSION -Dtest=TESTS_SCOPE -Ddelay=DELAY -DthreadCount=THREAD_COUNT
```

Where:
 Parameters for the API and UI tests:
 * TARGET_URL — the target site URL
* BROWSER_NAME — target browser name ('chromium' or 'firefox' or 'webkit')
 * BROWSER_VERSION — browser version, optional (the latest by default)
 * TESTS_SCOPE — test name(s) to execute (e.g. 'MyFirstTest' or 'MyFirstTest#firstMethod' or 'MyFirstTest#firstMethod+secondMethod' or 'MyFirstTest#firstMethod,MySecondTest#firstMethod')
 * DELAY — define an executing delay in millis (e.g. '1000') to enable the debugging mode and launch the browser in the headed mode, optional ('null' by default)
* THREAD_COUNT — specify how many threads should be allocated for this execution, optional (the one thread by default)

## An example params for launching the example test using Chrome browser and the default params:
```
mvn clean test site -Durl=https://usource.com.ua/ -Dbrowser=chromium -Dtest=AboutAppTests,SignUpTests,SignInTests -DthreadCount=3

```

## Test Execution Report:

To get the execution report, use maven `site` command and find the result in the `target\test-report\report.html` file.

NOTE: It's required to install and add to the PATH:

- [Java](https://java.com/en/download/);
- [Maven](https://maven.apache.org/download.cgi).

Also, in order to be able to execute tests using the Scripted Pipeline, it is required to have Jenkins environment with
a Pipeline type job (that will call the script from the project)
and a Freestyle type job with the 'ATExecutor' name (as a main test executor, configured in the pipeline script).
 