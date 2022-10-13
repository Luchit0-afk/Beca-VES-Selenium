package testSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSuite {
	public static WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://server3.evelia.unrc.edu.ar/eveliajunit/index.jsp");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void test() throws InterruptedException {
		CrearExamen.crearExamenCompleto();
		Thread.sleep(1000);
		RendirExamen.rendirExamenCompleto();
	}
	
}
