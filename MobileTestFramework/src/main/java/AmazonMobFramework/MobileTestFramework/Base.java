package AmazonMobFramework.MobileTestFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.ServerSocket;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement>  driver;

	//Method to start the Appium server on 4723
	public AppiumDriverLocalService startServer()
	{
		boolean flag=	checkIfServerIsRunnning(4723);
		if(!flag)
		{
			service=AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;

	}
	
	//Returns true if the service port is already in use
	public static boolean checkIfServerIsRunnning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	//Emulator is launched everytime a new TEST is executed
	public static void startEmulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
		Thread.sleep(6000);
	}

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\AmazonMobFramework\\MobileTestFramework\\global.properties");

		//Using external source to read data
		Properties properties=new Properties();

		properties.load(fis);
		File f=new File("src");
		File fs= new File(f,(String) properties.get(appName));
		String device=(String) properties.get("device");
		if(device.contains("emulator")){
			//Emulator is only launched when the device name has a substring as emulator
			startEmulator();
		}
		//Setting Up driver capabilities
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 400);

		//Local port on which appium server is running 
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);

		//declaring an Implicit timeout to the entire scope of Android Driver
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	
//Generic method to take screenshots
	public static void getScreenshot(String s) throws IOException
	{
	File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//Name of the PNG file will always be the method name which failed
	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
	
	}
}
