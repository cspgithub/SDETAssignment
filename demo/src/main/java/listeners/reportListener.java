package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import reports.extentreport;
import reports.reportLogger;

public class reportListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        try {
            extentreport.startReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        extentreport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentreport.createTest(result.getMethod().getMethodName());
        reportLogger.info("Test Case : " + result.getMethod().getMethodName() + " execution Started");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            reportLogger.pass(result.getMethod().getMethodName(), "yes");
            reportLogger.info("Test Case : " + result.getMethod().getMethodName() + " execution Finished");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // ExtentLogger.fail(result.getThrowable().getMessage());
        try {
            reportLogger.fail(result.getMethod().getMethodName(), "yes");
        } catch (Exception e) {

            e.printStackTrace();
        }
        reportLogger.info("Test Case : " + result.getMethod().getMethodName() + " execution Finished");

    }

    @Override
    public void onFinish(ITestContext arg0) {
        System.out.println("not reqd");

    }

    @Override
    public void onStart(ITestContext arg0) {
        System.out.println("not reqd");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        System.out.println("not reqd");

    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        System.out.println("not reqd");

    }

}
