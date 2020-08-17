package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

//User-defined re-usable function to achieve Abstraction and re-usability
public class WaitHelper {

	//User-defined method to wait for a non clickable element to ensure proper page rendering 
	public static void waitForElementPresence(AndroidDriver<AndroidElement> androidDriver, By element){
		WebDriverWait wait= new WebDriverWait(androidDriver, 30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
	}

	//User-defined method to wait for an clickable element
	public static void waitForClick(AndroidDriver<AndroidElement> androidDriver, By element){
		WebDriverWait wait= new WebDriverWait(androidDriver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
