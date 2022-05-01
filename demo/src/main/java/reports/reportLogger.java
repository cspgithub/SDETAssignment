package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.DriverManager;
import utilities.configReader;

public final class reportLogger {

    private reportLogger() {
        // private to avoid initialization
    }

    public static void pass(String message) {
        reportManager.getExtTest().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
    }

    public static void fail(String message) {

        reportManager.getExtTest().fail(message);
    }

    public static void info(String message) {

        reportManager.getExtTest().info(message);
    }

    public static void skip(String message) {

        reportManager.getExtTest().skip(message);
    }

    // overloaded
    public static void pass(String message, String isScreenshotreuired) throws Exception {
        if (configReader.getValue("PassedStepsScreenshots").equalsIgnoreCase("yes")
                && configReader.getValue("screenshotsrequired").equalsIgnoreCase("yes")) {

            reportManager.getExtTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());

        } else {
            pass(message);
        }

    }

    public static void fail(String message, String isScreenshotreuired) throws Exception {

        if (configReader.getValue("failedstepsscreenshots").equalsIgnoreCase("yes")
                && configReader.getValue("screenshotsrequired").equalsIgnoreCase("yes")) {

            reportManager.getExtTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());

        } else {
            fail(message);
        }
    }

    public static void skip(String message, String isScreenshotreuired) throws Exception {

        if (configReader.getValue("SkippedStepsScreenshots").equalsIgnoreCase("yes")
                && configReader.getValue("screenshotsrequired").equalsIgnoreCase("yes")) {

            reportManager.getExtTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());

        } else {
            skip(message);
        }
    }

    public static String getBase64Image() {

        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

    }

}
