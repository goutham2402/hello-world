package seleniumbasic;

//import java.io.*;
import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.apache.commons.io.FileUtils;

public class Spicejet {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gowtham\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.spicejet.com/");

		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		//Thread.sleep(3000);
		Explicitwait1(driver,".//*[@id='dropdownGroup1']/div/ul[2]/li[1]/a");
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
		driver.switchTo().window("converter");
		Thread.sleep(4000);
		new Select(driver.findElement(By.id("CurrencyConverterCurrencyConverterView_DropDownListBaseCurrency")))
				.selectByVisibleText("UAE Dirham(AED)");
		Thread.sleep(3000);
		new Select(driver.findElement(By.id("CurrencyConverterCurrencyConverterView_DropDownListConversionCurrency")))
				.selectByVisibleText("Indian Rupee(INR)");
		Thread.sleep(3000);
		driver.findElement(By.id("CurrencyConverterCurrencyConverterView_TextBoxAmount")).sendKeys("200");
		Thread.sleep(2000);
		driver.findElement(By.id("CurrencyConverterCurrencyConverterView_ButtonConvert")).click();
		Thread.sleep(5000);
		String element = driver.findElement(By.id("converterResults")).getText();
		System.out.println(element);

		// driver.close();

		/*
		 * driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1")).
		 * click(); driver.findElement(By.cssSelector("input.select_CTXT")).click();
		 * driver.findElement(By.cssSelector("a[value='DEL']")).click();
		 */

	}

	public static void Explicitwait1(WebDriver driver, String text) {
		WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(text)));
		boolean status =element.isDisplayed();
		if(status)
		{
			System.out.println("Element is visible");
		}
		else
		{
			System.out.println("Element is not visible");
		}
	}

}
