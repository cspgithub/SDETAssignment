package driver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                driver = new ChromeDriver(options);
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

    private static void createRemoteDriver(String browser) throws MalformedURLException, Exception {

        DesiredCapabilities capability = new DesiredCapabilities();

        switch (browser) {
            case "chrome":
                capability.setBrowserName("chrome");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--remote-debugin-port=9222");
                System.out.println(options.getBrowserName());

                capability.merge(options);
                break;

            case "firefox":

                capability.setBrowserName("firefox");
                FirefoxOptions foptions = new FirefoxOptions();
                foptions.setHeadless(true);
                System.out.println(foptions.getBrowserName());
                capability.merge(foptions);
                break;

            default:
                System.out.println("Invalid browser passed :" + browser);
                break;
        }
        capability.setPlatform(Platform.ANY);
        driver = new RemoteWebDriver(new URL(configReader.getValue("remoteurl")), capability);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().deleteAllCookies();
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        DriverManager.getDriver().get(configReader.getValue("url"));

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

    public static void setUpDocker() throws IOException, InterruptedException, Exception {
        if (configReader.getValue("executionmode").equalsIgnoreCase("remote")) {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("cmd /c start dockerUp.bat");
            Thread.sleep(90000);

        }

    }

    public static void closeDocker() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start dockerClose.bat");
        runtime.exec("taskkill /f /im cmd.exe");
    }

}
