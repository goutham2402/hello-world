package com.DDFW;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class FB_Login {

	static WebDriver driver;

	public static void main(String[] args) throws BiffException, IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gowtham\\Desktop\\Selenium\\chromedriver.exe");
		String filepath = "C:\\Users\\gowtham\\eclipse-workspace\\selenium test\\Test Data\\FB_Test Data.xls";
		// To get data from excel to eclipse
		FileInputStream fi = new FileInputStream(filepath);
		// To find workbook
		Workbook w = Workbook.getWorkbook(fi);
		// To get the data from the sheet
		Sheet s = w.getSheet("Sheet1");

		driver = new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.id(s.getCell(4, 2).getContents())).sendKeys(s.getCell(5, 2).getContents());
		driver.findElement(By.id(s.getCell(4, 3).getContents())).sendKeys(s.getCell(5, 3).getContents());
		driver.findElement(By.id(s.getCell(4, 4).getContents())).click();

	}

}
