package testEvelia;



import java.io.IOException;
import static testEvelia.TestEvelia.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testEvelia.Paths.*;

public class RendirExamen {
	/*
	// BOTONES - SERVIDOR DE PRUEBA
	// Botones comunes
	private static By evaluaciones = By.xpath("//*[@id=\"listado\"]/div[14]/a");
	private static By rendirExamen = By.xpath("//*[@id=\"examenDisp\"]/tbody/tr/td[4]/center/button");
	private static By siguiente = By.xpath("//*[@id=\"pregunta\"]/div[3]/div[2]/center/button");
	private static By entregar = By.xpath("//*[@id=\"FinalizExamen\"]");
	
	// Botones de opcion multiple
	private static By opcionUno = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div[1]/div/div[1]/label");
	private static By opcionDos = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div[2]/div/div[1]/label");
	
	// Botones de verdadero falso
	private static By verdadero = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/div[1]/label");
	private static By falso = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/div[2]/label");
	
	// Botones de respuesta numerica
	private static By escribir = By.xpath("//*[@id=\"rtaNC1\"]");
	// APRENDER A ESCRIBIR O PASAR CADENAS POR EXCEL
	*/
	
												
	protected static void ingresoExamen() throws IOException, InterruptedException {
		//TestIniciarSesion.entrarAulaSimulacroEvaluaciones(false);
		TestIniciarSesion.entrarAulaTestingAutomatizadoAlumno();
		
		driver.findElement(Paths.evaluaciones).click();
		//driver.findElement(Paths.rendirExamen).click();
		//driver.findElement(Paths.rendirExamen2).click();
		//driver.findElement(Paths.rendirExamen3).click();
		driver.findElement(Paths.rendirExamen(3)).click();
	}
	
	protected static void ingresoExamenConParametro(int position) throws IOException, InterruptedException {
		//TestIniciarSesion.entrarAulaSimulacroEvaluaciones(false);
		TestIniciarSesion.entrarAulaTestingAutomatizadoAlumno();
		
		driver.findElement(Paths.evaluaciones).click();
		driver.findElement(Paths.rendirExamen(position)).click();
		//driver.findElement(Paths.rendirExamen2).click();
	}
	
	// OPCION MULTIPLE CON DOS RESPUESTAS
	/*
	public static void opcionMultiple(int cantidadPreguntas, int[] respuestas) throws IOException, InterruptedException {
		
		ingresoExamen();
		
		for (int i = 0; i < cantidadPreguntas; i++) {
			if (respuestas[i] == 1) {
				driver.findElement(Paths.opcionUno).click();
				//Thread.sleep(500);
			} else {
				driver.findElement(Paths.opcionDos).click();
				//Thread.sleep(500);
			}
			driver.findElement(Paths.siguiente).click();
			//Thread.sleep(500);
		}
		
		driver.findElement(Paths.entregar).click();
		//Thread.sleep(500);
		//driver.switchTo().alert().accept();
		
		System.out.println("Evaluacion rendida exitosamente");
	}
	*/
	public static void opcionMultiple(int opciones, int respuesta) {
		if (opciones < 1) {
			throw new IllegalArgumentException("Cantidad de opcines invalida");
		}
		if (respuesta < 1 || respuesta > opciones) {
			throw new IllegalArgumentException("Respuesta invalida");
		} 
		if (respuesta == 1) {
			driver.findElement(Paths.opcionUno).click();
		} else {
			driver.findElement(Paths.opcionDos).click();
		}
	}
	
	/*
	public static void verdaderoFalso(int cantidadPreguntas, boolean[] respuestas) throws IOException, InterruptedException {
		
		ingresoExamen();
		
		for (int i = 0; i < cantidadPreguntas; i++) {
			if (respuestas[i] == true) {
				driver.findElement(Paths.verdadero).click();
			} else {
				driver.findElement(Paths.falso).click();
			}
			driver.findElement(Paths.siguiente).click();
		}

		driver.findElement(Paths.entregar).click();
	}
	*/
	public static void verdaderoFalso(boolean respuesta) {
		if (respuesta) {
			driver.findElement(Paths.verdadero).click();
		} else {
			driver.findElement(Paths.falso).click();
		}
	}
	
