/**
 * Clase que esta destinida a guardar metodos para la creacion de noticias en las 
 * distintas aulas de evelia. En esta clase deberian ir todas las interracciones con
 * la pestaña <b>Noticias</b> de evelia.
 */
package testEvelia;

import static org.junit.Assert.fail;
import static testEvelia.TestIniciarSesion.*;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static testEvelia.TestEvelia.*;

public class TestNoticias {
	
	private static By noticiasLocator = By.xpath("//*[@id=\"listado\"]/div[6]/a");
	private static By crearNoticiaLocator = By.xpath("//*[@id=\"contenido\"]/button");
	private static By dentroDeNoticiasLocator = By.xpath("//*[@id=\"contenido\"]/h1");
	private static By tituloLocator = By.xpath("//*[@id=\"TituloTexto\"]");
	private static By descriptionBotonLocator = By.xpath("//*[@id=\"cke_24\"]");
	private static By descriptionTextLocator = By.xpath("/html/body/p");
	private static By cargarArchivoLocator = By.xpath("//*[@id=\"uploadfile\"]");
	private static By comentariosLocator = By.xpath("//*[@id=\"permitirComentar\"]");
	private static By visualizacionBorradorLocator = By.xpath("/html/body/div[3]/div/div[2]/div/div/form[1]/fieldset/div[5]/div[2]/div/div[1]/label/input");
	private static By visualizacionPublicoLocator = By.xpath("/html/body/div[3]/div/div[2]/div/div/form[1]/fieldset/div[5]/div[2]/div/div[2]/label/input");		
	private static By agregarNoticiaLocator = By.xpath("//*[@id=\"agregarComunicacion\"]");
	
	/**
	 * Metodo que crea una noticia en el aula <b>"Simulacro Evaluaciones (030518) - 2018"</b>.
	 * @param tituloNoticia titulo que llevara la noticia
	 * @param pathArchivo ruta donde esta alojado el archivo a subir
	 * @param coments true sii la noticia permitira comentarios, false si no lo permitira
	 * @param visuali true para una visualizacion "publica" de la noticia, false para una visualizacion "borrador"
	 * @throws IOException
	 * @throws InterruptedException
	 * Usa el metodo <i>TestIniciarSesion.entrarAulaSimulacroEvaluaciones(true)</i> para iniciar sesion como docente.
	 */
	public static void publicarNoticiaSimulacroEvaluaciones(String tituloNoticia, String pathArchivo, boolean coments, boolean visuali) throws IOException, InterruptedException {
		
		TestIniciarSesion.entrarAulaSimulacroEvaluaciones(true);
		
		//String tituloNoticia = "Notica Test";
		
		driver.findElement(noticiasLocator).click();
		
		driver.findElement(crearNoticiaLocator).click();
		
		if(driver.findElement(dentroDeNoticiasLocator).isDisplayed()) {
			System.out.println("Ingreso correcto a la pestaña de noticias");
			driver.findElement(tituloLocator).sendKeys(tituloNoticia);
			driver.findElement(descriptionBotonLocator).click();
			Thread.sleep(1000);
			//driver.findElement(descriptionTextLocator).click();
			//driver.findElement(descriptionTextLocator).sendKeys("Description test");
			
			Thread.sleep(1000);
			
			File fileArchivoNoticia = new File(pathArchivo);
			String path = fileArchivoNoticia.getAbsolutePath();
			
			driver.findElement(cargarArchivoLocator).sendKeys(path);
			if(coments) {
				driver.findElement(comentariosLocator).click();
			}
			
			if(visuali) {
				driver.findElement(visualizacionPublicoLocator).click();
			}
			else {
				driver.findElement(visualizacionBorradorLocator).click();
			}
			
			
			//driver.findElement(agregarNoticiaLocator).click();
		}
		else {
			System.out.println("Error al ingresar a la pestaña de noticias");
		}
				
	}
}
