package test.selenium.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SeleniumWait {

	private WebDriver driver;

	public SeleniumWait(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriver getDriver() {
		return driver;
	}

	/**
	 * Realiza una espera genérica de 3000ms.
	 */
	public void getWait() {
		try {
			System.out.println("Inicia espera.");
			Thread.sleep(3000);
			System.out.println("Finaliza espera.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param xpath
	 *            De un elemento html.
	 * @throws Exception
	 *             En caso de que no exista el elemento del xpath al 3 intento
	 *             de localización del mismo.
	 */
	public void waitElementByXpath(String xpath) throws Exception {
		for (int intentos = 1;; intentos++) {
			// Se reduce la espera de 60 3 intentos
			if (intentos > 3)
				throw new Exception("Timeout: NO apareció un elemento con xpath: " + xpath);
			try {
				if (isElementPresent(By.xpath(xpath))) {
					System.out.println("Existe el elemento con xpath: " + xpath);
					// break;
					return;
				}
				Thread.sleep(1000);
				System.out.println("Fin Espera: Intento: " + intentos);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	private boolean isElementPresent(By by) {
		try {
			getDriver().findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * @throws Exception 
	 * */
	public void waitElementById(String id) throws Exception {
		for (int intentos = 1;; intentos++) {
			// Se reduce la espera de 60 3 intentos
			if (intentos > 3)
				throw new Exception("Timeout: NO apareció un elemento con id: " + id);
			try {
				if (isElementPresent(By.id(id))) {
					System.out.println("Existe el elemento con id: " + id);
					// break;
					return;
				}
				Thread.sleep(1000);
				System.out.println("Fin Espera: Intento: " + intentos);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

}
