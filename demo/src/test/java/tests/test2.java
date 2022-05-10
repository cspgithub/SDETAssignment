package tests;

import org.testng.annotations.Test;

import enums.loggerType;
import frameworkLogger.frameworkLog;

public class test2 extends baseTest {

  @Test
  public void verifyAttendance1() {

    frameworkLog.log(loggerType.EXTENTREPORTANDCONSOLE, "6");

  }

  @Test
  public void verifyAttendance4() {

    frameworkLog.log(loggerType.EXTENTREPORTANDCONSOLE, "7");

  }

  @Test
  public void verifyAttendance2() {

    frameworkLog.log(loggerType.EXTENTREPORTANDCONSOLE, "8");

  }

  @Test
  public void verifyAttendance3() {

    frameworkLog.log(loggerType.EXTENTREPORTANDCONSOLE, "9");

  }

}
