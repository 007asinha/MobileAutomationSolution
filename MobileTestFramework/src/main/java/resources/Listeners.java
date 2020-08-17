package resources;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import AmazonMobFramework.MobileTestFramework.Base;


public class Listeners implements ITestListener {

	public void onFinish(ITestContext arg0) {			
	}

	public void onStart(ITestContext arg0) {		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {				
	}

	//Method to take Screenshots dynamically On Test Failure & file name would be the test name 
	public void onTestFailure(ITestResult arg0) {
		String s=arg0.getName();
		try {
			Base.getScreenshot(s);
		} catch (IOException e) {

			e.printStackTrace();
		}		
	}

	public void onTestSkipped(ITestResult arg0) {		
	}

	public void onTestStart(ITestResult arg0) {		
	}

	public void onTestSuccess(ITestResult arg0) {		
	}

}