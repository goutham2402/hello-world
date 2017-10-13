package com.StaticFunctions;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.StaticFunctions.StaticVariables;

public class CommonFunctions extends StaticVariables {

	public static void EnterTextByID(String LocatorName, String InputData)

	{
		driver.findElement(By.id(LocatorName)).sendKeys(InputData);

	}

	public static void EnterTextByName(String LocatorName, String InputData)

	{
		driver.findElement(By.name(LocatorName)).sendKeys(InputData);

	}

	public static void EnterTextByxpath(String LocatorName, String InputData)

	{
		driver.findElement(By.xpath(LocatorName)).sendKeys(InputData);

	}

	public static void AssertByXpath(String LocatorName, String ExpectedStr) throws InterruptedException

	{
		String ElementText = driver.findElement(By.xpath(LocatorName)).getText();
		Assert.assertEquals(ElementText, ExpectedStr);
		Thread.sleep(3000);
		System.out.println(ElementText + "/t" + "Is the displayed Email Text");
	}

}
