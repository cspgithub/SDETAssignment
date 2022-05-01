package reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class extentreport {

    private extentreport() {

    }

    private static ExtentReports extent;

    public static void startReport() {

        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            String userDir = System.getProperty("user.dir") + "/src/test/java/report";
            ExtentSparkReporter spark = new ExtentSparkReporter(userDir);
            extent.attachReporter(spark);
            spark.config().setReportName("sdetexecutionreport");
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
