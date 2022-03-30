package constants;

public final class frameworkConstants {


    //private constructor to restrict anyone to craete object of this class
    //make class as final so that no one can extend it
    private frameworkConstants() {

    }

    

    private static final String BROW_URL = "https://www.google.com";
    private static final String CHROMEDRIVER_PATH = System.getProperty("user.dir")+"/src/test/resources/chromeDriverExe/chromedriver.exe";
    
    public static String getChromedriverPath() {
        return CHROMEDRIVER_PATH;
    }
    
    public static String getURL() {
        return BROW_URL;
    }

}
