/**
 * Clase que esta destinida a guardar metodos para la creacion y descarga de materiales
 * en las distintas aulas de evelia. En esta clase deberian ir todas las interracciones con
 * la pestaña <b>Materiales</b> de evelia.
 */
package testEvelia;

import static org.junit.Assert.fail;
import static testEvelia.TestEvelia.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestMateriales {
	
	//Localizadores para los materiales
	private static By materialesLocator = By.xpath("//*[@id=\"listado\"]/div[10]/a/span");
	private static By dentroDeMaterialesLocator = By.xpath("//*[@id=\"contenido\"]/h1");
	private static By descripcionNuevoMaterialLocator = By.xpath("//*[@id=\"archivoDescripcion\"]");
	private static By carpetaNuevoMaterialLocator = By.xpath("//*[@id=\"folderstore\"]");
	private static By archivoNuevoMaterialLocator = By.xpath("//*[@id=\"uploadfile\"]");
	
	/**
	 * Metodo que sube un material en el aula <b>"Simulacro Evaluaciones (030518) - 2018"</b>.
	 * @param descripcionMaterial descripcion del material subido
	 * @param pathArchivo ruta donde esta alojado el material a subir
	 * @throws IOException
	 * @throws InterruptedException
	 * Usa el metodo <i>TestIniciarSesion.entrarAulaSimulacroEvaluaciones(true)</i> para iniciar sesion como docente.
	 */
	public static void subirMaterialesSimulacroEvaluaciones(String descripcionMaterial,String pathArchivo) throws IOException, InterruptedException {
		TestIniciarSesion.entrarAulaSimulacroEvaluaciones(true);
		//String descripcionMaterial = "MaterialSubidoEclipse";
		
		driver.findElement(materialesLocator).click();
		
		ArrayList<WebElement> listWebElements = new ArrayList();
		
		if(driver.findElement(dentroDeMaterialesLocator).isDisplayed()) {
			System.out.println("Ingreso correcto a la pestaña de materiales");
			driver.findElement(descripcionNuevoMaterialLocator).sendKeys(descripcionMaterial);
			listWebElements = (ArrayList<WebElement>) driver.findElement(carpetaNuevoMaterialLocator).findElements(By.tagName("option"));
			for(int i = 0 ; i < listWebElements.size() ;i++) {												
				if(listWebElements.get(i).getText().equals("Materiales del aula")) {
					listWebElements.get(i).click();
				}
			}
			File file = new File(pathArchivo);
			
			String path = file.getAbsolutePath();
			
			driver.findElement(archivoNuevoMaterialLocator).sendKeys(path);
			//driver.findElement(generarEventoLocator).click();
			
		}
		else {
			fail("Error al ingresar a la pestaña de materiales");
		}
	}
	
}
