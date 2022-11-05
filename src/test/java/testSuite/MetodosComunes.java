package testSuite;

import static testSuite.TestSuite.driver;

public class MetodosComunes {
	
	enum TipoUsuario { ALUMNO, DOCENTE }
	
	public static void iniciarSesion(String usuario, String contrasenia) throws InterruptedException {
		driver.findElement(Paths.usuario).sendKeys(usuario);
		driver.findElement(Paths.contrasenia).sendKeys(contrasenia);
		
		Thread.sleep(1000);
		
		driver.findElement(Paths.acceder).click();
	}
	
	public static void ingresarAEvaluaciones(TipoUsuario tp) throws InterruptedException {
		if (tp == TipoUsuario.DOCENTE) {
			driver.findElement(Paths.aulaDoc).click();
			driver.findElement(Paths.comisionDoc).click();
			driver.findElement(Paths.evaluacionesDoc).click();
		} else {
			driver.findElement(Paths.aulaAlum).click();
			driver.findElement(Paths.comisionAlum).click();
			driver.findElement(Paths.evaluacionesAlum).click();
		}
	}
	
	public static void cerrarSesion() {
		driver.findElement(Paths.ventParaSalir).click();
		driver.findElement(Paths.salir).click();
	}

}
