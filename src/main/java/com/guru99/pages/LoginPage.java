package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	@FindBy(name = "uid")
	WebElement userId;

	@FindBy(name = "password")
	WebElement userPassword;

	@FindBy(name = "btnLogin")
	WebElement loginBtn;

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	public void loginToApplication(String userName, String pasword) {
		elementControle.setKeys(userId, userName);
		elementControle.setKeys(userPassword, pasword);
		elementControle.clickElement(loginBtn);
	}
}
