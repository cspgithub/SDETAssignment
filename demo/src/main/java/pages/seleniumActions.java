package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverManager;

public class seleniumActions {


    protected WebElement getWebElement(By by) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.presenceOfElementLocated(by));

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		/* Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverManager.getDriver()).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		}); */
		
	}

    protected void click(By by){

        getWebElement(by).click();

    }

    protected void type(By by,String value){

        getWebElement(by).sendKeys(value);

    }

    protected void selctValuesFromDropdown(By parentBy, String value){

       // DriverManager.getDriver().findElement(parentBy).click();

        Select objSelect = new Select(DriverManager.getDriver().findElement(parentBy));
        objSelect.selectByValue(value);


    } 
    
}
