package testEvelia;



import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static testEvelia.TestEvelia.*;

public class RendirExamen {
												
	protected static void ingresoExamen(int position) throws IOException, InterruptedException {
		TestIniciarSesion.entrarAulaSimulacroEvaluaciones(false);
		//TestIniciarSesion.entrarAulaTestingAutomatizadoAlumno();
		
		driver.findElement(Paths.evaluaciones).click();
		//driver.findElement(Paths.rendirExamen).click();
		//driver.findElement(Paths.rendirExamen2).click();
		//driver.findElement(Paths.rendirExamen3).click();
		driver.findElement(Paths.rendirExamen).click();
		
	}
	
	public static void siguiente() {
		driver.findElement(Paths.siguiente).click();
	}

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
	
	public static void verdaderoFalso(boolean respuesta) {
		if (respuesta) {
			driver.findElement(Paths.verdadero).click();
		} else {
			driver.findElement(Paths.falso).click();
		}
	}

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

	public static void numericaCalculada(double respuesta) {
		driver.findElement(Paths.inputNumericoCalculadaRespuestaLocator).sendKeys(String.valueOf(respuesta));
	}

	public static void completarFrase() {
		WebElement WebElementPrimerSelect = driver.findElement(Paths.primerSelectCompletarFraseLocator);
		WebElement WebElementSegundoSelect = driver.findElement(Paths.segundoSelectCompletarFraseLocator);
		
		Select primerSelect = new Select(WebElementPrimerSelect);
		Select segundoSelect = new Select(WebElementSegundoSelect);
		
		primerSelect.selectByIndex(1);
		segundoSelect.selectByIndex(2);
	}
	
	public static void asociacionDeTerminos() {
		WebElement WebElementPrimerSelect = driver.findElement(Paths.primerSelectAsociacionTerminosLocator);
		WebElement WebElementSegundoSelect = driver.findElement(Paths.segundoSelectAsociacionTerminosLocator);
		
		Select primerSelect = new Select(WebElementPrimerSelect);
		Select segundoSelect = new Select(WebElementSegundoSelect);
		
		primerSelect.selectByVisibleText("Correcto");
		segundoSelect.selectByVisibleText("Incorrecto");
	}

}
