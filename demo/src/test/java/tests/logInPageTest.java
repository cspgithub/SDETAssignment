package tests;

import com.github.javafaker.Faker;

import org.testng.annotations.Test;

import data.userData;
import pages.appLogInPage;

public final class logInPageTest extends baseTest {

    private logInPageTest() {

    }

    @Test
    public void verifySignIn() {

        appLogInPage applogin = new appLogInPage();
        applogin.clickSigIn();
        Faker fakeObj = new Faker();
        String email = fakeObj.internet().emailAddress();
        String password = fakeObj.internet().password();

        userData userDataObj = new userData(fakeObj.name().firstName(), fakeObj.name().lastName());
        applogin.createAccount(email).createAccountPageLoaded().fillUserDetails(password, userDataObj);

    }

}
