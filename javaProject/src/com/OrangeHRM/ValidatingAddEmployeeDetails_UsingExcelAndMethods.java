package com.OrangeHRM;

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
import org.openqa.selenium.interactions.Actions;

public class ValidatingAddEmployeeDetails_UsingExcelAndMethods {

	static WebDriver driver;
	String applicationUrl = "http://127.0.0.1/Orangehrm-4.2.0.1"; 
	String ExcelDataFile = "./src/com/Excel/Excel_Testing_Selenium_OrangeHRM.xlsx";
	//static String ExcelDataFileSheet = "Homework_11Jan23_AddEmployee_a";
	String ExcelDataFileSheet = "Homework_11Jan23_AddEmployee_b";
	static int i,j;
	public static void main(String[] args) throws IOException
	{
		ValidatingAddEmployeeDetails_UsingExcelAndMethods process = new ValidatingAddEmployeeDetails_UsingExcelAndMethods();
		process.applicationLaunch();

		for(i=2;i<6;i++)
		{
			j=i-1;
			System.out.println("iteration : "+j);
			process.HomePageTitle();
			process.HomePageLoginPanel();
			process.HomePageUrlAddress();
			process.logIn2LogOut();
			process.logout2LogInPage();
		}
		process.driverQuit();
	}
	public void applicationLaunch()
	{
		System.setProperty("webdriver.chrome.driver", "./Webdriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(applicationUrl);
		System.out.println("Application Launch - Success");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	}
	public void driverQuit()
	{
		driver.quit();
	}
	public void HomePageTitle() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

		FileInputStream file = new FileInputStream(ExcelDataFile);
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet(ExcelDataFileSheet);
		Row row_Title = sheet.getRow(i);
		Cell cell_ExpectedTitle = row_Title.getCell(0);
		String expected_Title = cell_ExpectedTitle.getStringCellValue();
		String actual_Title = driver.getTitle();
		Cell cell_ActualTitle = row_Title.createCell(1);
		cell_ActualTitle.setCellValue(actual_Title);
			if(actual_Title.equals(expected_Title))
			{
				System.out.println("Home Page - Title - Pass");
				Cell cell_Title_Result = row_Title.createCell(2);
				cell_Title_Result.setCellValue("Pass");
			}
			else
			{
				System.out.println("Home Page - Title - Fail");
				Cell cell_Title_Result = row_Title.createCell(2);
				cell_Title_Result.setCellValue("Fail");
			}
		FileOutputStream TestResultFile = new FileOutputStream(ExcelDataFile);
		workBook.write(TestResultFile);
		workBook.close();
	}
	public void HomePageLoginPanel() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		FileInputStream file = new FileInputStream(ExcelDataFile);
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet(ExcelDataFileSheet);
		Row row_LoginPanel = sheet.getRow(i);
		Cell cell_ExpectedLoginPanel= row_LoginPanel.getCell(3);
		String expected_LoginPanelText = cell_ExpectedLoginPanel.getStringCellValue();
	//<div id="logInPanelHeading">LOGIN Panel</div>
		By loginPanelLocator = By.id("logInPanelHeading");
		WebElement LoginPanel = driver.findElement(loginPanelLocator);
		String actual_LoginPanelText = LoginPanel.getText();
		Cell cell_actualLoginPanel = row_LoginPanel.createCell(4);
		cell_actualLoginPanel.setCellValue(actual_LoginPanelText);
			if(actual_LoginPanelText.equals(expected_LoginPanelText))
			{
				System.out.println("Home Page - Login Panel Heading - Pass");
				Cell cell_LoginPanel_Result = row_LoginPanel.createCell(5);
				cell_LoginPanel_Result.setCellValue("Pass");
			}
			else
			{
				System.out.println("Home Page - Login Panel Heading - Fail");
				Cell cell_LoginPanel_Result = row_LoginPanel.createCell(5);
				cell_LoginPanel_Result.setCellValue("Fail");
			}
		FileOutputStream TestResultFile = new FileOutputStream(ExcelDataFile);
		workBook.write(TestResultFile);
		workBook.close();
	}
	public void HomePageUrlAddress() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		FileInputStream file = new FileInputStream(ExcelDataFile);
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet(ExcelDataFileSheet);
		Row row_UrlAddress = sheet.getRow(i);
		Cell cell_ExpectedUrl = row_UrlAddress.getCell(6);
		String expected_Url = cell_ExpectedUrl.getStringCellValue();
		String actual_Url = driver.getCurrentUrl();
		Cell cell_ActualUrl = row_UrlAddress.createCell(7);
		cell_ActualUrl.setCellValue(actual_Url);
			if(actual_Url.contains(expected_Url))
			{
				System.out.println("Home Page - Url Address - Pass");
				Cell cell_Url_Result = row_UrlAddress.createCell(8);
				cell_Url_Result.setCellValue("Pass");
			}
			else
			{
				System.out.println("Home Page - Url Address - Fail");
				Cell cell_Url_Result = row_UrlAddress.createCell(8);
				cell_Url_Result.setCellValue("Fail"); 
			}
		FileOutputStream TestResultFile = new FileOutputStream(ExcelDataFile);
		workBook.write(TestResultFile);
		workBook.close();
	}
	public void logIn2LogOut() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		FileInputStream file = new FileInputStream(ExcelDataFile);
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet(ExcelDataFileSheet);
		Row row_LogIn = sheet.getRow(i);
		Cell cell_Login_Username = row_LogIn.getCell(9);
		String Username = cell_Login_Username.getStringCellValue();
		Cell cell_Login_Password = row_LogIn.getCell(10);
		String Password = cell_Login_Password.getStringCellValue();
	//<input name="txtUsername" id="txtUsername" type="text">
		By userNameLocator = By.id("txtUsername");
		WebElement userName = driver.findElement(userNameLocator);
		userName.sendKeys(Username);
	//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
		By passWordLocator = By.id("txtPassword");
		WebElement passWord = driver.findElement(passWordLocator);
		passWord.sendKeys(Password);
	//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
		By LoginLocator = By.name("Submit");
		WebElement Login = driver.findElement(LoginLocator);
		Login.click();
		Row row_Admin = sheet.getRow(i);
		Cell cell_Expected_AdminText = row_Admin.getCell(12);
		String expected_Admin = cell_Expected_AdminText.getStringCellValue();
		String actual_Admin;
			try
			{
				//<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
				By AdminLocator = By.linkText("Welcome Admin");
				WebElement admin = driver.findElement(AdminLocator);
				actual_Admin = admin.getText();
			}
			catch(Exception error)
			{
				actual_Admin = "error";
			}
				if(actual_Admin.contains(expected_Admin))
				{
				//Login Validation
					Row row_Login_Validation = sheet.getRow(i);
					Cell cell_Login_Validation = row_Login_Validation.createCell(11);
					cell_Login_Validation.setCellValue("Pass");
					System.out.println("Login (With Given Credentials) - Pass");
				//Admin HomePage Validation
					Row row_Admin_Validation = sheet.getRow(i);
					Cell cell_Admin_Result = row_Admin_Validation.createCell(14);
					cell_Admin_Result.setCellValue("Pass");
					System.out.println("Admin Home Page Validation - Pass");
					ValidatingAddEmployeeDetails_UsingExcelAndMethods logIn2LogOut = new ValidatingAddEmployeeDetails_UsingExcelAndMethods();
						logIn2LogOut.addEmployee();
						logIn2LogOut.logOut();
				}
				else
				{
					//<span id="spanMessage">Invalid credentials</span>
					String invalid = "Invalid";
					By LoginFailLocator = By.xpath("//span[text()='Invalid credentials']");
					WebElement LoginFail = driver.findElement(LoginFailLocator);
					String InvalidCredentials = LoginFail.getText();
					if(InvalidCredentials.contains(invalid))
					{
						Cell cell_Login_Result = row_LogIn.createCell(11);
						cell_Login_Result.setCellValue(InvalidCredentials+" - LogIn Fail");
						System.out.println("Login (With Given Credentials) - Fail");
						int cellCount = row_LogIn.getLastCellNum();
						for(int j=14;j<cellCount;j=j+3)
						{
							Cell cell_Results = row_Admin.createCell(j);
							cell_Results.setCellValue(" - LogIn - Fail - ");
						}
					}
				}
			FileOutputStream TestResultFile = new FileOutputStream(ExcelDataFile);
			workBook.write(TestResultFile);
			workBook.close();
	}
	public void addEmployee() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		FileInputStream file = new FileInputStream(ExcelDataFile);
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet(ExcelDataFileSheet);
		ValidatingAddEmployeeDetails_UsingExcelAndMethods addEmployeeProcess = new ValidatingAddEmployeeDetails_UsingExcelAndMethods();
