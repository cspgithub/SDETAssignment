package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import driver.DriverManager;

public final class First_Test extends baseTest {

    private First_Test() {

    }

    @Test
    public void verifyScrollToParticaularElement() {

        // enter text in search textbox
        DriverManager.getDriver().findElement(By.cssSelector("input[class='gLFyf gsfi'][name='q']"))
                .sendKeys("chandra shekhar pandey",Keys.ENTER);
        // click google searchbox
    /*     DriverManager.getDriver().findElement(
                By.cssSelector("div[class='FPdoLc lJ9FBc'] center input[class='gNO89b'][value='Google Search']"))
                .click(); */

        // scroll till end of the page where the element is available

        WebElement element = DriverManager.getDriver()
                .findElement(By.cssSelector("div[class='fbar'] span[id='fsl'] a:nth-of-type(1)"));
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

    }

}
