package pages;

import java.time.Duration;

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

    String originalWindowHandle;
    Set<String> windowhandle;

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

        getWebElement(by).sendKeys(value);

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
        originalWindowHandle = DriverManager.getDriver().getWindowHandle();
        windowhandle = DriverManager.getDriver().getWindowHandles();
        for (String windowHandle : windowhandle) {

            if (!originalWindowHandle.contentEquals(windowHandle)) {
                DriverManager.getDriver().switchTo().window(windowHandle);
            }

        }
    }

    protected void switchToParentWindow() {
        //DriverManager.getDriver().close();
        DriverManager.getDriver().switchTo().window(originalWindowHandle);
        
    }

    protected String getTitle() {
        String title = DriverManager.getDriver().getTitle();
        return title;
    }

}
