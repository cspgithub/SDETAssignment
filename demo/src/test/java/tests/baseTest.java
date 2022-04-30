package tests;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import driver.Driver;

public class baseTest {

  protected baseTest() {

  }

  /*
   * @BeforeSuite
   * public void start() throws Exception {
   * Driver.setUpDocker();
   * 
   * }
   */

  @Parameters("browser")
  @BeforeMethod
  protected void startBrowser(String browser) throws Exception {
    try {
      Driver.initDriver(browser);
    } catch (Exception e) {
      // closeBrowser();
    }

  }

  @AfterMethod
  protected void closeBrowser() {
    Driver.closeDriver();
  }

  /*
   * @AfterSuite
   * public void CloseD() throws Exception {
   * Driver.closeDocker();
   * }
   */

}
