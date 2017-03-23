package test.automatizado.gedo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import gedo.api.qa.Constantes;
import gedo.api.qa.DocumentoImportado;
import gedo.api.qa.DocumentoLibre;
import test.selenium.util.DriverPhantom;
import test.selenium.util.IngresoLoginCas;
/**
 * TODO: Parametrizar o externalizar datos variables
 * 
 * */
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
	 * realicen pruebas automáticas, de modo de reutilizar código la
	 * inicialización del driver debería estar incluída en la misma
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
		// String rutaArchivoPuntoDoc = RUTAARCHIVOSENTRADA + archivoPuntoDoc;
		DocumentoLibre documentoLibre = new DocumentoLibre(getDriver(), RUTAARCHIVOSENTRADA);
		// Parametrizar o externalizar datos variables

		try {
			documentoLibre.inicioDocumento();
			documentoLibre.iniciarProduccionDeDocumento(DOCUMENTOELECTRONICO, acronimoGEDO);
			documentoLibre.producirloYoMismo();
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.producirDocumentoLibreImportarWord(textoReferencia, archivoPuntoDoc);
			/* Esperar a que suba el archivo word */
			documentoLibre.getEspera().getWait();
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.firmarYoMismo();
			documentoLibre.getEspera().waitElementByXpath(FIRMARCONCERTIFICADO);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.firmarConCertificado();
			documentoLibre.getEspera().waitElementByXpath(VOLVERALBUZONDETAREAS);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.volverAlBuzonDeTareas();
			documentoLibre.getCapturarPantalla().capturarPantalla();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGEDODocumentoImportado() throws Exception {
		// Parametrizar o externalizar datos variables
		String acronimoGEDO = "IMAUT";
		String textoReferencia = "PhantomJS - AUTOMATIZADO - Importado";
		String archivoImportado = "archivoImportado.png";
		// String rutaArchivoPuntoDoc = RUTAARCHIVOSENTRADA + archivoPuntoDoc;
		DocumentoImportado documentoImportado = new DocumentoImportado(getDriver(), RUTAARCHIVOSENTRADA);
		// Parametrizar o externalizar datos variables

		try {
			documentoImportado.inicioDocumento();
			documentoImportado.iniciarProduccionDeDocumento(DOCUMENTOELECTRONICO, acronimoGEDO);
			documentoImportado.producirloYoMismo();
			documentoImportado.getCapturarPantalla().capturarPantalla();
			documentoImportado.producirDocumentoImportado(textoReferencia, archivoImportado);
			/* Esperar a que suba el archivo word */
			documentoImportado.getEspera().getWait();
			documentoImportado.getCapturarPantalla().capturarPantalla();
			documentoImportado.firmarYoMismo();
			documentoImportado.getEspera().waitElementByXpath(FIRMARCONCERTIFICADO);
			documentoImportado.getCapturarPantalla().capturarPantalla();
			documentoImportado.firmarConCertificado();
			documentoImportado.getEspera().waitElementByXpath(VOLVERALBUZONDETAREAS);
			documentoImportado.getCapturarPantalla().capturarPantalla();
			documentoImportado.volverAlBuzonDeTareas();
			documentoImportado.getCapturarPantalla().capturarPantalla();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Test
	public void testGEDODocumentoLibreEnviarARevisarUsuarioMismaReparticion() throws Exception {
		// Parametrizar o externalizar datos variables
		String acronimoGEDO = "IF";
		DocumentoLibre documentoLibre = new DocumentoLibre(getDriver(), RUTAARCHIVOSENTRADA);
		String usuarioRevisorMismaRepaticion = "NRuby ARuby";
		String textoReferencia = "PhantomJS - AUTOMATIZADO";
		String archivoPuntoDoc = "GobTuc_Diseño Funcional-Expediente Electrónico.doc";
		String mensaje = "Mensaje: PhantomJS - AUTOMATIZADO";
		// Parametrizar o externalizar datos variables

		try {
			documentoLibre.inicioDocumento();
			documentoLibre.iniciarProduccionDeDocumento(DOCUMENTOELECTRONICO, acronimoGEDO);
			documentoLibre.producirloYoMismo();
			// documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.producirDocumentoLibreImportarWord(textoReferencia, archivoPuntoDoc);
			/* Esperar a que suba el archivo word */
			documentoLibre.getEspera().getWait();
			// documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.enviarARevisar();
			documentoLibre.getEspera().getWait();
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.completarRevisorMensaje(usuarioRevisorMismaRepaticion, mensaje);
			documentoLibre.getEspera().getWait();
			documentoLibre.getCapturarPantalla().capturarPantalla();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Test
	public void testGEDODocumentoLibreEnviarAProducirUsuarioMismaReparticion() throws Exception {
		String acronimoGEDO = "IF";
		DocumentoLibre documentoLibre = new DocumentoLibre(getDriver(), RUTAARCHIVOSENTRADA);
		String mensajeParaProductor = "PhantomJS: testGEDODocumentoLibreEnviarAProducirUsuarioMismaReparticion.";
		String usuarioProductorMismaReparticion = "NRuby ARuby";
		// Parametrizar o externalizar datos variables

		try {
			documentoLibre.inicioDocumento();
			documentoLibre.iniciarProduccionDeDocumento(DOCUMENTOELECTRONICO, acronimoGEDO);
			documentoLibre.enviarAProducirTareaUsuario(usuarioProductorMismaReparticion, mensajeParaProductor);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.enviarAProducirUsuarioMismaReparticion();
			documentoLibre.getEspera().getWait();
			documentoLibre.getCapturarPantalla().capturarPantalla();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Test
	public void testGEDODocumentoLibreEnviarAProducirUsuarioDistintaReparticion() throws Exception {
		// Parametrizar o externalizar datos variables
		String acronimoGEDO = "IF";
		DocumentoLibre documentoLibre = new DocumentoLibre(getDriver(), RUTAARCHIVOSENTRADA);
		String mensajeParaProductor = "PhantomJS: testGEDODocumentoLibreEnviarAProducirUsuarioDistintaReparticion.";
		String usuarioProductorDisintaRepaticion = "Carlos Gauto";
		// Parametrizar o externalizar datos variables

		try {
			documentoLibre.inicioDocumento();
			documentoLibre.iniciarProduccionDeDocumento(DOCUMENTOELECTRONICO, acronimoGEDO);
			documentoLibre.enviarAProducirTareaUsuario(usuarioProductorDisintaRepaticion, mensajeParaProductor);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.enviarAProducirUsuarioDistintaReparticionAceptar();
			documentoLibre.getEspera().getWait();
			documentoLibre.getCapturarPantalla().capturarPantalla();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
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