package testEvelia;

import static testEvelia.TestEvelia.driver;

import java.io.IOException;

public class RendirExamenCompleto extends RendirExamen{
	
	public enum EVAL_TYPE {
		VERD_FALSO, 
		OP_MULTIPLE,
		FORMATO_TABLA,
		RESP_ABIERTA,
		RESP_CERRADA,
		COMPLETAR_FRASE,
		NUMERICA_CALC,
		ASOC_DE_TERMINOS
	}
	
	public static EVAL_TYPE questionType() {
		EVAL_TYPE et = null;
		if (driver.findElement(Paths.verdadero).isDisplayed()) {
			et = EVAL_TYPE.VERD_FALSO;
		}
		if (driver.findElement(Paths.opcionUno).isDisplayed()) {
			et = EVAL_TYPE.OP_MULTIPLE;
		}
		if (driver.findElement(Paths.preguntaXOpcionY(1,2)).isDisplayed()) {
			et = EVAL_TYPE.FORMATO_TABLA;
		}
		if (driver.findElement(Paths.inputNumericoCalculadaRespuestaLocator).isDisplayed()) {
			et = EVAL_TYPE.NUMERICA_CALC;
		}
		if (driver.findElement(Paths.primerSelectCompletarFraseLocator).isDisplayed()) {
			et = EVAL_TYPE.COMPLETAR_FRASE;
		}
		if (driver.findElement(Paths.primerSelectAsociacionTerminosLocator).isDisplayed()) {
			et = EVAL_TYPE.ASOC_DE_TERMINOS;
		}
		else {
			System.out.println("ERROR");
		}
		return et;
	}
	
	public static void rendir(int cantPreguntas) throws IOException, InterruptedException {
		ingresoExamen(1);
		for (int i = 0; i < cantPreguntas; i++) {
			EVAL_TYPE et = null;
			et = questionType();
			if (et == EVAL_TYPE.VERD_FALSO) {
				verdaderoFalso(true);
				System.out.println("1 BIEN");
			}
			if (et == EVAL_TYPE.OP_MULTIPLE) {
				opcionMultiple(3, 2);
				System.out.println("2 BIEN");
			}
			if (et == EVAL_TYPE.FORMATO_TABLA) {
				formatoTabla(new int[] {1,2,3});
				System.out.println("3 BIEN");
			}
			if (et == EVAL_TYPE.NUMERICA_CALC) {
				numericaCalculada(5.0);
				System.out.println("4 BIEN");
			}
			if (et == EVAL_TYPE.COMPLETAR_FRASE) {
				completarFrase();
				System.out.println("5 BIEN");
			}
			if (et == EVAL_TYPE.ASOC_DE_TERMINOS) {
				asociacionDeTerminos();
				System.out.println("6 BIEN");
			}
		}
	}
	
	public static void rendir2(int cantPreguntas) throws IOException, InterruptedException {
		ingresoExamen(1);
		for (int i = 0; i < cantPreguntas; i++) {
			if (i == 0) {
				opcionMultiple(3, 2);
				System.out.println("1 BIEN");
			}
			if (i == 1) {
				verdaderoFalso(true);
				System.out.println("2 BIEN");
			}
			if (i == 2) {
				numericaCalculada(5.0);
				System.out.println("3 BIEN");
			}
			if (i == 3) {
				completarFrase();
				System.out.println("4 BIEN");
			}
			if (i == 4) {
				asociacionDeTerminos();
				System.out.println("5 BIEN");
			}
			if (i == 5) {
				formatoTabla(new int[] {1,2,3});
				System.out.println("6 BIEN");
			}
			Thread.sleep(500);
			siguiente();
			Thread.sleep(500);
		}
	}

}
