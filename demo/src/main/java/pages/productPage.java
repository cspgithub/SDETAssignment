package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class productPage extends seleniumActions {

    By section = By.xpath(
            "//div[@class='a-section a-spacing-none apb-browse-refinements']//div[@class='a-section a-spacing-small']/span[text()='Brands']");// brand

    By sectionItemCheckbox = By.xpath(
            "//div[@class='a-section a-spacing-none apb-browse-refinements']//div[@class='a-section a-spacing-small']/span[text()='Brands']/following::ul/li//span[text()='Samsung']/..//input[@type='checkbox']");// Samsung

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

    String secondHighestPriceproductName;

    String actualVerficationtext;

    public productPage productPageLoaded() {
        isWebElementDisplayed(section);
        return this;

    }

    public void SelectBrandAndFilterByPrice() {

        jsClick(sectionItemCheckbox);

        if (isWebElementDisplayed(dropDownSelectForFilter)) {

            selctValuesFromDropdown(dropDownSelectForFilter, "price-desc-rank");
            sleep(2000);

        }

    }

    public String getSecondLargestPricedProduct() {

        List<WebElement> pricelistWebElements = getListOfWebElements(priceOfProduct);
        List<Integer> pricelist = new ArrayList<>();

        for (WebElement webElement : pricelistWebElements) {
            pricelist.add(Integer.parseInt(webElement.getText().toString().replace(",", "")));
        }
        int[] array = pricelist.stream().mapToInt(i -> i).toArray();
        int total = array.length;
        Arrays.sort(array);
        int secondlargestprceValue = array[total - 2];
        for (WebElement el : pricelistWebElements) {
            if (Integer.parseInt(el.getText().toString().replace(",", "")) == secondlargestprceValue) {
                secondHighestPriceproductName = el.findElement(nameOfProduct).getText();
                el.click();
                break;

            }

        }

        sleep(3000);

        if (!getTitle().matches(secondHighestPriceproductName)) {

            switchToNewTab();
            actualVerficationtext = getWebElement(aboutThisItem).getText().trim();

        }
        return actualVerficationtext;

    }

    public List<String> printAllAboutThisContent() {

        List<WebElement> abtContent = getListOfWebElements(aboutThisItemContent);
        List<String> actualContent = new ArrayList<>();
        for (WebElement webElement : abtContent) {
            actualContent.add(webElement.getText());

        }
        return actualContent;

    }

}
