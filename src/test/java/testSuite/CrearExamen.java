package testSuite;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import testSuite.MetodosComunes.TipoUsuario;

import static testSuite.TestSuite.driver;

public class CrearExamen {

	private static String usuarioDocente = "1110102";
	private static String contraseniaDocente = "10102";
	private static String tituloExamen = "AAAAA";
	private static String notaDeAprobacion = "5.0";

	private static void crearExamen(String titulo) {
		driver.findElement( Paths.crearExamen ).click();
		driver.findElement( Paths.tituloExamen ).sendKeys( titulo );
		driver.findElement( Paths.guardarDatos ).click();
	}
	
	private static void agregarNotaDeAprobacion(String nota) throws InterruptedException {
		driver.findElement( Paths.notaDeAprobacion ).sendKeys( nota );
		driver.findElement( Paths.guardarDatos ).click();
	}
	
	private static void agregarPregunta(int indice, String puntaje) throws InterruptedException {
		Select select = new Select( driver.findElement( By.id( "tipoPregunta" ) ) );
		select.selectByIndex( indice );

		driver.findElement( Paths.agregarPregunta ).click();
		driver.findElement( Paths.puntaje ).sendKeys( puntaje );
		//driver.findElement(Paths.mezclarAlAzar).click();
	}
	
	private static void agregarPreguntas(String[] puntajes) throws InterruptedException {
		for (int i = 1; i < 4; i++) {
			agregarPregunta( i, puntajes[i] );
			tipoDePregunta( i );
			driver.findElement( Paths.aceptar ).click();
		}
	}
	
	private static void tipoDePregunta(int indice) {
		switch( indice ) {
			case 1:
				opcionMultiple( "correcta", "incorrecta" );
				break;
			case 2:
				verdaderoFalso( true );
				break;
			case 3:
				numericaCalculada( "5" );
				break;
			default:
				break;
		}
	}
	
	private static void opcionMultiple(String opCorrecta, String opIncorrecta) {
		driver.findElement( Paths.opcionCorrecta ).sendKeys( opCorrecta );
		driver.findElement( Paths.opcionIncorrecta ).sendKeys( opIncorrecta );
	}
	
	private static void verdaderoFalso(boolean verdadero) {
		if ( verdadero ) {
			driver.findElement( Paths.verdadero ).click();
		} else {
			driver.findElement( Paths.falso ).click();
		}
	}
	
	private static void numericaCalculada(String numero) {
		driver.findElement( Paths.respuesta ).sendKeys( numero );
	}
	
	private static void publicarEvaluacion() throws InterruptedException {
		driver.findElement( Paths.prepararPublicacion ).click();
		driver.findElement( Paths.publicarYReservarEvaluacion ).click();
		
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public static void crearExamenCompleto() throws InterruptedException {
		MetodosComunes.iniciarSesion( usuarioDocente, contraseniaDocente );
		MetodosComunes.ingresarAEvaluaciones( TipoUsuario.DOCENTE );

		crearExamen( tituloExamen );
		agregarNotaDeAprobacion( notaDeAprobacion );
		
		String[] puntajes = {"0.0", "3.0", "3.0", "4.0"};
		
		agregarPreguntas( puntajes );
		publicarEvaluacion();
		
		MetodosComunes.cerrarSesion();
	}
	
}