//<a  id="menu_pim_viewPimModule" class="firstLevelMenu"><b>PIM</b></a>
		By pimLocator = By.linkText("PIM");
		WebElement Pim = driver.findElement(pimLocator);
		Actions action = new Actions(driver);
		action.moveToElement(Pim).build().perform();
		System.out.println("PIM Locate - Pass");
//<a id="menu_pim_addEmployee">Add Employee</a>
		By addEmployeeLocator = By.linkText("Add Employee");
		WebElement addEmployee = driver.findElement(addEmployeeLocator);
		addEmployee.click();
		System.out.println("PIM - Add Employee click - Pass");

		addEmployeeProcess.addEmployeePageValidation();
		addEmployeeProcess.addingEmployee();
		addEmployeeProcess.addedEmployeeDetailValidation();
		
		FileOutputStream TestResultFile = new FileOutputStream(ExcelDataFile);
		workBook.write(TestResultFile);
		workBook.close();
	}
	public void addEmployeePageValidation() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		FileInputStream file = new FileInputStream(ExcelDataFile);
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet(ExcelDataFileSheet);
			/*
//  AddEmployee Page Validation
	//<label class="hasTopFieldHelp">Full Name</label>
		By FullNameLocator = By.xpath("//xpath[text()='Add Employee']");
		WebElement FullName = driver.findElement(FullNameLocator);
		String actualFullNameText = FullName.getTagName();	
		Row row_FullName = sheet.getRow(i);
		Cell cell_actual_FullName = row_FullName.createCell(16);
		cell_actual_FullName.setCellValue(actualFullNameText);
		Cell cell_expected_FullName = row_FullName.getCell(15); 
		String expectedFullNameText = cell_expected_FullName.getStringCellValue();
		Row row_addEmployeePage_Result = sheet.getRow(i);
		Cell cell_addEmployeePage_Result =row_addEmployeePage_Result.getCell(17);
			if(actualFullNameText.equals(expectedFullNameText))
			{
				System.out.println("Add Employee Page - Pass");
				cell_addEmployeePage_Result.setCellValue("Matched");
			}
			else
			{
				System.out.println("Add Employee Page - Fail");
				cell_addEmployeePage_Result.setCellValue("Not Matched");
			}
			 																				*/
			
	//*[@id="content"]/div/div[1]/h1
	///html/body/div[1]/div[3]/div/div[1]/h1
	//<h1>Add Employee</h1>
		By addEmployeeLocator = By.xpath("/html/body/div[1]/div[3]/div/div[1]/h1");
		WebElement AddEmployee = driver.findElement(addEmployeeLocator);
		String actual_AddEmployee_Text = AddEmployee.getText();
		Row row_addEmployee = sheet.getRow(i);
		Cell cell_Actual_addEmployee = row_addEmployee.createCell(16);
		cell_Actual_addEmployee.setCellValue(actual_AddEmployee_Text);
		Cell cell_Expected_addEmployee = row_addEmployee.getCell(15);
		String expected_AddEmployee_Text = cell_Expected_addEmployee.getStringCellValue();
		Cell cell_addEmployee_Result = row_addEmployee.createCell(17);
			if(actual_AddEmployee_Text.contains(expected_AddEmployee_Text))
			{
				System.out.println("Add Employee Page - Pass");
				cell_addEmployee_Result.setCellValue("Pass");
			}
			else
			{
				System.out.println("Add Employee Page - Fail");
				cell_addEmployee_Result.setCellValue("Fail");
			}
		FileOutputStream TestResultFile = new FileOutputStream(ExcelDataFile);
		workBook.write(TestResultFile);
		workBook.close();
	}
	public void addingEmployee() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		FileInputStream file = new FileInputStream(ExcelDataFile);
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet(ExcelDataFileSheet);
//First Name Input Values
		Row row_FirstName = sheet.getRow(i);
		Cell cell_FirstName = row_FirstName.getCell(18);
		String first_name = cell_FirstName.getStringCellValue();
	// <input class="formInputText" maxlength="30" type="text" name="firstName" id="firstName">
		By FirstNameLocator = By.name("firstName");
		WebElement FirstName= driver.findElement(FirstNameLocator);
		FirstName.sendKeys(first_name);
