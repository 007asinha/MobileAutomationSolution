package AmazonMobFramework.MobileTestFramework;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DriverOrientationHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
import pageObjects.AmazonHomePage;
import pageObjects.AmazonLauncherPage;
import pageObjects.AmazonSearchResultsPage;
import pageObjects.FinalCartPage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

public class ShoppingE2ESpec extends Base {
	AndroidDriver<AndroidElement> driver;
	AmazonLauncherPage amazonLauncherPage;
	LoginPage loginPage;
	AmazonHomePage amazonHomePage;
	AmazonSearchResultsPage amazonSearchResultsPage;
	ProductPage productPage;
	FinalCartPage finalCartPage;

	@BeforeTest
	public void initSetup() throws IOException, InterruptedException
	{
		//Killing all the processes on the port so that null pointer Exception in not thrown 
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		service=startServer();
		driver=capabilities("AmazonApp");
		amazonLauncherPage=new AmazonLauncherPage(driver);
		loginPage=new LoginPage(driver);
		amazonHomePage=new AmazonHomePage(driver);
		amazonSearchResultsPage=new AmazonSearchResultsPage(driver);
		productPage=new ProductPage(driver);
		finalCartPage=new FinalCartPage(driver);

	}

	@Test(dataProvider="ScreenRotation")
	public void shopSuitcase(String screenRotation) throws InterruptedException, IOException
	{
		//determine screen orientation
		DriverOrientationHelper.rotate(driver,screenRotation);
		//Step by step test scenario execution 
		amazonLauncherPage.gotoSignInpage();
		loginPage.enterUsername();
		loginPage.login();
		amazonHomePage.enterItemAndSearch();
		amazonSearchResultsPage.selectItem();
		productPage.AddToCart();
		Thread.sleep(5000L);
		finalCartPage.checkoutItem();
		Assert.assertEquals(productPage.getProductPageDetails(), finalCartPage.getCartPageDetails());
	}

	@AfterTest
	public void tearDown()
	{
		//Stopping the appium server at the end of the test
		service.stop();
	}

	//DataProvider is used to run the test twice , once in PORTRAIT and the next time in LANDSCAPE mode.
	@DataProvider(name="ScreenRotation")
	public Object[][] getScreenRotationType(){
		return new Object[][] {
			{ "PORTRAIT" },
			{ "LANDSCAPE" }
		};
	}

}