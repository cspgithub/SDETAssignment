package pages;

import org.openqa.selenium.By;

import data.userData;

public final class createAccountPage extends seleniumActions {

    /*
     * private appLogInPage(){
     * 
     * }
     */
    private final By title = By.cssSelector("#id_gender1");
    private final By fName = By.cssSelector("#customer_firstname");
    private final By lName = By.cssSelector("#customer_lastname");
    private final By passwd = By.cssSelector("#passwd");

    // dob
    private final By days = By.cssSelector("#days");
    private final By months = By.cssSelector("#months");
    private final By year = By.cssSelector("#years");

    public createAccountPage createAccountPageLoaded() {
        getWebElement(title);
        return this;
    }

    public createAccountPage fillUserDetails(String password, userData obj) {
        click(title);
        type(fName, obj.getFName());
        type(lName, obj.getFName());
        type(passwd, password);

        // select dropdown values - DOB
        selctValuesFromDropdown(days, "1");
        selctValuesFromDropdown(months, "1");
        selctValuesFromDropdown(year, "2022");

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;

    }

}
