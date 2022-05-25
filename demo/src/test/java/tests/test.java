package tests;


import org.testng.annotations.Test;

import enums.loggerType;
import frameworkLogger.frameworkLog;


public class test extends baseTest {

  @Test(groups={"Group1"})
  public void verifyAttendance() {

    frameworkLog.log(loggerType.EXTENTREPORTANDCONSOLE, "group1");

    /* login login = new login();
    String actualURL = login.loginisLoaded("chandrashekhar_pande@hcl.com", "Hcl@2022$");
    Assert.assertEquals("https://www.myhcl.com/bprhome/Home/Index", actualURL);
    login
        .markattendance("https://wf24.myhcl.com/TSMS/login.aspx");
    login.checkPendingStatusAndSubmitHours("https://wf24.myhcl.com/TSMS/login.aspx");  */

  }

}
