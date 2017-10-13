package com.TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class dynamicXpath {
	WebDriver driver;
	
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\gowtham\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("gmail@gmail.com");;
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
  }
}
