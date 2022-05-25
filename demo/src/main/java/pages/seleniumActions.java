package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverManager;

public class seleniumActions {

    String parentTabhandel;
    Set<String> allhandles;
    String newTabhandle;
    WebDriverWait wait;

    protected void sleep(int sleep) {

        try {
            Thread.sleep(sleep);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected WebElement getWebElement(By by) {
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void scrollToWebElement(By by) {

        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);",
                getWebElement(by));

    }

    protected boolean waitForElementToDisappear(By by) {
        try {
            while (true) {
                try {
                    if (getWebElement(by).isDisplayed()) {
                        sleep(500);
                    }
                } catch (NoSuchElementException e) {
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }

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

    protected void clearAndType(WebElement el, String value) {
        el.clear();
        el.sendKeys(value);

    }

    protected void clearWebField(WebElement element) {
        while (!element.getAttribute("value").equals("")) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    protected boolean isWebElementDisplayed(WebElement el) {
        return el.isDisplayed();

    }

    protected void selctValuesFromDropdown(By parentBy, String value) {

        Select objSelect = new Select(getWebElement(parentBy));
        objSelect.selectByValue(value);

    }

    protected void scrollToElement(By by) throws Exception {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoViewIfNeeded()",
                getWebElement(by));
        sleep(500);
    }

    protected void jsClick(By by) {
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));
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

    protected String getText(By by) {
        return getWebElement(by).getText();
    }

}
