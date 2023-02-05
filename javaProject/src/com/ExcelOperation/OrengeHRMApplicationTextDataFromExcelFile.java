package com.ExcelOperation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrengeHRMApplicationTextDataFromExcelFile {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		 
		WebDriver driver;
		
		String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		System.setProperty("webdriver.chrome.driver", "./WebDriver/chromedriver.exe");
		
		driver= new ChromeDriver();
		
		driver.get(applicationUrlAddress);
		
		driver.manage().window().maximize();
		
		FileInputStream logintestdedafile=new FileInputStream("./src/com/Excel/file4.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(logintestdedafile);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		
		Row row=sheet.getRow(0);
		Cell userNameTestDataCell=row.getCell(0);
		
		String userNameTestData=userNameTestDataCell.getStringCellValue();
		System.out.println("The userName is:-"+userNameTestData);
		
		Cell passwordTestDataCell=row.getCell(1);
		String passwordTestData=passwordTestDataCell.getStringCellValue();
		System.out.println("The password is:-"+passwordTestData);
		
		By userNameLocator=By.id("txtUsername");
		WebElement userName=driver.findElement(userNameLocator);
		userName.sendKeys(userNameTestData);
		
		By passwordLocator=By.name("txtPassword");
		WebElement password=driver.findElement(passwordLocator);
		password.sendKeys(passwordTestData);
		
		By loginButtonLocator=By.className("button");
		WebElement loginButton=driver.findElement(loginButtonLocator);
		loginButton.click();
		
		//Validating HomaPage
		By welcomeAdminLocator=By.id("welcome");
		WebElement welccomeAdmin=driver.findElement(welcomeAdminLocator);
		
		String expected_OrangeHRMApplicationHomePageText="Admin";
		String actual_OrangeHRMApplicationHomePageText=welccomeAdmin.getText();
		
		if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText))
		{
		System.out.println("successfully Navigated to HOME page - PASS");
		Cell newRowOfCell=row.createCell(2);
		newRowOfCell.setCellValue("successfully Navigated to HOME page - PASS");		
		}
		
		else
		{
			System.out.println("failed navigated to Home Page - FAIL");
			Cell newRowOfcell=row.createCell(2);
			newRowOfcell.setCellValue("failed navigated to Home Page - FAIL");
		}
		
		FileOutputStream loginTestResultFile = new FileOutputStream("./src/com/Excel/file4.xlsx");
		workbook.write(loginTestResultFile);
		
		welccomeAdmin.click();
		
		//Automating Logout 
		Thread.sleep(5000);
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
		By LogoutL=By.linkText("Logout");
	    WebElement Logout=driver.findElement(LogoutL);
	    Logout.click();
	    
	    driver.quit();
	}

}
