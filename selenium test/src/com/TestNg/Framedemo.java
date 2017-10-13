package com.TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Framedemo {

	static WebDriver driver;

	@Test
	public void testframes() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gowtham\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://way2automation.com/way2auto_jquery/frames-windows/frameset.html");
		int total= driver.findElements(By.tagName("frame")).size();
		System.out.println(total);
		driver.close();
		/*driver.manage().window().maximize();
		driver.switchTo().frame("topFrame");
		String text = driver.findElement(By.xpath("html/body/h2")).getText();
		System.out.println(text);
		driver.switchTo().defaultContent();
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();*/

	}
}
