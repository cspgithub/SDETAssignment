package reports;

import com.aventstack.extentreports.ExtentTest;

public class reportManager {


    private reportManager() {}
	
	public static ThreadLocal<ExtentTest> exTest= new ThreadLocal<ExtentTest>();
	

	static ExtentTest getExtTest() {//accseble to only packages
		return exTest.get();
	}

	static void setExtentTest(ExtentTest test) {
		exTest.set(test);
	}

	
	static void unloadExtentTest(ExtentTest test) {
		exTest.remove();
	}
    
}
