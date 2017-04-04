package test.automatizado.gedo;
import java.awt.List;
import java.util.ArrayList;
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
 * TODO: Parametrizar o externalizar datos variables.-
 * ---------------------------------------------------------------------------
 * TODO Crear una clase que resuelva la posibilidad de obtener el nombre del
 * método que se ejecuta, para pasar dicho nombre como patrón de las capturas a
 * realizar. Lo que facilitaría el seguimiento de lo que sucede en cada
 * ejecución.
 * 
 */
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
		new IngresoLoginCas(getDriver(), URLGEDOTEST, getUsuario(), getPassword());
	}
	// Lógica de automatización
	//@Test
	public void testCCOODefinirDestinatariosEnviarFirmarUsuarioMismaRepaticion() throws Exception {
		// Parametrizar o externalizar datos variables
		String nombreMetodo = "testCCOODefinirDestinatariosEnviarFirmarUsuarioMismaRepaticion";
		String acronimoGEDO = "SS86";
		// String rutaArchivoPuntoDoc = RUTAARCHIVOSENTRADA + archivoPuntoDoc;
		DocumentoLibre documentoLibre = new DocumentoLibre(getDriver(), RUTAARCHIVOSENTRADA);
		documentoLibre.getCapturarPantalla().setPatron(nombreMetodo);
		String textoReferencia = "PhantomJS - AUTOMATIZADO - testGEDOEnviarAFirmar";
		String archivoPuntoDoc = "GobTuc_Diseño Funcional-Expediente Electrónico.doc";
		String usuarioFirmanterMismaRepaticion = "NRuby ARuby";
		String[] listaDestinatarios = {"Carlos Gauto","NRuby ARuby"};
		String[] listaDestinatariosCopia = {"DJANGO DJANGO","Mindi Mindi"};
		String[] listaDestinatariosCopiaOculta = {"NILRACOLOS","MARINA VILLAGGI"};
		// Parametrizar o externalizar datos variables

		try {
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.inicioDocumento();
			documentoLibre.iniciarProduccionDeDocumento(DOCUMENTOELECTRONICO, acronimoGEDO);
			documentoLibre.quieroRecibirUnAvisoCuandoElDocumentoSeFirme();
			documentoLibre.quieroEnviarUnCorreoAlReceptorDeLaTarea();
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.definirDestinatarios();
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.getCapturarPantalla().capturarPantalla();			
			documentoLibre.definirDestinatariosCCOO(listaDestinatarios,listaDestinatariosCopia, listaDestinatariosCopiaOculta);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.producirloYoMismo();
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.producirDocumentoLibreImportarWord(textoReferencia, archivoPuntoDoc);
			/* Esperar a que suba el archivo word */
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.enviarAFirmarUsuarioMismaReparticion(usuarioFirmanterMismaRepaticion);

		} catch (Exception e) {
			e.printStackTrace();
			documentoLibre.getCapturarPantalla().setPatron("ERROR_" + nombreMetodo);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			throw e;
		}

	}
	//@Test
	public void testGEDOEnviarAFirmarUsuarioMismaReparticion() throws Exception {
		// Parametrizar o externalizar datos variables
		String nombreMetodo = "testGEDOEnviarAFirmar";
		String acronimoGEDO = "IF";
		String textoReferencia = "PhantomJS - AUTOMATIZADO - testGEDOEnviarAFirmar";
		String archivoPuntoDoc = "GobTuc_Diseño Funcional-Expediente Electrónico.doc";
		String usuarioFirmanterMismaRepaticion = "NRuby ARuby";
		// String rutaArchivoPuntoDoc = RUTAARCHIVOSENTRADA + archivoPuntoDoc;
		DocumentoLibre documentoLibre = new DocumentoLibre(getDriver(), RUTAARCHIVOSENTRADA);
		documentoLibre.getCapturarPantalla().setPatron(nombreMetodo);
		// Parametrizar o externalizar datos variables

		try {
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.inicioDocumento();
			documentoLibre.quieroRecibirUnAvisoCuandoElDocumentoSeFirme();
			documentoLibre.quieroEnviarUnCorreoAlReceptorDeLaTarea();
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.iniciarProduccionDeDocumento(DOCUMENTOELECTRONICO, acronimoGEDO);
			documentoLibre.producirloYoMismo();
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.producirDocumentoLibreImportarWord(textoReferencia, archivoPuntoDoc);
			/* Esperar a que suba el archivo word */
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.enviarAFirmarUsuarioMismaReparticion(usuarioFirmanterMismaRepaticion);
		} catch (Exception e) {
			e.printStackTrace();
			documentoLibre.getCapturarPantalla().setPatron("ERROR_" + nombreMetodo);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			throw e;
		}

	}

	//@Test
	public void testGEDOEnviarAFirmarUsuarioDistintaReparticion() throws Exception {
		// Parametrizar o externalizar datos variables
		String nombreMetodo = "testGEDOEnviarAFirmarUsuarioDistintaReparticion";
		String acronimoGEDO = "IF";
		String textoReferencia = "PhantomJS - AUTOMATIZADO " + nombreMetodo;
		String archivoPuntoDoc = "GobTuc_Diseño Funcional-Expediente Electrónico.doc";
		String usuarioFirmanterDistintaRepaticion = "Carlos Gauto";
		// String rutaArchivoPuntoDoc = RUTAARCHIVOSENTRADA + archivoPuntoDoc;
		DocumentoLibre documentoLibre = new DocumentoLibre(getDriver(), RUTAARCHIVOSENTRADA);
		documentoLibre.getCapturarPantalla().setPatron(nombreMetodo);
		// Parametrizar o externalizar datos variables

		try {
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.inicioDocumento();
			documentoLibre.quieroRecibirUnAvisoCuandoElDocumentoSeFirme();
			documentoLibre.quieroEnviarUnCorreoAlReceptorDeLaTarea();
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.iniciarProduccionDeDocumento(DOCUMENTOELECTRONICO, acronimoGEDO);
			documentoLibre.producirloYoMismo();
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.producirDocumentoLibreImportarWord(textoReferencia, archivoPuntoDoc);
			/* Esperar a que suba el archivo word */
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.enviarAFirmarUsuarioDistintaReparticion(usuarioFirmanterDistintaRepaticion);
		} catch (Exception e) {
			e.printStackTrace();
			documentoLibre.getCapturarPantalla().setPatron("ERROR_" + nombreMetodo);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			throw e;
		}

	}

	// Lógica de automatización
	//@Test
	public void testGEDOAvisoDeFirma() throws Exception {
		// Parametrizar o externalizar datos variables
		String nombreMetodo = "testGEODAvisoDeFirma";
//		String acronimoGEDO = "IF";
//		String textoReferencia = "PhantomJS - AUTOMATIZADO - testGEODAvisoDeFirma";
//		String archivoPuntoDoc = "GobTuc_Diseño Funcional-Expediente Electrónico.doc";
		// String rutaArchivoPuntoDoc = RUTAARCHIVOSENTRADA + archivoPuntoDoc;
		DocumentoLibre documentoLibre = new DocumentoLibre(getDriver(), RUTAARCHIVOSENTRADA);
		documentoLibre.getCapturarPantalla().setPatron(nombreMetodo);
		// Parametrizar o externalizar datos variables

		try {
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.inicioDocumento();
			documentoLibre.quieroRecibirUnAvisoCuandoElDocumentoSeFirme();
			documentoLibre.quieroEnviarUnCorreoAlReceptorDeLaTarea();
			documentoLibre.getCapturarPantalla().capturarPantalla();
		} catch (Exception e) {
			e.printStackTrace();
			documentoLibre.getCapturarPantalla().setPatron("ERROR_" + nombreMetodo);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			throw e;
		}

	}

	//@Test
	public void testGEDODocumentoLibre() throws Exception {
		// Parametrizar o externalizar datos variables
		String nombreMetodo = "testGEDODocumentoLibre";
		String acronimoGEDO = "IF";
		String textoReferencia = "PhantomJS - AUTOMATIZADO - testGEDODocumentoLibre";
		String archivoPuntoDoc = "GobTuc_Diseño Funcional-Expediente Electrónico.doc";
		// String rutaArchivoPuntoDoc = RUTAARCHIVOSENTRADA + archivoPuntoDoc;
		DocumentoLibre documentoLibre = new DocumentoLibre(getDriver(), RUTAARCHIVOSENTRADA);
		// Parametrizar o externalizar datos variables

		try {
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.inicioDocumento();
			documentoLibre.iniciarProduccionDeDocumento(DOCUMENTOELECTRONICO, acronimoGEDO);
			documentoLibre.producirloYoMismo();
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.producirDocumentoLibreImportarWord(textoReferencia, archivoPuntoDoc);
			/* Esperar a que suba el archivo word */
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.firmarYoMismo();
			documentoLibre.getSeleniumUtilitario().waitElementByXpath(FIRMARCONCERTIFICADO);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.firmarConCertificado();
			documentoLibre.getSeleniumUtilitario().waitElementByXpath(VOLVERALBUZONDETAREAS);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.volverAlBuzonDeTareas();
			documentoLibre.getCapturarPantalla().capturarPantalla();
		} catch (Exception e) {
			e.printStackTrace();
			documentoLibre.getCapturarPantalla().setPatron("ERROR_" + nombreMetodo);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			throw e;
		}

	}

	@Test
	public void testGEDODocumentoImportado() throws Exception {
		// Parametrizar o externalizar datos variables
		String nombreMetodo = "testGEDODocumentoImportado";
		String acronimoGEDO = "IMAUT";
		String textoReferencia = "PhantomJS - AUTOMATIZADO - Importado - testGEDODocumentoImportado";
		String archivoImportado = "archivoImportado.png";
		// String rutaArchivoPuntoDoc = RUTAARCHIVOSENTRADA + archivoPuntoDoc;
		DocumentoImportado documentoImportado = new DocumentoImportado(getDriver(), RUTAARCHIVOSENTRADA);
		// Parametrizar o externalizar datos variables

		try {
			documentoImportado.getSeleniumUtilitario().getWait();
			documentoImportado.inicioDocumento();
			documentoImportado.iniciarProduccionDeDocumento(DOCUMENTOELECTRONICO, acronimoGEDO);
			documentoImportado.producirloYoMismo();
			documentoImportado.getCapturarPantalla().capturarPantalla();
			documentoImportado.producirDocumentoImportado(textoReferencia, archivoImportado);
			/* Esperar a que suba el archivo word */
			documentoImportado.getSeleniumUtilitario().getWait();
			documentoImportado.getCapturarPantalla().capturarPantalla();
			documentoImportado.firmarYoMismo();
			documentoImportado.getSeleniumUtilitario().waitElementByXpath(FIRMARCONCERTIFICADO);
			documentoImportado.getCapturarPantalla().capturarPantalla();
			documentoImportado.firmarConCertificado();
			documentoImportado.getSeleniumUtilitario().waitElementByXpath(VOLVERALBUZONDETAREAS);
			documentoImportado.getCapturarPantalla().capturarPantalla();
			documentoImportado.volverAlBuzonDeTareas();
			documentoImportado.getCapturarPantalla().capturarPantalla();
		} catch (Exception e) {
			e.printStackTrace();
			documentoImportado.getCapturarPantalla().setPatron("ERROR_" + nombreMetodo);
			documentoImportado.getCapturarPantalla().capturarPantalla();
			throw e;
		}

	}

	//@Test
	public void testGEDODocumentoLibreEnviarARevisarUsuarioMismaReparticion() throws Exception {
		// Parametrizar o externalizar datos variables
		String nombreMetodo = "testGEDODocumentoLibreEnviarARevisarUsuarioMismaReparticion";
		String acronimoGEDO = "IF";
		DocumentoLibre documentoLibre = new DocumentoLibre(getDriver(), RUTAARCHIVOSENTRADA);
		String usuarioRevisorMismaRepaticion = "NRuby ARuby";
		String textoReferencia = "PhantomJS - AUTOMATIZADO - testGEDODocumentoLibreEnviarARevisarUsuarioMismaReparticion";
		String archivoPuntoDoc = "GobTuc_Diseño Funcional-Expediente Electrónico.doc";
		String mensaje = "Mensaje: PhantomJS - AUTOMATIZADO";
		// Parametrizar o externalizar datos variables

		try {
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.inicioDocumento();
			documentoLibre.iniciarProduccionDeDocumento(DOCUMENTOELECTRONICO, acronimoGEDO);
			documentoLibre.producirloYoMismo();
			// documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.producirDocumentoLibreImportarWord(textoReferencia, archivoPuntoDoc);
			/* Esperar a que suba el archivo word */
			documentoLibre.getSeleniumUtilitario().getWait();
			// documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.enviarARevisar();
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.completarRevisorMensaje(usuarioRevisorMismaRepaticion, mensaje);
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.getCapturarPantalla().capturarPantalla();
		} catch (Exception e) {
			e.printStackTrace();
			documentoLibre.getCapturarPantalla().setPatron("ERROR_" + nombreMetodo);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			throw e;
		}

	}

	//@Test
	public void testGEDODocumentoLibreEnviarAProducirUsuarioMismaReparticion() throws Exception {
		String nombreMetodo = "testGEDODocumentoLibreEnviarAProducirUsuarioMismaReparticion";
		String acronimoGEDO = "IF";
		DocumentoLibre documentoLibre = new DocumentoLibre(getDriver(), RUTAARCHIVOSENTRADA);
		String mensajeParaProductor = "PhantomJS: testGEDODocumentoLibreEnviarAProducirUsuarioMismaReparticion.";
		String usuarioProductorMismaReparticion = "NRuby ARuby";
		// Parametrizar o externalizar datos variables

		try {
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.inicioDocumento();
			documentoLibre.iniciarProduccionDeDocumento(DOCUMENTOELECTRONICO, acronimoGEDO);
			documentoLibre.enviarAProducirTareaUsuario(usuarioProductorMismaReparticion, mensajeParaProductor);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.enviarAProducirUsuarioMismaReparticion();
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.getCapturarPantalla().capturarPantalla();
		} catch (Exception e) {
			e.printStackTrace();
			documentoLibre.getCapturarPantalla().setPatron("ERROR_" + nombreMetodo);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			throw e;
		}

	}

	//@Test
	public void testGEDODocumentoLibreEnviarAProducirUsuarioDistintaReparticion() throws Exception {
		// Parametrizar o externalizar datos variables
		String nombreMetodo = "testGEDODocumentoLibreEnviarAProducirUsuarioDistintaReparticion";
		String acronimoGEDO = "IF";
		DocumentoLibre documentoLibre = new DocumentoLibre(getDriver(), RUTAARCHIVOSENTRADA);
		String mensajeParaProductor = "PhantomJS: testGEDODocumentoLibreEnviarAProducirUsuarioDistintaReparticion.";
		String usuarioProductorDisintaRepaticion = "Carlos Gauto";
		// Parametrizar o externalizar datos variables

		try {
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.inicioDocumento();
			documentoLibre.iniciarProduccionDeDocumento(DOCUMENTOELECTRONICO, acronimoGEDO);
			documentoLibre.enviarAProducirTareaUsuario(usuarioProductorDisintaRepaticion, mensajeParaProductor);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			documentoLibre.enviarAProducirUsuarioDistintaReparticionAceptar();
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.getCapturarPantalla().capturarPantalla();
		} catch (Exception e) {
			e.printStackTrace();
			documentoLibre.getCapturarPantalla().setPatron("ERROR_" + nombreMetodo);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			throw e;
		}
	}
	//@Test
	public void testArchivoTrabajoPantallaInicioDoc() throws Exception{
		DocumentoLibre documentoLibre= new DocumentoLibre(getDriver(), RUTAARCHIVOSENTRADA);
		String archivoImportado[]={"archivoImportado.png"};
		//String archivoImportado = "archivoImportado.png";
		String nombreMetodo = "testArchivoTrabajoPantallaInicioDoc";
		try {
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.inicioDocumento();
			documentoLibre.ArchivosDeTrabajo();
			documentoLibre.AniadirDocumento(archivoImportado, SELECCCIONARARCHIVO);
			documentoLibre.getCapturarPantalla().capturarPantalla();
		} catch (Exception e) {
			e.printStackTrace();
			documentoLibre.getCapturarPantalla().setPatron("ERROR_" + nombreMetodo);
			documentoLibre.getCapturarPantalla().capturarPantalla();
			throw e;
		}	
	}
	
	//@Test
	public void testArchivoTrabajoPantallaProducirDocumento() throws Exception{
		DocumentoLibre documentoLibre= new DocumentoLibre(getDriver(), RUTAARCHIVOSENTRADA);
		String archivoImportado[]={"archivoImportado.png"};
		//String archivoImportado = "archivoImportado.png";
		String nombreMetodo = "testArchivoTrabajoPantallaInicioDoc";
		String acronimoGEDO = "IF";
		try {
			documentoLibre.getSeleniumUtilitario().getWait();
			documentoLibre.inicioDocumento();
			documentoLibre.iniciarProduccionDeDocumento(DOCUMENTOELECTRONICO, acronimoGEDO);
			documentoLibre.producirloYoMismo();
			documentoLibre.seleccionarSolapaArchivosDeTrabajoProducirDocumento();
			documentoLibre.AniadirDocumento(archivoImportado, SELECCCIONARARCHIVO);
			documentoLibre.getCapturarPantalla().capturarPantalla();
		} catch (Exception e) {
			e.printStackTrace();
			documentoLibre.getCapturarPantalla().setPatron("ERROR_" + nombreMetodo);
			documentoLibre.getCapturarPantalla().capturarPantalla();
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