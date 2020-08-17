package Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

//User-defined re-usable function to achieve Abstraction and re-usability
public class Helpers {

	//User-defined method to scroll to view and-or click
	public static void scrollAndClick(AndroidDriver<AndroidElement> androidDriver, String visibleText, boolean click) {
		if(click)
			androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
		else
			androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))");
			
		
	}
	//User-defined method to dismiss suggestions	
	public static void dismissSuggestions(AndroidDriver<AndroidElement> androidDriver, String text){
		if(androidDriver.findElementsByAndroidUIAutomator("text(\""+text+"\")").size()==1){
			androidDriver.findElementByAndroidUIAutomator("text(\""+text+"\")").click();
						
		}else
			return;
	}


}
