package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverManager;

public class seleniumActions {

    String parentTabhandel;
    Set<String> allhandles;
    String newTabhandle;

    protected void sleep(int sleep) {

        try {
            Thread.sleep(sleep);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected WebElement getWebElement(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(45));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void scrollToWebElement(By by) {

        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);",
                getWebElement(by));

    }

    protected List<WebElement> getListOfWebElements(By by) {

        return DriverManager.getDriver().findElements(by);

    }

    protected boolean isWebElementDisplayed(By by) {
        return getWebElement(by).isDisplayed();

    }

    protected WebElement getWebElementByVisiblity(WebElement elemnt) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOf(elemnt));
    }

    protected void click(By by) {

        getWebElement(by).click();

    }

    protected void type(By by, String value) {

        click(by);

        getWebElement(by).sendKeys(value);

    }

    protected void type(WebElement el, String value) {
        // click
        // sendkeys
        el.click();
        el.sendKeys(value);

    }
    protected boolean isWebElementDisplayed(WebElement el) {
        return el.isDisplayed();

    }

    protected void selctValuesFromDropdown(By parentBy, String value) {

        Select objSelect = new Select(getWebElement(parentBy));
        objSelect.selectByValue(value);

    }

    protected void jsClick(By by) {

        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        // executor.executeScript("arguments[0].scrollIntoView(true);",
        // getWebElement(by));
        executor.executeScript("arguments[0].click();", getWebElement(by));

    }

    protected void switchToNewTab() {
        parentTabhandel = DriverManager.getDriver().getWindowHandle();
        allhandles = DriverManager.getDriver().getWindowHandles();
        for (String handel : allhandles) {
            newTabhandle = handel;

            if (!parentTabhandel.contentEquals(newTabhandle)) {
                DriverManager.getDriver().switchTo().window(newTabhandle);
            }

        }
    }

    protected void switchToParentWindow() {

        DriverManager.getDriver().close();
        System.out.println("succdssfully closed new tab  " + newTabhandle);
        sleep(6000);
        DriverManager.getDriver().switchTo().window(parentTabhandel);
        System.out.println("succdssfully focus changed to paremt tab " + parentTabhandel);

    }

    protected String getTitle() {
        String title = DriverManager.getDriver().getTitle();
        return title;
    }

    protected String getCurrentURL() {
        String url = DriverManager.getDriver().getCurrentUrl();
        return url;
    }

    protected void cancelPopup() {
        DriverManager.getDriver().switchTo().alert().dismiss();
    }

    protected void navigateToURL(String url) {
        DriverManager.getDriver().navigate().to(url);
    }

    protected String getCurrentDate() {
        Date date = new Date();
        String dateFormatString = "d";
        DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        String currentDate = dateFormat.format(date);
        System.out.println("Current date: " + currentDate);
        return currentDate;
    }

}
