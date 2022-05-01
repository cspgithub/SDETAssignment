package reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.configReader;

public final class extentreport {

    private extentreport() {

    }

    private static ExtentReports extent;

    public static void startReport() throws Exception {

        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            String userDir = System.getProperty("user.dir") + "/src/test/java/report";
            ExtentSparkReporter spark = new ExtentSparkReporter(userDir);
            extent.attachReporter(spark);
            spark.config().setReportName("sdetexecution-report"+" on "+ configReader.getValue("executionmode")+"environemnt");
            spark.config().setTheme(Theme.STANDARD);
        }

    }

    public static void createTest(String testname) {
        reportManager.setExtentTest(extent.createTest(testname));

    }

    public static void flushReports() {
        if (Objects.nonNull(extent)) {

            extent.flush();

        }

    }

}
