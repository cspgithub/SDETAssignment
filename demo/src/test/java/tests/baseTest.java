package tests;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import driver.Driver;

public class baseTest {

  protected baseTest() {

  }

  @BeforeMethod
  protected void startBrowser() {
    Driver.initDriver();
  }

  @AfterMethod
  protected void closeBrowser() {
    Driver.closeDriver();
  }

}
