/**
 * Clase que esta destinida a guardar metodos para la creacion y respuesta de actividades
 * en las distintas aulas de evelia. En esta clase deberian ir todas las interracciones con
 * la pestaña <b>Actividades</b> de evelia.
 */
package testEvelia;

import static org.junit.Assert.fail;
import static testEvelia.TestIniciarSesion.*;
import static testEvelia.TestEvelia.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestActividad {

	private static By actividadDocenteLocator = By.xpath("//*[@id=\"listado\"]/div[12]/a/span");
	private static By dentroDeActividadLocator = By.xpath("//*[@id=\"contenido\"]/h1");
	private static By crearActividadLocator = By.xpath("//*[@id=\"contenido\"]/div[4]/div[1]/center/button[1]");
	private static By dentroDeCrearActividadLocator = By.xpath("//*[@id=\"contenido\"]/h1");
	private static By tipoAlumnosLocator = By.xpath("//*[@id=\"TipoAula\"]");
	private static By tituloActividadLocator = By.xpath("//*[@id=\"TituloActividad\"]");
	private static By tipoActividadLocator = By.xpath("//*[@id=\"TipoActividad\"]");
	private static By visualizacionBorradorLocator = By.xpath("//*[@id=\"addActividad\"]/fieldset/div[4]/div[2]/div/div[1]/label");
	private static By visualiazcionPublicoLocator = By.xpath("//*[@id=\"addActividad\"]/fieldset/div[4]/div[2]/div/div[2]/label");
	private static By escalaCalificacionLocator = By.xpath("//*[@id=\"TipoCalificacion\"]");
	private static By notaAprobarLocator = By.xpath("//*[@id=\"notaAprobarN\"]");
	private static By subirArchivosLocator = By.xpath("//*[@id=\"uploadfile\"]");
	private static By generarEventoLocator = By.xpath("//*[@id=\"addActividad\"]");
	private static By crearNuevaActividarLocator = By.xpath("//*[@id=\"addActividad\"]/fieldset/div[12]/div[2]/label/small");
	
	private static By actividadAlumnoLocator = By.xpath("//*[@id=\"listado\"]/div[12]/a");
	private static By enviarActividadTituloLocator = By.xpath("//*[@id=\"formEnvioActividad\"]/fieldset/legend");
	private static By actividadPendienteLocator = By.xpath("//*[@id=\"list2\"]/ul/label");
	private static By cargarArchivoLocator = By.xpath("//*[@id=\"uploadfile\"]");
	private static By enviarActividadLocator = By.xpath("//*[@id=\"enviar\"]");
	
	/**
	 * Metodo que crea una actividad en el aula <b>"Simulacro Evaluaciones (030518) - 2018"</b>.
	 * @param tituloActividad titulo que llevara la actividad.
	 * @param visuaPublic true si la visualizacion sera <i>publica</i>, false si la visualizacion sera <i>borrador.</i>
	 * @param evenAutom true si la actividad generara un evento automatico, false si la actividad no generara un evento(En la version de prueba por defecto se genera un evento automatico).
	 * @param pathArchivo ruta donde esta alojado el archivo a subir para actividad 
	 * @throws IOException
	 * @throws InterruptedException
	 * Usa el metodo <i>TestIniciarSesion.entrarAulaSimulacroEvaluaciones(true)</i> para iniciar sesion como docente.
	 */
	public static void crearActividadEnSimulacroEvaluaciones(String tituloActividad, boolean visuaPublic,boolean evenAutom,String pathArchivo) throws IOException, InterruptedException {
		//String filePathDatosActividad = "/home/luchit0afk/eclipse-workspace/QuealityStreamTutorial/datosActividad.xlsx";
		//String tituloActividad = readExcelFile.getCellValue(filePathDatosActividad, "Hoja1", 1, 0);
		
		TestIniciarSesion.entrarAulaSimulacroEvaluaciones(true);
		
		driver.findElement(actividadDocenteLocator).click();
		
		ArrayList<WebElement> listWebElements = new ArrayList();
		
		if(driver.findElement(dentroDeActividadLocator).isDisplayed()) {
			System.out.println("Ingreso correcto a la pestaña de actividades");
			driver.findElement(crearActividadLocator).click();
			if(driver.findElement(dentroDeCrearActividadLocator).isDisplayed()) {
				listWebElements = (ArrayList<WebElement>) driver.findElement(tipoAlumnosLocator).findElements(By.tagName("option"));
				listWebElements.get(0).click();
				driver.findElement(tituloActividadLocator).sendKeys(tituloActividad);
				if(visuaPublic) {
					driver.findElement(visualiazcionPublicoLocator).click();
				}
				else {
					driver.findElement(visualizacionBorradorLocator).click();
				}
				
				listWebElements = (ArrayList<WebElement>) driver.findElement(escalaCalificacionLocator).findElements(By.tagName("option"));
				listWebElements.get(2).click();
				listWebElements = (ArrayList<WebElement>) driver.findElement(notaAprobarLocator).findElements(By.tagName("option"));
				listWebElements.get(3).click();
				File file = new File(pathArchivo);
				String path = file.getAbsolutePath();
				
				driver.findElement(subirArchivosLocator).sendKeys(path);
				if(!evenAutom) {
					driver.findElement(generarEventoLocator).click();
				}
				
				//driver.findElement(crearActividadLocator).click();
				
			}
			else {
				fail("Error al ingresar a crear actividad");
			}
		}	
		else {
			driver.quit();
			System.out.println("Error al ingresar a la pestaña de actividades");
		}
	}
	
	/**
	 * Metodo que entrega una actividad pendiente en el aula <b>"Simulacro Evaluaciones (030518) - 2018"</b>.
	 * @param pathArchivo ruta donde esta alojado el archivo a subir para entregar la actividad
	 * @throws IOException
	 * @throws InterruptedException
	 * Usa el metodo <i>TestIniciarSesion.entrarAulaSimulacroEvaluaciones(false)</i> para iniciar sesion como alumno.
	 * Falta poder elegir una actividad para enviar
	 */
	public static void entregarActividadEnSimulacroEvaluaciones(String pathArchivo) throws IOException, InterruptedException {
		TestIniciarSesion.entrarAulaSimulacroEvaluaciones(false);
		
		driver.findElement(actividadAlumnoLocator).click();
		
		ArrayList<WebElement> listWebElements = new ArrayList();
		
		if(driver.findElement(dentroDeActividadLocator).isDisplayed()) {
			System.out.println("Ingreso correcto a la pestaña de actividades");
			if(driver.findElement(enviarActividadTituloLocator).isDisplayed()) {
				System.out.println("Se deben actividades");
				
				String filePathDatosActividad = "/home/luchit0afk/eclipse-workspace/QuealityStreamTutorial/datosActividad.xlsx";
				String tituloActividad = readExcelFile.getCellValue(filePathDatosActividad, "Hoja1", 1, 0);
				
				driver.findElement(actividadPendienteLocator).click();
				
				Thread.sleep(1000);
				
				File fileArchivoActividad = new File(pathArchivo);
				String path = fileArchivoActividad.getAbsolutePath();
				
				driver.findElement(cargarArchivoLocator).sendKeys(path);
				
				//driver.findElement(enviarActividadLocator).click();
				
			}
			else {
				System.out.println("No se deben actividades");
			}
		}
		else {
			driver.quit();
			System.out.println("Error al ingresar a la pestaña de actividades");
		}
		
	}

}
