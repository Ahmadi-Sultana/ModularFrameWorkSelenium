package com.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginTests extends BaseTests {

	@Parameters({ "username", "userPassword" })
	@Test
	public void verifyUserLoginWithCorrectCredentials(String userName, String password) {
		reportUtils.createATestCase("verify User Login With Correct Credentials");
		reportUtils.addTestLog(Status.INFO, "Started test verifyUserLoginWithCorrectCredentials");
		loginPage.loginToApplication(userName, password);
		String expectedTitle = "Guru99 Bank Manager Home Page";
		String actualTitle = commonDriver.getTitle(webDriver);
		reportUtils.addTestLog(Status.INFO, "comparing auctual and expected title");
		Assert.assertEquals(actualTitle, expectedTitle);

	}

}
