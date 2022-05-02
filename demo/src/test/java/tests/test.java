package tests;



import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

import pages.brokenlinks;


public class test extends baseTest {

  @Test
  public void verifyAboutThisItemForProduct() throws MalformedURLException, IOException {

    brokenlinks brokenlinks = new brokenlinks();
    brokenlinks.a();

  }

}
