package com.TestNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class FB_Login {
	static WebDriver driver;

	@Test
  public void f() throws Exception {
	  
	  File fi= new File("C:\\\\Users\\\\gowtham\\\\eclipse-workspace\\\\selenium test\\\\src\\\\com\\\\TestNg\\\\FB_Login.properties");
	  FileInputStream f1 = new FileInputStream(fi);
	  Properties props =  new Properties();
	  props.load(f1);
	  
	  if (props.getProperty("Borwser").equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\gowtham\\Desktop\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (props.getProperty("Borwser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", 
					"C:\\Users\\gowtham\\Desktop\\Selenium\\IEDriverServer.exe");
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability("ignoreZoomSetting", true);
			ieCapabilities.setCapability("nativeEvents", false);
			driver = new InternetExplorerDriver(ieCapabilities);
		}
	  
	  driver.get(props.getProperty("URL"));
	  takeScreenshot("fb");
	  driver.findElement(By.id("email")).sendKeys(props.getProperty("Email"));
	  driver.findElement(By.id("pass")).sendKeys(props.getProperty("Password"));
	  //driver.findElement(By.id("u_0_r")).click();
	  
	  
  }
	
	public static String TimestampString()
	{
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return timestamp;
	}
	public void takeScreenshot(String Name) throws IOException, Exception
	{
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(srcFile, new File("C:\\Users\\gowtham\\eclipse-workspace\\selenium test\\Screenshots" + Name + TimestampString() + ".png"));
			
		}
		catch(IOException e)
		{
			e.getStackTrace();
		}
		
	}

}
