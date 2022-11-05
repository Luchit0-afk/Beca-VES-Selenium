package testEvelia;

import org.openqa.selenium.By;

public class Paths {
	
	// SIAT2RESPONSIVO
	
	// INGRESO A EVELIA
	//public static By usuarioLocator = By.xpath("/html/body/div[2]/div/div/div/div/div/article/div[1]/form/div/div/div/div[1]/input");
	//*[@id="login"]
	public static By usuarioLocator = By.xpath("//*[@id=\"login\"]");
	public static By contraseniaLocator = By.xpath("//*[@id=\"clave\"]");
	public static By iniciarSesionLocator = By.xpath("//*[@id=\"Ingresar\"]/b");
	
	public static By simulacroEvaluacionesAlumnoLocator = By.xpath("//*[@id=\"contenido\"]/ul[4]/li[1]/a/b");
	
	public static By rendirExamen = By.xpath("//*[@id=\"examenDisp\"]/tbody/tr[1]/td[4]/center/button");
	
	public static By evaluacionesBotonLocator = By.xpath("//*[@id=\"listado\"]/div[14]/a");
	public static By crearExamenBotonLocator = By.xpath("//*[@id=\"contenido\"]/fieldset[1]/button[1]");
	
	public static By inputTituloExamenLocator = By.xpath("//*[@id=\"nombreExamen\"]");
	public static By guardarEvaluacionBotonLocator = By.xpath("//*[@id=\"aceptarConfigEx\"]");
	
	public static By agregarPreguntaBotonLocator = By.xpath("//*[@id=\"configEx\"]");
	
	public static By escribirPreguntaLocator = By.xpath("/html/body/p");
	
	public static By puntajePreguntaLocator = By.xpath("//*[@id=\"puntuacion\"]");
	
	// opcion multiple
	
	public static By opcionCorrecta = By.xpath("//*[@id=\"opciones\"]");
	public static By opcionIncorrecta = By.xpath("//*[@id=\"otrasOpc\"]");
	
	public static By mezclarAlAzar = By.xpath("//*[@id=\"addPregunta\"]/fieldset/div[6]/div[2]/div/div[2]/label");
	public static By aceptar = By.xpath("//*[@id=\"addPreguntas\"]");
	
	public static By nuevaPagina = By.xpath("//*[@id=\"cke_24\"]/span[1]");
	
	
	
		public static By evaluaciones = By.xpath("//*[@id=\"listado\"]/div[9]/a");
		// LAS DE ABAJO SON IGUALES
	
		public static By rendirExamen2 = By.xpath("//*[@id=\"examenDisp\"]/tbody/tr[2]/td[4]/center/button");
		public static By rendirExamen3 = By.xpath("//*[@id=\"examenDisp\"]/tbody/tr[3]/td[4]/center/button");
		
		public static By siguiente = By.xpath("//*[@id=\"pregunta\"]/div[3]/div[2]/center/button");
		public static By entregar = By.xpath("//*[@id=\"FinalizExamen\"]");
		
		public static By opcionUno = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div[1]/div/div[1]/label");
		public static By opcionDos = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div[2]/div/div[1]/label");

		// VER SI HAY DIFERENCIA ENTRE ALGUNOS X PATH DE PROFESORES Y ALUMNOS
		
		
		public static By verdadero = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/div[1]/label"); 
		public static By falso = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/div[2]/label"); 	
		
		public static By inputNumericoCalculadaRespuestaLocator = By.xpath("//*[@id=\"rtaNC3\"]");
		
		public static By primerSelectCompletarFraseLocator = By.xpath("//*[@id=\"rtaCF11\"]");
		public static By segundoSelectCompletarFraseLocator = By.xpath("//*[@id=\"rtaCF12\"]");
		
		public static By primerSelectAsociacionTerminosLocator = By.xpath("//*[@id=\"rtaAT11\"]");
		public static By segundoSelectAsociacionTerminosLocator = By.xpath("//*[@id=\"rtaAT12\"]");
		
		public static By rendirExamenMayo = By.xpath("//*[@id=\"examenDisp\"]/tbody/tr[1]/td[4]/center/button");

		// REVISAR BIEN
		public static By rendirExamen(int posicion) {
			return By.xpath("//*[@id=\"examenDisp\"]/tbody/tr[" + posicion + "]/td[4]/center/button");
		}
		
		public static By preguntaXOpcionY(int x, int y) {
			return By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/table/tbody/tr[" + x + "]/td[" + y + "]/center/label");
		}
		
		public static By iconoPregunta(int numeroPregunta) {
			System.out.println(numeroPregunta);
			return By.xpath("//*[@id=\\\"preg_" + numeroPregunta + "\\\"]/i");
			//*[@id="preg_1"]/i
		}
		public static By numeroPreguntaLocator = By.xpath("//*[@id=\"pregunta\"]/center/b");
		
		//Localizadores de las aulas donde podemos entrar
		public static By simulacroEvaluacionesDocenteLocator = By.xpath("//*[@id=\"contenido\"]/ul[3]/li[1]/a/b");
		public static By testIRCDocenteLocator = By.xpath("//*[@id=\"contenido\"]/ul[3]/li[2]/a/b");
		
		public static By simulacroEvaluacionesAlumnoLocator2 = By.xpath("//*[@id=\"contenido\"]/ul[4]/li[1]/a/b");
		public static By testIRCAlumnoLocator = By.xpath("//*[@id=\"contenido\"]/ul[4]/li[2]/a/b");
		
		//Localizador para verificar el correcto ingreso a un aula(cualquiera) en evelia
		public static By dentroDeAulaVirtualLocator = By.xpath("//*[@id=\"contenido\"]/h1");
		
		public static By paginaInicialEveliaLocator = By.xpath("//*[@id=\"contenido\"]/div[4]/h4");

		//BOTONES DEL SERVIDOR NUEVOS
		// REVISAR !!! SON IGUALES
		public static By usuario2 = By.xpath("//*[@id=\"login\"]");
		public static By contraseña2 = By.xpath("//*[@id=\"clave\"]");
		public static By iniciarSesion2 = By.xpath("//*[@id=\"Ingresar\"]");
		// Aula: testing automatizado
		
		//private static By aula = By.xpath("//*[@id=\"contenido\"]/ul[3]/li[4]/a/b");
		public static By aula = By.xpath("//*[@id=\"contenido\"]/ul[2]/li[4]/a/b");

		public static By aulaDocente = By.xpath("//*[@id=\"contenido\"]/ul[2]/li[3]/a");
		
		// Comision: testing automatizado
		public static By comision = By.xpath("//*[@id=\"contenido\"]/b[5]/a");
}
