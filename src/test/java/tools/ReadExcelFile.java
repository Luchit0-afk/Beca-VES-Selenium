package tools;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	public ReadExcelFile(){
		
	}
	
	public void readExcel(String filePath,String sheetName) throws IOException {
		File file = new File(filePath);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream); 
		
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		
		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum(); 
		
	
		System.out.print("test2 " + rowCount);
		for(int i = 0;i < rowCount ;i++) {
			XSSFRow row = newSheet.getRow(i);
			System.out.print("test");
			for(int j = 0; j < row.getLastCellNum();j++) {//Suponiendo que todas las filas tendran la misma cantidad de celdas
				System.out.println(row.getCell(j).getStringCellValue() + "||");
			}
		}
	}
	
	public String getCellValue(String filePath, String sheetName, int rowNumber, int cellNumber) throws IOException {
		
		File file = new File(filePath);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream); 
		
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		
		//XSSFRow row = newSheet.getRow(rowNumber);
		
		//XSSFCell cell = row.getCell(cellNumber);
		
		DataFormatter formatter = new DataFormatter();
		
		return formatter.formatCellValue(newSheet.getRow(rowNumber).getCell(cellNumber));
		
		//return cell.getStringCellValue();
	}
}




