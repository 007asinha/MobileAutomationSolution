package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AmazonLauncherPage {
	//Page Object Model
	AndroidDriver<AndroidElement> driver;
	
	public AmazonLauncherPage(AndroidDriver<AndroidElement> driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	//Locators are declared in the respective pages
	By signInButton=By.id("com.amazon.mShop.android.shopping:id/sign_in_button");
	
	//Operations specific to the page
	public void gotoSignInpage()
	{
	
		driver.findElement(signInButton).click();
	}
	
	
	
	
}



