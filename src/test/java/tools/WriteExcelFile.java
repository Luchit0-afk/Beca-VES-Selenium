package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	public WriteExcelFile() {
		// TODO Auto-generated constructor stub
	}
	
	public void writeExcel(String filePath,String sheetName,String[] dataToWrite) throws IOException {
		
		File file = new File(filePath);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		
		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
		
		XSSFRow row = newSheet.getRow(0);
		
		XSSFRow newRow = newSheet.createRow(rowCount + 1);
		
		for(int i = 0 ; i < row.getLastCellNum() ;i++) {
			XSSFCell newCell = newRow.createCell(i);
			newCell.setCellValue(dataToWrite[i]);
		}
		
		inputStream.close();
		
		FileOutputStream outputStream = new FileOutputStream(file);
		
		newWorkbook.write(outputStream);
		
		outputStream.close();
	}
	
	public void writeCellValue(String filePath,String sheetName,int rowNumber, int cellNumber, String resultText) throws IOException {

		File file = new File(filePath);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		
		XSSFRow row = newSheet.createRow(rowNumber);
		
		XSSFCell firstCell = row.createCell(cellNumber);
		firstCell.setCellValue(resultText);
		//XSSFCell firstCell = row.getCell(cellNumber - 1);
		
		//System.out.println("first cell value es: " + firstCell.getStringCellValue());
		
		//XSSFCell nextCell = row.createCell(cellNumber + 1);
		//nextCell.setCellValue(resultText);
		
		//System.out.println("next cell value es: " + nextCell.getStringCellValue());
		
		inputStream.close();
		
		FileOutputStream outputStream = new FileOutputStream(file);
		
		newWorkbook.write(outputStream);
		
		outputStream.close();
	}
}























