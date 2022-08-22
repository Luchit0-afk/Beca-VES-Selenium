package testEvelia;

import static org.junit.Assert.fail;
import static testEvelia.TestEvelia.driver;
import testEvelia.Paths.*;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class examCreate {
	
	// ULTIMA VERSION
	public static void iniciarSesion0(String usuario, String contrasenia) throws IOException, InterruptedException {

		driver.findElement(Paths.usuarioLocator).sendKeys(usuario);
		driver.findElement(Paths.contraseniaLocator).sendKeys(contrasenia);
		Thread.sleep(1000);

		driver.findElement(Paths.iniciarSesionLocator).click();
		
		/*
		if(driver.findElement(paginaInicialEveliaLocator).isDisplayed()) {
			System.out.println("Ingreso correcto a Evelia");
		}
		else {
			fail("Error al ingresar a Evelia");
		}
		*/
	}
	
	public static void entrarAulaSimulacroEvaluaciones0(boolean esDocente) throws IOException, InterruptedException {
		iniciarSesion0("18645043", "siat2019");
		//iniciarSesion("99999001", "siat2019");
		
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
	
	public static void ingresoExamen() throws IOException, InterruptedException {
		//TestIniciarSesion.entrarAulaTestingAutomatizadoDocente();
		entrarAulaSimulacroEvaluaciones0(true);
		
		driver.findElement(Paths.evaluacionesBotonLocator).click();
		driver.findElement(Paths.crearExamenBotonLocator).click();
	}
	
	public static void crearExamen(String titulo) throws IOException, InterruptedException {
		ingresoExamen();
		
		driver.findElement(Paths.inputTituloExamenLocator).sendKeys("test");
		
		Thread.sleep(1000);
		driver.findElement(Paths.guardarEvaluacionBotonLocator).click();
		
		Select select = new Select(driver.findElement(By.id("tipoPregunta")));
		
		select.selectByIndex(0);
		
		driver.findElement(Paths.agregarPreguntaBotonLocator).click();
		
		//driver.findElement(Paths.escribirPreguntaLocator).click();
		//driver.findElement(Paths.escribirPreguntaLocator).click();
		driver.findElement(Paths.nuevaPagina).click();
		driver.findElement(Paths.escribirPreguntaLocator).sendKeys("pregunta 1");
		
		driver.findElement(Paths.puntajePreguntaLocator).sendKeys("5");
		
		driver.findElement(Paths.opcionCorrecta).sendKeys("si");
		driver.findElement(Paths.opcionIncorrecta).sendKeys("no");
		
		driver.findElement(Paths.mezclarAlAzar).click();
		
		driver.findElement(Paths.aceptar).click();
		
	}

}
