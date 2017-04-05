package gedo.api.qa;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import gde.api.qa.Constantes;
import test.selenium.util.CapturarPantalla;
import test.selenium.util.SeleniumUtilitario;

/***
 * @autor Carlos Gauto
 **/
public abstract class Documento implements Constantes {

	private WebDriver driver; // Extender WebDriver para sumarle nuevo
								// comportamiento a extraer de la clase
								// Documento
	private SeleniumUtilitario seleniumUtilitario;
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
		setSeleniumUtilitario(new SeleniumUtilitario(getDriver()));
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

	public SeleniumUtilitario getSeleniumUtilitario() {
		return seleniumUtilitario;
	}

	public void setSeleniumUtilitario(SeleniumUtilitario seleniumUtilitario) {
		this.seleniumUtilitario = seleniumUtilitario;
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
		getSeleniumUtilitario().waitElementByXpath(INICIODOCUMENTO);
		getSeleniumUtilitario().clickByXPath(INICIODOCUMENTO);
		getSeleniumUtilitario().getWait();
	}

	/**
	 * @param documentoElectronico
	 * @param acronimoGEDO
	 * @throws Exception
	 */
	public void iniciarProduccionDeDocumento(String documentoElectronico, String acronimoGEDO) throws Exception {
		getSeleniumUtilitario().waitElementByXpath(documentoElectronico);
		getDriver().findElement(By.xpath(documentoElectronico)).clear();
		getDriver().findElement(By.xpath(documentoElectronico)).sendKeys(acronimoGEDO);
		// Para forzar el fuera de foco del elemento y recalcule la pantalla
		getDriver().findElement(By.xpath(DESCRIPCIONDELTIPODEDOCUMENTO)).click();
		getSeleniumUtilitario().getWait();
	}

	/**
	 * 
	 */
	public void producirloYoMismo() {
		getSeleniumUtilitario().clickByXPath(PRODUCIRLOYOMISMO);
	}

	/**
	 * @throws Exception
	 * 
	 */
	public void enviarAProducirUsuarioMismaReparticion() throws Exception {
		getSeleniumUtilitario().clickByXPath(ENVIARAPRODUCIR);
		validarProcesoDeProduccion();
		getCapturarPantalla().capturarPantalla();
	}

	public void enviarAProducirUsuarioDistintaReparticionAceptar() throws Exception {
		getSeleniumUtilitario().clickByXPath(ENVIARAPRODUCIR);
		aceptarMensajeUsuarioDistintaReparticion();
		validarProcesoDeProduccion();
		getCapturarPantalla().capturarPantalla();
	}

