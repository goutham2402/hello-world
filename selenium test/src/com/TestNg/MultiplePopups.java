package com.TestNg;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultiplePopups {
	static WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gowtham\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		String parent = driver.getWindowHandle();
		System.out.println("parent WindowTitle is" + " " + parent);
		Set<String> allwindows = driver.getWindowHandles();
		ArrayList<String> tabs=new ArrayList<>(allwindows);
		driver.switchTo().window(tabs.get(1));
		driver.close();
		driver.switchTo().window(tabs.get(2));
		driver.close();
		driver.switchTo().window(tabs.get(3));
		driver.close();
		driver.switchTo().window(tabs.get(0));
		System.out.println(driver.getTitle()); 
	}
}
