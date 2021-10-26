/**
 * Clase que esta destinada a guardar metodos para el inicio de sesion en evelia 
 * y metodos para entrar a las distintas aulas virtuales.
 * 
 */
package testEvelia;

import static org.junit.Assert.fail;
import static testEvelia.TestEvelia.*;

import java.io.IOException;

import org.openqa.selenium.By;


public class TestIniciarSesion {
	
	//Localizadores de las aulas donde podemos entrar
	private static By simulacroEvaluacionesDocenteLocator = By.xpath("//*[@id=\"contenido\"]/ul[3]/li[1]/a/b");
	private static By testIRCDocenteLocator = By.xpath("//*[@id=\"contenido\"]/ul[3]/li[2]/a/b");
	private static By simulacroEvaluacionesAlumnoLocator = By.xpath("//*[@id=\"contenido\"]/ul[4]/li[1]/a/b");
	private static By testIRCAlumnoLocator = By.xpath("//*[@id=\"contenido\"]/ul[4]/li[2]/a/b");
	
	//Localizador para verificar el correcto ingreso a un aula(cualquiera) en evelia
	private static By dentroDeAulaVirtualLocator = By.xpath("//*[@id=\"contenido\"]/h1");
	
	private static By usuarioLocator = By.xpath("//*[@id=\"login\"]");
	private static By contraseñaLocator = By.xpath("//*[@id=\"clave\"]");
	private static By iniciarSesionLocator = By.xpath("//*[@id=\"Ingresar\"]/b");
	private static By paginaInicialEveliaLocator = By.xpath("//*[@id=\"contenido\"]/div[4]/h4");
	
	/**
	 * Metodo que inicia sesion como docente o alumno a evelia.
	 * @param esDocente true para entrar como docente, false para entrar como alumno.
	 * Usa un archivo externo .xlsx para extraer datos de ingreso al aula.
	 */
	public static void iniciarSesion(boolean esDocente) throws IOException, InterruptedException {
		String filePathDatosUsuario = "/home/luchit0afk/eclipse-workspace/QuealityStreamTutorial/datosEvelia.xlsx";
		String usuario;
		String contraseña;
		if(esDocente) {
			usuario = readExcelFile.getCellValue(filePathDatosUsuario, "Hoja1", 1, 1);
			contraseña = readExcelFile.getCellValue(filePathDatosUsuario, "Hoja1", 2, 1);
			
		}
		else {
			usuario = readExcelFile.getCellValue(filePathDatosUsuario, "Hoja1", 1, 5);
			contraseña = readExcelFile.getCellValue(filePathDatosUsuario, "Hoja1", 2, 1);
		}
		driver.findElement(usuarioLocator).sendKeys(usuario);
		driver.findElement(contraseñaLocator).sendKeys(contraseña);
		driver.findElement(iniciarSesionLocator).click();
		
		Thread.sleep(1000);
		
		if(driver.findElement(paginaInicialEveliaLocator).isDisplayed()) {
			System.out.println("Ingreso correcto a Evelia");
		}
		else {
			fail("Error al ingresar a Evelia");
		}
	}
	
	/**
	 * Metodo que entrar al aula <b>"Simulacro Evaluaciones (030518) - 2018"</b>.
	 * @param esDocente true para entrar como docente, false para entrar como alumno.
	 * Usa el metodo <i> iniciarSesion(esDocente) </i> para iniciar sesion en evelia.
	 */
	public static void entrarAulaSimulacroEvaluaciones(boolean esDocente) throws IOException, InterruptedException {
		iniciarSesion(esDocente);
		
		if(esDocente) {
			driver.findElement(simulacroEvaluacionesDocenteLocator).click();
		}
		else {
			driver.findElement(simulacroEvaluacionesAlumnoLocator).click();
		}
		Thread.sleep(1000);
		
		if(driver.findElement(dentroDeAulaVirtualLocator).isDisplayed()) {
			System.out.println("Ingreso correcto al aula de Simulacro De Evaluaciones");
		}
		else {
			fail("Error al ingresar al aula de Simulacro De Evaluaciones");
		}
	}
	
	/**
	 * Metodo que entrar al aula <b>"test IRC - EVELIA1 (AGO19) - 2019"</b>.
	 * @param esDocente true para entrar como docente, false para entrar como alumno.
	 * Usa el metodo <i> iniciarSesion(esDocente) </i> para iniciar sesion en evelia.
	 */
	public static void entrarAulaTestIRC(boolean esDocente) throws IOException, InterruptedException {
		iniciarSesion(esDocente);
		if(esDocente) {
			driver.findElement(testIRCDocenteLocator).click();
		}
		else {
			driver.findElement(testIRCAlumnoLocator).click();
		}
		Thread.sleep(1000);
		
		if(driver.findElement(dentroDeAulaVirtualLocator).isDisplayed()) {
			System.out.println("Ingreso correcto al aula de Simulacro De Evaluaciones");
		}
		else {
			fail("Error al ingresar al aula de Simulacro De Evaluaciones");
		}
	}
	
}