package com.StepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utility.Log;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMApplicationMethods {

	WebDriver driver;

	@Given("^Should Open Chrome Browser in The System$")
	public void should_Open_Chrome_Browser_in_The_System()  
	{
		System.setProperty("webdriver.chrome.driver", "./ChromeBrowser/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	@When("^User Enter OrangeHRM Application URL Address$")
	public void user_Enter_OrangeHRM_Application_URL_Address() 
	{

		String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		driver.get(applicationUrlAddress);

	}

	@Then("^User Should be Navigated to OrangeHRM Application LogIn Page$")
	public void user_Should_be_Navigated_to_OrangeHRM_Application_LogIn_Page() throws InterruptedException 
	{
		String expected_TitleofOrangeHRMApplicationLoginPage="OrangeHRM";
		Log.info("The expected Title of the OrangeHRM Application LogiPage is:-"+expected_TitleofOrangeHRMApplicationLoginPage);

		String actual_TitleofOrangeHRMApplicationLoginPage = "driver.getTitle";
		System.out.println("The actual Title of the OrangeHRM Application LogiPage is:-"+actual_TitleofOrangeHRMApplicationLoginPage);

		if(actual_TitleofOrangeHRMApplicationLoginPage.equals(expected_TitleofOrangeHRMApplicationLoginPage))
		{
			Log.info(actual_TitleofOrangeHRMApplicationLoginPage);
		}
		else
		{
			Log.info("Its Not Login page of OrangeHRM Application - FAIL");
		}
		String expected_CurrentUrlAddressOfOrangeHRMApplicationLoginPage ="Orange HRM-4.2.0.1";
		Log.info("The expected URl Address of OrangeHRM Applicatoin LoginPage is:-"+expected_CurrentUrlAddressOfOrangeHRMApplicationLoginPage);

		String actual_CurrentUrlAddressOfOrangeHRMApplicationLoginPage = driver.getCurrentUrl();
		Log.info("The actual URl Address of OrangeHRM Applicatoin LoginPage is:-"+actual_CurrentUrlAddressOfOrangeHRMApplicationLoginPage);

		if(actual_CurrentUrlAddressOfOrangeHRMApplicationLoginPage.contains(expected_CurrentUrlAddressOfOrangeHRMApplicationLoginPage))
		{
			Log.info("Its a LoginPage of OrangeHRM Application Url Address Matched PASS");
		}
		else
		{
			Log.info("Its a LoginPage of OrangeHRM Application Url Address Not Matched FAIL");
		}

		By usernameL=By.id("txtUsername");
		WebElement username=driver.findElement(usernameL);
		username.sendKeys("PULIRAJU");

		By passwordL=By.id("txtPassword");
		WebElement password=driver.findElement(passwordL);
		password.sendKeys("Puli996632@");

		By loginbuttonL=By.id("btnLogin");
		WebElement loginbutton=driver.findElement(loginbuttonL);
		loginbutton.click();

		//<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
		By welcomeL=By.id("welcome");
		WebElement welcome=driver.findElement(welcomeL);
		welcome.click();

		Thread.sleep(2000);
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
		By LogoutL=By.linkText("Logout");
		WebElement logout=driver.findElement(LogoutL);
		logout.click();	

	}

	@Then("^User Should Close the OrangeHRM Application And The Close$")
	public void user_Should_Close_the_OrangeHRM_Application_And_The_Close() 
	{
		driver.quit();  
	}
	
	
}