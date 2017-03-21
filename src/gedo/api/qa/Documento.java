package gedo.api.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.selenium.util.CapturarPantalla;
import test.selenium.util.SeleniumWait;

public abstract class Documento implements Constantes {

	private WebDriver driver;
	private SeleniumWait espera;
	private CapturarPantalla capturarPantalla;
	private String rutaCapturasDePantalla;

	public Documento(WebDriver driver, String rutaArchivosEntrada) {
		// inicializarDriver();
		setDriver(driver);
		setEspera(new SeleniumWait(getDriver()));
		setCapturarPantalla(new CapturarPantalla(getDriver(), rutaArchivosEntrada));
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public CapturarPantalla getCapturarPantalla() {
		return capturarPantalla;
	}

	public void setCapturarPantalla(CapturarPantalla capturarPantalla) {
		this.capturarPantalla = capturarPantalla;
	}

	public SeleniumWait getEspera() {
		return espera;
	}

	public void setEspera(SeleniumWait espera) {
		this.espera = espera;
	}

	public String getRutaCapturasDePantalla() {
		return rutaCapturasDePantalla;
	}

	public void setRutaCapturasDePantalla(String rutaCapturasDePantalla) {
		this.rutaCapturasDePantalla = rutaCapturasDePantalla;
	}

	/**
	 * @param inicioDocumento
	 */
	public void inicioDocumento(String inicioDocumento) {
		getEspera().waitElementByXpath(inicioDocumento);
		clickByXPath(inicioDocumento);
	}

	/**
	 * @param documentoElectronico
	 * @param acronimoGEDO
	 */
	public void iniciarProduccionDeDocumento(String documentoElectronico, String acronimoGEDO) {
		getEspera().waitElementByXpath(documentoElectronico);
		driver.findElement(By.xpath(documentoElectronico)).clear();
		driver.findElement(By.xpath(documentoElectronico)).sendKeys(acronimoGEDO);
	}

	/**
	 * @param producirloYoMismo
	 */
	public void producirloYoMismo(String producirloYoMismo) {
		clickByXPath(producirloYoMismo);
	}

	/**
	 * @param firmarYoMismo
	 */
	public void firmarYoMismo(String firmarYoMismo) {
		clickByXPath(firmarYoMismo);
	}

	/**
	 * @param firmarConCertificadoLibre
	 */
	public void firmarConCertificado(String firmarConCertificado) {
		clickByXPath(firmarConCertificado);
	}

	/**
	 * @param volverAlBuzonDeTareas
	 */
	public void volverAlBuzonDeTareas(String volverAlBuzonDeTareas) {
		clickByXPath(volverAlBuzonDeTareas);
	}

	/**
	 * @param xpath
	 */
	private void clickByXPath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void completarReferencia(String textoReferencia) {
		getEspera().waitElementByXpath(CAMPOREFERENCIA);
		getDriver().findElement(By.xpath(CAMPOREFERENCIA)).clear();
		getDriver().findElement(By.xpath(CAMPOREFERENCIA)).sendKeys(textoReferencia);
	}

//	public abstract void producirDocumento(String textoReferencia);
}
