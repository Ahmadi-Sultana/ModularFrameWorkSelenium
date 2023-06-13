package commonLibs.utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportUtils {
	ExtentHtmlReporter extentHtmlReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;
	
	public ReportUtils(String htmlReportFileName) {
		htmlReportFileName = htmlReportFileName.trim();
		extentHtmlReporter = new ExtentHtmlReporter(htmlReportFileName);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
	}
	
	public void createATestCase(String testCaseName) {
		extentTest = extentReports.createTest(testCaseName);
	}
	
	public void addTestLog(Status status, String comment) {
		extentTest.log(status, comment);
	}
	
	public void flushReports() {
		extentReports.flush();
	}
	
	public void attachScreenshotToReport(String fileName) throws IOException {
		extentTest.addScreenCaptureFromPath(fileName);
	}
}
