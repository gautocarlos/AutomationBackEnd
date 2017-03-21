package gedo.api.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/***
 * @autor Carlos Gauto
 **/
public class DocumentoLibre extends Documento {
	// Patrón utilizado para diferencias las capturas de pantalla realizadas
	private static String patronCapturasPantalla = GEDOLIBRE_;

	public DocumentoLibre(WebDriver driver, String rutaCapturasDePantalla) {
		super(driver, rutaCapturasDePantalla, patronCapturasPantalla);
	}

	/**
	 * TODO: Quitar harcode "file"
	 * 
	 * @param textoReferencia
	 * @param rutaArchivoPuntoDoc
	 */

	public void producirDocumentoLibreImportarWord(String textoReferencia, String archivoPuntoDoc) {
		// getEspera().waitElementByXpath(campoReferencia);
		// getDriver().findElement(By.xpath(campoReferencia)).clear();
		// getDriver().findElement(By.xpath(campoReferencia)).sendKeys(textoReferencia);
		completarReferencia(textoReferencia);
		getDriver().findElement(By.name("file")).sendKeys(RUTAARCHIVOSENTRADA + archivoPuntoDoc);
	}

}
