package constants;

public final class frameworkConstants {

    // private constructor to restrict anyone to craete object of this class
    // make class as final so that no one can extend it
    private frameworkConstants() {

    }

    private static final String RESOURCE_PATH = System.getProperty("user.dir")
            + "/src/test/java/resources";
    private static final String BROW_URL = "https://www.google.com";
    private static final String CHROMEDRIVER_PATH = RESOURCE_PATH + "/chromeDriverExe/chromedriver.exe";
    private static final String CONFIGFILE_PATH = RESOURCE_PATH + "/config.properties";

    public static String getConfigPath() {
        return CONFIGFILE_PATH;
    }

    public static String getChromedriverPath() {
        return CHROMEDRIVER_PATH;
    }

    public static String getURL() {
        return BROW_URL;
    }

}