//Middle Name Input Values
		Row row_MiddleName = sheet.getRow(i);
		Cell cell_MiddleName = row_MiddleName.getCell(19);
		String middle_name = cell_MiddleName.getStringCellValue();
	// <input class="formInputText" maxlength="30" type="text" name="middleName" id="middleName">
		By MiddleNameLocator = By.name("middleName");
		WebElement MiddleName= driver.findElement(MiddleNameLocator);
		MiddleName.sendKeys(middle_name);
//Middle Name Input Values
		Row row_LastName = sheet.getRow(i);
		Cell cell_LastName = row_LastName.getCell(20);
		String last_name = cell_LastName.getStringCellValue();
	// <input class="formInputText" maxlength="30" type="text" name="lastName" id="lastName">
		By LastNameLocator = By.name("lastName");
		WebElement LastName= driver.findElement(LastNameLocator);
		LastName.sendKeys(last_name);
// Employee Id  
	//<input class="formInputText valid" maxlength="10" type="text" name="employeeId" value="xxxx" id="employeeId">
		By empId = By.name("employeeId");
		WebElement employeeId = driver.findElement(empId);
		String employee_Id = employeeId.getAttribute("value");
		Row row_employeeId= sheet.getRow(i);
		Cell cell_Extracted_EmployeeId = row_employeeId.createCell(21);
		cell_Extracted_EmployeeId.setCellValue(employee_Id);
