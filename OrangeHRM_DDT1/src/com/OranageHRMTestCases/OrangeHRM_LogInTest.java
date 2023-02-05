package com.OranageHRMTestCases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.OrangeHRM.BaseTest;
import com.Utility.Log;

public class OrangeHRM_LogInTest extends BaseTest{
	
	FileInputStream propertyfile;
	   Properties properties;
	
	@Test(priority=1,description="OangeHRMApplicationLogInpageTextValidation")
	public void LoginPanelTest() throws IOException {
		
		propertyfile=new FileInputStream("./src/com/Config/OrengeHRMApplication.Properties");
        properties =new Properties();
		properties.load(propertyfile);
		
		
		//<div id="logInPanelHeading">LOGIN Panel</div>
		By loginpanelLocator=By.id(properties.getProperty("loginPanelTextProperty"));
		WebElement loginpanel=driver.findElement(loginpanelLocator);
		
		String ExpecedText_loginpanel="LOGIN Panel";
		//System.out.println("the Expected text of login of orangeHRM Login page is :-"+ExpecedText_loginpanel);
		Log.info("the Expected text of login of orangeHRM Login page is :-"+ExpecedText_loginpanel);
		
		String ActualText_loginpanel=loginpanel.getText();
		//System.out.println("The Actual text of  login of orangeHRM Login page is :-"+ActualText_loginpanel);
		Log.info("The Actual text of  login of orangeHRM Login page is :-"+ActualText_loginpanel);
		
		if(ActualText_loginpanel.equals(ExpecedText_loginpanel)) {
			//System.out.println("Actual and expected login panel text are same - PASS");
			Log.info("Actual and expected login panel text are same - PASS");
		}
		else {
			//System.out.println("Actual and expected login panel text are same - PASS")
			Log.info("Actual and expected login panel text are Not same - FAIL");
		}
	}
	@Test(priority=2)
	public void LoginFuctionalityTest() throws IOException {
		
		FileInputStream file = new FileInputStream("./src/com/ApplicationTestDataFiles/OrangeHRM_LoginTestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet =workbook.getSheet("Sheet2");
		
		Row row=sheet.getRow(1);
		Cell rowOfCell=row.getCell(0);
		String userNameData=rowOfCell.getStringCellValue();
		rowOfCell=row.getCell(1);
		String passwordData=rowOfCell.getStringCellValue();
	
		
		//1 Enter valid userName and Enter valid Password------------------------
		
		//<input name="txtUsername" id="txtUsername" type="text">
		By UserNameLocator=By.id(properties.getProperty("userNameProperty"));
		WebElement UserName=driver.findElement(UserNameLocator);
		UserName.sendKeys(userNameData);
		
		//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
		By PasswordLocator=By.id(properties.getProperty("passwordProperty"));   
		WebElement Password=driver.findElement(PasswordLocator);
		Password.sendKeys(passwordData);
		
		//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
		By LoginLocator=By.id(properties.getProperty("loginButtonProperty"));
		WebElement Login=driver.findElement(LoginLocator);
		Login.click();
	
		//<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
		By WelcomeAdminLocator=By.id(properties.getProperty("welcomeAdminProperty"));
		WebElement WelcomeAdmin=driver.findElement(WelcomeAdminLocator);
		
		String Expected_OrangeHRMHomePageText="Admin";
		
		String Actual_OrangeHRMHomePageText= WelcomeAdmin.getText();
		
		if(Actual_OrangeHRMHomePageText.contains(Expected_OrangeHRMHomePageText)) {
			//System.out.println("successfully Navigate to HomePage - PASS");
			Log.info("successfully Navigate to HomePage - PASS");
			Cell newrowOfcell=row.createCell(2);
			newrowOfcell.setCellValue("Successfullly NaviGate to HomePage - PASS ");
		}
		else {
			//System.out.println("Failed Navigate to HomePage - FAIL");
			Log.info("Failed Navigate to HomePage - FAIL");
			Cell newrowOfcell=row.createCell(2);
			newrowOfcell.setCellValue("Failed Navigate to HomePage - FAIL");
		}
		
		FileOutputStream loginTestResultFile=new FileOutputStream("./src/com/ApplicationTestResultFile/OrangeHRM_LoginTestResultData.xlsx");
	    workbook.write(loginTestResultFile);
    }
	@Test(priority=3)
	public void LogOutTest() {
		
		By WelcomeAdminLocator=By.id(properties.getProperty("welcomeAdminProperty"));
		WebElement WelcomeAdlin=driver.findElement(WelcomeAdminLocator);
		WelcomeAdlin.click();
		
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
		By logoutLocator=By.linkText(properties.getProperty("logoutProperty"));
		WebElement logout=driver.findElement(logoutLocator);
		logout.click();
	}
}
