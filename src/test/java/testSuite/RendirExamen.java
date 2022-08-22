package testSuite;

import static org.junit.Assert.fail;
import static testEvelia.TestEvelia.driver;
import testEvelia.Paths.*;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RendirExamen {
	
	public static String usuarioAlumno = "1110011";
	public static String contraseniaAlumno = "10011";
	
	public static void iniciarSesion(String usuario, String contrasenia) throws InterruptedException {
		// Ingreso nombre de usuario
		driver.findElement(Paths.usuario).sendKeys(usuarioAlumno);
		// Ingreso nombre de usuario
		driver.findElement(Paths.contrasenia).sendKeys(contraseniaAlumno);
		// cliqueo ACCEDER
		Thread.sleep(1000);
		driver.findElement(Paths.acceder).click();
		
		Thread.sleep(1000);
		
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
		if (verdadero) {
			driver.findElement(Paths.respVerdadero).click();
		} else {
			driver.findElement(Paths.respFalso).click();
		}
		Thread.sleep(1000);
		driver.findElement(Paths.siguiente).click();
		Thread.sleep(1000);
	}
	
	public static void numericaCalculada(String respuesta) {
		driver.findElement(Paths.respNumCalc).sendKeys(respuesta);
		driver.findElement(Paths.entregar).click();
	}
	
	public static void rendirExamenCompleto() throws InterruptedException {
		iniciarSesion(usuarioAlumno, contraseniaAlumno);
		driver.findElement(Paths.rendirExamen).click();
		Thread.sleep(1000);
		
		Random rand = new Random();
		int num = rand.nextInt(2);
		boolean bool = rand.nextBoolean();
		
		opcionMultiple(num);
		verdaderoFalso(bool);
		
		num = rand.nextInt(11);
		numericaCalculada(String.valueOf(num));
		
	}

}