//Saving the Details
	//<input type="button" class="" id="btnSave" value="Save">
		By saveLocator = By.id("btnSave");
		WebElement Save= driver.findElement(saveLocator);
		Save.click();
		System.out.println("       "+j+" Add Employee - Pass");
		FileOutputStream TestResultFile = new FileOutputStream(ExcelDataFile);
		workBook.write(TestResultFile);
		workBook.close();
	}
	public void addedEmployeeDetailValidation() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		FileInputStream file = new FileInputStream(ExcelDataFile);
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet(ExcelDataFileSheet);
		Row row_Actual = sheet.getRow(i);
//<input value="Eashwara" type="text" name="personal[txtEmpFirstName]" class="block default editable" 
//  maxlength="30" title="First Name" id="personal_txtEmpFirstName" disabled="disabled">
		By FirstName = By.id("personal_txtEmpFirstName");
		WebElement Firstname = driver.findElement(FirstName);
		String actual_FirstName = Firstname.getAttribute("Value");
		Cell cell_Actual_FN = row_Actual.createCell(22);
		cell_Actual_FN.setCellValue(actual_FirstName);
		System.out.println("First Name identified");
	//MiddleName
		By MiddleName = By.id("personal_txtEmpMiddleName");
		WebElement Middlename = driver.findElement(MiddleName);
		String actual_MiddleName = Middlename.getAttribute("Value");
		Cell cell_Actual_MN = row_Actual.createCell(23);
		cell_Actual_MN.setCellValue(actual_MiddleName);
		System.out.println("Middle Name identified");
	//LastName
		By LastName = By.id("personal_txtEmpLastName");
		WebElement Lastname = driver.findElement(LastName);
		String actual_LastName = Lastname.getAttribute("Value");
		Cell cell_Actual_LN = row_Actual.createCell(24);
		cell_Actual_LN.setCellValue(actual_LastName);
		System.out.println("Last Name identified");
	//Employee Id
		By EmployeeIdL = By.id("personal_txtEmpEmployeeId");
		WebElement EmployeeId = driver.findElement(EmployeeIdL);
		String actual_EmployeeId = EmployeeId.getAttribute("Value");
		Cell cell_Actual_Id = row_Actual.createCell(25);
		cell_Actual_Id.setCellValue(actual_EmployeeId);
		System.out.println("Employee Id identified");
		Row row_expected = sheet.getRow(i);
		Row row_result = sheet.getRow(i);
// Validating Added Employee Details
		System.out.println("-----Validating Added Employee Details-----");
