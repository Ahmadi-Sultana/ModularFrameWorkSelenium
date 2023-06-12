package commonLibs.implementation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class commonDriver {
	
	private WebDriver webDriver;
	private int pageLodeTimeOut;
	private int elementDetectionTimeout;
	private String url = "";

	public commonDriver(String browserType) throws Exception {
		pageLodeTimeOut = 10;
		elementDetectionTimeout = 10;

		if (browserType.equalsIgnoreCase("chrome")) {
			webDriver = WebDriverManager.chromedriver().create();
		} else if (browserType.equalsIgnoreCase("edge")) {
			webDriver = WebDriverManager.edgedriver().create();
		} else {
			throw new Exception("Invalid browser type " + browserType);
		}
		webDriver.manage().window().maximize();
		webDriver.manage().deleteAllCookies();
	}

	public void navigateToUrl(String url) {
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLodeTimeOut));
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementDetectionTimeout));
		webDriver.get(url);
	}
	
	public  void closeAllBrowser() {
		webDriver.quit();
	}

}
