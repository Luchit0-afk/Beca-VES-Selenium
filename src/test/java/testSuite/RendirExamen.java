package testSuite;

import java.util.Random;

import org.openqa.selenium.Alert;

import testSuite.MetodosComunes.TipoUsuario;

import static testSuite.TestSuite.driver;

public class RendirExamen {
	
	private static String usuarioAlumno = "1110011";
	private static String contraseniaAlumno = "10011";

	private static void opcionMultiple(int numero) throws InterruptedException {
		if (numero == 0) {
			driver.findElement( Paths.opcion1 ).click();
		} else {
			driver.findElement( Paths.opcion2 ).click();
		}
	}
	
	private static void verdaderoFalso(boolean verdadero) throws InterruptedException {
		/*
		if (verdadero) {
			driver.findElement(Paths.respVerdadero).click();
		} else {
			driver.findElement(Paths.respFalso).click();
		}
		*/
	}
	
	private static void numericaCalculada(String respuesta) {
		driver.findElement( Paths.respNumCalc ).sendKeys( respuesta );
	}
	
	private static void siguiente() throws InterruptedException {
		driver.findElement( Paths.siguiente ).click();
		Thread.sleep(1000);
	}
	
	private static void rendirExamen() {
		driver.findElement( Paths.rendirExamen ).click();
	}
	
	private static void entregar() {
		driver.findElement( Paths.entregar ).click();
	}
	
	public static void rendirExamenCompleto() throws InterruptedException {
		MetodosComunes.iniciarSesion( usuarioAlumno, contraseniaAlumno );
		MetodosComunes.ingresarAEvaluaciones( TipoUsuario.ALUMNO );
		
		rendirExamen();
		
		Random r = new Random();
		int num = r.nextInt( 2 );
		boolean bool = r.nextBoolean();
		
		opcionMultiple( num );
		siguiente();
		verdaderoFalso( bool );
		siguiente();
		
		num = r.nextInt( 11 );
		
		numericaCalculada( String.valueOf( num ) );
		entregar();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		MetodosComunes.cerrarSesion();
	}

}
