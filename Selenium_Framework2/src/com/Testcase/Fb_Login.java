package com.Testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ObjectRepository.Locaters;
import com.StaticFunctions.CommonFunctions;
import com.StaticFunctions.StaticVariables;

public class Fb_Login extends StaticVariables {

	static CommonFunctions cfn = new CommonFunctions();
	static Locaters loc = new Locaters();

	@Test
	public static void login() throws Exception {
		File src = new File(
				"C:\\Users\\gowtham\\eclipse-workspace\\Selenium_Framework2\\src\\com\\InputData\\Input.properties");
		FileInputStream fi = new FileInputStream(src);
		Properties prop = new Properties();
		prop.load(fi);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gowtham\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(prop.getProperty("URL"));
		cfn.takeScreenshot("fb");
		cfn.EnterEmailByID(loc.Id_Email, prop.getProperty("Email"));
		cfn.EnterEmailByID(loc.Id_Password, prop.getProperty("Password"));
		Thread.sleep(5000);
		driver.quit();

	}

}
