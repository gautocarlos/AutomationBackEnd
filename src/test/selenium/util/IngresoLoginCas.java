package test.selenium.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IngresoLoginCas extends IngresoLogin {

	public IngresoLoginCas(WebDriver driver, String url, String usuario, String password) throws Exception {
		super(driver, url, usuario, password);
	}

	@Override
	public void login(String usuario, String password) throws Exception {
		WebDriver driver = getDriver();
		driver.findElement(By.xpath(CAMPOUSUARIOCAS)).clear();
		driver.findElement(By.xpath(CAMPOUSUARIOCAS)).sendKeys(usuario);
		driver.findElement(By.xpath(CAMPOPASSWORDCAS)).clear();
		driver.findElement(By.xpath(CAMPOPASSWORDCAS))
				.sendKeys(password);
		driver.findElement(By.xpath(CAMPOACCEDERCAS)).click();
		new SeleniumWait(driver).getWait();
	}

}
