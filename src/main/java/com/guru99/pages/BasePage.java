package com.guru99.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.ElementControl;

public class BasePage {

	private WebDriver webDriver;
	public ElementControl elementControle;

	public BasePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		elementControle = new ElementControl(webDriver);
	}

}
