package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import Utilities.WaitHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AmazonHomePage {

	//Page Object Model
	AndroidDriver<AndroidElement> driver;
	FileInputStream fis;
	Properties properties=new Properties();

	public AmazonHomePage(AndroidDriver<AndroidElement> driver) {

		this.driver=driver;
	}

	//Locators are declared in the respective pages
	By searchItem=By.xpath("//android.widget.EditText[@resource-id='com.amazon.mShop.android.shopping:id/rs_search_src_text']");

	//Operations specific to the page
	public void enterItemAndSearch() throws InterruptedException, IOException
	{
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\AmazonMobFramework\\MobileTestFramework\\externalData.properties");
		
		//Reading data from external source - Property File
		properties.load(fis);	
		
		WaitHelper.waitForElementPresence(driver, searchItem);
		driver.findElement(searchItem).click();
		WaitHelper.waitForClick(driver, searchItem);
		driver.findElement(searchItem).sendKeys((String) properties.get("SearchItem"));
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}




}



