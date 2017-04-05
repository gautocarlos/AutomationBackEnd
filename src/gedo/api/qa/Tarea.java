/**
 * 
 */
package gedo.api.qa;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import gde.api.qa.Constantes;
import test.selenium.util.CapturarPantalla;
import test.selenium.util.SeleniumUtilitario;

/**
 * @author cargauto Clase utilizada para realizar opreaciones sobre tareas
 *
 */
public class Tarea implements Constantes {
	/**
	 * 
	 */
	private WebDriver driver; // Extender WebDriver para sumarle nuevo
	// comportamiento a extraer de la clase
	// Documento
	private SeleniumUtilitario seleniumUtilitario;
	private CapturarPantalla capturarPantalla;
	private String patronCapturasPantalla = TAREA_;

	/**
	 * 
	 */
	public Tarea(WebDriver driver, String rutaArchivosEntrada) {
		setDriver(driver);
		setSeleniumUtilitario(new SeleniumUtilitario(driver));
		setCapturarPantalla(new CapturarPantalla(driver, RUTACAPTURASDEPANTALLA, patronCapturasPantalla ));
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @param driver
	 *            the driver to set
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @return the seleniumUtilitario
	 */
	public SeleniumUtilitario getSeleniumUtilitario() {
		return seleniumUtilitario;
	}

	/**
	 * @param seleniumUtilitario
	 *            the seleniumUtilitario to set
	 */
	public void setSeleniumUtilitario(SeleniumUtilitario seleniumUtilitario) {
		this.seleniumUtilitario = seleniumUtilitario;
	}

	/**
	 * @return the capturarPantalla
	 */
	public CapturarPantalla getCapturarPantalla() {
		return capturarPantalla;
	}

	/**
	 * @param capturarPantalla
	 *            the capturarPantalla to set
	 */
	public void setCapturarPantalla(CapturarPantalla capturarPantalla) {
		this.capturarPantalla = capturarPantalla;
	}

	/**
	 * @param fechaDesde
	 *            [Opcional] filtra de las tareas en las cuales participó el
	 *            usuario a partir desde una fecha determinada
	 * @param fechaHasta
	 *            [Opcional] filtra de las tareas en las cuales participó el
	 *            usuario hasta una fecha determinada
	 * @param tipoDeDocumento
	 *            [Opcional] filtra de las tareas en las cuales participó,
	 *            aquellas que sean del tipo de documento que se reciba
	 * @param tipoDeTarea
	 *            [Opcional] filtra de las tareas en las cuales participó el
	 *            usuario, aquellas que sean del tipo de tarea que se reciba
	 * @param usuarioDestino
	 *            [Opcional] filtra de las tareas en las cuales participó el
	 *            usuario, las que tenga actualmente el usuario destino que se
	 *            reciba
	 * @throws Exception 
	 */
	public void busquedaDeTareas(Date fechaDesde, Date fechaHasta, String tipoDeDocumento, String tipoDeTarea,
			String usuarioDestino) throws Exception {
		getSeleniumUtilitario().getWait();
		getSeleniumUtilitario().clickByXPath(TABCONSULTAS);
		getCapturarPantalla().capturarPantalla();
		getSeleniumUtilitario().getWait();
		getSeleniumUtilitario().waitElementByXpath(BUSQUEDADETAREAS);
		getSeleniumUtilitario().clickByXPath(BUSQUEDADETAREAS);
		getSeleniumUtilitario().getWait();
		getCapturarPantalla().capturarPantalla();
		getSeleniumUtilitario().getWait();
		getSeleniumUtilitario().clickByXPath(BUSCAR);
		getSeleniumUtilitario().getWait();
		getCapturarPantalla().capturarPantalla();
	}

}
