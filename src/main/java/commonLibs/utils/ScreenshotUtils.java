package commonLibs.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	
	TakesScreenshot takeScreenshots;
	
	public ScreenshotUtils(WebDriver webDriver) {
		takeScreenshots = (TakesScreenshot) webDriver;
	}
	
	public void captureAndSaveScreens0hot(String fileName) throws Exception {
		fileName = fileName.trim();
		File imgFile, tempFile;
		imgFile = new File(fileName);
		if(imgFile.exists()) {
			throw new Exception("File already exists");
		}
		tempFile = takeScreenshots.getScreenshotAs(OutputType.FILE);
		FileUtils.moveFile(tempFile, imgFile);
	}

}
