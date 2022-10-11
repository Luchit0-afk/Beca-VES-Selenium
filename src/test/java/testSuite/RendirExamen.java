package testSuite;

import java.util.Random;


import static testSuite.TestSuite.driver;

public class RendirExamen {
	
	private static String usuarioAlumno = "1110011";
	private static String contraseniaAlumno = "10011";
	
	private static void iniciarSesion(String usuario, String contrasenia) throws InterruptedException {
		// Ingreso nombre de usuario
		driver.findElement(Paths.usuario).sendKeys(usuarioAlumno);
		// Ingreso nombre de usuario
		driver.findElement(Paths.contrasenia).sendKeys(contraseniaAlumno);
		// cliqueo ACCEDER
		Thread.sleep(1000);
		driver.findElement(Paths.acceder).click();
	}
	
	private static void ingresarAEvaluaciones() {
		// Ingreso al aula
		driver.findElement(Paths.aulaAlumno).click();
		// Ingreso a la comicion
		driver.findElement(Paths.comision).click();
		// Ingreso a evaluaciones
		driver.findElement(Paths.evalAlumno).click();
	}
	
	public static void opcionMultiple(int numero) throws InterruptedException {
		if (numero == 0) {
			driver.findElement(Paths.opcion1).click();
		} else {
			driver.findElement(Paths.opcion2).click();
		}
		Thread.sleep(1000);
		driver.findElement(Paths.siguiente).click();
		Thread.sleep(1000);
	}
	
	public static void verdaderoFalso(boolean verdadero) throws InterruptedException {
		//String value = driver.findElement(Paths.respVerdadero).getAttribute("value");
		//Select select = new Select(driver.findElement(By.id("rtaVF2")));
		//select.selectByValue("true");
		/*
		if (verdadero) {
			driver.findElement(Paths.respVerdadero).click();
		} else {
			driver.findElement(Paths.respFalso).click();
		}
		*/
		Thread.sleep(1000);
		driver.findElement(Paths.siguiente).click();
		Thread.sleep(1000);
	}
	
	public static void numericaCalculada(String respuesta) {
		driver.findElement(Paths.respNumCalc).sendKeys(respuesta);
		//driver.findElement(Paths.entregar).click();
	}
	
	public static void rendirExamenCompleto() throws InterruptedException {
		iniciarSesion(usuarioAlumno, contraseniaAlumno);
		ingresarAEvaluaciones();
		Thread.sleep(1000);
		driver.findElement(Paths.rendirExamen).click();
		Thread.sleep(1000);
		
		Random rand = new Random();
		int num = rand.nextInt(2);
		boolean bool = rand.nextBoolean();
		
		opcionMultiple(num);
		verdaderoFalso(bool);
		
		
		num = rand.nextInt(11);
		numericaCalculada(String.valueOf(num));
		Thread.sleep(1000);
		driver.findElement(Paths.entregar).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		Thread.sleep(1000);
		driver.findElement(Paths.ventParaSalir).click();
		driver.findElement(Paths.salir).click();
		
	}

}
