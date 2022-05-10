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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testEvelia.Paths.*;


public class TestIniciarSesion {
	
	
	/**
	 * Metodo que inicia sesion como docente o alumno a evelia.
	 * @param esDocente true para entrar como docente, false para entrar como alumno.
	 * Usa un archivo externo .xlsx para extraer datos de ingreso al aula.
	 */
	public static void iniciarSesion(boolean esDocente) throws IOException, InterruptedException {
		//String filePathDatosUsuario = "/home/luchit0afk/eclipse-workspace/QuealityStreamTutorial/datosEvelia.xlsx";
//		String filePathDatosUsuario = "/home/agustin/Escritorio/Repositorios/Beca-VES./datosEvelia.xlsx";
		// Cambiar a ods ?????
		String usuario;
		String contraseña;
//		if(esDocente) {
//			usuario = readExcelFile.getCellValue(filePathDatosUsuario, "Hoja1", 1, 1);
//			contraseña = readExcelFile.getCellValue(filePathDatosUsuario, "Hoja1", 2, 1);
//			
//		}
//		else {
//			//usuario = readExcelFile.getCellValue(filePathDatosUsuario, "Hoja1", 1, 5);
//			//contraseña = readExcelFile.getCellValue(filePathDatosUsuario, "Hoja1", 2, 1);
//			
//			usuario = readExcelFile.getCellValue(filePathDatosUsuario, "Hoja1", 1, 8);
//			contraseña = readExcelFile.getCellValue(filePathDatosUsuario, "Hoja1", 2, 8);
//		}
		if(esDocente) {
			usuario = "1110100";
			contraseña = "10100";
			
		}
		else {			
			usuario = "1110013";
			contraseña = "10013";
		}
		//driver.findElement(usuarioLocator).sendKeys(usuario);
		//driver.findElement(contraseñaLocator).sendKeys(contraseña);
		//driver.findElement(iniciarSesionLocator).click();
		driver.findElement(Paths.usuario2).sendKeys(usuario);
		driver.findElement(Paths.contraseña2).sendKeys(contraseña);
		Thread.sleep(1000);

		driver.findElement(Paths.iniciarSesion).click();
		
		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(iniciarSesion)).click();
//		driver.findElement(iniciarSesion).click();
		//Thread.sleep(1000);
		/*
		if(driver.findElement(paginaInicialEveliaLocator).isDisplayed()) {
			System.out.println("Ingreso correcto a Evelia");
		}
		else {
			fail("Error al ingresar a Evelia");
		}
		*/
	}
	
	/**
	 * Metodo que entrar al aula <b>"Simulacro Evaluaciones (030518) - 2018"</b>.
	 * @param esDocente true para entrar como docente, false para entrar como alumno.
	 * Usa el metodo <i> iniciarSesion(esDocente) </i> para iniciar sesion en evelia.
	 */
	public static void entrarAulaSimulacroEvaluaciones(boolean esDocente) throws IOException, InterruptedException {
		iniciarSesion(esDocente);
		
		if(esDocente) {
			driver.findElement(Paths.simulacroEvaluacionesDocenteLocator).click();
		}
		else {
			driver.findElement(Paths.simulacroEvaluacionesAlumnoLocator).click();
		}
		Thread.sleep(1000);
		
		if(driver.findElement(Paths.dentroDeAulaVirtualLocator).isDisplayed()) {
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
			driver.findElement(Paths.testIRCDocenteLocator).click();
		}
		else {
			driver.findElement(Paths.testIRCAlumnoLocator).click();
		}
		Thread.sleep(1000);
		
		if(driver.findElement(Paths.dentroDeAulaVirtualLocator).isDisplayed()) {
			System.out.println("Ingreso correcto al aula de Simulacro De Evaluaciones");
		}
		else {
			fail("Error al ingresar al aula de Simulacro De Evaluaciones");
		}
	}

	public static void entrarAulaTestingAutomatizadoAlumno() throws IOException, InterruptedException {
		iniciarSesion(false);
		
		//Thread.sleep(1000);
		driver.findElement(Paths.aula).click();
		//Thread.sleep(1000);
		//driver.findElement(comision).click();
		
	}
	
	public static void entrarAulaTestingAutomatizadoDocente() throws IOException, InterruptedException {
		iniciarSesion(true);
		
		//Thread.sleep(1000);
		driver.findElement(Paths.aulaDocente).click();
		//Thread.sleep(1000);
		driver.findElement(Paths.comision).click();
		
	}
	
	/**
	 * Metodo que inicia sesion como docente o alumno a evelia.
	 * @param esDocente true para entrar como docente, false para entrar como alumno.
	 * Usa un archivo externo .xlsx para extraer datos de ingreso al aula.
	 */
	public static void iniciarSesionConParametros(String usuario, String contrasenia) throws IOException, InterruptedException {
		
		driver.findElement(Paths.usuarioLocator).sendKeys(usuario);
		driver.findElement(Paths.contraseñaLocator).sendKeys(contrasenia);
		driver.findElement(Paths.iniciarSesionLocator).click();
		
		Thread.sleep(1000);
		
		if(driver.findElement(Paths.paginaInicialEveliaLocator).isDisplayed()) {
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
//	public static void entrarAulaSimulacroEvaluacionesConParametros(String Usuario, String Contrasenia) throws IOException, InterruptedException {
//		iniciarSesion(esDocente);
//		
//		if(esDocente) {
//			driver.findElement(simulacroEvaluacionesDocenteLocator).click();
//		}
//		else {
//			driver.findElement(simulacroEvaluacionesAlumnoLocator).click();
//		}
//		Thread.sleep(1000);
//		
//		if(driver.findElement(dentroDeAulaVirtualLocator).isDisplayed()) {
//			System.out.println("Ingreso correcto al aula de Simulacro De Evaluaciones");
//		}
//		else {
//			fail("Error al ingresar al aula de Simulacro De Evaluaciones");
//		}
//	}
	
	private static WebElement waitForElement(By locator, int timeout){
	    WebElement element=new WebDriverWait(driver,timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
	    return element;
	}
	
}
