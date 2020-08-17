package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.WaitHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
	//Page Object Model
	AndroidDriver driver;
	WebDriverWait wait;
	FileInputStream fis;
	Properties properties=new Properties();
	
	
	public LoginPage(AndroidDriver<AndroidElement> driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	//Locators are declared in the respective pages
	By usernameInput= By.xpath("//android.widget.EditText[@resource-id='ap_email_login']");
	By continueButton= By.xpath("//android.widget.Button[@resource-id='continue']");
	

	//Operations specific to the page
	public void enterUsername() throws InterruptedException, IOException
	{
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\AmazonMobFramework\\MobileTestFramework\\credentials.properties");
		//Reading data from external source - Property File
		properties.load(fis);
		WaitHelper.waitForClick(driver, usernameInput);
		driver.findElement(usernameInput).sendKeys((String) properties.get("username"));
		driver.findElement(continueButton).click();
		wait=new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@resource-id='ap_password']")));
	}
	
	By passwordInput= By.xpath("//android.widget.EditText[@resource-id='ap_password']");
	By signInButton= By.xpath("//android.widget.Button[@resource-id='signInSubmit']");
		
		
	public void login() throws InterruptedException
	{
		driver.findElement(passwordInput).sendKeys((String) properties.get("password"));
		driver.findElement(signInButton).click();
	}
	
}



