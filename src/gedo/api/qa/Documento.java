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

	/**
	 * Presiona el botón de la funcionalidad enviar a firmar
	 */
	public void enviarAFirmar() {
		clickByXPath(ENVIARAFIRMAR);
	}

	/**
	 * TODO - Renombrar método para que incluya la acción de presionar el botón
	 * de enviar a revisar
	 * 
	 * @see - Método: enviarAFirmarUsuarioMismaReparticion(String firmante)
	 * 
	 */
	public void completarRevisorMensaje(String revisor, String mensaje) throws Exception {
		getEspera().waitElementByXpath(CAMPOREVISOR);
		getDriver().findElement(By.xpath(CAMPOREVISOR)).clear();
		getDriver().findElement(By.xpath(CAMPOREVISOR)).sendKeys("");
		getDriver().findElement(By.xpath(CAMPOREVISOR)).sendKeys(revisor);
		getEspera().getWait();
		getCapturarPantalla().capturarPantalla();
		getDriver().findElement(By.cssSelector(TDZ_COMBOITEM_TEXT)).click();
		getDriver().findElement(By.xpath(TD_TEXTAREA)).clear();
		getDriver().findElement(By.xpath(TD_TEXTAREA)).sendKeys(mensaje);
		getCapturarPantalla().capturarPantalla();
		getEspera().waitElementByXpath(BOTONACEPTAR);
		clickByXPath(BOTONACEPTAR);
		getEspera().getWait();
		// getCapturarPantalla().capturarPantalla();
	}

	public void enviarAFirmarUsuarioMismaReparticion(String firmante) throws Exception {
		clickByXPath(ENVIARAFIRMAR);
		getEspera().waitElementByXpath(CAMPOFIRMANTE);
		getDriver().findElement(By.xpath(CAMPOFIRMANTE)).clear();
		getDriver().findElement(By.xpath(CAMPOFIRMANTE)).sendKeys("");
		getDriver().findElement(By.xpath(CAMPOFIRMANTE)).sendKeys(firmante);
		getEspera().getWait();
		getCapturarPantalla().capturarPantalla();
		getDriver().findElement(By.cssSelector(TDZ_COMBOITEM_TEXT)).click();
		getCapturarPantalla().capturarPantalla();
		getEspera().waitElementByXpath(BOTONACEPTAR);
		clickByXPath(BOTONACEPTAR);
		getEspera().getWait();
		// getCapturarPantalla().capturarPantalla();
	}

	public void enviarAFirmarUsuarioDistintaReparticion(String firmante) throws Exception {
		clickByXPath(ENVIARAFIRMAR);
		getEspera().waitElementByXpath(CAMPOFIRMANTE);
		getDriver().findElement(By.xpath(CAMPOFIRMANTE)).clear();
		getDriver().findElement(By.xpath(CAMPOFIRMANTE)).sendKeys("");
		getDriver().findElement(By.xpath(CAMPOFIRMANTE)).sendKeys(firmante);
		getEspera().getWait();
		getCapturarPantalla().capturarPantalla();
		getDriver().findElement(By.cssSelector(TDZ_COMBOITEM_TEXT)).click();
		getCapturarPantalla().capturarPantalla();
		getEspera().waitElementByXpath(BOTONACEPTAR);
		clickByXPath(BOTONACEPTAR);
		getEspera().getWait();
		aceptarMensajeUsuarioDistintaReparticion();
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
	 * @see - Esta lógica tiene un problema a resolver: Si existe más de un
	 *      usuario con el mismo nombre y apellido no podría distinguir entre
	 *      ambos
	 */
	public void enviarAProducirTareaUsuario(String usuarioProductor, String mensajeParaProductor) {
		driver.findElement(By.xpath(TEXTAREA)).clear();
		driver.findElement(By.xpath(TEXTAREA)).sendKeys(mensajeParaProductor);
		driver.findElement(By.xpath(CAMPOPRODUCTOR)).clear();
		driver.findElement(By.xpath(CAMPOPRODUCTOR)).sendKeys("");
		driver.findElement(By.xpath(CAMPOPRODUCTOR)).sendKeys(usuarioProductor);
		driver.findElement(By.cssSelector(TDZ_COMBOITEM_TEXT)).click();
	}

	/**
	 * Realiza click en la opción de recibir un aviso ante la firma de un
	 * documento.-
	 * 
	 * TODO - Crear lógica para los tipos de documentos que no permiten esta
	 * opción
	 * 
	 */
	public void quieroRecibirUnAvisoCuandoElDocumentoSeFirme() {
		driver.findElement(By.xpath(LABELQUIEROAVISOCUANDOFIRME)).click();
	}

	public void quieroEnviarUnCorreoAlReceptorDeLaTarea() {
		driver.findElement(By.xpath(LABELQUIEROENVIARUNCORREOALRECEPTORDELATAREA)).click();
	}
}
