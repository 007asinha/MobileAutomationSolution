package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utilities.Helpers;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AmazonSearchResultsPage {
	
	//Page Object Model
	AndroidDriver<AndroidElement> driver;
	FileInputStream fis;
	Properties properties=new Properties();
	
	public AmazonSearchResultsPage(AndroidDriver<AndroidElement> driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	//Locators are declared in the respective pages
	By item=By.xpath("//android.widget.TextView[@text='Sony A8H 65 Inch TV: BRAVIA OLED 4K Ultra HD Smart TV with HDR and Alexa Compatibility - 2020 Model (XBR65A8H)']");
	
	
	//Operations specific to the page
	public void selectItem() throws InterruptedException, IOException
	{
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\AmazonMobFramework\\MobileTestFramework\\externalData.properties");
		//Reading data from external source - Property File
		properties.load(fis);	
		
		Thread.sleep(3000L);
		Helpers.scrollAndClick(driver, (String) properties.get("TVDetails"),true);
		Thread.sleep(3000L);
	}
	
	
	
	
}



