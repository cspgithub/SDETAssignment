package pages;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import enums.loggerType;
import reports.frameworkLogger;

import static reports.frameworkLogger.*;

public class productPage extends seleniumActions {

    By section = By.xpath(
            "//div[@class='a-section a-spacing-none apb-browse-refinements']//div[@class='a-section a-spacing-small']/span[text()='Brands']");// brand

    By sectionItemCheckbox = By.xpath(
            "//span[text()='Brands']/../following-sibling::ul/li//span[text()='Samsung']/preceding-sibling::div//input");
    By dropDownSelectForFilter = By.xpath(
            "//div[@class='a-section a-spacing-small a-spacing-top-small a-text-right']/form[@class='aok-inline-block a-spacing-none']//select[@class='a-native-dropdown a-declarative']");// Samsung

    By priceOfProduct = By.xpath(
            "//div[@class='a-section a-spacing-none a-spacing-top-small s-price-instructions-style']//span[@class='a-price-whole']");// Hih
                                                                                                                                     // to
    By nameOfProduct = By.xpath(
            "//div[@class='a-section a-spacing-none a-spacing-top-small s-price-instructions-style']//span[@class='a-price-whole']/../../../../../../div//span[@class='a-size-base-plus a-color-base a-text-normal']");
    // low

    By aboutThisItem = By.xpath(
            "//div[@class='a-section a-spacing-medium a-spacing-top-small']/h1[@class='a-size-base-plus a-text-bold']");

    By aboutThisItemContent = By.xpath(
            "//div[@class='a-section a-spacing-medium a-spacing-top-small']/h1[@class='a-size-base-plus a-text-bold']/following::ul[@class='a-unordered-list a-vertical a-spacing-mini']/li/span");

    private static String secondHighestPriceproductName;

    private static String actualVerficationtext;

    private static List<WebElement> pricelistWebElements;

    private static List<Integer> pricelist;

    private static int secondlargestprceValue;

    public boolean isProductPageLoaded() {
        return isWebElementDisplayed(section);
    }

    public productPage filterProductsByPriceHighToLow() {

        jsClick(sectionItemCheckbox);

        if (isWebElementDisplayed(dropDownSelectForFilter)) {

            selctValuesFromDropdown(dropDownSelectForFilter, "price-desc-rank");
            sleep(2000);
            frameworkLogger.log(loggerType.EXTENTREPORTANDCONSOLE, getURL());

        }
        return this;

    }

    public productPage getSecondHighestPrice() {

        pricelistWebElements = getListOfWebElements(priceOfProduct);// storing all webelements -price
        pricelist = new ArrayList<>();// storing all price as int
        for (WebElement webElement : pricelistWebElements) {
            int price = Integer.parseInt(webElement.getText().toString().replace(",", ""));
            pricelist.add(price);
        }
        int[] array = pricelist.stream().mapToInt(i -> i).toArray();// converting arraylist to array
        int total = array.length;
        Arrays.sort(array);
        secondlargestprceValue = array[total - 2];// after sorting in ascending order it will give 2nd index item which
        log(loggerType.INFO, "desired item : ---" + String.valueOf(secondlargestprceValue)); // is 2nd
        // higest price
        return this;

    }

    public productPage openSecondHighestPriceProductDeatilsPage() {
        for (WebElement el : pricelistWebElements) {
            if (Integer.parseInt(el.getText().toString().replace(",", "")) == secondlargestprceValue) {
                secondHighestPriceproductName = el.findElement(nameOfProduct).getText();
                el.click();
                break;
            }
        }
        return this;
    }

    public String getActualVerficationText() {

        sleep(3000);

        if (!getTitle().matches(secondHighestPriceproductName)) {
            switchToNewTab();

            scrollToWebElement(aboutThisItem);
            actualVerficationtext = getWebElement(aboutThisItem).getText().trim();
        }
        return actualVerficationtext;

    }

    public void printAllAboutThisContent() {

        List<WebElement> abtContent = getListOfWebElements(aboutThisItemContent);
        String AboutThisProductDetail = "";

        for (WebElement el : abtContent) {
            AboutThisProductDetail += el.getText();

        }
        log(loggerType.EXTENTREPORTANDCONSOLE, AboutThisProductDetail);

    }

}
