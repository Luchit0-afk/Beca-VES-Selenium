package testEvelia;



import java.io.IOException;
import static testEvelia.TestEvelia.*;
import static org.junit.Assert.fail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testEvelia.Paths.*;

public class CrearExamen {
						
	private static By evaluacionesBotonLocator = By.xpath("//*[@id=\"listado\"]/div[10]/a");
	private static By crearExamenBotonLocator = By.xpath("//*[@id=\"contenido\"]/fieldset[1]/button[1]");
	private static By inputTituloExamenLocator = By.xpath("//*[@id=\"nombreExamen\"]");
	private static By guardarEvaluacionBotonLocator = By.xpath("//*[@id=\"aceptarConfigEx\"]");
	private static By tituloDentroDeCrearExamenLocator = By.xpath("//*[@id=\"contenido\"]/h1");
	private static By tipoPreguntaSelectLocator = By.xpath("//*[@id=\"tipoPregunta\"]");
	private static By agregarPreguntaBotonLocator = By.xpath("//*[@id=\"configEx\"]");
	private static By tituloTipoPreguntaLegendLocator = By.xpath("//*[@id=\"addPregunta\"]/fieldset/legend");
	private static By puntuacionInputLocator = By.xpath("//*[@id=\"puntuacion\"]");
	private static By crearPreguntaLocator = By.xpath("//*[@id=\"addPreguntas\"]");
	
	
	//Opcion multiple
	private static By opcionCorrectaInputLocator = By.xpath("//*[@id=\"opciones\"]");
	private static By opcionIncorrectaLocator = By.xpath("//*[@id=\"otrasOpc\"]");
	
	
	private static void ingresoExamen() throws IOException, InterruptedException {
		//TestIniciarSesion.entrarAulaTestingAutomatizadoDocente();
		TestIniciarSesion.entrarAulaSimulacroEvaluaciones(true);
		
		driver.findElement(evaluacionesBotonLocator).click();
		driver.findElement(crearExamenBotonLocator).click();
	}
	
	public static void crearExamen(String titulo) throws IOException, InterruptedException {
		ingresoExamen();
		if ( driver.findElement(tituloDentroDeCrearExamenLocator).isDisplayed() ) {

			driver.findElement(inputTituloExamenLocator).sendKeys("test");
			

			driver.findElement(guardarEvaluacionBotonLocator).click();

			WebElement WebElementTipoPreguntaSelect = driver.findElement(tipoPreguntaSelectLocator);
			Select tipoPreguntaSelect = new Select(WebElementTipoPreguntaSelect);
			//Creando pregunta multiple opcion
			System.out.print("Creando pregunta multiple opcion");
			tipoPreguntaSelect.selectByVisibleText("Opción Múltiple");
//			Thread.sleep(1000);
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(agregarPreguntaBotonLocator)).click();
//			driver.findElement(agregarPreguntaBotonLocator).click();
			Thread.sleep(10000);

//			System.out.print(driver.findElement(tituloTipoPreguntaLegendLocator).getText());
			//Deberia chequear que estamos en la vista de crear pregunta
//			if( (driver.findElement(tituloTipoPreguntaLegendLocator).getText()).equalsIgnoreCase("Opción Múltiple")) {
				
				driver.findElement(puntuacionInputLocator).sendKeys("1");
				driver.findElement(crearPreguntaLocator).click();

//			}
//			else {
//				fail("Error al intentar agregar una pregunta multiple opcion");
//			}
			System.out.print("La pregunta multiple opcion se creo correctamente");


		}
		else {
			fail("Fallo al intentar entrar a crear exa");
		}
	}
	

}
