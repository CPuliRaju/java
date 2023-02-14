package com.Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCommonMethods {
	
	String excelfileinputpath;
	String excelfileoutputpath;
	String SheetName;
	XSSFWorkbook  workbook;

	public ExcelCommonMethods(String excelfileInputPath,String SheetName,String excelfileoutputpath) throws IOException {
		
		this.excelfileinputpath=excelfileInputPath;
		this.excelfileoutputpath=excelfileoutputpath;
		this.SheetName=SheetName;
		FileInputStream file=new FileInputStream(excelfileinputpath);
		workbook=new XSSFWorkbook(file);
	}
	
	public String getcellvalue(int rowIndex,int cellIndex){
		
		XSSFSheet sheet=workbook.getSheet(SheetName);
		Row row=sheet.getRow(rowIndex);
		Cell rowOfCell=row.getCell(cellIndex);
	    return rowOfCell.getStringCellValue();
	}
	
	public void SetCellValue(int rowIndex,int cellIndex,String data) throws IOException {
		
		XSSFSheet sheet= workbook.getSheet(SheetName);
		Row row=sheet.getRow(rowIndex);
		Cell rowOfcell=row.createCell(cellIndex);
		rowOfcell.setCellValue(data);
		
		FileOutputStream outputstreamtestResultFile=new FileOutputStream(excelfileoutputpath);
		workbook.write(outputstreamtestResultFile);
	}
	public void saveExcelData() {
		
	}
	
}
