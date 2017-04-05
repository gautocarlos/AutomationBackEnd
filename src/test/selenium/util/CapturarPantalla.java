package test.selenium.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import gde.api.qa.Constantes;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.remote.Augmenter;
/***
 * @autor Carlos Gauto
 **/
public class CapturarPantalla implements Constantes {

	private WebDriver driver;
	/**
	 * TODO Pasar la ruta de captura como constante
	 * */
	private String rutaCapturasDePantalla = "capturasDePantalla";
	private String patron;

	// Constructor
	public CapturarPantalla(WebDriver driver, String rutaCapturasDePantalla, String patron) {
		setDriver(driver);
		setPatron(patron);
		setRutaCapturasDePantalla(rutaCapturasDePantalla);
	}

	public String getRutaCapturasDePantalla() {
		return rutaCapturasDePantalla;
	}

	public void setRutaCapturasDePantalla(String rutaCapturasDePantalla) {
		this.rutaCapturasDePantalla = rutaCapturasDePantalla;
	}

	public WebDriver getDriver() {
		return driver;
	}

	// public void setDriver(PhantomJSDriver driver) {
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getPatron() {
		return (patron.equals(null)?"Captura_":patron);
	}

	public void setPatron(String patron) {
		this.patron = patron;
	}

	public void capturarPantalla(/* String patron */) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
		Date date = new Date();
		String nombreArchivoCaptura;
		/***
		 * TODO Recibir como parámetro el campo: patrón para definir el patrón
		 * en el nombre de la captura realizada, por ejemplo una opción podría
		 * ser el sistema que realiza la prueba
		 **/
//		String patron = "GEDO_";
		System.out.println(dateFormat.format(date)); // 2016-11-16_12.08.43
		System.out.println("Tomando captura de pantalla.");
		// setDriver((PhantomJSDriver) new Augmenter().augment(getDriver()));
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		System.out.println("File:" + srcFile);
		try {
			nombreArchivoCaptura = RUTACAPTURASDEPANTALLA + getPatron() + dateFormat.format(date) + ".png";
			FileUtils.copyFile(srcFile, new File(nombreArchivoCaptura));
			System.out.println("Captura de pantalla realizada:" + nombreArchivoCaptura);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}

	}

}
