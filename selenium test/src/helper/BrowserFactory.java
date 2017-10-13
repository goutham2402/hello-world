package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\gowtham\\Desktop\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.navigate().to(url);
		return driver;
	}

}
