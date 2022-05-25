package tests;

import org.testng.annotations.Test;

import pages.dropdownFlipkart;
import pages.indexDropdown;

public class dropdownTest extends baseTest {

  @Test(enabled = false)
  public void verifyindexOfDropdownValue() {

    // frameworkLog.log(loggerType.EXTENTREPORTANDCONSOLE, "successfully started
    // test");
    indexDropdown drp = new indexDropdown();
    drp.findIndexOfSelectedDropdownOption("Separated link");

  }

  @Test
  public void verifyFlipkartDropdown() {

    dropdownFlipkart drpFlipkart = new dropdownFlipkart();
    drpFlipkart.dropdownTest( "headphone","headphone with mic");
    

  }

}
