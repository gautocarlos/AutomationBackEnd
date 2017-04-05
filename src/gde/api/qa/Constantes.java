package gde.api.qa;

/***
 * @autor Carlos Gauto
 **/
public interface Constantes {
	//TABS GEDO
	public static final String TABMISTAREAS = "//span[contains(., 'Mis Tareas') and contains(@class, 'z-tab-text')]";
	public static final String TABTAREASOTROSUSUARIOS = "//span[contains(., 'Tareas otros Usuarios') and contains(@class, 'z-tab-text')]";
	public static final String TABTAREASSUPERVISADOS = "//span[contains(., 'Tareas Supervisados') and contains(@class, 'z-tab-text')]";
	public static final String TABADMTIPOSDOCUMENTOS = "//span[contains(., 'Adm. Tipos Documentos') and contains(@class, 'z-tab-text')]";
	public static final String TABCONSULTAS = "//span[contains(., 'Consultas') and contains(@class, 'z-tab-text')]";
	public static final String TABPLANTILLAS = "//span[contains(., 'Plantillas') and contains(@class, 'z-tab-text')]";
	public static final String TABPORTAFIRMA = "//span[contains(., 'Porta Firma') and contains(@class, 'z-tab-text')]";
	//Botones TABCONSULTA
	public static final String BUSQUEDADETAREAS  = "//button[contains(., 'Búsqueda de Tareas') and contains(@type, 'button')]";
	public static final String BUSQUEDADETAREASZ  = "//div[contains(.,button[contains(., 'Búsqueda de Tareas') and contains(@type, 'button')])]";
	public static final String BUSQUEDADETAREASX  = "//table/tbody/tr/td[4]/a/table/tbody/tr/td[2]/div/button";
	public static final String BUSQUEDADEDOCUMENTOS  = "//button[contains(text(), 'Búsqueda de Documentos') and contains(@type, 'button')]";
	public static final String BUSCAR  = "//td[contains(., 'Buscar') and contains(@class, 'z-button-cm')]";
	// Span de la pantalla De la Descripción del tipo de trámite a iniciar
	public static final String DESCRIPCIONDELTIPODEDOCUMENTO = "//span[contains(text(),'Descripción del tipo de documento')]";
	//Patrones para generar screenshot por clase
	public static final String GEDOLIBRE_ = "GEDOLIBRE_";
	public static final String GEDOIMPORTADO_ = "GEDOIMPORTADO_";
	public static final String GEDOTEMPLATE_ = "GEDOTEMPLATE_";
	public static final String GEDOIMPTEMPLATE_ = "GEDOIMPTEMPLATE_";
	public static final String TAREA_ = "TAREA_";
	//
	public static final String URLGEDOTEST = "http://eug.nac.gde.gob.ar/gedo-web/";
	public static final String URLGEDOQA = "http://eug.qac.gde.gob.ar/gedo-web/";
	public static final String INICIODOCUMENTO = "//img[contains(@src,'./imagenes/page_white_text.png')]";
	public static final String DOCUMENTOELECTRONICO = "//td[3]/i/input";
	public static final String PRODUCIRLOYOMISMO = "//img[contains(@src,'/gedo-web/imagenes/ProducirloYoMismo.png')]";
	public static final String ENVIARAPRODUCIR = "//img[contains(@src,'/gedo-web/imagenes/EnviarAProducir.png')]";
	public static final String ENVIARAFIRMAR = "//img[contains(@src,'/gedo-web/imagenes/EnviarAFirmar.png')]";
	public static final String DEFINIRDESTINATARIOS = "//img[contains(@src,'/gedo-web/imagenes/definirDestinatarios.png')]";
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
	// Botones TD
	public static final String BOTONACEPTAR = "//td[contains(text(),'Aceptar')]";
	public static final String BOTONAGREGAR = "//td[contains(text(),'Agregar')]";
	public static final String BOTONGUARDAR = "//td[contains(text(),'Guardar')]";
	public static final String BOTONCANCELAR = "//td[contains(text(),'Cancelar')]";
//	public static final String BOTONSI = "//td[contains(text(),'Sí')]";
	public static final String BOTONSI = "//td[contains(., 'Sí') and contains(@class, 'z-button-cm')]";
	public static final String BOTONNO = "//td[contains(., 'No') and contains(@class, 'z-button-cm')]";
	/**/
	public static final String TDZ_COMBOITEM_TEXT = "td.z-comboitem-text";
	public static final String TD_TEXTAREA = "//td/textarea";
	//
	public static final String CAMPOREVISOR = "//tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td[5]/i/input";
	public static final String CAMPOPRODUCTOR = "//div/i/input";
	public static final String TEXTAREA = "//textarea";
	// Firma conjunta
	public static final String CARGARUSUARIOSFIRMANTES = "//img[contains(@src,'/gedo-web/imagenes/CargarUsuariosFirmantes.png')]";
	public static final String CAMPOUSUARIOFIRMANTE = "//tbody/tr/td[2]/div/i/input";
	public static final String CARTELFIRMANTESINREVISOR = "El usuario firmante seleccionado no tiene definido un usuario revisor de documentos de firma conjunta en su perfil de Escritorio Único (solapa Datos Personales). Si es necesario usted puede agregar ahora un revisor para este documento.";
	public static final String CARTELFIRMANTENOREVISOR = "//span[contains(text(),'El usuario firmante seleccionado no tiene definido un usuario revisor de documentos de firma conjunta en su perfil de Escritorio Único (solapa Datos Personales). Si es necesario usted puede agregar ahora un revisor para este documento.')]";
	// Enviar a firmar documento
	public static final String CAMPOFIRMANTE = "//tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td[5]/i/input";
	public static final String LABELQUIEROAVISOCUANDOFIRME = "//label[contains(text(),'Quiero recibir un aviso cuando el documento se firme.')]";
	public static final String LABELQUIEROENVIARUNCORREOALRECEPTORDELATAREA = "//label[contains(text(),'Quiero enviar un correo electrónico al receptor de la tarea.')]";
	// Destinatario de una CCOO
	public static final String CAMPODESTINATARIO = "//tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td[5]/i/input";
	public static final String BOTONMAS = "//img[contains(@src,'/gedo-web/imagenes/mas.png')]";
	public static final String SELECCIONARUSUARIODESTINATARIO = "//tbody/tr/td/table/tbody/tr[3]/td/i/input";
	public static final int INDICEBOTONMASDESTINATARIO = 0;
	public static final int INDICEBOTONMASCOPIA = 1;
	public static final int INDICEBOTONMASCOPIAOCULTA = 2;

}
