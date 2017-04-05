package test.selenium.util;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public abstract class DriverWeb{
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().window().maximize();
	}

//	/**
//	 * @param xpath
//	 */
//	public void clickByXPath(String xpath) {
//		driver.findElement(By.xpath(xpath)).click();
//	}

	public abstract WebDriver inicializar() throws Exception;
}
