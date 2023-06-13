package com.guru99.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.guru99.pages.LoginPage;

import commonLibs.implementation.CommonDriver;
import commonLibs.utils.CofigUtils;
import commonLibs.utils.ReportUtils;
import commonLibs.utils.ScreenshotUtils;

public class BaseTests {

	CommonDriver commonDriver;
	String url = "https://demo.guru99.com/v4";
	WebDriver webDriver;
	LoginPage loginPage;

	String currentWorkingDirectory;
	String configFileName;
	Properties configProperties;
	String reportFileName;
	ReportUtils reportUtils;
	ScreenshotUtils screenshotUtils;

	@BeforeSuite
	public void preSetup() throws IOException {
		currentWorkingDirectory = System.getProperty("user.dir");
		configFileName = currentWorkingDirectory + "/config/config.properties";
		configProperties = CofigUtils.readProperties(configFileName);

		reportFileName = currentWorkingDirectory + "/reports/guru99TestRports.html";
		currentWorkingDirectory = System.getProperty("user.dir");
		reportUtils = new ReportUtils(reportFileName);

	}

	@BeforeClass
	public void setup() throws Exception {
		url = configProperties.getProperty("baseUrl");
		commonDriver = new CommonDriver(configProperties.getProperty("browserType"));
		this.webDriver = commonDriver.getWebDriver();
		loginPage = new LoginPage(webDriver);
		screenshotUtils = new ScreenshotUtils(webDriver);
		commonDriver.navigateToUrl(this.url);
	}

	@AfterMethod
	public void postTestAction(ITestResult itTestResults) throws Exception {
		String testCaseName = itTestResults.getName();
		long executionTime = System.currentTimeMillis();
		String screenshotFileName = currentWorkingDirectory + "/screenshots/" + testCaseName + executionTime + ".jpeg";
		if (itTestResults.getStatus() == ITestResult.FAILURE) {
			reportUtils.addTestLog(Status.FAIL, "Test case failed " + testCaseName);
			screenshotUtils.captureAndSaveScreens0hot(screenshotFileName);
			reportUtils.attachScreenshotToReport(screenshotFileName);
		}
	}

	@AfterClass
	public void testDown() {
		commonDriver.closeAllBrowser();
	}

	@AfterSuite
	public void postTeardown() {
		reportUtils.flushReports();
	}
}
