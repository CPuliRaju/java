package com.OrangeHRMApplicationPageTestCases;



import org.testng.annotations.Test;

import com.OrangeHRMApplicationBaseTest.BaseTest;
import com.OrangeHRMApplicationPages.OrangeHRMLoginPage;

public class OrangeHRMLoginPageTest extends BaseTest{

	OrangeHRMLoginPage lip;
	@Test(priority=1,description="Validating OrangeHRM Application Login Page  Logo Test")
	public void loginPageLogoValidationTest() 
	{
	   lip=new OrangeHRMLoginPage();
	   lip.LohinPageLogoValidation();
	}
	
	@Test(priority=2,description="Validating OrangeHRM Applicaton Login Page Text Test")
	public void loginPageTextValidationTest()
	{
		lip=new OrangeHRMLoginPage();
		lip.loginPageTextValidation();
	}
	@Test(priority=3,description="Validating OrangeHRM Application Login Page Login Fuctionality Test")
	public void loginPageloginFuctionalityTest()
	{
		lip=new OrangeHRMLoginPage();
		lip.loginPageLoginFunctionality("PULIRAJU","Puli996632@");
	}
	
	
}
