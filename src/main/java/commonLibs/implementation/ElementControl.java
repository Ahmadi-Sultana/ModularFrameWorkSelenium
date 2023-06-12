package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementControl {
	WebDriver webDriver;

	public ElementControl(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void clickElement(WebElement webElement) {
		webElement.click();
	}

	public void clearElement(WebElement webElement) {
		webElement.clear();
	}

	public void setKeys(WebElement webElement, String inputData) {
		webElement.sendKeys(inputData);
	}

	public Boolean isEnabled(WebElement webElement) {
		return webElement.isEnabled();
	}

	public Boolean isDisplayed(WebElement webElement) {
		return webElement.isDisplayed();
	}

	public Boolean isSeleceted(WebElement webElement) {
		return webElement.isSelected();
	}

	public void acceptAlert() {
		webDriver.switchTo().alert().accept();
	}
	
	public String getTextFromAlert() {
		return webDriver.switchTo().alert().getText();
	}
	
	public void selectViaVisibleText(WebElement webElement, String visibleText) {
		Select select = new Select(webElement);
		select.selectByVisibleText(visibleText);
	}
}
