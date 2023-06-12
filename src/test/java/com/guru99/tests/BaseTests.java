package com.guru99.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import commonLibs.implementation.commonDriver;

public class BaseTests {

	commonDriver commonDriver;
	String url = "demo.guru99.com/v4";
	WebDriver webDriver;
	
	@BeforeClass
	public void setup() throws Exception {
		commonDriver = new commonDriver("chrome");
//		webDriver = commonDriver.getWe

		commonDriver.navigateToUrl(url);
	}
	
	@AfterClass
	public void testDown() {
		commonDriver.closeAllBrowser();
	}
}
