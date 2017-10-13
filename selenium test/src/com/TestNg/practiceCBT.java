package com.TestNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterTest;

public class practiceCBT {

	static WebDriver driver;

	@Parameters("Browser")
	@Test
	public void A(String Browser) {

	try {
		if (Browser.equalsIgnoreCase("Chrome"))
		{
			
			driver = new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("phantomJs"))
		{
			File src = new File("E:\\softwares\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
			System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
			driver = new PhantomJSDriver();
		}
	}
	catch (WebDriverException e)
	{
		System.out.println(e.getMessage());
	}
		

	}
	@Test
	public void B() {
		driver.findElement(By.linkText("Gmail"));
		
	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {

		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@AfterTest
	public void afterTest() {
	}

}
