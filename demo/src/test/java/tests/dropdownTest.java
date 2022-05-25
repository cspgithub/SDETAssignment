package tests;

import org.testng.ITestListener;
import org.testng.annotations.Test;

import enums.loggerType;
import frameworkLogger.frameworkLog;
import pages.indexDropdown;

public class dropdownTest extends baseTest {

  @Test(groups = { "Group3" })
  public void verifyindexOfDropdownValue() {

    //frameworkLog.log(loggerType.EXTENTREPORTANDCONSOLE, "successfully started test");
    indexDropdown drp = new indexDropdown();
    drp.findIndexOfSelectedDropdownOption("Separated link");

  }

}
