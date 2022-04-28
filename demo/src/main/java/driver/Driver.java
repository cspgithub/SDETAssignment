package driver;


import java.time.Duration;
import java.util.Objects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import enums.execution;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.configReader;

public final class Driver {

    private static WebDriver driver;
    private static execution executionType;

    private Driver() {

    }

    public static void initDriver(String browser) throws Exception {

        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                createDriver(browser);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void createDriver(String browser) throws Exception {

        executionType = execution.valueOfLabel(configReader.getValue("executionmode"));
        switch (executionType) {
            case LOCAL_ENV:
                createLocalDriver(browser);
                break;
            case REMOTE_ENV:

                createRemoteDriver(browser);

                break;
            default:
                System.out.println("please provide correct environment");
                break;
        }

    }

    private static void createLocalDriver(String browser) throws Exception {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                // System.setProperty("webdriver.chrome.driver",
                // FrameworkConstants.getChromedriverpath());
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                System.out.println("Invalid browser passed :" + browser);
                break;
        }
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().deleteAllCookies();
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(configReader.getValue("url"));
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    private static void createRemoteDriver(String browser) {
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
