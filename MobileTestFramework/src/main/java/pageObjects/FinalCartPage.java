package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utilities.Helpers;
import Utilities.WaitHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FinalCartPage {
	
	//Page Object Model
	AndroidDriver<AndroidElement> driver;
	ArrayList<String> cartPageDetails=new ArrayList<String>();
	public FinalCartPage(AndroidDriver<AndroidElement> driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	//Locators are declared in the respective pages
	By productName=By.xpath("//android.view.View[contains(@resource-id,'sc-item')]/android.view.View[2]/android.view.View[1]/android.view.View[3]/android.view.View[1]");
	By priceText=By.xpath("//android.view.View/android.view.View");
	By checkout=By.xpath("//android.widget.Button[text='Proceed to checkout']");
		
	//Operations specific to the page
	public void checkoutItem() throws InterruptedException
	{
		WaitHelper.waitForElementPresence(driver, productName);
		cartPageDetails.add(driver.findElement(productName).getText());
		cartPageDetails.add(driver.findElement(priceText).getText());
		driver.findElement(checkout).click();
		Thread.sleep(3000L);
	}
	
	
	public ArrayList<String> getCartPageDetails(){
		return cartPageDetails;
	}
	
	
	
	
}



