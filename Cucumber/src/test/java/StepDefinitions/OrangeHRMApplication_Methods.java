package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utility.Log;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRMApplication_Methods {

	WebDriver driver;

	@Given("Should Open Chrome Browser in The System")
	public void should_open_chrome_browser_in_the_system() {


		System.setProperty("webdriver.chrome.driver", "./driverfiles/chromedriver.exe");

		driver= new ChromeDriver();
		driver.manage().window().maximize();
       
	}

	@When("User Enter OrangeHRM Application URL Address")
	public void user_enter_orange_hrm_application_url_address() {

		String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		driver.get(applicationUrlAddress);

	}

	@Then("User Should be Navigated to OrangeHRM Application LogIn Page")
	public void user_should_be_navigated_to_orange_hrm_application_log_in_page() throws InterruptedException {
		String expected_TitleofOrangeHRMApplicationLoginPage="OrangeHRM";
		//System.out.println("The expected Title of the OrangeHRM Application LogiPage is:-"+expected_TitleofOrangeHRMApplicationLoginPage);
		Log.info("The expected Title of the OrangeHRM Application LogiPage is:-"+expected_TitleofOrangeHRMApplicationLoginPage);

		String actual_TitleofOrangeHRMApplicationLoginPage = "driver.getTitle";
		//System.out.println("The actual Title of the OrangeHRM Application LogiPage is:-"+actual_TitleofOrangeHRMApplicationLoginPage);
		Log.info("The actual Title of the OrangeHRM Application LogiPage is:-"+actual_TitleofOrangeHRMApplicationLoginPage);

		if(actual_TitleofOrangeHRMApplicationLoginPage.equals(expected_TitleofOrangeHRMApplicationLoginPage))
		{
			//System.out.println("Its a Login page of OrangeHRM Application - PASS");
			Log.info(actual_TitleofOrangeHRMApplicationLoginPage);
		}
		else
		{
			//System.out.println("Its Not Login page of OrangeHRM Application - FAIL");
			Log.info(actual_TitleofOrangeHRMApplicationLoginPage);
		}
		String expected_CurrentUrlAddressOfOrangeHRMApplicationLoginPage ="Orange HRM-4.2.0.1";
		//System.out.println("The expected URl Address of OrangeHRM Applicatoin LoginPage is:-"+expected_CurrentUrlAddressOfOrangeHRMApplicationLoginPage);
		Log.info("The expected URl Address of OrangeHRM Applicatoin LoginPage is:-"+expected_CurrentUrlAddressOfOrangeHRMApplicationLoginPage);


		String actual_CurrentUrlAddressOfOrangeHRMApplicationLoginPage = driver.getCurrentUrl();
		//System.out.println("The actual URl Address of OrangeHRM Applicatoin LoginPage is:-"+actual_CurrentUrlAddressOfOrangeHRMApplicationLoginPage);
		Log.info("The actual URl Address of OrangeHRM Applicatoin LoginPage is:-"+actual_CurrentUrlAddressOfOrangeHRMApplicationLoginPage);


		if(actual_CurrentUrlAddressOfOrangeHRMApplicationLoginPage.contains(expected_CurrentUrlAddressOfOrangeHRMApplicationLoginPage))
		{
			//System.out.println("Its a LoginPage of OrangeHRM Application Url Address Matched PASS");
			Log.info(actual_CurrentUrlAddressOfOrangeHRMApplicationLoginPage);
		}
		else
		{
			//System.out.println("Its a LoginPage of OrangeHRM Application Url Address Not Matched FAIL");
			Log.info(actual_CurrentUrlAddressOfOrangeHRMApplicationLoginPage);
		}
        
		//driver.findElement(By.id("txtUsername")).sendKeys("PULIRAJU");
		By usernameLocator =By.id("txtUsername");
		WebElement username =driver.findElement(usernameLocator);
		username.sendKeys("PULIRAJU");
		
		//driver.findElement(By.id("txtPassword")).sendKeys("Puli996632@");
        By passwordLocator=By.id("txtPassword");
        WebElement password=driver.findElement(passwordLocator);
        password.sendKeys("Puli996632@");
        
		//driver.findElement(By.className("button")).click();
        By LoginButtonLocator=By.id("btnLogin");
        WebElement Loginbutton=driver.findElement(LoginButtonLocator);
        Loginbutton.click();

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

	@Then("User Should Close the OrangeHRM Application And The Close")
	public void user_should_close_the_orange_hrm_application_and_the_close() {

		driver.quit();

	}
}
