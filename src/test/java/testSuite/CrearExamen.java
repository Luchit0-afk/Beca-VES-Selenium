package testSuite;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static testSuite.TestSuite.driver;

public class CrearExamen {

	private static String usuarioDocente = "1110100";
	private static String contraseniaDocente = "10100";
	private static String tituloExamen = "AAAAA";
	private static String notaDeAprobacion = "5.0";
	
	private static void iniciarSesion(String usuario, String contrasenia) throws InterruptedException {
		// Ingreso nombre de usuario
		driver.findElement(Paths.usuario).sendKeys(usuarioDocente);
		// Ingreso nombre de usuario
		driver.findElement(Paths.contrasenia).sendKeys(contraseniaDocente);
		// cliqueo ACCEDER
		Thread.sleep(1000);
		driver.findElement(Paths.acceder).click();
		
	}
	
	private static void ingresarAEvaluaciones() {
		// Ingreso al aula
		driver.findElement(Paths.aula).click();
		// Ingreso a la comicion
		driver.findElement(Paths.comision).click();
		// Ingreso a evaluaciones
		driver.findElement(Paths.evaluaciones).click();
	}
	
	// paso 1
	private static void crearExamen(String titulo) {
		driver.findElement(Paths.crearExamen).click();
		driver.findElement(Paths.tituloExamen).sendKeys(titulo);
		driver.findElement(Paths.guardarDatos).click();
	}
	
	// paso 2
	private static void agregarNotaDeAprobacion(String nota) throws InterruptedException {
		driver.findElement(Paths.notaDeAprobacion).sendKeys("5");
		
		Thread.sleep(1000);
		/*
		driver.findElement(Paths.disponibleDesde).clear();
		Thread.sleep(10000);
		driver.findElement(Paths.disponibleDesde).sendKeys("11/09/2022");
		Thread.sleep(5000);
		driver.findElement(Paths.disponibleHasta).clear();
		Thread.sleep(10000);
		driver.findElement(Paths.disponibleHasta).sendKeys("11/09/2022");
		*/
		driver.findElement(Paths.guardarDatos).click();
	}
	
	private static void agregarPregunta(int indice, String puntaje) throws InterruptedException {
		
		
		// selecciono el tipo de pregunta
		Select select = new Select(driver.findElement(By.id("tipoPregunta")));
		// USAR INDICE
		select.selectByIndex(indice);
		Thread.sleep(1000);

		driver.findElement(Paths.agregarPregunta).click();
		
		driver.findElement(Paths.puntaje).sendKeys(puntaje);
		//driver.findElement(Paths.aceptar).click();
		
		// preparo la publicacion
		
		/*
		//
		driver.findElement(Paths.mezclarAlAzar).click();
		//
		driver.findElement(Paths.aceptar).click();
		*/
	}
	
	private static void agregarPreguntas(String[] puntajes) throws InterruptedException {
		for (int i = 1; i < 4; i++) {
			agregarPregunta(i, puntajes[i]);
			tipoDePregunta(i);
			driver.findElement(Paths.aceptar).click();
		}
	}
	
	private static void tipoDePregunta(int indice) {
		switch( indice ) 
		{
			case 1:
				opcionMultiple("correcta", "incorrecta");
				break;
			case 2:
				verdaderoFalso(true);
				break;
			case 3:
				numericaCalculada("5");
				break;
			//case 6:
				//asociacionDeTerminos("1", "2", "3", "4");
				//break;
			//case 7:
				//formatoTabla("1", "2", "3", "4");
				//break;
			default:
				break;
		}
			
	}
	
	
	private static void publicarEvaluacion() throws InterruptedException {
		driver.findElement(Paths.prepararPublicacion).click();
		Thread.sleep(1000);
		driver.findElement(Paths.publicarYReservarEvaluacion).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	private static void opcionMultiple(String opCorrecta, String opIncorrecta) {
		driver.findElement(Paths.opcionCorrecta).sendKeys(opCorrecta);
		driver.findElement(Paths.opcionIncorrecta).sendKeys(opIncorrecta);
	}
	
	private static void verdaderoFalso(boolean verdadero) {
		if (verdadero) {
			driver.findElement(Paths.verdadero).click();
		} else {
			driver.findElement(Paths.falso).click();
		}
	}
	
	private static void numericaCalculada(String numero) {
		driver.findElement(Paths.respuesta).sendKeys(numero);
	}
	
	private static void asociacionDeTerminos(String pmp1, String smp1, String pmp2, String smp2) {
		List<WebElement> array = new ArrayList<WebElement>();
		array = driver.findElements(By.id("primerMiembroPareja"));
		
		Select primerMiembroPareja1 = new Select(array.get(0));
		Select primerMiembroPareja2 = new Select(array.get(1));
		
		driver.findElement(Paths.primerMiembroPareja).sendKeys(pmp1);
		driver.findElement(Paths.segundoMiembroPareja).sendKeys(pmp2);
		
		array = driver.findElements(By.id("primerMiembroPareja"));
		
		Select segundoMiembroPareja1 = new Select(array.get(0));
		Select segundoMiembroPareja2 = new Select(array.get(1));
		
		driver.findElement(Paths.primerMiembroPareja).sendKeys(smp1);
		driver.findElement(Paths.segundoMiembroPareja).sendKeys(smp2);
		
	}
	
	private static void formatoTabla(String p1, String r1, String p2, String r2) {
		driver.findElement(Paths.pregunta1).sendKeys(p1);
		driver.findElement(Paths.respuesta1).sendKeys(r1);
		
		driver.findElement(Paths.pregunta2).sendKeys(p2);
		driver.findElement(Paths.respuesta2).sendKeys(r2);
	}
	
	private static void cerrarSesion() {
		driver.findElement(Paths.ventParaSalir).click();
		driver.findElement(Paths.salir).click();
	}
	
	public static void crearExamenCompleto() throws InterruptedException {
		iniciarSesion(usuarioDocente, contraseniaDocente);
		ingresarAEvaluaciones();
		crearExamen(tituloExamen);
		agregarNotaDeAprobacion(notaDeAprobacion);
		Thread.sleep(1000);
		String[] puntajes = {"0.0", "3.0", "3.0", "4.0"};
		agregarPreguntas(puntajes);
		Thread.sleep(10000);
		publicarEvaluacion();
		cerrarSesion();
	}
	
	private static WebElement waitForElement(By locator, int timeout){
	    WebElement element = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
	    return element;
	}
	
}
