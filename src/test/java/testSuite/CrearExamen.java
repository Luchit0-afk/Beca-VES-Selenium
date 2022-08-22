package testSuite;

import static org.junit.Assert.fail;
import static testEvelia.TestEvelia.driver;
import testEvelia.Paths.*;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CrearExamen {

	public static String usuarioDocente = "1110100";
	public static String contraseniaDocente = "10100";
	public static String tituloExamen = "Examen";
	
	public static void iniciarSesion(String usuario, String contrasenia) throws InterruptedException {
		// Ingreso nombre de usuario
		driver.findElement(Paths.usuario).sendKeys(usuarioDocente);
		// Ingreso nombre de usuario
		driver.findElement(Paths.contrasenia).sendKeys(contraseniaDocente);
		// cliqueo ACCEDER
		Thread.sleep(1000);
		driver.findElement(Paths.acceder).click();
		
		Thread.sleep(1000);
		
		// Ingreso al aula
		driver.findElement(Paths.aula).click();
		// Ingreso a la comicion
		driver.findElement(Paths.comision).click();
		// Ingreso a evaluaciones
		driver.findElement(Paths.evaluaciones).click();
	}
	
	public static void crearExamen(String titulo) {
		//
		driver.findElement(Paths.crearExamen).click();
		//
		driver.findElement(Paths.tituloExamen).sendKeys(titulo);
		//
		driver.findElement(Paths.guardarDatos).click();
	}
	
	// HACER CICLO DEL 1 AL 5 
	
	public static void agregarPregunta(int indice, String puntaje) throws InterruptedException {
		//
		Select select = new Select(driver.findElement(By.id("tipoPregunta")));
		// USAR INDICE
		select.selectByIndex(indice);
		Thread.sleep(1000);
		//
		//driver.findElement(Paths.agregarPregunta).click();
		// Agrego puntaje
		//driver.findElement(Paths.puntaje).sendKeys(puntaje);
		
		/*
		//
		driver.findElement(Paths.mezclarAlAzar).click();
		//
		driver.findElement(Paths.aceptar).click();
		*/
	}
	
	public static void opcionMultiple(String opCorrecta, String opIncorrecta) {
		driver.findElement(Paths.opcionCorrecta).sendKeys(opCorrecta);
		driver.findElement(Paths.opcionCorrecta).sendKeys(opIncorrecta);
	}
	
	public static void verdaderoFalso(boolean verdadero) {
		if (verdadero) {
			driver.findElement(Paths.verdadero).click();
		} else {
			driver.findElement(Paths.falso).click();
		}
	}
	
	public static void numericaCalculada(String numero) {
		driver.findElement(Paths.respuesta).sendKeys(numero);
	}
	
	// TERMINAR !!!
	
	public static void asociacionDeTerminos(String numero) {
		driver.findElement(Paths.respuesta).sendKeys(numero);
	}
	
	public static void formatoTabla(String numero) {
		driver.findElement(Paths.respuesta).sendKeys(numero);
	}
	
	public static void crearExamenCompleto() throws InterruptedException {
		iniciarSesion(usuarioDocente, contraseniaDocente);
		crearExamen(tituloExamen);
		Thread.sleep(1000);
		agregarPregunta(2, "1");
		driver.findElement(Paths.agregarPregunta).click();
		//opcionMultiple("correcta", "incorrecta");
		verdaderoFalso(true);
		// Agrego puntaje
		driver.findElement(Paths.puntaje).sendKeys("1");
		//
		//driver.findElement(Paths.mezclarAlAzar).click();
		//
		//driver.findElement(Paths.aceptar).click();
		
	}
	
	private static WebElement waitForElement(By locator, int timeout){
	    WebElement element = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
	    return element;
	}
	
}
