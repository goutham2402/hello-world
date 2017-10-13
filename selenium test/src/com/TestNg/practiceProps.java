package com.TestNg;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class practiceProps {
	static WebDriver driver;

	@Test
	public void A() throws IOException, InterruptedException {

		File src = new File("C:\\Users\\gowtham\\eclipse-workspace\\selenium test\\src\\com\\TestNg\\Gmail.properties");

		FileInputStream fi = new FileInputStream(src);
		Properties props = new Properties();
		props.load(fi);

		try {
			if (props.getProperty("Browser").equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\gowtham\\Desktop\\Selenium\\chromedriver.exe");
				driver = new ChromeDriver();
			}
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}

		driver.get(props.getProperty("googleURL"));
		driver.manage().window().maximize();
		driver.findElement(By.linkText(props.getProperty("Link"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(props.getProperty("moreoptionsXpath"))).click();
		Thread.sleep(3000);
		driver.findElement(By.className(props.getProperty("createacc"))).click();

	}
}
