package stepDefinations;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMApplicationMethods {
	
	WebDriver driver;

	@Given("^User Should Open chrome Browser inthe System$")
	public void user_Should_Open_chrome_Browser_inthe_System()  {
		
		 //Navigate to OrangeHRM Application 
				
		System.setProperty("webdriver.chrome.driver", "./Webdriver/chromedriver.exe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	    
	}
      
	@When("^User Enter OrangeHRM Application Url Address$")
	public void user_Enter_OrangeHRM_Application_Url_Address()  {
		
		
		String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		driver.get(applicationUrlAddress);
		
	
       
	}

	@Then("^User Should be Navigated to OrangeHRM Application Login Page$")
	public void user_Should_be_Navigated_to_OrangeHRM_Application_Login_Page() throws InterruptedException {//throws InterruptedException  {
			
		
		
		String expected_TitleofOrangeHRMApplicationLoginPage="OrangeHRM";
		System.out.println("The expected Title of the OrangeHRM Application LogiPage is:-"+expected_TitleofOrangeHRMApplicationLoginPage);
		
		String actual_TitleofOrangeHRMApplicationLoginPage = "driver.getTitle";
		System.out.println("The actual Title of the OrangeHRM Application LogiPage is:-"+actual_TitleofOrangeHRMApplicationLoginPage);
		
		if(actual_TitleofOrangeHRMApplicationLoginPage.equals(expected_TitleofOrangeHRMApplicationLoginPage))
		{
		System.out.println("Its a Login page of OrangeHRM Application - PASS");
		}
		else
		{
		System.out.println("Its Not Login page of OrangeHRM Application - FAIL");
		}
		String expected_CurrentUrlAddressOfOrangeHRMApplicationLoginPage ="Orange HRM-4.2.0.1";
		System.out.println("The expected URl Address of OrangeHRM Applicatoin LoginPage is:-"+expected_CurrentUrlAddressOfOrangeHRMApplicationLoginPage);
		
		String actual_CurrentUrlAddressOfOrangeHRMApplicationLoginPage = driver.getCurrentUrl();
		System.out.println("The actual URl Address of OrangeHRM Applicatoin LoginPage is:-"+actual_CurrentUrlAddressOfOrangeHRMApplicationLoginPage);
		
		if(actual_CurrentUrlAddressOfOrangeHRMApplicationLoginPage.contains(expected_CurrentUrlAddressOfOrangeHRMApplicationLoginPage))
		{
		System.out.println("Its a LoginPage of OrangeHRM Application Url Address Matched PASS");
		}
		else
		{
		System.out.println("Its a LoginPage of OrangeHRM Application Url Address Not Matched FAIL");
		}
		By UserNameLocator=By.id("txtUsername");
		WebElement UserName=driver.findElement(UserNameLocator);
		UserName.sendKeys("PULIRAJU");
        
		By PasswordLocator=By.id("txtPassword");
		WebElement Password=driver.findElement(PasswordLocator);
		Password.sendKeys("Puli996632@");
		
		//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
		By LoginButtonLocator=By.id("btnLogin");
		WebElement LoginButton=driver.findElement(LoginButtonLocator);
		LoginButton.click();
		
		
		//<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
		String expected_HomePageText="Admin";
	    By welcomeL=By.id("welcome");
		WebElement welcome=driver.findElement(welcomeL);
		String actual_HomePageText=welcome.getText();
		if(actual_HomePageText.contains(expected_HomePageText))		
		welcome.click();
				
		Thread.sleep(2000);
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
		By LogoutL=By.linkText("Logout");
		WebElement logout=driver.findElement(LogoutL);
		logout.click();		
		
	}

	@Then("^User Should close the OrangeHRM Application and the Browser$")
	public void user_Should_close_the_OrangeHRM_Application_and_the_Browser()  {
		
		
		driver.quit();
	    
	}
	

}
