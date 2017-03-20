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
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.remote.Augmenter;

public class CapturarPantalla {

	private WebDriver driver;
	private String rutaCapturasDePantalla = "capturasDePantalla";

	// Constructor
	public CapturarPantalla(WebDriver driver, String rutaCapturasDePantalla) {
		setDriver(driver);
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

	public void capturarPantalla() throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); // 2016-11-16_12.08.43
		System.out.println("Tomando captura de pantalla.");
//		setDriver((PhantomJSDriver) new Augmenter().augment(getDriver()));
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		System.out.println("File:" + srcFile);
		try {
			FileUtils.copyFile(srcFile,
					new File(".\\" + rutaCapturasDePantalla + "\\screenshot_" + dateFormat.format(date) + ".png"));
			System.out.println("Captura de pantalla realizada.");
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}

	}

}
