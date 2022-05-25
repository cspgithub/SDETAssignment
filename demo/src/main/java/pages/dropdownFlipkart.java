
package pages;

import java.util.ArrayList;
import java.util.List;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.reactivex.rxjava3.functions.Action;

public class dropdownFlipkart extends seleniumActions {

    // locators
    By searchTextBox = By.cssSelector("input[title='Search for products, brands and more'][name='q']");
    By croosButton = By.xpath("/html/body/div[2]/div/div/button");

    static String optionvalue;
    // actions

    public void dropdownTest(String searchText, String optionToClick) {

        click(croosButton);
        type(searchTextBox, searchText);

        List<String> values = new ArrayList<>();
        for (int k = 0; k <= values.size(); k++) {
            scrollInto(searchTextBox);
            optionvalue = getWebElement(searchTextBox).getAttribute("value");
            if (!values.contains(optionvalue)) {
                values.add(optionvalue);
                if (values.contains(optionToClick)) {
                    String a = String.format("//input[@value='%s']", optionToClick);
                    By option = By.xpath(a);
                    enterusingActionClass(option);
                    sleep(3000);
                    break;

                }

            }

        }

    }

}
