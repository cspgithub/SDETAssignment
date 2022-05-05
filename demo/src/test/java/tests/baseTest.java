package tests;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import driver.Driver;

public class baseTest {

  protected baseTest() {

  }

  // @Parameters("browser")
  @BeforeMethod
  protected void startBrowser() throws Exception {
    try {
      Driver.initDriver();
    } catch (Exception e) {
      // closeBrowser();
    }

  }

  @AfterMethod
  protected void closeBrowser() {
    Driver.closeDriver();
  }

}
