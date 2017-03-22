package gedo.api.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.selenium.util.CapturarPantalla;
import test.selenium.util.SeleniumWait;

/***
 * @autor Carlos Gauto
 **/
public abstract class Documento implements Constantes {

	private WebDriver driver;
	private SeleniumWait espera;
	private CapturarPantalla capturarPantalla;
	private String rutaCapturasDePantalla;

	/***
	 * @param driver
	 *            - Se trata del driver de Selenium propiamente dicho
	 * @param rutaArchivosEntrada
	 *            - Ruta donde se dejan los archivos de entrada por ejemplo:
	 *            archivos para un documento importado o de trabajo entre otros
	 * @param patron
	 *            - Se utiliza para setear un prefijo para los archivos de
	 *            capturas de pantalla.
	 * @see
	 * 
	 * 		TODO Eliminar los parámetros ya que se tratan de constantes que se
	 *      conocen ya en la clase Documento, con lo cual carece de sentido que
	 *      quién utilice tenga que pasar este dato
	 **/
	public Documento(WebDriver driver, String rutaArchivosEntrada, String patron) {
		// inicializarDriver();
		setDriver(driver);
		setEspera(new SeleniumWait(getDriver()));
		setCapturarPantalla(new CapturarPantalla(getDriver(), rutaArchivosEntrada, patron));
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
	 * @throws Exception
	 * 
	 */
	public void inicioDocumento() throws Exception {
		getEspera().waitElementByXpath(INICIODOCUMENTO);
		clickByXPath(INICIODOCUMENTO);
	}

	/**
	 * @param documentoElectronico
	 * @param acronimoGEDO
	 * @throws Exception
	 */
	public void iniciarProduccionDeDocumento(String documentoElectronico, String acronimoGEDO) throws Exception {
		getEspera().waitElementByXpath(documentoElectronico);
		getDriver().findElement(By.xpath(documentoElectronico)).clear();
		getDriver().findElement(By.xpath(documentoElectronico)).sendKeys(acronimoGEDO);
	}

	/**
	 * 
	 */
	public void producirloYoMismo() {
		clickByXPath(PRODUCIRLOYOMISMO);
	}

	/**
	 * @throws Exception
	 * 
	 */
	public void enviarAProducirUsuarioMismaReparticion() throws Exception {
		clickByXPath(ENVIARAPRODUCIR);
		validarProcesoDeProduccion();
		getCapturarPantalla().capturarPantalla();
	}

	public void enviarAProducirUsuarioDistintaReparticionAceptar() throws Exception {
		clickByXPath(ENVIARAPRODUCIR);
		aceptarMensajeUsuarioDistintaReparticion();
		validarProcesoDeProduccion();
		getCapturarPantalla().capturarPantalla();
	}

	private void validarProcesoDeProduccion() throws Exception {
		try {
			getEspera().waitElementByXpath(PROCESOPRODUCCION);
			clickByXPath(TDMSJBOXOK);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void enviarAProducirUsuarioDistintaReparticionRechazar() throws Exception {
		clickByXPath(ENVIARAPRODUCIR);
		noAceptarMensajeUsuarioDistintaReparticion();
	}

	private void aceptarMensajeUsuarioDistintaReparticion() throws Exception {
		getEspera().waitElementByXpath(DISTINTAREPASI);
		getCapturarPantalla().capturarPantalla();
		clickByXPath(DISTINTAREPASI);
	}

	private void noAceptarMensajeUsuarioDistintaReparticion() throws Exception {
		getEspera().waitElementByXpath(DISTINTAREPANO);
		getCapturarPantalla().capturarPantalla();
		clickByXPath(DISTINTAREPANO);
	}

	/**
	 * 
	 */
	public void firmarYoMismo() {
		clickByXPath(FIRMARYOMISMO);
	}

	/**
	 * 
	 */
	public void firmarConCertificado() {
		clickByXPath(FIRMARCONCERTIFICADO);
	}

	/**
	 * 
	 */
	public void volverAlBuzonDeTareas() {
		clickByXPath(VOLVERALBUZONDETAREAS);
	}

	/**
	 * Presiona el botón de la funcionalidad enviar a revisar
	 */
	public void enviarARevisar() {
		clickByXPath(ENVIARAREVISAR);
	}

	public void completarRevisorMensaje(String revisor, String mensaje) throws Exception {
		String campoRevisor = "//tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td[5]/i/input";
		// String usuarioSeleccionado = "//td[contains(text(),'NRuby ARuby')]";
		// "//div[6]/table/tbody/tr/td[2]";
		String usuarioSeleccionado = "td.z-comboitem-text";
		getEspera().waitElementByXpath(campoRevisor);
		getDriver().findElement(By.xpath(campoRevisor)).clear();
		getDriver().findElement(By.xpath(campoRevisor)).sendKeys("");
		getDriver().findElement(By.xpath(campoRevisor)).sendKeys(revisor);
		getEspera().getWait();
		getCapturarPantalla().capturarPantalla();
		getDriver().findElement(By.cssSelector(usuarioSeleccionado)).click();
		getDriver().findElement(By.xpath("//td/textarea")).clear();
		getDriver().findElement(By.xpath("//td/textarea")).sendKeys(mensaje);
		getCapturarPantalla().capturarPantalla();
		getEspera().waitElementByXpath(BOTONACEPTAR);
		clickByXPath(BOTONACEPTAR);
		getEspera().getWait();
		// getCapturarPantalla().capturarPantalla();
	}

	/**
	 * @param xpath
	 */
	private void clickByXPath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void completarReferencia(String textoReferencia) throws Exception {
		getEspera().waitElementByXpath(CAMPOREFERENCIA);
		getDriver().findElement(By.xpath(CAMPOREFERENCIA)).clear();
		getDriver().findElement(By.xpath(CAMPOREFERENCIA)).sendKeys(textoReferencia);
	}

	/**
	 * @param usuarioProductor
	 *            - Se trata del nombre y apellido exacto de un usuario GDE
	 *            válido para producir el documento.
	 * @param mensajeParaProductor
	 *            - Se trata de un mensaje a enviar al productor de la tarea.
	 */
	public void enviarAProducirTareaUsuario(String usuarioProductor, String mensajeParaProductor) {
		driver.findElement(By.xpath("//textarea")).clear();
		driver.findElement(By.xpath("//textarea")).sendKeys(mensajeParaProductor);
		driver.findElement(By.xpath("//div/i/input")).clear();
		driver.findElement(By.xpath("//div/i/input")).sendKeys("");
		driver.findElement(By.xpath("//div/i/input")).sendKeys(usuarioProductor);
		driver.findElement(By.xpath("//body/div[4]/table/tbody/tr/td[2]")).click();
	}
}
