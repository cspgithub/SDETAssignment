package tests;

import org.testng.annotations.Test;

import enums.loggerType;
import frameworkLogger.frameworkLog;

public class test1 extends baseTest {

  @Test
  public void verifyAttendance1() {

    frameworkLog.log(loggerType.EXTENTREPORTANDCONSOLE, "2");

  }

  @Test
  public void verifyAttendance4() {

    frameworkLog.log(loggerType.EXTENTREPORTANDCONSOLE, "3");

  }

  @Test
  public void verifyAttendance2() {

    frameworkLog.log(loggerType.EXTENTREPORTANDCONSOLE, "4");

  }

  @Test
  public void verifyAttendance3() {

    frameworkLog.log(loggerType.EXTENTREPORTANDCONSOLE, "5");

  }

}
