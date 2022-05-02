package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class login extends seleniumActions {

    By emailTextbox = By.cssSelector("input[type='email']");
    By submitbtn = By.cssSelector("  input[type='submit']");
    By pswdTextbox = By.cssSelector("input[type='password']");
    By signInbtn = By.cssSelector("input[type='submit']");

    By donotShowCheckbox = By.cssSelector("input[name='DontShowAgain']");

    By numberOfAccount = By.xpath("//div[@id='tilesHolder']//div[@role='listitem']");

    By searchTextBox = By.cssSelector("input[name='searchtext']");

    public String loginisLoaded(String emailValue, String password) {

        isWebElementDisplayed(emailTextbox);
        type(emailTextbox, emailValue);
        click(submitbtn);
        sleep(1500);
        type(pswdTextbox, password);
        click(submitbtn);
        jsClick(donotShowCheckbox);
        click(submitbtn);
        sleep(2000);

        return getCurrentURL();

        /*
         * List<WebElement> accounts = getListOfWebElements(numberOfAccount);
         * for (WebElement account : accounts) {
         * if (account.getText().trim().equalsIgnoreCase(emailValue)) {
         * account.click();
         * //wait for microsoft activation
         * sleep(1000);
         * //jsClick(donotShowCheckbox);
         * click(submitbtn);
         * break;
         * }
         * 
         * }
         */

    }

    public String actionOnDashboard(String searchText, String url) {

        /*
         * type(searchTextBox, searchText);
         * sleep(1000);
         * getWebElement(searchTextBox).sendKeys(Keys.ARROW_DOWN);
         * getWebElement(searchTextBox).sendKeys(Keys.ENTER);
         */
        sleep(1000);
        return getCookie(url);
        // navigateToURL(url);

    }

}
