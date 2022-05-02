package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

import pages.login;

public class test extends baseTest {

  @Test
  public void verifyLogin() throws MalformedURLException, IOException {

    login login = new login();
    String actualURL = login.loginisLoaded("chandrashekhar_pande@hcl.com", "Hcl@2022$");
    assertEquals("https://www.myhcl.com/bprhome/Home/Index", actualURL);
    login.markattendance("https://wf24.myhcl.com/TSMS/login.aspx");

  }

}
