package utilities;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

import constants.frameworkConstants;

public final class configReader {

    private configReader() {
        // so that no one can craete object of this class
    }

    public static String getValue(String keyName) throws Exception {

        String value = "";

        Properties prop = new Properties();
        FileInputStream fi = new FileInputStream(frameworkConstants.getConfigPath());
        prop.load(fi);
        value = prop.getProperty(keyName).trim();
        if (Objects.isNull(value)) {

            throw new Exception("property named : " + keyName + "  not found");

        }
        return value;
    }

}
