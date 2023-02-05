package com.ExcelOperation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_ReadMultipleTestData {

	public static void main(String[] args) throws IOException {
	
FileInputStream file=new FileInputStream("./src/com/Excel/File2.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		
	   XSSFSheet sheet = workbook.getSheet("sheet1");
	   
	   int sheetRowCount=sheet.getLastRowNum();
	   
	   for (int rowIndex=0;rowIndex<=sheetRowCount;rowIndex++)
	   {
		   int rowOfcellcount = sheet.getRow(rowIndex).getLastCellNum();
		   
		   for (int cellindex=0;cellindex<rowOfcellcount;cellindex++)
		   {
		   
		   }
		   Row row=sheet.getRow(rowIndex);
		  
	   }
			   

	}

}
