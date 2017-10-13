package com.TestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover {
	static WebDriver driver;

	@Test
	public void f() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gowtham\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-perform-mouse-hover-in-selenium.html");
		//storing mousehover element
		WebElement ele=driver.findElement(By.className("dropbtn"));
		Actions Mhover = new Actions(driver);
		//asking to wait for hover
		Mhover.moveToElement(ele).perform();
		//clicks on dropdown of hovered elements
		driver.findElement(By.linkText("Selenium")).click();
		driver.close();
		
		

	}
}
