package testEvelia;

import java.io.IOException;

public abstract class Controller {
	
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
	
	public void rendirExamen(EVAL_TYPE et) throws IOException, InterruptedException {
		if (et == EVAL_TYPE.OP_MULTIPLE) {
			RendirExamen.opcionMultiple(3, new int[] {});
		}
		if (et == EVAL_TYPE.VERD_FALSO) {
			RendirExamen.verdaderoFalso(3, new boolean[] {});
		}
		if (et == EVAL_TYPE.FORMATO_TABLA) {
			RendirExamen.formatoTabla(3, 3, null);
		}
	}
	
	public void crearExamen(EVAL_TYPE et) {
		
	}
	
	public void crearActividad() {
		
	}
	
	public void crearNoticia() {
		
	}
	

}
