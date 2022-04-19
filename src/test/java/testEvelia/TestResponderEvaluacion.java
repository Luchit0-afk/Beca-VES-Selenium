/**
 * Clase que esta destinida a guardar metodos para la creacion y entrega de 
 * eveluaciones en las distintas aulas de evelia. En esta clase deberian ir 
 * todas las interracciones con la pestaña <b>Evaluaciones</b> de evelia.
 */
package testEvelia;

import static org.junit.Assert.fail;
import static testEvelia.TestIniciarSesion.*;
import static testEvelia.TestEvelia.*;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestResponderEvaluacion {
	
	//Localizadores para las evaluaciones
	private static By evaluacionesLocator = By.xpath("//*[@id=\"listado\"]/div[14]/a");
	private static By dentroDeEvalLocator = By.xpath("//*[@id=\"contenido\"]/h1");
	private static By nombreEvaluacionLocator = By.xpath("//*[@id=\"examenDisp\"]/tbody/tr[1]/td[1]");
	
	private static By botonParaRendirEvaluacionLocator = By.xpath("//*[@id=\"examenDisp\"]/tbody/tr[1]/td[4]/center/button");
	private static By dentroDeRendirLocator = By.xpath("//*[@id=\"contenido\"]/h1");
	private static By opcionCorrectaMultipleChoiceLocator = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div[1]/div/div[1]/label");
	private static By botonSiguientePreguntaLocator = By.xpath("//*[@id=\"pregunta\"]/div[3]/div[2]/center/button");
	private static By opcionCorrectaVerdFalsoLocator = By.xpath("//input[@value='verdadero']");
	private static By inputPregNumericaLocator = By.xpath("//input[@id='rtaNC3']");
	private static By inputPregCompFraseLocator = By.xpath("//input[@name='rtaCF41']");
	private static By inputPregCerradaLocator = By.xpath("//input[@name='rtaRC5']");
	private static By inputRespuestaAbiertaLocator = By.xpath("//*[@id=\"cke_126_contents\"]/iframe");
	private static By botonEntregarLocator = By.xpath("//*[@id=\"FinalizExamen\"]");
	private static By inputComentariosLocator = By.xpath("//input[@id='comentarioDescargaExamen']");
	private static By botonEnviarComentariosLocator = By.xpath("//*[@id=\"EnviarComentario\"]");
	private static By examenFinalizadoLocator = By.xpath("//*[@id=\"contenido\"]/div[4]");

	
	/**
	 * Metodo que crea una evaluacion en el aula <b>"Simulacro Evaluaciones (030518) - 2018"</b>.
	 * @param tituloEvaluacion titulo que llevara la evaluacion
	 * @param duracionEvaluacion duracion que tendra la evaluacion
	 * @param horaAdvertenciaEvaluacion 
	 * @param entrAuto true sii la entrega de la evaluacion es automatica una vez finalizada la evaluacion, false en caso contrario
	 * @param notaAprobEvaluacion nota para aprobar la evaluacion
	 * @param mostrRespue true para mostrar al alumno las respuestas correctas una vez finalizada la evaluacion, false en caso contrario
	 * @param orgPreg true para organizar las preguntas en categorias, false para no organizarlas en categorias
	 * @param ordenPreg true para ordenar las preguntas secuencialmente, false para ordenarlas de manera aleatoria
	 * @param pregAleat true para tener preguntas aleatorias, false para tenerlas de manera secuencial
	 * @param descripcionEvaluacion descripcion de la evaluacion
	 * @param evenAutom true para generar un evento automaticamente, false para no generarlo
	 * @throws IOException
	 * @throws InterruptedException
	 * Usa el metodo <i>TestIniciarSesion.entrarAulaSimulacroEvaluaciones(true)</i> para iniciar sesion como docente.
	 */
	public static void hacerEvaluacionSimulacroEvaluaciones() throws IOException, InterruptedException {
		TestIniciarSesion.entrarAulaSimulacroEvaluaciones(false);
		
		driver.findElement(evaluacionesLocator).click();
		Thread.sleep(1000);
		
		if ( driver.findElement(dentroDeEvalLocator).isDisplayed() ) {
			if ( driver.findElement(nombreEvaluacionLocator).isDisplayed() ) {
				driver.findElement(botonParaRendirEvaluacionLocator).click();
				Thread.sleep(1000);
				if ( driver.findElement(dentroDeRendirLocator).isDisplayed() ) {
					
					Thread.sleep(1500);

					driver.findElement(opcionCorrectaMultipleChoiceLocator).click();
					driver.findElement(botonSiguientePreguntaLocator).click();
					
					Thread.sleep(1500);
					
					driver.findElement(opcionCorrectaVerdFalsoLocator).click();
					
					Thread.sleep(1500);

					driver.findElement(botonSiguientePreguntaLocator).click();
					
					Thread.sleep(1500);
					
					driver.findElement(inputPregNumericaLocator).clear();
					driver.findElement(inputPregNumericaLocator).sendKeys("1");
					
					Thread.sleep(1500);

					driver.findElement(botonSiguientePreguntaLocator).click();
					
					Thread.sleep(1500);

					driver.findElement(inputPregCompFraseLocator).clear();
					driver.findElement(inputPregCompFraseLocator).sendKeys("Completar");
					
					Thread.sleep(1500);

					driver.findElement(botonSiguientePreguntaLocator).click();
					
					Thread.sleep(1500);

					driver.findElement(inputPregCerradaLocator).clear();
					driver.findElement(inputPregCerradaLocator).sendKeys("1");
					
					Thread.sleep(1500);

					driver.findElement(botonSiguientePreguntaLocator).click();
					
					Thread.sleep(1500);

					//Falta completar la ultima pregunta
					driver.findElement(botonEntregarLocator).click();
					
					Thread.sleep(1500);
					
					driver.switchTo().alert().accept();
					
					Thread.sleep(4000);
					
					driver.findElement(inputComentariosLocator).clear();
					driver.findElement(inputComentariosLocator).sendKeys("Este comentario fue hecho desde Selenium.");
					
					Thread.sleep(1500);

					driver.findElement(botonEnviarComentariosLocator).click();
					
					Thread.sleep(1500);
					
					if ( !driver.findElement(nombreEvaluacionLocator).isDisplayed() ) {
						fail("Algo sucedio mal en la entrega de la evaluacion.");
					}
				}
				else {
					fail("Error al ingresar a la evaluacion.");
				}

			}
			else {
				fail("La evaluacion que quiere rendir no se encuentra disponible");
			}
			
		}
		else {
			fail("Error al ingresar a la pestaña de evaluaciones");
		}
		
	}

}