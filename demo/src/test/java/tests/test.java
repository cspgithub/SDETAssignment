package tests;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.homepage;
import pages.productPage;

public class test extends baseTest {

  @Test
  public void verifyTitlrOfproduct() {

    homepage obj = new homepage();
    obj.clickHamburgerMenu()
        .productPageLoaded();

    productPage obj1 = new productPage();
    obj1.SelectBrandAndFilterByPrice();

    assertEquals("About this item", obj1.getSecondLargestPricedProduct());

    System.out.println(obj1.printAllAboutThisContent());

  }

}
