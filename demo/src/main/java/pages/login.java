package pages;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

public class login extends seleniumActions {

    By emailTextbox = By.cssSelector("input[type='email']");
    By submitbtn = By.cssSelector("  input[type='submit']");
    By pswdTextbox = By.cssSelector("input[type='password']");
    By signInbtn = By.cssSelector("input[type='submit']");

    By donotShowCheckbox = By.cssSelector("input[name='DontShowAgain']");

    By numberOfAccount = By.xpath("//div[@id='tilesHolder']//div[@role='listitem']");

    By datesVisible = By.xpath("//div[@class='it-enterList hdalign']/div");

    By inputBoxBalnk = By.xpath(
            "//div[@class='it-enterList hdalign']/div/following::div[@class='it-enterList pannel-body'][1]//div[@style='background-color: rgb(255, 255, 255);']//input");

    By submitForApprovalButton = By.xpath("//button[@class='btn primary-button'] [@id='le_apply']");

    // variables

    private static List<WebElement> listOfdates;

    private static int index;
    private static String currentDate;

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

    }

    public void markattendance(String url) {

        sleep(1000);
        navigateToURL(url);
        sleep(1000);

        List<WebElement> listofInput = getListOfWebElements(inputBoxBalnk);
        if (listofInput.size() > 0) {
            for (WebElement input : listofInput) {
                if (isWebElementDisplayed(input)) {
                    type(input, "9");
                    jsClick(submitForApprovalButton);
                }
            }

        } else {
            System.out.println("attendance has been already marked or its holiday");
        }
    }

    public int findIndexOfdate() {
        currentDate = getCurrentDate();
        listOfdates = getListOfWebElements(datesVisible);
        int listsize = listOfdates.size();
        for (index = 0; index < listsize; index++) {
            System.out.println(listOfdates.get(index).getText());
            if (listOfdates.get(index).getText().equalsIgnoreCase(currentDate)) {
                System.out.println(index + "=index of curremt date");
                break;
            }

        }
        return index;

    }

}
