package pages;

import org.openqa.selenium.By;

import driver.DriverManager;

public final class appLogInPage {

    /* private appLogInPage(){

    } */


    private final By SigInLink = By.cssSelector("a[class='login']");

    private final By emailAddress = By.cssSelector("input[id='email_create']");

    private final By createAccountButton = By.cssSelector("button[id='SubmitCreate']");

    public  void clickSigIn(){

         DriverManager.getDriver().findElement(SigInLink).click();

    }

    public createAccountPage createAccount(String email) {
        DriverManager.getDriver().findElement(emailAddress).sendKeys(email);
        DriverManager.getDriver().findElement(createAccountButton).click();
        return new createAccountPage();
        
    }



    
    
}
