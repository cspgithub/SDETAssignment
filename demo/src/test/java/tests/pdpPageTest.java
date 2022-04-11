package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.pdpPage;

public class pdpPageTest extends baseTest {

    @DataProvider(name = "test-data")
    public Object[][] dataProvFunc() {
        return new Object[][] {
                { "facebook" }
        };
    }

    @Test(dataProvider = "test-data")
    public void verifySocial(String keyWord) throws Exception {

        pdpPage obj = new pdpPage();
        obj.socialshareLogic(keyWord);

    }
}
