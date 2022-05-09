package reports;

import com.aventstack.extentreports.ExtentTest;

public final class reportManager {


    private reportManager() {}
	
	public static ThreadLocal<ExtentTest> exTest= new ThreadLocal<ExtentTest>();
	

	public static ExtentTest getExtTest() {//accseble to only packages
		return exTest.get();
	}

	public static void setExtentTest(ExtentTest test) {
		exTest.set(test);
	}

	
	public static void unloadExtentTest(ExtentTest test) {
		exTest.remove();
	}
    
}
