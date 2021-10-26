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

public class TestEvaluaciones {
	
	//Localizadores para las evaluaciones
	private static By evaluacionesLocator = By.xpath("//*[@id=\"listado\"]/div[14]/a");
	private static By dentroDeEvalLocator = By.xpath("//*[@id=\"contenido\"]/h1");
	private static By crearExamenLocator = By.xpath("//*[@id=\"contenido\"]/fieldset[1]/button[1]");
	private static By dentroDeCrearExamLocator = By.xpath("//*[@id=\"contenido\"]/h1");
	private static By entrAutoNuevoExamLocator = By.xpath("//*[@id=\"configEx\"]/div[6]/div[2]/label");
	private static By duracionNuevoExamLocator = By.xpath("//*[@id=\"HoraDuracion\"]");
	private static By horaAdverNuevoExamLocator = By.xpath("//*[@id=\"HoraAdvertencia\"]");
	private static By notaAprobNuevoExamLocator = By.xpath("//*[@id=\"NotaAprobar\"]");
	private static By mostrarRespNuevoExamLocator = By.xpath("//*[@id=\"configEx\"]/div[12]/div[2]/label");
	private static By pregCategNuevoExamLocator = By.xpath("//*[@id=\"configEx\"]/div[13]/div[2]/label");
	private static By tituloNuevoExamLocator = By.xpath("//*[@id=\"nombreExamen\"]");
	private static By ordenSecNuevoExamLocator = By.xpath("//*[@id=\"configEx\"]/div[14]/div[2]/div/div[1]/label");
	private static By ordenAleatNuevoExamLocator = By.xpath("//*[@id=\"configEx\"]/div[14]/div[2]/div/div[2]/label");
	private static By pregNOAleatNuevoExamLocator = By.xpath("//*[@id=\"configEx\"]/div[15]/div[2]/div/div[1]/label");
	private static By pregSIAleatNuevoExamLocator = By.xpath("//*[@id=\"configEx\"]/div[15]/div[2]/div/div[2]/label");
	private static By alcanceNuevoExamLocator = By.xpath("//*[@id=\"AlcanceExamen\"]");
	private static By descripNuevoExamLocator = By.xpath("/html");
	private static By genAutomNuevoExamLocator = By.xpath("//*[@id=\"configEx\"]/div[20]/div[2]/label");
	private static By crearNuevoExamLocator = By.xpath("//*[@id=\"aceptarConfigEx\"]");
	private static By cancelarNuevoExamLocator = By.xpath("//*[@id=\"BTN_CrearEA20\"]");
	
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
	public static void hacerEvaluacionSimulacroEvaluaciones(String tituloEvaluacion,boolean entrAuto,String duracionEvaluacion,String horaAdvertenciaEvaluacion,String notaAprobEvaluacion,boolean mostrRespue,boolean orgPreg,boolean ordenPreg,boolean pregAleat,String descripcionEvaluacion,boolean evenAutom) throws IOException, InterruptedException {
		TestIniciarSesion.entrarAulaSimulacroEvaluaciones(true);
		
		//String tituloEvaluacion = "Evaluacion creada desde eclipse";
		//String duracionEvaluacion = "03:00";
		//String horaAdvertenciaEvaluacion = "00:01:00";
		//String notaAprobEvaluacion = "7.0";
		//String descripcionEvaluacion = "Evaluacion de test";
		
		driver.findElement(evaluacionesLocator).click();
		
		ArrayList<WebElement> listWebElements = new ArrayList();
		
		if(driver.findElement(dentroDeEvalLocator).isDisplayed()) {
			driver.findElement(crearExamenLocator).click();
			if(driver.findElement(dentroDeCrearExamLocator).isDisplayed()) {
				driver.findElement(tituloNuevoExamLocator).sendKeys(tituloEvaluacion);
				if(!entrAuto) {
					driver.findElement(entrAutoNuevoExamLocator).click();
				}
				driver.findElement(duracionNuevoExamLocator).clear();
				driver.findElement(duracionNuevoExamLocator).sendKeys(duracionEvaluacion);
				driver.findElement(horaAdverNuevoExamLocator).clear();
				driver.findElement(horaAdverNuevoExamLocator).sendKeys(horaAdvertenciaEvaluacion);
				driver.findElement(notaAprobNuevoExamLocator).clear();
				driver.findElement(notaAprobNuevoExamLocator).sendKeys(notaAprobEvaluacion);
				if(!mostrRespue) {
					driver.findElement(mostrarRespNuevoExamLocator).click();
				}
				if(orgPreg) {
					driver.findElement(pregCategNuevoExamLocator).click();
				}
				if(ordenPreg) {
					driver.findElement(ordenSecNuevoExamLocator).click();
				}
				else {
					driver.findElement(ordenAleatNuevoExamLocator).click();
				}
				if(pregAleat) {
					driver.findElement(pregSIAleatNuevoExamLocator).click();
				}
				else {
					driver.findElement(pregNOAleatNuevoExamLocator).click();
				}
				listWebElements = (ArrayList<WebElement>) driver.findElement(alcanceNuevoExamLocator).findElements(By.tagName("option"));
				for(int i = 0 ; i < listWebElements.size() ; i++) {
					if(listWebElements.get(i).getText().equals("Para algunos alumnos")) {
						listWebElements.get(i).click();
					}
				}
				driver.findElement(descripNuevoExamLocator).sendKeys(descripcionEvaluacion);
				if(!evenAutom) {
					driver.findElement(genAutomNuevoExamLocator).click();
				}
			}
			else {
				fail("Error al ingresar a la pestaña de crear evaluaciones");
			}
		}
		else {
			fail("Error al ingresar a la pestaña de evaluaciones");
		}
		
	}

}
