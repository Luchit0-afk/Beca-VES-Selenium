package testSuite;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {
	
	public static void Main(String[] args) throws FileNotFoundException, ScriptException {
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine se = sem.getEngineByName("JavaScript");
		se.eval(new FileReader("Escritorio/Repositorios/Beca-VES/writeTextArea.js"));
	}

}
