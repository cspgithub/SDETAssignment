package pages;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import enums.loggerType;
import frameworkLogger.frameworkLog;
import reports.reportLogger;

public class login extends seleniumActions {

    By emailTextbox = By.cssSelector("input[type='email']");
    By submitbtn = By.cssSelector("  input[type='submit']");
    By pswdTextbox = By.cssSelector("input[type='password']");
    By signInbtn = By.cssSelector("input[type='submit']");

    By donotShowCheckbox = By.cssSelector("input[name='DontShowAgain']");

    By numberOfAccount = By.xpath("//div[@id='tilesHolder']//div[@role='listitem']");

    By datesVisible = By.xpath("//div[@class='it-enterList hdalign']/div");

    By inputBoxBlank = By.xpath(
            "//div[@class='it-enterList hdalign']/div/following::div[@class='it-enterList pannel-body'][1]//div[@style='background-color: rgb(255, 255, 255);']//input");

    By saveButton = By.cssSelector("span[class='glb-btn le_calendar'] button[data-original-title='Save']");
    By saveSuccesMessage = By.xpath("//*[@id='CustomMsg']");
    By pendingState = By.xpath("//div[@title='Pending with Employee']/input");
    By markAttendaceButton = By
            .cssSelector("span[class='glb-btn le_calendar'] button[data-original-title='Submit For Approval']");

    // variables

    private static List<WebElement> listOfdates;

    private static int index;
    private static String currentDate;
    // private static String actualMessage;

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
        navigateToURL(url);
        List<WebElement> listofInput = getListOfWebElements(inputBoxBlank);
        int size = listofInput.size();
        if (size >= 1) {
            for (WebElement input : listofInput) {
                clearAndType(input, "09:00");
                sleep(600);
            }
            jsClick(saveButton);

        } else {

            frameworkLog.log(loggerType.EXTENTREPORTANDCONSOLE, "attendance has been already marked or its holiday or you have missed the attendance");
        }
    }

    public void checkPendingStatusAndSubmitHours(String url) {
        navigateToURL(url);
        List<WebElement> pendingList = getListOfWebElements(pendingState);
        int size = pendingList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                sleep(600);
                jsClick(markAttendaceButton);

            }
            reportLogger.info("sucessfully submitted hours");
        }

        else {
            reportLogger.info("no pending attendce everything is marked!!");
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
