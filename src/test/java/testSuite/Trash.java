package testSuite;

public class Trash {
	
	// Para cambiar la fecha
	/*
	driver.findElement(Paths.disponibleDesde).clear();
	Thread.sleep(10000);
	driver.findElement(Paths.disponibleDesde).sendKeys("11/09/2022");
	Thread.sleep(5000);
	driver.findElement(Paths.disponibleHasta).clear();
	Thread.sleep(10000);
	driver.findElement(Paths.disponibleHasta).sendKeys("11/09/2022");
	*/
	
	// Otras preguntas, para cuando tengamos lo de JavaScript
	/*
	private static void asociacionDeTerminos(String pmp1, String smp1, String pmp2, String smp2) {
		List<WebElement> array = new ArrayList<WebElement>();
		array = driver.findElements(By.id("primerMiembroPareja"));
		
		Select primerMiembroPareja1 = new Select(array.get(0));
		Select primerMiembroPareja2 = new Select(array.get(1));
		
		driver.findElement(Paths.primerMiembroPareja).sendKeys(pmp1);
		driver.findElement(Paths.segundoMiembroPareja).sendKeys(pmp2);
		
		array = driver.findElements(By.id("primerMiembroPareja"));
		
		Select segundoMiembroPareja1 = new Select(array.get(0));
		Select segundoMiembroPareja2 = new Select(array.get(1));
		
		driver.findElement(Paths.primerMiembroPareja).sendKeys(smp1);
		driver.findElement(Paths.segundoMiembroPareja).sendKeys(smp2);
		
	}
	
	private static void formatoTabla(String p1, String r1, String p2, String r2) {
		driver.findElement(Paths.pregunta1).sendKeys(p1);
		driver.findElement(Paths.respuesta1).sendKeys(r1);
		
		driver.findElement(Paths.pregunta2).sendKeys(p2);
		driver.findElement(Paths.respuesta2).sendKeys(r2);
	}
	*/
	
	
	//
	/*
	private static WebElement waitForElement(By locator, int timeout){
	    WebElement element = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
	    return element;
	}
	*/

}
