package pages;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.DriverManager;

public final class pdpPage extends seleniumActions {

    private By items = By.cssSelector(".cmp-integration--socialsharing div a");

    public void socialshareLogic(String value) throws Exception {

        List<WebElement> options = DriverManager.getDriver().findElements(items);
        int size = DriverManager.getDriver().findElements(items).size();
        /*
         * List<String>optionByAtrribute = new ArrayList<>();
         * for (WebElement item : options) {
         * optionByAtrribute.add(item.getAttribute("title").toString().trim());
         * 
         * }
         */
        for (int i = 0; i < size; i++) {

            if (options.get(i).getAttribute("title").toString().trim().equals(value)) {
                System.out.println(options.get(i).getAttribute("title") + "is present in DOM");
                try {
                    getWebElementByVisiblity(options.get(i));
                    jsclick(options.get(i));
                    // Thread.sleep(10000);
                } catch (Exception e) {

                    throw new Exception("social ions : " + options.get(i) + "  not found in GUI");

                }

                break;

            }

        }

    }

    /* private void SwitchTabandClose() {
        Set<String> windows = DriverManager.getDriver().getWindowHandles();
        String mainwindow = DriverManager.getDriver().getWindowHandle();

        for (String handle : windows) {
            DriverManager.getDriver().switchTo().window(handle);
            System.out.println("switched to " + DriverManager.getDriver().getTitle() + "  Window");
            String pagetitle = DriverManager.getDriver().getTitle();
            if (pagetitle.equalsIgnoreCase("Facebook")) {
                DriverManager.getDriver().close();
                System.out.println("Closed the  '" + pagetitle + "' Tab now ...");
            }
        }

        DriverManager.getDriver().switchTo().window(mainwindow);
    } */

}
