package com.StaticFunctions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.StaticFunctions.StaticVariables;

public class CommonFunctions extends StaticVariables {

	public static void EnterEmailByID(String LocaterName, String Inputdata) {
		driver.findElement(By.id(LocaterName)).sendKeys(Inputdata);
	}

	public static void EnterPwdById(String LocaterName, String Inputdata) {
		driver.findElement(By.id(LocaterName)).sendKeys(Inputdata);
	}
	public static String TimestampString()
	{
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return timestamp;
	}
	public void takeScreenshot(String Name) throws IOException, Exception
	{
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(srcFile, new File("C:\\Users\\gowtham\\eclipse-workspace\\selenium test\\Screenshots" + Name + TimestampString() + ".png"));
			
		}
		catch(IOException e)
		{
			e.getStackTrace();
		}
		
	}

}
