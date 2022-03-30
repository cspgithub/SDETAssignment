package driver;

import java.util.Objects;
import org.openqa.selenium.chrome.ChromeDriver;
import constants.frameworkConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {

    private Driver() {

    }

    public static void initDriver() {

        

        if (Objects.isNull(DriverManager.getDriver())) {
            WebDriverManager.chromedriver().setup(); 
           // System.setProperty("webdriver.chrome.driver", frameworkConstants.getChromedriverPath());
            DriverManager.setDriver(new ChromeDriver());
            DriverManager.getDriver().navigate().to(frameworkConstants.getURL());
            DriverManager.getDriver().manage().window().maximize();
        }

    }

    public static void closeDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().close();
            DriverManager.unloaDriver();
        }
    }

}
