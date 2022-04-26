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
            /*
             * ChromeOptions options = new ChromeOptions();
             * 
             * options.addArguments("--no-sandbox");
             * options.addArguments("--disable-dev-shm-usage");
             * options.addArguments("--headless");
             */
            DriverManager.setDriver(new ChromeDriver());

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
