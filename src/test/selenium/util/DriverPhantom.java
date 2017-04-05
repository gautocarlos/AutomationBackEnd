package test.selenium.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverPhantom extends DriverWeb {

	@Override
	public WebDriver inicializar() throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true);
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				"C:/phantomjs-2.1.1-windows/bin/phantomjs.exe");
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] { "--web-security=no",
				"--ignore-ssl-errors=yes", "--ignore-ssl-errors=true", "--ssl-protocol=TLSv1" });

		try {
			setDriver(new PhantomJSDriver(caps));
			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Fix tamaño pantalla
			getDriver().manage().window().maximize();
			// Fix tamaño pantalla
			System.out.println("Inicialización Driver PhantomJS: SIN ERRORES");
		} catch (Exception e) {
			System.out.println("Inicialización Driver PhantomJS: ERROR");
			throw e;
		}
		return getDriver();
	}

}
