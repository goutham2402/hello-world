package com.TestNg;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleWindows {
	static WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gowtham\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.in/");
		String parent = driver.getWindowHandle();
		System.out.println("parent WindowTitle is" + " " + parent);
		driver.findElement(By.xpath("//a[contains(@href,'http://www.google.com')]")).click();
		Set<String> allwindows = driver.getWindowHandles();
		for (String child : allwindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				System.out.println("Child title is " + " " + child);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[contains(@href,'https://mail.google.com/mail/?tab=wm')]")).click();
			}
		}
		System.out.println("Exited from for lopp");
		driver.switchTo().window(parent);
		String title= driver.getTitle();
		System.out.println(title);
		
		
	}
}
