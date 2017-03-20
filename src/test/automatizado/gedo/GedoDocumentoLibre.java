package test.automatizado.gedo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.selenium.util.CapturarPantalla;
import test.selenium.util.DriverPhantom;
import test.selenium.util.IngresoLoginCas;
import test.selenium.util.SeleniumWait;

public class GedoDocumentoLibre {
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
		setCapturarPantalla(new CapturarPantalla(getDriver(), rutaCapturasDePantalla));
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

	// Lógica de automatización
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

	@Test
	public void testGEDOInicioDocumentoLibre() throws Exception {
		// Separar constantes
		String inicioDocumento = "//div[2]/div[1]/div/div/div[1]/div/div[8]/div[1]/div[1]/div";
		String documentoElectronico = "//td[3]/i/input";
		String producirloYoMismo = "//div[6]/div/table/tbody/tr/td/div/table/tbody/tr/td/table/tbody/tr/td[11]/div/div/div/img";
		String campoReferencia = "//td[2]/input";
		String firmarYoMismo = "//tr[7]/td/div/div/div/img";
		String firmarConCertificado = "//td[5]/div/div/div/img";
		String volverAlBuzonDeTareas = "//td[2]/div/div/div/div/img";
		// Separar constantes

		// Variables
		String acronimoGEDO = "IF";
		String textoReferencia = "PhantomJS - AUTOMATIZADO";
		String rutaArchivoPuntoDoc = "C:\\Users\\cargauto\\Downloads\\GobTuc_Diseño Funcional-Expediente Electrónico.doc";
		// Variables
		try {
			driver.findElement(By.xpath(inicioDocumento)).click();
			getEspera().waitElementByXpath(inicioDocumento);
			driver.findElement(By.xpath(documentoElectronico)).clear();
			driver.findElement(By.xpath(documentoElectronico)).sendKeys(acronimoGEDO);
			driver.findElement(By.xpath(documentoElectronico)).click();
			driver.findElement(By.xpath(producirloYoMismo)).click();
			getCapturarPantalla().capturarPantalla();
			getEspera().waitElementByXpath(campoReferencia);
			driver.findElement(By.xpath(campoReferencia)).clear();
			driver.findElement(By.xpath(campoReferencia)).sendKeys(textoReferencia);
			// driver.findElement(By.name("file")).clear();
			driver.findElement(By.name("file")).sendKeys(rutaArchivoPuntoDoc);
			getEspera().getWait(); // Esperar a que suba el archivo word
			getCapturarPantalla().capturarPantalla();
			driver.findElement(By.xpath(firmarYoMismo)).click();
			// getEspera().getWait(); // Ver si aplica espera genérica o sobre
			// el
			// botón de firmar con certificado
			getEspera().waitElementByXpath(firmarConCertificado);
			getCapturarPantalla().capturarPantalla();
			driver.findElement(By.xpath(firmarConCertificado)).click();
			getEspera().waitElementByXpath(volverAlBuzonDeTareas);
			getCapturarPantalla().capturarPantalla();
			driver.findElement(By.xpath(volverAlBuzonDeTareas)).click();
			getCapturarPantalla().capturarPantalla();
		} catch (Exception e) {
			e.printStackTrace();
		}

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