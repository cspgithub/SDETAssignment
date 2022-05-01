package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.homepage;
import pages.productPage;

public class test extends baseTest {

  @Test
  public void verifyAboutThisItemForProduct() {

    homepage homepage = new homepage();
    assertTrue(homepage.clickHamburgerMenuOnHomePage().isProductPageLoaded());

    productPage productPage = new productPage();
    String actualText= productPage.filterProductsByPriceHighToLow()
        .getSecondHighestPrice()
        .openSecondHighestPriceProductDeatilsPage().getActualVerficationText();

    assertEquals("About this item", actualText);
    productPage.printAllAboutThisContent();

  }

}
