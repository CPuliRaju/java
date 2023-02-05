package com.TimeAndDateWebPage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CapturingFirstColumDataInExcelSheet {

	WebDriver driver;
	String applicationurladdress="https://www.TimeAndDate.com/worldclock/";
	
	public void applicationlaunch()
	{
		System.setProperty("webdriver.chrome.driver", "./Webdriver/chromedriver.exe");
		
		driver =new ChromeDriver();
		driver.get(applicationurladdress);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	  public void applicationclose()
      {
   	  driver.quit(); 
      }
	
       public void getfirstcolumData() throws IOException
       {
    	   //first row of first cell
    	   //html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
    	   
    	   //Last cell of first cell
    	  // /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[1]
    	   
    	   
    	   String xpathExpresionpart1="html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[";
    	   String xpathExpresionpart2="]/td[1]";
    	   
    	   FileInputStream file = new FileInputStream("./src/com/Excel/File5.xlsx");
    	   XSSFWorkbook workbook = new XSSFWorkbook(file);
    	   XSSFSheet sheet = workbook.getSheet("Sheet1");
    	   
    	   for (int index=1;index<=36;index++)
    	   {
    		  // By xpath Row Locator=By.xpath
    		   By xpathRowLocator=By.xpath(xpathExpresionpart1+index+xpathExpresionpart2);
    		   
    		   WebElement cityName=driver.findElement(xpathRowLocator);
    		   String cityNameText=cityName.getText();
    		   System.out.println(cityNameText);
    		   
    	//creating a new Row
    		  Row row = sheet.createRow(index);
    		  
    		   //creating a new row of cell 
    		  Cell cell = row.createCell(0);
    		  
    		  cell.setCellValue(cityNameText);
    		  
    	   }
    	   
    		  FileOutputStream file1 = new FileOutputStream("./src/com/Excel/File5.xlsx");
    		  workbook.write(file1);
    		  workbook.close();
    		
       }
     
       public static void main(String[] args) throws IOException {
    	   CapturingFirstColumDataInExcelSheet getData=new CapturingFirstColumDataInExcelSheet();
    	   
    	  getData.applicationlaunch();
    	  getData.getfirstcolumData();
    	  getData.applicationclose();
	}
	
}