//FirstName Validation
		Cell cell_Expected_FN = row_expected.getCell(18);
		String expected_FirstName = cell_Expected_FN.getStringCellValue();
			if(actual_FirstName.equals(expected_FirstName))
			{
				Cell cell_FN_result = row_result.createCell(26);
				cell_FN_result.setCellValue("Matched - Pass");
				System.out.println("First Name - Pass");
			}
			else
			{
				Cell cell_FN_result = row_result.createCell(26);
				cell_FN_result.setCellValue("Not Matched - Fail");
				System.out.println("First Name - Fail");
			}
//MiddleName Validation
		Cell cell_Expected_MN = row_expected.getCell(19);
		String expected_MiddleName = cell_Expected_MN.getStringCellValue();
			if(actual_MiddleName.equals(expected_MiddleName))
			{
				Cell cell_MN_result = row_result.createCell(27);
				cell_MN_result.setCellValue("Matched - Pass");
				System.out.println("Middle Name - Pass");
			}
			else
			{
				Cell cell_MN_result = row_result.createCell(27);
				cell_MN_result.setCellValue("Not Matched - Fail");
				System.out.println("Middle Name - Fail");
			}
//LastName Validation
			Cell cell_Expected_LN = row_expected.getCell(20);
			String expected_LastName = cell_Expected_LN.getStringCellValue();
				if(actual_LastName.equals(expected_LastName))
				{
					Cell cell_LN_result = row_result.createCell(28);
					cell_LN_result.setCellValue("Matched - Pass");
					System.out.println("Last Name - Pass");
				}
				else
				{
					Cell cell_LN_result = row_result.createCell(28);
					cell_LN_result.setCellValue("Not Matched - Fail");
					System.out.println("Last Name - Fail");
				}
//EmployeeId Validation
				
			Cell cell_Expected_Id = row_expected.getCell(21);
			String expected_Id = cell_Expected_Id.getStringCellValue();
				if(actual_EmployeeId.equals(cell_Expected_Id))
				{
					Cell cell_Id_result = row_result.createCell(29);
					cell_Id_result.setCellValue("Matched - Pass");
					System.out.println("Employee Id - Pass");
				}
				else
				{
					Cell cell_Id_result = row_result.createCell(29);
					cell_Id_result.setCellValue("Not Matched - Fail");
					System.out.println("Employee Id - Fail");
				}
		FileOutputStream TestResultFile = new FileOutputStream(ExcelDataFile);
		workBook.write(TestResultFile);
		workBook.close();
	}
	public void logout2LogInPage() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		FileInputStream file = new FileInputStream(ExcelDataFile);
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet(ExcelDataFileSheet);
		Row row_LoginPanel = sheet.getRow(i);
		Cell cell_ExpectedLoginPanel= row_LoginPanel.getCell(30);
		String expected_LoginPanelText = cell_ExpectedLoginPanel.getStringCellValue();
	//<div id="logInPanelHeading">LOGIN Panel</div>
		By loginPanelLocator = By.linkText("LOGIN Panel");
		WebElement LoginPanel = driver.findElement(loginPanelLocator);
		String actual_LoginPanelText = LoginPanel.getText();
		Cell cell_actualLoginPanel = row_LoginPanel.createCell(31);
		cell_actualLoginPanel.setCellValue(actual_LoginPanelText);
			if(actual_LoginPanelText.equals(expected_LoginPanelText))
			{
				Cell cell_LoginPanel_Result = row_LoginPanel.createCell(32);
				cell_LoginPanel_Result.setCellValue("Pass");
				System.out.println("LogIn Panel after Logout/Login Fail - Successful");
			}
			else
			{
				Cell cell_LoginPanel_Result = row_LoginPanel.createCell(32);
				cell_LoginPanel_Result.setCellValue("Fail");
				System.out.println("LogIn Panel after Logout/Login Fail - Unsuccessful");
			}
		FileOutputStream TestResultFile = new FileOutputStream(ExcelDataFile);
		workBook.write(TestResultFile);
		workBook.close();
	}
	public void logOut()
	
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		By AdminLocator = By.linkText("Welcome Admin");
		WebElement admin = driver.findElement(AdminLocator);
		admin.click();
		By LogOutLocator = By.linkText("Logout");
		WebElement logout = driver.findElement(LogOutLocator);
		logout.click();
		System.out.println("Logout - Successful");
	}
}
