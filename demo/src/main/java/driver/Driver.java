package driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.configReader;

public final class Driver {

    private Driver() {

    }

    public static void initDriver() throws Exception {

        if (Objects.isNull(DriverManager.getDriver())) {
            WebDriverManager.chromedriver().setup();
            // WebDriverManager.firefoxdriver().setup();
            // System.setProperty("webdriver.chrome.driver",
            // frameworkConstants.getChromedriverPath());
            DriverManager.setDriver(new ChromeDriver());
            DriverManager.getDriver().navigate().to(configReader.getValue("url"));
            DriverManager.getDriver().manage().window().maximize();
        }

    }

    public static void closeDriver() {

        try {
            if (Objects.nonNull(DriverManager.getDriver())) {
                DriverManager.getDriver().close();

            }
        } finally {
            DriverManager.getDriver().quit();
            DriverManager.unloaDriver();
        }

    }

}
