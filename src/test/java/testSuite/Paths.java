package testSuite;

import org.openqa.selenium.By;

public class Paths {
	
	// Inicio
	public static By usuario = By.xpath("//*[@id=\"login\"]");
	public static By contrasenia = By.xpath("//*[@id=\"clave\"]");
	public static By acceder = By.xpath("//*[@id=\"Ingresar\"]");
	
	// Ingreso
	public static By aula = By.xpath("//*[@id=\"contenido\"]/ul[2]/li[3]/a/b");
	public static By comision = By.xpath("//*[@id=\"contenido\"]/b[5]/a");
	public static By evaluaciones = By.xpath("//*[@id=\"listado\"]/div[10]/a/span");
	
	// Crear Examen
	public static By crearExamen = By.xpath("//*[@id=\"contenido\"]/fieldset[1]/button[1]");
	public static By tituloExamen = By.xpath("//*[@id=\"nombreExamen\"]");
	public static By guardarDatos = By.xpath("//*[@id=\"aceptarConfigEx\"]");
	
	// Probablemente no sirve
	public static By menuDesplegable = By.xpath("//*[@id=\"tipoPregunta\"]");

	//*[@id="configEx"]
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
	public static By primerMiembroPareja1 = By.xpath("//*[@id=\"parejaA\"]");
	public static By segundoMiembroPareja1 = By.xpath("//*[@id=\"parejaB\"]");
	
	public static By primerMiembroPareja2 = By.xpath("//*[@id=\"parejaA\"]");
	public static By segundoMiembroPareja2 = By.xpath("//*[@id=\"parejaB\"]");
	
	// Formato tabla
	public static By pregunta1 = By.xpath("//*[@id=\"preguntasFT\"]");
	public static By pregunta2 = By.xpath("//*[@id=\"preguntasFT\"]");
	
	public static By respuesta1 = By.xpath("//*[@id=\"respuestasFT1\"]");
	public static By respuesta2 = By.xpath("//*[@id=\"respuestasFT2\"]");
	
	// PARA RESPONDER
	// aula alumno
	public static By aulaAlumno = By.xpath("//*[@id=\"contenido\"]/ul[3]/li[4]/a/b");
	
	// comision alumno
	//*[@id="contenido"]/b[5]/a  (es la misma) 
	
	// eval alumno
	public static By evalAlumno = By.xpath("//*[@id=\"listado\"]/div[9]/a");
	
	// rendirExamen
	public static By rendirExamen = By.xpath("//*[@id=\"examenDisp\"]/tbody/tr[1]/td[4]/center/button");
	
	//OPCION MULTIPLE
	public static By opcion1 = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div[1]/div/div[1]/label");
	public static By opcion2 = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div[2]/div/div[1]/label");
	
	// siguiente
	public static By siguiente = By.xpath("//*[@id=\"pregunta\"]/div[3]/div[2]/center/button");
	
	// VERDADERO FALSO
	public static By respVerdadero = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/div[1]/label");
	public static By respFalso = By.xpath("//*[@id=\"tablaPreguntaEx\"]/div/div[2]/div/div[2]/label");
	
	// numerica calculada
	public static By respNumCalc = By.xpath("//*[@id=\"rtaNC3\"]");
	
	// entregar
	public static By entregar = By.xpath("//*[@id=\"FinalizExamen\"]");

}
