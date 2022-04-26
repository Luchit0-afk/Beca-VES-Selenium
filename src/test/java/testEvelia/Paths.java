package testEvelia;

import org.openqa.selenium.By;

public class Paths {
	
		// BOTONES - SERVIDOR DE PRUEBA
		public static By evaluaciones = By.xpath("//*[@id=\"listado\"]/div[9]/a");
		// LAS DE ABAJO SON IGUALES
		public static By rendirExamen = By.xpath("//*[@id=\"examenDisp\"]/tbody/tr/td[4]/center/button");
		public static By rendirExamen2 = By.xpath("//*[@id=\"examenDisp\"]/tbody/tr[2]/td[4]/center/button");
		
		public static By siguiente = By.xpath("//*[@id=\"pregunta\"]/div[3]/div[2]/center/button");
		public static By entregar = By.xpath("//*[@id=\"FinalizExamen\"]");
		
		public static By opcionUno = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div[1]/div/div[1]/label");
		public static By opcionDos = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div[2]/div/div[1]/label");

		// VER SI HAY DIFERENCIA ENTRE ALGUNOS X PATH DE PROFESORES Y ALUMNOS
		
		
		public static By verdadero = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/div[1]/label"); 
		public static By falso = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/div[2]/label"); 	
		
		public static By inputNumericoCalculadaRespuestaLocator = By.xpath("//*[@id=\"rtaNC1\"]");
		
		public static By primerSelectCompletarFraseLocator = By.xpath("//*[@id=\"rtaCF11\"]");
		public static By segundoSelectCompletarFraseLocator = By.xpath("//*[@id=\"rtaCF12\"]");
		
		public static By primerSelectAsociacionTerminosLocator = By.xpath("//*[@id=\"rtaAT11\"]");
		public static By segundoSelectAsociacionTerminosLocator = By.xpath("//*[@id=\"rtaAT12\"]");
		// Generalizar la construcciones de los x path
		/*
		public static By pregUnoOpUno = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/table/tbody/tr[1]/td[2]/center/label");
		public static By pregUnoOpDos = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/table/tbody/tr[1]/td[3]/center/label");
		public static By pregUnoOpTres = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/table/tbody/tr[1]/td[4]/center/label");
		public static By pregDosOpUno = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/table/tbody/tr[2]/td[2]/center/label");
		public static By pregDosOpDos = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/table/tbody/tr[2]/td[3]/center/label");
		public static By pregDosOpTres = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/table/tbody/tr[2]/td[4]/center/label");
		public static By pregTresOpUno = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/table/tbody/tr[3]/td[2]/center/label");
		public static By pregTresOpDos = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/table/tbody/tr[3]/td[3]/center/label");
		public static By pregTresOpTres = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/table/tbody/tr[3]/td[4]/center/label");
		*/
		
		
		// REVISAR BIEN
		public static By rendirExamen(int posicion) {
			return By.xpath("//*[@id=\"examenDisp\"]/tbody/tr[" + posicion + "]/td[4]/center/button");
		}
		
		public static By preguntaXOpcionY(int x, int y) {
			return By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/table/tbody/tr[" + x + "]/td[" + y + "]/center/label");
		}
}
