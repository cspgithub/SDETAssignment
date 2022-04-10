package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.userData;
import driver.DriverManager;

public final class createAccountPage {

    /*
     * private appLogInPage(){
     * 
     * }
     */
    private final By title = By.cssSelector("#id_gender1");
    private final By fName = By.cssSelector("#customer_firstname");
    private final By lName = By.cssSelector("#customer_lastname");
    private final By passwd = By.cssSelector("#passwd");
    

    public createAccountPage createAccountPageLoaded() {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(30));
        // presenceOfElementLocated condition
        explicitWait.until(ExpectedConditions.presenceOfElementLocated (title));
       // DriverManager.getDriver().findElement(createAccountLabel).isDisplayed();
        return this;

    }

    public createAccountPage fillUserDetails(String password, userData obj) {

        DriverManager.getDriver().findElement(title).click();
        DriverManager.getDriver().findElement(fName).sendKeys(obj.getFName());
        DriverManager.getDriver().findElement(lName).sendKeys(obj.getLName());
        DriverManager.getDriver().findElement(passwd).sendKeys(password);

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
           e.printStackTrace();
        }
      

        return this;

    }

}
