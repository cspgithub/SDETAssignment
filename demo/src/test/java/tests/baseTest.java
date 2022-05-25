package tests;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import driver.Driver;

public class baseTest {

  protected baseTest() {

  }

  // @Parameters("browser")
  @BeforeMethod(groups={"Group1", "Group2", "Group3", "Group4"})
  protected void startBrowser() throws Exception {
    try {
      Driver.initDriver();
    } catch (Exception e) {
      // closeBrowser();
    }

  }

  @AfterMethod(groups={"Group1", "Group2", "Group3", "Group4"})
  protected void closeBrowser() {
    Driver.closeDriver();
  }

}