	public static void siguiente() {
		driver.findElement(Paths.siguiente).click();
	}
	/*
	public static void formatoTabla(int cantidadPreguntas, int cantidadOpciones, int[][] respuestas) throws IOException, InterruptedException {
		
		ingresoExamen();
		
		// PENSAR BIEN
		for (int i = 0; i < cantidadPreguntas; i++) {
			for (int j = 0; j < cantidadOpciones; j++) {
				if (respuestas[i][j] == 1) {
					driver.findElement(Paths.preguntaXOpcionY(i+1,1+1)).click();
				} else {
					if (respuestas[i][j] == 2) {
						driver.findElement(Paths.preguntaXOpcionY(i+1,2+1)).click();
					} else {
						driver.findElement(Paths.preguntaXOpcionY(i+1,3+1)).click();
					}
				}
			}
			driver.findElement(Paths.siguiente).click();
		}
		driver.findElement(Paths.entregar).click();	
	}
	*/
	public static void formatoTabla(int[] respuestas) {
		for (int i = 0; i < respuestas.length; i++) {
			if (respuestas[i] == 1) {
				driver.findElement(Paths.preguntaXOpcionY(i+1,1+1)).click();
			} else {
				if (respuestas[i] == 2) {
					driver.findElement(Paths.preguntaXOpcionY(i+1,2+1)).click();
				} else {
					driver.findElement(Paths.preguntaXOpcionY(i+1,3+1)).click();
				}
			}
		}
	}
	/*
	public static void numericoCalculada() throws IOException, InterruptedException {
		
		ingresoExamenConParametro(5);
		
		driver.findElement(Paths.inputNumericoCalculadaRespuestaLocator).sendKeys("1");
		
		Thread.sleep(2000);
		System.out.print("Respondida la evaluacion de manera correcta");
		
	}
	*/
	public static void numericaCalculada(double respuesta) {
		driver.findElement(Paths.inputNumericoCalculadaRespuestaLocator).sendKeys(String.valueOf(respuesta));
	}
	/*
	public static void completarFrase() throws IOException, InterruptedException {
		
		ingresoExamenConParametro(4);
		
		WebElement WebElementPrimerSelect = driver.findElement(Paths.primerSelectCompletarFraseLocator);
		WebElement WebElementSegundoSelect = driver.findElement(Paths.segundoSelectCompletarFraseLocator);
		
		Select primerSelect = new Select(WebElementPrimerSelect);
		Select segundoSelect = new Select(WebElementSegundoSelect);
		
		
//		primerSelect.selectByVisibleText("Correcta");
//		segundoSelect.selectByVisibleText("Incorrecta");
		primerSelect.selectByIndex(1);
		segundoSelect.selectByIndex(2);
		
		Thread.sleep(2000);
		System.out.print("Respondida la evaluacion de manera correcta");
	}
	*/
	public static void completarFrase() {
		WebElement WebElementPrimerSelect = driver.findElement(Paths.primerSelectCompletarFraseLocator);
		WebElement WebElementSegundoSelect = driver.findElement(Paths.segundoSelectCompletarFraseLocator);
		
		Select primerSelect = new Select(WebElementPrimerSelect);
		Select segundoSelect = new Select(WebElementSegundoSelect);
		
		primerSelect.selectByIndex(1);
		segundoSelect.selectByIndex(2);
	}
	
	/*
	public static void asociacionDeTerminos() throws IOException, InterruptedException {
		
		ingresoExamenConParametro(3);
		
		WebElement WebElementPrimerSelect = driver.findElement(Paths.primerSelectAsociacionTerminosLocator);
		WebElement WebElementSegundoSelect = driver.findElement(Paths.segundoSelectAsociacionTerminosLocator);
		
		Select primerSelect = new Select(WebElementPrimerSelect);
		Select segundoSelect = new Select(WebElementSegundoSelect);
		
		
		primerSelect.selectByVisibleText("Correcto");
		segundoSelect.selectByVisibleText("Incorrecto");
//		primerSelect.selectByIndex(1);
//		segundoSelect.selectByIndex(2);
		
		Thread.sleep(2000);
		System.out.print("Respondida la evaluacion de manera correcta");	
	}
	*/
	public static void asociacionDeTerminos() {
		WebElement WebElementPrimerSelect = driver.findElement(Paths.primerSelectAsociacionTerminosLocator);
		WebElement WebElementSegundoSelect = driver.findElement(Paths.segundoSelectAsociacionTerminosLocator);
		
		Select primerSelect = new Select(WebElementPrimerSelect);
		Select segundoSelect = new Select(WebElementSegundoSelect);
		
		primerSelect.selectByVisibleText("Correcto");
		segundoSelect.selectByVisibleText("Incorrecto");
	}

}
