package gedo.api.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/***
 * @autor Carlos Gauto
 **/
public class DocumentoImportado extends Documento {
	// Patrón utilizado para diferencias las capturas de pantalla realizadas
	private static String patronCapturasPantalla = GEDOIMPORTADO_;

	public DocumentoImportado(WebDriver driver, String rutaArchivosEntrada) {
		super(driver, rutaArchivosEntrada, patronCapturasPantalla);
	}

	/**
	 * 
	 * @param archivoImportado
	 */

	public void seleccionarArchivo(String archivoImportado) {
		getDriver().findElement(By.xpath(SELECCCIONARARCHIVO)).sendKeys(RUTAARCHIVOSENTRADA + archivoImportado);
	}

	public void producirDocumentoImportado(String textoReferencia, String archivoImportado) throws Exception {
		completarReferencia(textoReferencia);
		seleccionarArchivo(archivoImportado);
	}
}
