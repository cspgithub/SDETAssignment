package tests;

import org.testng.annotations.Test;

import enums.loggerType;
import frameworkLogger.frameworkLog;

public class test1 extends baseTest {

  @Test(groups = { "Group2" })
  public void verifyAttendance1() {

    // frameworkLog.log(loggerType.EXTENTREPORTANDCONSOLE, "2");
    System.out.println("grp2");

  }

  @Test(groups = { "Group2", "Group1" })
  public void verifyAttendance3() {

    // frameworkLog.log(loggerType.EXTENTREPORTANDCONSOLE, "2");
    System.out.println("group1 and 2");

  }

}