	private void validarProcesoDeProduccion() throws Exception {
		try {
			getSeleniumUtilitario().waitElementByXpath(PROCESOPRODUCCION);
			getSeleniumUtilitario().clickByXPath(TDMSJBOXOK);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void enviarAProducirUsuarioDistintaReparticionRechazar() throws Exception {
		getSeleniumUtilitario().clickByXPath(ENVIARAPRODUCIR);
		noAceptarMensajeUsuarioDistintaReparticion();
	}

	private void aceptarMensajeUsuarioDistintaReparticion() throws Exception {
		getSeleniumUtilitario().waitElementByXpath(DISTINTAREPASI);
		getCapturarPantalla().capturarPantalla();
		getSeleniumUtilitario().clickByXPath(DISTINTAREPASI);
	}

	private void noAceptarMensajeUsuarioDistintaReparticion() throws Exception {
		getSeleniumUtilitario().waitElementByXpath(DISTINTAREPANO);
		getCapturarPantalla().capturarPantalla();
		getSeleniumUtilitario().clickByXPath(DISTINTAREPANO);
	}

	/**
	 * 
	 */
	public void firmarYoMismo() {
		getSeleniumUtilitario().clickByXPath(FIRMARYOMISMO);
	}

	/**
	 * Posiblemente haya que realizar un método que: presione el botón cancelar
	 * que se vea en primer plano, o que en el caso de que existan renderizados
	 * más de un mismo botón cancelar se pueda elegir cual presionar. Esto mismo
	 * hay que realizar para todos los métodos que presionar un botón en base al
	 * contains text() de una imagen.
	 */
	public void cancelar() throws Exception {
		getSeleniumUtilitario().waitElementByXpath(CANCELAR);
		getSeleniumUtilitario().clickByXPath(CANCELAR);
	}

	/**
	 * 
	 */
	public void firmarConCertificado() {
		getSeleniumUtilitario().clickByXPath(FIRMARCONCERTIFICADO);
	}

	/**
	 * 
	 */
	public void volverAlBuzonDeTareas() {
		getSeleniumUtilitario().clickByXPath(VOLVERALBUZONDETAREAS);
	}

	/**
	 * Presiona el botón de la funcionalidad enviar a revisar
	 */
	public void enviarARevisar() {
		getSeleniumUtilitario().clickByXPath(ENVIARAREVISAR);
	}

	/**
	 * Presiona el botón de la funcionalidad enviar a firmar
	 */
	public void enviarAFirmar() {
		getSeleniumUtilitario().clickByXPath(ENVIARAFIRMAR);
	}

	/**
	 * TODO - Renombrar método para que incluya la acción de presionar el botón
	 * de enviar a revisar
	 * 
	 * @see - Método: enviarAFirmarUsuarioMismaReparticion(String firmante)
	 * 
	 */
	public void completarRevisorMensaje(String revisor, String mensaje) throws Exception {
		getSeleniumUtilitario().waitElementByXpath(CAMPOREVISOR);
		getDriver().findElement(By.xpath(CAMPOREVISOR)).clear();
		getDriver().findElement(By.xpath(CAMPOREVISOR)).sendKeys("");
		getDriver().findElement(By.xpath(CAMPOREVISOR)).sendKeys(revisor);
		getSeleniumUtilitario().getWait();
		getCapturarPantalla().capturarPantalla();
		getDriver().findElement(By.cssSelector(TDZ_COMBOITEM_TEXT)).click();
		getDriver().findElement(By.xpath(TD_TEXTAREA)).clear();
		getDriver().findElement(By.xpath(TD_TEXTAREA)).sendKeys(mensaje);
		getCapturarPantalla().capturarPantalla();
		getSeleniumUtilitario().waitElementByXpath(BOTONACEPTAR);
		getSeleniumUtilitario().clickByXPath(BOTONACEPTAR);
		getSeleniumUtilitario().getWait();
		// getCapturarPantalla().capturarPantalla();
	}

	public void enviarAFirmarUsuarioMismaReparticion(String firmante) throws Exception {
		getSeleniumUtilitario().clickByXPath(ENVIARAFIRMAR);
		getSeleniumUtilitario().waitElementByXpath(CAMPOFIRMANTE);
		getDriver().findElement(By.xpath(CAMPOFIRMANTE)).clear();
		getDriver().findElement(By.xpath(CAMPOFIRMANTE)).sendKeys("");
		getDriver().findElement(By.xpath(CAMPOFIRMANTE)).sendKeys(firmante);
		getSeleniumUtilitario().getWait();
		getCapturarPantalla().capturarPantalla();
		getDriver().findElement(By.cssSelector(TDZ_COMBOITEM_TEXT)).click();
		getCapturarPantalla().capturarPantalla();
		getSeleniumUtilitario().waitElementByXpath(BOTONACEPTAR);
		getSeleniumUtilitario().clickByXPath(BOTONACEPTAR);
		getSeleniumUtilitario().getWait();
		// getCapturarPantalla().capturarPantalla();
	}

	public void enviarAFirmarUsuarioDistintaReparticion(String firmante) throws Exception {
		getSeleniumUtilitario().clickByXPath(ENVIARAFIRMAR);
		getSeleniumUtilitario().waitElementByXpath(CAMPOFIRMANTE);
		getDriver().findElement(By.xpath(CAMPOFIRMANTE)).clear();
		getDriver().findElement(By.xpath(CAMPOFIRMANTE)).sendKeys("");
		getDriver().findElement(By.xpath(CAMPOFIRMANTE)).sendKeys(firmante);
		getSeleniumUtilitario().getWait();
		getCapturarPantalla().capturarPantalla();
		getDriver().findElement(By.cssSelector(TDZ_COMBOITEM_TEXT)).click();
		getCapturarPantalla().capturarPantalla();
		getSeleniumUtilitario().waitElementByXpath(BOTONACEPTAR);
		getSeleniumUtilitario().clickByXPath(BOTONACEPTAR);
		getSeleniumUtilitario().getWait();
		aceptarMensajeUsuarioDistintaReparticion();
		// getCapturarPantalla().capturarPantalla();
	}

	// /**
	// * @param xpath
	// * xpath del elemento a realizar click
	// * @param indice
	// * se utiliza para el caso en el que con el mismo xpath relativo
	// * se obtiene más de un elemento, se realiza click sobre el
	// * elemento pasado por parámetro
	// * @throws Exception
	// * "El índice recibido tiene que ser mayor o igual a 0"
	// *
	// -----------------------------------------------------------------------------
	// * TODO - Externalizar en otra clase ya que se trata de un
	// * comportamiento estándar que será utilizado en cualquier
	// * módulo
	// * @deprecated Pasar a la clase SeleniumUtilitario
	// */
	// private void clickByXPath(String xpath, int indice) throws Exception {
	// try {
	// this.getSeleniumUtilitario().getWait();
	// List<WebElement> elementos = driver.findElements(By.xpath(xpath));
	// int cantidadElementos = elementos.size();
	// // validar por el límite máximo
	// if ((indice >= 0) && (cantidadElementos > 0) && (cantidadElementos >
	// indice)) {
	// elementos.get(indice).click();
	// // return elementos.get(indice);
	// } else {
	// throw new Exception("El índice: " + indice + " recibido es menor a 0 o la
	// cantidad de elementos: "
	// + cantidadElementos + " retornados para el xpath: " + xpath + " es 0");
	// }
	// } catch (Exception e) {
	// throw e;
	// }
	// }

	// /**
	// * @param xpath
	// * xpath del elemento a realizar click
	// * @param indice
	// * se utiliza para el caso en el que con el mismo xpath relativo
	// * se obtiene más de un elemento, se realiza click sobre el
	// * elemento pasado por parámetro
	// * @throws Exception
	// * "El índice recibido tiene que ser mayor o igual a 0"
	// *
	// -----------------------------------------------------------------------------
	// * TODO - Externalizar en otra clase ya que se trata de un
	// * comportamiento estándar que será utilizado en cualquier
	// * módulo
	// */
	// private WebElement obtenerElementoPorXPathPorIndice(String xpath, int
	// indice) throws Exception {
	// try {
	// List<WebElement> elementos = driver.findElements(By.xpath(xpath));
	// int cantidadElementos = elementos.size();
	// // validar por el límite máximo
	// if ((indice >= 0) && (cantidadElementos > 1) && (cantidadElementos <
	// indice)) {
	// return elementos.get(indice);
	// } else {
	// throw new Exception("El índice: " + indice + " recibido es menor a 0 o la
	// cantidad de elementos: "
	// + cantidadElementos + " retornados para el xpath: " + xpath
	// + " es 0 o supera el límite de elementos");
	// }
	// } catch (Exception e) {
	// throw e;
	// }
	// }

	public void completarReferencia(String textoReferencia) throws Exception {
		getSeleniumUtilitario().waitElementByXpath(CAMPOREFERENCIA);
		getDriver().findElement(By.xpath(CAMPOREFERENCIA)).clear();
		getDriver().findElement(By.xpath(CAMPOREFERENCIA)).sendKeys(textoReferencia);
	}

	/**
	 * @param usuarioProductor
	 *            - Se trata del nombre y apellido exacto de un usuario GDE
	 *            válido para producir el documento.
	 * @param mensajeParaProductor
	 *            - Se trata de un mensaje a enviar al productor de la tarea.
	 * @throws Exception
	 * @see - Esta lógica tiene un problema a resolver: Si existe más de un
	 *      usuario con el mismo nombre y apellido no podría distinguir entre
	 *      ambos
	 */
	public void enviarAProducirTareaUsuario(String usuarioProductor, String mensajeParaProductor) throws Exception {
		driver.findElement(By.xpath(TEXTAREA)).clear();
		driver.findElement(By.xpath(TEXTAREA)).sendKeys(mensajeParaProductor);
		// Extraer/Factorizar ya que este código se repite cada vez que se tiene
		// un input de carga de usuario
		cargarInputSeleccionarUsuarioByXPath(usuarioProductor, CAMPOPRODUCTOR);
		// Extraer
	}

	/**
	 * @param usuario
	 *            Nombre y apellido exacto del Usuario
	 * @param xpathCampoUsuario
	 *            recibe el xpath del campo de usuario, se creó de este modo ya
	 *            que ye se llama al mismo comportamiento en diferentes lugares,
	 *            por ejemplo en la carga de destinatarios de una CCOO o en la
	 *            carga de usuarios firmantes de una tarea de Firma Conjunta
	 *            TODO - Extraer y colocar en otra clase, sugerido:
	 *            SeleniumUtilitario, u otra alternativa podría ser exender esta
	 *            misma y crear SeleniumUtilitarioGEDO.
	 * @throws Exception
	 *             En caso de no encontrar el elemento por xpath corta la
	 *             ejecución
	 */
	private void cargarInputSeleccionarUsuarioByXPath(String usuario, String xpathCampoUsuario) throws Exception {
		// getSeleniumUtilitario().waitElementByXpath(xpathCampoUsuario);
		// driver.findElement(By.xpath(xpathCampoUsuario)).clear();
		// driver.findElement(By.xpath(xpathCampoUsuario)).sendKeys("");
		getSeleniumUtilitario().getWait();
		driver.findElement(By.xpath(xpathCampoUsuario)).sendKeys(usuario);
		getSeleniumUtilitario().getWait();
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

	// Lógica CCOO

	/**
	 * Carga el/los destinatario/s de una CCOO
	 * 
	 * @throws Exception
	 *             -------------------------------------------------------------
	 *             /** TODO Crear nuevo método para el caso de que retorne con
	 *             este xpath más de un elemento.
	 * @deprecated Nuevo método que recibe 3 listas de destinatarios
	 * @see void gedo.api.qa.Documento.cargarDestinatariosCCOO(String[]
	 *      listaDestinatarios, int tipoDestinatario) throws Exception,
	 *      IOException
	 */
	public void definirDestinatariosCCOO(String[] listaDestinatarios) throws Exception {
		int elementosListaDestinatarios = listaDestinatarios.length;
		if (elementosListaDestinatarios > 0) {
			// Itera la lista de strings para ir cargando los destintarios
			for (int i = 0; i < elementosListaDestinatarios; i++) {
				presionarBotonMasDestinatariosCCOO(INDICEBOTONMASDESTINATARIO);
				// Extraer/Factorizar
				getSeleniumUtilitario().waitElementByXpath(SELECCIONARUSUARIODESTINATARIO);
				getCapturarPantalla().capturarPantalla();
				driver.findElement(By.xpath(SELECCIONARUSUARIODESTINATARIO)).clear();
				driver.findElement(By.xpath(SELECCIONARUSUARIODESTINATARIO)).sendKeys(listaDestinatarios[i]);
				driver.findElement(By.cssSelector(TDZ_COMBOITEM_TEXT)).click();
				// Extraer/Factorizar
				getSeleniumUtilitario().getWait();
				getCapturarPantalla().capturarPantalla();
				// Aceptar del popup Seleccionar usuario
				/**
				 * TODO Eliminar hardcode y crear constante
				 */
				getSeleniumUtilitario().clickByXPath(BOTONACEPTAR, 1);
				getSeleniumUtilitario().getWait();
				getCapturarPantalla().capturarPantalla();
			}
			// Aceptar del popup de Definir Destinatarios
			getSeleniumUtilitario().clickByXPath(BOTONACEPTAR, 0);
		}
	}

	/**
	 * Carga el/los destinatario/s, destinatario/s copia y copia oculta de una
	 * CCOO
	 * 
	 * @throws Exception
	 * 
	 */
	public void definirDestinatariosCCOO(String[] listaDestinatarios, String[] listaDestinatariosCopia,
			String[] listaDestinatariosCopiaOculta) throws Exception {
		int elementosListaDestinatarios = (listaDestinatarios != null) ? listaDestinatarios.length : 0;
		int elementosListaDestinatariosCopia = (listaDestinatariosCopia != null) ? listaDestinatarios.length : 0;
		int elementosListaDestinatariosCopiaOculta = (listaDestinatariosCopiaOculta != null) ? listaDestinatarios.length
				: 0;
		if (elementosListaDestinatarios > 0) {
			cargarDestinatariosCCOO(listaDestinatarios, INDICEBOTONMASDESTINATARIO);
			if (elementosListaDestinatariosCopia > 0) {
				cargarDestinatariosCCOO(listaDestinatariosCopia, INDICEBOTONMASCOPIA);
			}
			if (elementosListaDestinatariosCopiaOculta > 0) {
				cargarDestinatariosCCOO(listaDestinatariosCopiaOculta, INDICEBOTONMASCOPIAOCULTA);
			}
			getSeleniumUtilitario().clickByXPath(BOTONACEPTAR, 0);
		} else {
			throw new Exception("Debe cargar como mínimo un destinatario. Rearmar el set de datos y volver a ejecutar");
		}

	}

	/**
	 * @param listaDestinatarios
	 *            - Lista de "Nombre y apellido" de los usuarios destinatarios a
	 *            cargar
	 * @param tipoDestinatario
	 *            0: Para cargar Destinatarios en el para. 1: Para cargar
	 *            destinatarios en copia. 2: Para cargar destinatarios en copia
	 *            oculta.
	 * @throws Exception
	 * @throws IOException
	 */
	private void cargarDestinatariosCCOO(String[] listaDestinatarios, int tipoDestinatario)
			throws Exception, IOException {
		int cantidadElementosListaDestinatarios = (listaDestinatarios != null) ? listaDestinatarios.length : 0;
		if (listaDestinatarios.length > 0) {
			// Itera la lista de strings para ir cargando los destintarios
			for (int i = 0; i < cantidadElementosListaDestinatarios; i++) {
				presionarBotonMasDestinatariosCCOO(tipoDestinatario);
				// Extraer/Factorizar
				getSeleniumUtilitario().waitElementByXpath(SELECCIONARUSUARIODESTINATARIO);
				getCapturarPantalla().capturarPantalla();
				driver.findElement(By.xpath(SELECCIONARUSUARIODESTINATARIO)).clear();
				driver.findElement(By.xpath(SELECCIONARUSUARIODESTINATARIO)).sendKeys(listaDestinatarios[i]);
				driver.findElement(By.cssSelector(TDZ_COMBOITEM_TEXT)).click();
				// Extraer/Factorizar
				getSeleniumUtilitario().getWait();
				getCapturarPantalla().capturarPantalla();
				// Aceptar del popup Seleccionar usuario
				/**
				 * TODO Eliminar hardcode y crear constante
				 */
				getSeleniumUtilitario().clickByXPath(BOTONACEPTAR, 1);
				getSeleniumUtilitario().getWait();
				getCapturarPantalla().capturarPantalla();
			}
		}
	}

	/**
	 * Carga el/los destinatario/s que irá/n en copia de una CCOO
	 * 
	 * @throws Exception
	 */
	public void definirDestinatarioCopiaCCOO() throws Exception {
		presionarBotonMasDestinatariosCCOO(INDICEBOTONMASCOPIA);
	}

	/**
	 * Carga el/los destinatario/s que irá/n en copia oculta de una CCOO
	 * 
	 * @throws Exception
	 */
	public void definirDestinatarioCopiaOcultaCCOO() throws Exception {
		presionarBotonMasDestinatariosCCOO(INDICEBOTONMASCOPIAOCULTA);
	}

	/**
	 * @throws Exception
	 *             "El índice recibido tiene que ser mayor o igual a 0"
	 * @see clickByXPath(String xpath, int indice)
	 */
	private void presionarBotonMasDestinatariosCCOO(int indice) throws Exception {
		getSeleniumUtilitario().clickByXPath(BOTONMAS, indice);
	}

	/**
	 * 
	 */
	public void definirDestinatarios() {
		getSeleniumUtilitario().clickByXPath(DEFINIRDESTINATARIOS);
	}

	/**
	 * Se encarga de cargar los firmantes de una tarea de firma conjunta
	 * 
	 * @param listaFirmante
	 *            TODO
	 * @throws Exception
	 */
	public void cargarFirmantesOmitirRevisores(String[] listaFirmantes) throws Exception {
		getSeleniumUtilitario().clickByXPath(CARGARUSUARIOSFIRMANTES);
		int cantidadElementosListaFirmantes = (listaFirmantes != null) ? listaFirmantes.length : 0;
		// La cantidad mínima de firmantes es 2
		if (listaFirmantes.length > 1) {
			for (int i = 0; i < cantidadElementosListaFirmantes; i++) {
				cargarInputSeleccionarUsuarioByXPath(listaFirmantes[i], CAMPOUSUARIOFIRMANTE);
				getSeleniumUtilitario().getWait();
				getCapturarPantalla().capturarPantalla();
				// Agregar a la lista de firmantes
				getSeleniumUtilitario().clickByXPath(BOTONAGREGAR);
				getSeleniumUtilitario().getWait();
				getCapturarPantalla().capturarPantalla();
				if (usuarioFirmanteTieneRevisor()) {
					getCapturarPantalla().capturarPantalla();
					getSeleniumUtilitario().getWait();
					noAgregarRevisorFirmante();
					getCapturarPantalla().capturarPantalla();
				}
			}
			// getSeleniumUtilitario().clickByXPath(BOTONGUARDAR);
		} else {
			throw new Exception("Debe cargar como mínimo 2 firmantes. Rearmar el set de datos y volver a ejecutar");
		}
	}

	/**
	 * 
	 * */
	private void agregarRevisorFirmante(String string) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * */
	private void noAgregarRevisorFirmante() {
		getSeleniumUtilitario().clickByXPath(BOTONNO);
	}

	/**
	 * Validar en caso de que no tenga revisor un firmante.
	 * ----------------------------------------------------------------------
	 * TODO A futuro sería idea validar esto directamente contra EU
	 */
	private boolean usuarioFirmanteTieneRevisor() {
		try {
			// Se valida que si el usuario firmante no tiene revisor
			getSeleniumUtilitario().waitElementByXpath(CARTELFIRMANTENOREVISOR);
			getCapturarPantalla().capturarPantalla();
			return true;
		} catch (Exception e) {
			// Se termina la espera y no apareció el cartel de validación de
			// revisor
		}
		return false;
	}
}
