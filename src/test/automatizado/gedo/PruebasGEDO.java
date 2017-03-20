package test.automatizado.gedo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import gedo.api.qa.Constantes;
import gedo.api.qa.DocumentoLibre;
import test.selenium.util.DriverPhantom;
import test.selenium.util.IngresoLoginCas;

public class PruebasGEDO implements Constantes {
	private WebDriver driver;
	// private String url;
	// private String usuario;
	// private String password;
	private String usuario = "RUBIEE";
	private String password = "Zaq12w";
	private StringBuffer verificationErrors = new StringBuffer();
	// Constructor
	public PruebasGEDO() {
		inicializarDriver();
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

	/**
	 * TODO crear clase abastracta de la que deriven las nuevas clases que
	 * realicen pruebas automáticas, de modo de reutilizar código
	 * la inicialización del driver debería estar incluída en la misma
	 **/
	public void inicializarDriver() {
		try {
			setDriver(new DriverPhantom().inicializar());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Before
	public void setUp() throws Exception {
		new IngresoLoginCas(getDriver(), URLGEDO, getUsuario(), getPassword());
	}

	// Lógica de automatización
	@Test
	public void testGEDODocumentoLibre() throws Exception {
		// Parametrizar o externalizar datos variables
		String acronimoGEDO = "IF";
		String textoReferencia = "PhantomJS - AUTOMATIZADO";
		String archivoPuntoDoc = "GobTuc_Diseño Funcional-Expediente Electrónico.doc";
//		String rutaArchivoPuntoDoc = RUTAARCHIVOSENTRADA + archivoPuntoDoc;
		DocumentoLibre documentoLibre = new DocumentoLibre(getDriver(), RUTAARCHIVOSENTRADA);
		// Parametrizar o externalizar datos variables

		try {
			documentoLibre.inicioDocumento(INICIODOCUMENTO);
			documentoLibre.iniciarProduccionDeDocumento(DOCUMENTOELECTRONICO, acronimoGEDO);
			documentoLibre.producirloYoMismo(PRODUCIRLOYOMISMO);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.producirDocumentoLibreImportarWord(CAMPOREFERENCIA, textoReferencia, archivoPuntoDoc);
			documentoLibre.getEspera().getWait(); // Esperar a que suba el archivo word
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.firmarYoMismo(FIRMARYOMISMO);
			documentoLibre.getEspera().waitElementByXpath(FIRMARCONCERTIFICADO);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.firmarConCertificado(FIRMARCONCERTIFICADO);
			documentoLibre.getEspera().waitElementByXpath(VOLVERALBUZONDETAREAS);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.volverAlBuzonDeTareas(VOLVERALBUZONDETAREAS);
			documentoLibre.getCapturarPantalla().capturarPantalla();
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