package testEvelia;



import java.io.IOException;
import static testEvelia.TestEvelia.*;

import org.openqa.selenium.By;

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
	
	private static void ingresoExamen() throws IOException, InterruptedException {
		//TestIniciarSesion.entrarAulaSimulacroEvaluaciones(false);
		TestIniciarSesion.entrarAulaTestingAutomatizadoAlumno();
		
		driver.findElement(Paths.evaluaciones).click();
		//driver.findElement(Paths.rendirExamen).click();
		//driver.findElement(Paths.rendirExamen2).click();
		//driver.findElement(Paths.rendirExamen3).click();
		driver.findElement(Paths.rendirExamen(3)).click();
	}
	
	// OPCION MULTIPLE CON DOS RESPUESTAS
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

}
