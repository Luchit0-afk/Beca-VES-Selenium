package testSuite;

import org.openqa.selenium.By;

public class Paths {
	
	// Inicio
	public static By usuario = By.xpath("//*[@id=\"login\"]");
	public static By contrasenia = By.xpath("//*[@id=\"clave\"]");
	public static By acceder = By.xpath("//*[@id=\"Ingresar\"]");
	
	// Ingreso
	public static By aulaDoc = By.xpath("//*[@id=\"contenido\"]/ul[2]/li[3]/a/b");
	public static By aulaAlum = By.xpath("//*[@id=\"contenido\"]/ul[3]/li[4]/a/b");
	public static By comisionDoc = By.xpath("//*[@id=\"contenido\"]/b[5]/a");
	public static By comisionAlum = By.xpath("//*[@id=\"contenido\"]/b[5]/a");
	public static By evaluacionesDoc = By.xpath("//*[@id=\"listado\"]/div[10]/a/span");
	public static By evaluacionesAlum = By.xpath("//*[@id=\"listado\"]/div[9]/a");
	
	// Egreso
	public static By ventParaSalir = By.xpath("//*[@id=\"banner\"]/nav/div[2]/button");
	public static By salir = By.xpath("//*[@id=\"banner\"]/nav/div[2]/div/div/div[2]/a[6]");
	
	// Crear Examen
	public static By crearExamen = By.xpath("//*[@id=\"contenido\"]/fieldset[1]/button[1]");
	public static By tituloExamen = By.xpath("//*[@id=\"nombreExamen\"]");
	public static By guardarDatos = By.xpath("//*[@id=\"aceptarConfigEx\"]");
	
	public static By menuDesplegable = By.xpath("//*[@id=\"tipoPregunta\"]");
	public static By agregarPregunta = By.xpath("//*[@id=\"configEx\"]");
	public static By puntaje = By.xpath("//*[@id=\"puntuacion\"]");
	public static By notaDeAprobacion = By.xpath("//*[@id=\"NotaAprobar\"]");
	
	public static By prepararPublicacion = By.xpath("//*[@id=\"contenido\"]/fieldset/div[3]/button");
	public static By publicarYReservarEvaluacion = By.xpath("//*[@id=\"contenido\"]/fieldset/div/div/div/button");
	
	// Opcion multiple
	public static By opcionCorrecta = By.xpath("//*[@id=\"opciones\"]");
	public static By opcionIncorrecta = By.xpath("//*[@id=\"otrasOpc\"]");
	public static By mezclarAlAzar = By.xpath("//*[@id=\"addPregunta\"]/fieldset/div[7]/div[2]/div/div[2]/label");
	public static By aceptar = By.xpath("//*[@id=\"addPreguntas\"]");
	
	// Verdadero - Falso
	public static By verdadero = By.xpath("//*[@id=\"addPregunta\"]/fieldset/div[5]/div[2]/div/div[1]/label");
	public static By falso = By.xpath("//*[@id=\"addPregunta\"]/fieldset/div[5]/div[2]/div/div[2]/label");
	
	// Numerica calculada
	public static By respuesta = By.xpath("//*[@id=\"respuesta\"]");
	
	// Asociacion de terminos
	public static By primerMiembroPareja = By.xpath("//*[@id=\"parejaA\"]");
	public static By segundoMiembroPareja = By.xpath("//*[@id=\"parejaB\"]");
	
	// Formato tabla
	public static By pregunta1 = By.xpath("//*[@id=\"preguntasFT\"]");
	public static By pregunta2 = By.xpath("//*[@id=\"preguntasFT\"]");
	
	public static By respuesta1 = By.xpath("//*[@id=\"respuestasFT1\"]");
	public static By respuesta2 = By.xpath("//*[@id=\"respuestasFT2\"]");
	
	// PARA RESPONDER
	
	// rendirExamen
	public static By rendirExamen = By.xpath("//*[@id=\"examenDisp\"]/tbody/tr[1]/td[4]/div/button");
	
	// opcion multiple
	public static By opcion1 = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div[1]/div/div[1]/label");
	public static By opcion2 = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div[2]/div/div[1]/label");
	
	// siguiente
	public static By siguiente = By.xpath("//*[@id=\"pregunta\"]/div[4]/div[2]/div/button");
	
	// verdadero falso
	public static By respVerdadero = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div[1]/div[1]/label");
	public static By respFalso = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div[1]/div[2]/label");
	
	// numerica calculada
	public static By respNumCalc = By.xpath("//*[@id=\"rtaNC3\"]");
	
	// entregar
	public static By entregar = By.xpath("//*[@id=\"FinalizExamen\"]");
	
	public static By disponibleDesde = By.xpath("//*[@id=\"fechaInicioEval\"]");
	public static By disponibleHasta = By.xpath("//*[@id=\"fechaFinEval\"]");

}
