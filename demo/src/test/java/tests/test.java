package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import enums.loggerType;
import frameworkLogger.frameworkLog;
import pages.login;

public class test extends baseTest {

  @Test
  public void verifyAttendance() {

    frameworkLog.log(loggerType.EXTENTREPORTANDCONSOLE, "1");

    /* login login = new login();
    String actualURL = login.loginisLoaded("chandrashekhar_pande@hcl.com", "Hcl@2022$");
    Assert.assertEquals("https://www.myhcl.com/bprhome/Home/Index", actualURL);
    login
        .markattendance("https://wf24.myhcl.com/TSMS/login.aspx");
    login.checkPendingStatusAndSubmitHours("https://wf24.myhcl.com/TSMS/login.aspx");  */

  }

}
