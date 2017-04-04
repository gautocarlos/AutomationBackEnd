package test.selenium.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gedo.api.qa.Constantes;

public class SeleniumUtilitario implements Constantes {

	private WebDriver driver;

	public SeleniumUtilitario(WebDriver driver) {
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
	 */
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

	/**
	 * @param xpath
	 *            recibe un xpath y realiza click sobre el mismo
	 */
	public void clickByXPath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	/**
	 * @param xpath
	 * @param DatoEntrada
	 *            recibe un xpath y en posterior envia al elemento DatoEntrada
	 */
	public void sendKeysByXPath(String xpath, String DatoEntrada) {
		driver.findElement(By.xpath(xpath)).sendKeys(DatoEntrada);
	}
	

	/**
	 * @param xpath
	 *            xpath del elemento a realizar click
	 * @param indice
	 *            se utiliza para el caso en el que con el mismo xpath relativo
	 *            se obtiene más de un elemento, se realiza click sobre el
	 *            elemento pasado por parámetro
	 * @throws Exception
	 *             "El índice recibido tiene que ser mayor o igual a 0"
	 */
	public void clickByXPath(String xpath, int indice) throws Exception {
		try {
			getWait();
			List<WebElement> elementos = driver.findElements(By.xpath(xpath));
			int cantidadElementos = elementos.size();
			// validar por el límite máximo
			if ((indice >= 0) && (cantidadElementos > 0) && (cantidadElementos > indice)) {
				elementos.get(indice).click();
				// return elementos.get(indice);
			} else {
				throw new Exception("El índice: " + indice + " recibido es menor a 0 o la cantidad de elementos: "
						+ cantidadElementos + " retornados para el xpath: " + xpath + " es 0");
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
