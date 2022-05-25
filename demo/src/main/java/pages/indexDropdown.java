
package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class indexDropdown extends seleniumActions {

    // locators
    private By dropdownToggle = By.xpath(
            "//div[@class='container-fluid']//main//div[@class='bd-example'][4]/div[1]/button[@class='btn btn-primary dropdown-toggle dropdown-toggle-split']");

    private By dropdownToggleValues = By.xpath(
            "//div[@class='container-fluid']//main//div[@class='bd-example'][4]/div[1]/div/a");

    static int position = 0;
    // actions

    public void findIndexOfSelectedDropdownOption(String option) {

        jsClick(dropdownToggle);

        List<WebElement> dropValues = getListOfWebElements(dropdownToggleValues);

        for (WebElement value : dropValues) {

            if (option.equalsIgnoreCase(value.getText())) {
                value.click();
                break;
            }
            position++;

        }
        System.out.println("index of selected value in dropdown is : " + position);
    }

}
