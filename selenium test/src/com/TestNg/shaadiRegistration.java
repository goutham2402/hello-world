package com.TestNg;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class shaadiRegistration {
	static WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gowtham\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.shaadi.com/");
		driver.findElement(By.className("member_login")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("regi_free_link")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("layer_email")).sendKeys("Test3654@gmail.com");
		driver.findElement(By.id("layer_password1")).sendKeys("548799");
		driver.findElement(By.xpath(".//*[@id='s2id_layer_postedby']/a/span[2]/b")).click();
		driver.findElement(By.xpath(".//*[@id='select2-drop']/ul/li[2]/div")).click();
		driver.findElement(By.id("layer_gender-Male")).click();
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("layer_first_name")).sendKeys("Test1");
		driver.findElement(By.id("layer_last_name")).sendKeys("Last1");
		driver.findElement(By.xpath(".//*[@id='s2id_layer_community']/a/span[2]/b")).click();
		driver.findElement(By.xpath(".//*[@id='select2-drop']/ul/li[10]/div")).click();

	}
}
