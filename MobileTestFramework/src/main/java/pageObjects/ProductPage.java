package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utilities.Helpers;
import Utilities.WaitHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage {
	
	//Page Object Model
	AndroidDriver<AndroidElement> driver;
	String name;
	String price;
	String description;
	ArrayList<String> productPageDetails=new ArrayList<String>();
	public ProductPage(AndroidDriver<AndroidElement> driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	//Locators are declared in the respective pages
	By item=By.xpath("//android.view.View[@resource-id='title_feature_div']/android.view.View");
	By nameText=By.xpath("//android.view.View[@resource-id='title_feature_div']/android.view.View");
	By priceText=By.xpath("//android.view.View[@resource-id='newPitchPriceWrapper_feature_div']/android.view.View/android.view.View[2]");
	By addToCartButton=By.xpath("//android.widget.Button[@resource-id='add-to-cart-button']");
	By goToCartButton=By.xpath("//com.amazon.mShop.android.shopping[@resource-id='com.amazon.mShop.android.shopping:id/action_bar_cart_image']");
	
	
	//Operations specific to the page
	public void AddToCart() throws InterruptedException
	{
		WaitHelper.waitForElementPresence(driver, nameText);
		productPageDetails.add(driver.findElement(nameText).getText());
		Helpers.scrollAndClick(driver, "Add to Cart",false);
		productPageDetails.add("$".concat(driver.findElement(priceText).getText()));
		//Helpers.scrollAndClick(driver, "Add to Cart",true);
		Thread.sleep(2000L);
		driver.findElement(addToCartButton).click();
		Helpers.dismissSuggestions(driver, "No Thanks");
		Thread.sleep(2000L);
		driver.findElement(goToCartButton).click();
				
	}
	
	public ArrayList<String> getProductPageDetails(){
		return productPageDetails;
	}
	
	
}



