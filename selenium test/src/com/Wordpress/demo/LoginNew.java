package com.Wordpress.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginNew {
	WebDriver driver;

	public LoginNew(WebDriver ldriver)

	{
		this.driver = ldriver;
	}
	
	@FindBy(id = "user_login")
	@CacheLookup
	WebElement username;

	@FindBy(how = How.ID, using = "user_pass")
	@CacheLookup
	WebElement password;

	@FindBy(how = How.XPATH, using = ".//*[@id='wp-submit']")
	@CacheLookup
	WebElement login_button;

	public void login_wordpress(String uid, String passwd) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		username.sendKeys(uid);
		password.sendKeys(passwd);
		login_button.click();
	}

}
