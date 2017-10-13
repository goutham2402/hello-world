package com.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ObjectRepository.RegistrationObj;
import com.StaticFunctions.CommonFunctions;
import com.StaticFunctions.StaticVariables;



public class Sregist extends StaticVariables {
	CommonFunctions cfn = new CommonFunctions();
	RegistrationObj rg = new RegistrationObj();
	
	@Test
	public void f() throws InterruptedException, IOException
	{
		//Sregist_positive ();
		Sregist_negative();
	}
	
	@SuppressWarnings("static-access")
	public void Sregist_positive () throws InterruptedException, IOException {

		File src = new File(
				"C:\\Users\\gowtham\\eclipse-workspace\\Selenium_Framework\\src\\com\\InputData\\Registration.properties");
		FileInputStream fi = new FileInputStream(src);
		Properties props = new Properties();
		props.load(fi);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gowtham\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.shaadi.com/");
		driver.findElement(By.className("member_login")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("regi_free_link")).click();
		Thread.sleep(3000);

		cfn.EnterTextByID(rg.Id_Email, props.getProperty("Email"));

		cfn.EnterTextByID(rg.Id_Password, props.getProperty("Password"));
		driver.findElement(By.xpath(".//*[@id='s2id_layer_postedby']/a/span[2]/b")).click();
		driver.findElement(By.xpath(".//*[@id='select2-drop']/ul/li[2]/div")).click();
		driver.findElement(By.id("layer_gender-Male")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(3000);

		cfn.EnterTextByID(rg.Id_fn, props.getProperty("FirstName"));

		cfn.EnterTextByID(rg.Id_ln, props.getProperty("LastName"));
		driver.findElement(By.xpath(".//*[@id='s2id_layer_community']/a/span[2]/b")).click();
		driver.findElement(By.xpath(".//*[@id='select2-drop']/ul/li[10]/div")).click();
	}
	
	public void Sregist_negative () throws InterruptedException, IOException {

		File src = new File(
				"C:\\Users\\gowtham\\eclipse-workspace\\Selenium_Framework\\src\\com\\InputData\\Registration.properties");
		FileInputStream fi = new FileInputStream(src);
		Properties props = new Properties();
		props.load(fi);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gowtham\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.shaadi.com/"); 
		driver.findElement(By.className("member_login")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("regi_free_link")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(3000);
		//Error message validation
		cfn.AssertByXpath(rg.Xp_Email_ErrMsg,props.getProperty("Email_ErrMsg"));
		
		
		
	}
}
