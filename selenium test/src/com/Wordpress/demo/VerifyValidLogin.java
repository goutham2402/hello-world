package com.Wordpress.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import helper.BrowserFactory;

public class VerifyValidLogin {

	@Test
	public void CheckValidUser()
	{
		//To launch browser
		WebDriver driver=BrowserFactory.startBrowser("chrome", "http://demosite.center/wordpress/wp-login.php");
		
		//created page object using pageFactory
		LoginNew login_page=PageFactory.initElements(driver, LoginNew.class);
		
		//call the method
		login_page.login_wordpress("admin","demo123");
	
	}
}
