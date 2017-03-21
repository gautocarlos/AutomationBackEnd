package test.automatizado.gedo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gedo.api.qa.Constantes;
import test.selenium.util.CapturarPantalla;
import test.selenium.util.DriverPhantom;
import test.selenium.util.IngresoLoginCas;
import test.selenium.util.SeleniumWait;

public class GedoDocumentoLibre implements Constantes{
	private WebDriver driver;
	// private String url;
	// private String usuario;
	// private String password;
	private String url = "http://eug.nac.gde.gob.ar/gedo-web/";
	private String usuario = "RUBIEE";
	private String password = "Zaq12w";
	private SeleniumWait espera;
	private StringBuffer verificationErrors = new StringBuffer();
	private CapturarPantalla capturarPantalla;
	private String rutaCapturasDePantalla = "capturasDePantalla";

	// Constructor
	public GedoDocumentoLibre() {
		inicializarDriver();
		setEspera(new SeleniumWait(getDriver()));
		setCapturarPantalla(new CapturarPantalla(getDriver(), rutaCapturasDePantalla, "GEDO_"));
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public SeleniumWait getEspera() {
		// espera.getWait();
		return espera;
	}

	public void setEspera(SeleniumWait espera) {
		this.espera = espera;
	}

	public CapturarPantalla getCapturarPantalla() {
		return capturarPantalla;
	}

	public void setCapturarPantalla(CapturarPantalla capturarPantalla) {
		this.capturarPantalla = capturarPantalla;
	}

	public void inicializarDriver() {
		try {
			setDriver(new DriverPhantom().inicializar());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Before
	public void setUp() throws Exception {
		new IngresoLoginCas(getDriver(), getUrl(), getUsuario(), getPassword());
	}

	// Lógica de automatización
	@Test
	public void testGEDOInicioDocumentoLibre() throws Exception {
		// Parametrizar o externalizar datos variables
		String acronimoGEDO = "IF";
		String textoReferencia = "PhantomJS - AUTOMATIZADO";
		String archivoPuntoDoc = "GobTuc_Diseño Funcional-Expediente Electrónico.doc";
		String rutaArchivoPuntoDoc = RUTAARCHIVOSENTRADA + archivoPuntoDoc;
		// Parametrizar o externalizar datos variables

		try {
			inicioDocumento(INICIODOCUMENTO);
			iniciarProduccionDeDocumentoLibre(DOCUMENTOELECTRONICO, acronimoGEDO);
			producirloYoMismoLibre(PRODUCIRLOYOMISMO);
			getCapturarPantalla().capturarPantalla();
			producirDocumentoLibreImportarWord(CAMPOREFERENCIA, textoReferencia, rutaArchivoPuntoDoc);
			getEspera().getWait(); // Esperar a que suba el archivo word
			getCapturarPantalla().capturarPantalla();
			firmarYoMismo(FIRMARYOMISMO);
			getEspera().waitElementByXpath(FIRMARCONCERTIFICADO);
			getCapturarPantalla().capturarPantalla();
			firmarConCertificado(FIRMARCONCERTIFICADO);
			getEspera().waitElementByXpath(VOLVERALBUZONDETAREAS);
			getCapturarPantalla().capturarPantalla();
			volverAlBuzonDeTareas(VOLVERALBUZONDETAREAS);
			getCapturarPantalla().capturarPantalla();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param campoReferencia
	 * @param textoReferencia
	 * @param rutaArchivoPuntoDoc
	 * @throws Exception 
	 */
	private void producirDocumentoLibreImportarWord(String campoReferencia, String textoReferencia,
			String rutaArchivoPuntoDoc) throws Exception {
		getEspera().waitElementByXpath(campoReferencia);
		driver.findElement(By.xpath(campoReferencia)).clear();
		driver.findElement(By.xpath(campoReferencia)).sendKeys(textoReferencia);
		driver.findElement(By.name("file")).sendKeys(rutaArchivoPuntoDoc);
	}

	/**
	 * @param producirloYoMismo
	 */
	private void producirloYoMismoLibre(String producirloYoMismo) {
		clickByXPath(producirloYoMismo);
	}

	/**
	 * @param firmarYoMismo
	 */
	private void firmarYoMismo(String firmarYoMismo) {
		clickByXPath(firmarYoMismo);
	}

	/**
	 * @param firmarConCertificadoLibre
	 */
	private void firmarConCertificado(String firmarConCertificadoLibre) {
		clickByXPath(firmarConCertificadoLibre);
	}

	/**
	 * @param volverAlBuzonDeTareas
	 */
	private void volverAlBuzonDeTareas(String volverAlBuzonDeTareas) {
		clickByXPath(volverAlBuzonDeTareas);
	}

	/**
	 * @param xpath
	 */
	private void clickByXPath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	/**
	 * @param documentoElectronico
	 * @param acronimoGEDO
	 * @throws Exception 
	 */
	private void iniciarProduccionDeDocumentoLibre(String documentoElectronico, String acronimoGEDO) throws Exception {
		getEspera().waitElementByXpath(documentoElectronico);
		driver.findElement(By.xpath(documentoElectronico)).clear();
		driver.findElement(By.xpath(documentoElectronico)).sendKeys(acronimoGEDO);
		producirloYoMismoLibre(documentoElectronico);
	}

	/**
	 * @param inicioDocumento
	 * @throws Exception 
	 */
	private void inicioDocumento(String inicioDocumento) throws Exception {
		getEspera().waitElementByXpath(inicioDocumento);
		clickByXPath(inicioDocumento);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}