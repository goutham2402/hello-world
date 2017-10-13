package com.TestNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Popup {
	static WebDriver driver;

	@Parameters({"Browser"})

	@BeforeTest

	public void beforeTest(String Browser) {
		try {
			if (Browser.equalsIgnoreCase("Chrome")) { 
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\gowtham\\Desktop\\Selenium\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (Browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", 
						"C:\\Users\\gowtham\\Desktop\\Selenium\\IEDriverServer.exe");
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				ieCapabilities.setCapability("ignoreZoomSetting", true);
				ieCapabilities.setCapability("nativeEvents", false);
				driver = new InternetExplorerDriver(ieCapabilities);
			}
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test

	public void f() throws InterruptedException {

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='dropdownGroup1']/div/ul[2]/li[1]/a")).click();
		Thread.sleep(5000); // To selection
		driver.findElement(By.linkText("Hyderabad (HYD)")).click();
		// new Select(driver.findElement(By.xpath(""))).selectByVisibleText("2 Adults");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[4]/a")).click();
		Thread.sleep(2500);
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		driver.findElement(By.linkText("Currency Converter")).click();
		Thread.sleep(3000);
		/*
		 * driver.switchTo().window("converter"); Thread.sleep(4000); new
		 * Select(driver.findElement(By.id(
		 * "CurrencyConverterCurrencyConverterView_DropDownListBaseCurrency")))
		 * .selectByVisibleText("UAE Dirham(AED)"); Thread.sleep(3000); new
		 * Select(driver.findElement(By.id(
		 * "CurrencyConverterCurrencyConverterView_DropDownListConversionCurrency")))
		 * .selectByVisibleText("Indian Rupee(INR)"); Thread.sleep(3000);
		 * driver.findElement(By.id(
		 * "CurrencyConverterCurrencyConverterView_TextBoxAmount")).sendKeys("200");
		 * Thread.sleep(2000); driver.findElement(By.id(
		 * "CurrencyConverterCurrencyConverterView_ButtonConvert")).click();
		 * Thread.sleep(5000); String element =
		 * driver.findElement(By.id("converterResults")).getText();
		 * System.out.println(element);
		 */

		// driver.close();

		/*
		 * driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1")).
		 * click(); driver.findElement(By.cssSelector("input.select_CTXT")).click();
		 * driver.findElement(By.cssSelector("a[value='DEL']")).click();
		 */

	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {

		driver = new ChromeDriver();
		driver.navigate().to("http://www.spicejet.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}