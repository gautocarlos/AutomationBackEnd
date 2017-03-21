package gedo.api.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DocumentoImportado extends Documento {

	public DocumentoImportado(WebDriver driver, String rutaArchivosEntrada) {
		super(driver, rutaArchivosEntrada);
	}

	/**
	 * 
	 * @param archivoImportado
	 */

	public void seleccionarArchivo(String archivoImportado) {
		getDriver().findElement(By.xpath(SELECCCIONARARCHIVO)).sendKeys(RUTAARCHIVOSENTRADA + archivoImportado);
	}
	
	public void producirDocumentoImportado(String textoReferencia, String archivoImportado) {
		completarReferencia(textoReferencia);
		seleccionarArchivo(archivoImportado);
	}
}
