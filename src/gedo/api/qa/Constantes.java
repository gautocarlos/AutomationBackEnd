package gedo.api.qa;

/***
 * @autor Carlos Gauto
 **/
public interface Constantes {
	public static final String GEDOLIBRE_ = "GEDOLIBRE_";
	public static final String GEDOIMPORTADO_ = "GEDOIMPORTADO_";
	public static final String GEDOTEMPLATE_ = "GEDOTEMPLATE_";
	public static final String GEDOIMPTEMPLATE_ = "GEDOIMPTEMPLATE_";
	public static final String URLGEDO = "http://eug.nac.gde.gob.ar/gedo-web/";
	public static final String INICIODOCUMENTO = "//img[contains(@src,'./imagenes/page_white_text.png')]";
	public static final String DOCUMENTOELECTRONICO = "//td[3]/i/input";
	public static final String PRODUCIRLOYOMISMO = "//img[contains(@src,'/gedo-web/imagenes/ProducirloYoMismo.png')]";
	public static final String ENVIARAPRODUCIR = "//img[contains(@src,'/gedo-web/imagenes/EnviarAProducir.png')]";
	public static final String CANCELAR = "//img[contains(@src,'/gedo-web/imagenes/Cancelar.png')]";
	public static final String ARCHIVOSDETRABAJO = "//img[contains(@src,'/gedo-web/imagenes/ArchivosDeTrabajo.png')]";
	public static final String ENVIARAREVISAR = "//img[contains(@src,'/gedo-web/imagenes/EnviarARevisar.png')]";
	public static final String HISTORIAL_GRANDE = "//img[contains(@src,'./imagenes/historial_grande.png')]";
	public static final String PREVISUALIZARDOCUMENTO = "//img[contains(@src,'./imagenes/PrevisualizarDocumento.png')]";
	public static final String VOLVERALDOCUMENTO = "//img[contains(@src,'./imagenes/VolverAlDocumento.png')]";
	public static final String CAMPOREFERENCIA = "//td[2]/input";
	public static final String FIRMARYOMISMO = "//img[contains(@src,'/gedo-web/imagenes/FirmarYoMismoElDocumento.png')]";
	public static final String FIRMARCONCERTIFICADO = "//img[contains(@src,'./imagenes/FirmarConCertificado.png')]";
	public static final String RECHAZOFIRMARDOCUMENTO = "//img[contains(@src,'./imagenes/RechazoFirmarDocumento.png')]";
	public static final String VOLVERALBUZONDETAREAS = "//img[contains(@src,'./imagenes/VolverAlBuzonTareas.png')]";
	public static final String MODIFICARYOMISMOELDOCUMENTO = "//img[contains(@src,'/gedo-web/imagenes/ModificarYoMismoElDocumento.png')]";
	public static final String FIRMARCONTOKEN = "//img[contains(@src,'./imagenes/FirmarConToken.png')]";
	public static final String RUTAARCHIVOSENTRADA = ".\\archivosDeEntrada\\";
	public static final String RUTACAPTURASDEPANTALLA = ".\\capturasDePantalla\\";
	public static final String CAMPOUSUARIOCAS = "/html/body/div/div[2]/div[2]/div/div/div/div/div[2]/div/input";
	public static final String CAMPOPASSWORDCAS = "/html/body/div/div[2]/div[2]/div/div/div/div/div[3]/div/input";
	public static final String CAMPOACCEDERCAS = "/html/body/div/div[2]/div[2]/div/div/div/div/div[4]/button";
	// DocumentoImportado
	public static final String SELECCCIONARARCHIVO = "//table/tbody[2]/tr/td[1]/span/form/input";
	/*
	 * Cartel al intentar enviar una tarea de confección a un usuario que no
	 * pertenece a la repartición del emisor
	 */
	public static final String DISTINTAREPASI = "//tbody/tr/td[1]/span/table/tbody/tr[2]/td[2]";
	public static final String DISTINTAREPANO = "//tbody/tr/td[3]/span/table/tbody/tr[2]/td[2]";

	public static final String PROCESOPRODUCCION = "//span[contains(text(),'El proceso de producción del documento se ha iniciado correctamente')]";
	public static final String TDMSJBOXOK = "//td[contains(text(),'OK')]";
	public static final String BOTONACEPTAR = "//td[contains(text(),'Aceptar')]";

	/**/
	public static final String TDZ_COMBOITEM_TEXT = "td.z-comboitem-text";
	public static final String TD_TEXTAREA = "//td/textarea";
	//
	public static final String CAMPOREVISOR = "//tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td[5]/i/input";
}
