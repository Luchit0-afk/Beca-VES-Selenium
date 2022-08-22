package testEvelia;

import org.testng.annotations.AfterMethod;
import testSuite.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import testEvelia.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.edge.EdgeDriver;

import tools.WriteExcelFile;
import tools.ReadExcelFile;

public class TestEvelia {
	
	public static WebDriver driver;
	protected static WriteExcelFile writeExcelFile;
	protected static ReadExcelFile readExcelFile;
	
	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
//		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
		//File operaFile = new File("./drivers/operadriver");
		
		//System.setProperty("webdriver.opera.driver", "/home/luchit0afk/eclipse-workspace/QuealityStreamTutorial/drivers/operadriver");
		//System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver");
		//System.setProperty("webdriver.opera.driver", "./drivers/operadriver");
		
		//WebDriver driver = new SafariDriver();
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		//driver = new OperaDriver();
		//driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		writeExcelFile = new WriteExcelFile();
		readExcelFile = new ReadExcelFile();
		
		//driver.get("https://prueba.evelia.unrc.edu.ar/siat2Responsivo/");
		driver.get("https://server3.evelia.unrc.edu.ar/eveliajunit/index.jsp");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	/**
	 * Test para iniciar sesion en la pagina de Evelia como docente
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
	public void iniciarSesionDocente() throws IOException, InterruptedException {
		TestIniciarSesion.iniciarSesion(true);
	}
	
	/**
	 * Test para iniciar sesion en la pagina de Evelia como alumno
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
	public void iniciarSesionAlumno() throws IOException, InterruptedException {
		TestIniciarSesion.iniciarSesion(false);
	}
	
	/**
	 * Test para entrar al aula "Simulacro Evaluaciones (030518) - 2018" como docente
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
	public void entrarAulaSimulacroEvaluacionesDocente() throws IOException, InterruptedException {
		TestIniciarSesion.entrarAulaSimulacroEvaluaciones(true);
	}
	
	/**
	 * Test para entrar al aula "test IRC - EVELIA1 (AGO19) - 2019" como alumno
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
	public void entrarAulaTestIRCAlumno() throws IOException, InterruptedException {
		TestIniciarSesion.entrarAulaTestIRC(false);
	}
	
	/**
	 * Test para entrar al aula "Simulacro Evaluaciones (030518) - 2018" como alumno
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
	public void entrarAulaSimulacroEvaluacionesAlumno() throws IOException, InterruptedException {
		TestIniciarSesion.entrarAulaSimulacroEvaluaciones(false);
	}
	
	/**
	 * Test para entrar al aula "test IRC - EVELIA1 (AGO19) - 2019" como docente
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
	public void entrarAulaTestIRCDocente() throws IOException, InterruptedException {
		TestIniciarSesion.entrarAulaTestIRC(true);
	}
	
	/**
	 * Test para crear actividades dentro del aula "Simulacro Evaluaciones (030518) - 2018"
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
	public void crearActividadSimulacroEvaluaciones() throws IOException, InterruptedException {
		//TestActividad.crearActividadEnSimulacroEvaluaciones("TituloActividadTest",true,true,"/home/luchit0afk/eclipse-workspace/QuealityStreamTutorial/subirArchivoAct");
		TestActividad.crearActividadEnSimulacroEvaluaciones("TituloActividadTest",true,true,"/home/agustin/Escritorio/Repositorios/Beca-VES./subirArchivoAct");
		//TestActividad.entregarActividadEnSimulacroEvaluaciones("/home/luchit0afk/eclipse-workspace/QuealityStreamTutorial/entregaActividad");
		TestActividad.entregarActividadEnSimulacroEvaluaciones("/home/agustin/Escritorio/Repositorios/Beca-VES./entregaActividad");
	}
	
	/**
	 * Test para subir materiales dentro del aula "Simulacro Evaluaciones (030518) - 2018"
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
	public void subirMaterialesSimulacroEvaluaciones() throws IOException, InterruptedException {
		//TestMateriales.subirMaterialesSimulacroEvaluaciones("MaterialSubidoEclipse","/home/luchit0afk/eclipse-workspace/QuealityStreamTutorial/testMaterialNuevo");
		TestMateriales.subirMaterialesSimulacroEvaluaciones("MaterialSubidoEclipse","/home/agustin/Escritorio/Repositorios/Beca-VES./testMaterialNuevo");
	}
	
	/**
	 * Test para crear una evaluacion dentro del aula "Simulacro Evaluaciones (030518) - 2018"
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Test
	public void hacerEvaluacionSimulacroEvaluaciones() throws IOException, InterruptedException {
		TestEvaluaciones.hacerEvaluacionSimulacroEvaluaciones("Evaluacion creada desde eclipse",true,"03:00","00:01:00","7.0",true,true,true,true,"Evaluacion de test",true);
	}
	
	//@Test
	public void crearNoticiaEnSimulacroEvaluaciones() throws IOException, InterruptedException{
		//TestNoticias.publicarNoticiaSimulacroEvaluaciones("Notica Test","/home/luchit0afk/eclipse-workspace/QuealityStreamTutorial/archivoNoticia",true,true);
		TestNoticias.publicarNoticiaSimulacroEvaluaciones("Notica Test","/home/agustin/Escritorio/Repositorios/Beca-VES./archivoNoticia",true,true);
		
	}
	
	//@Test
	public void rendirExamen() throws IOException, InterruptedException {
		RendirExamenCompleto.rendir2(6);
	}
	
	//@Test
	public void crearExamen() throws IOException, InterruptedException {
		CrearExamen.crearExamen("Test123");
	}
	
	@Test
	public void crearExamen2() throws IOException, InterruptedException {
		//testSuite.CrearExamen.crearExamenCompleto();
		testSuite.RendirExamen.rendirExamenCompleto();
	}
}

