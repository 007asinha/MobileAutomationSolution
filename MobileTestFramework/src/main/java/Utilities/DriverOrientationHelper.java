package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

//User-defined re-usable function to achieve Abstraction and re-usability
public class DriverOrientationHelper {
	public static void rotate(AndroidDriver<AndroidElement> androidDriver, String screenRotation){
		if(screenRotation.equalsIgnoreCase("LANDSCAPE")){
			androidDriver.rotate(ScreenOrientation.LANDSCAPE);
		}else if(screenRotation.equalsIgnoreCase("PORTRAIT")){
			androidDriver.rotate(ScreenOrientation.PORTRAIT);
		}

	}
}
