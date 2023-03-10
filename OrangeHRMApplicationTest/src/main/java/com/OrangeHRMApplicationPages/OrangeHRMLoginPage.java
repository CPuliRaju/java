package com.OrangeHRMApplicationPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRMApplicationBaseTest.BaseTest;
import com.Utility.Log;

public class OrangeHRMLoginPage extends BaseTest{

	public OrangeHRMLoginPage()//its a constructor
	{
	 PageFactory.initElements(driver, this);
	}
	////*[@id="divLogo"]/img
	@FindBy(xpath="//*[@id=\"divLogo\"]/img")
	WebElement orangeHRMLogo;
	
	//<div id="logInPanelHeading">LOGIN Panel</div>
	@FindBy(id="logInPanelHeading")
	WebElement orangeHRMLoginPageText;
	
	//<input name="txtUsername" id="txtUsername" type="text">
	@FindBy(id="txtUsername")
	WebElement userName;
	
	//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
	@FindBy(name="txtPassword")
	WebElement password;
	
	//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
	@FindBy(className="button")
	WebElement loginButton;
	
	public void LohinPageLogoValidation() 
	{
		boolean flag=orangeHRMLogo.isDisplayed();
		
		if(flag)
		{
			Log.info("OrangeHRM Application Logo found on OrangeHRM Application LoginPage - PASS");
		}
		else
		{
			Log.info("OrangeHRM Application Logo Not found on OrangeHRM Application LoginPage - FAIL");
		}
	}
	
	public void loginPageTextValidation()
	{
		String expected_OrangeHRMApplicationLoginPageText="LOGIN Panel";
		Log.info("The expected Login page Text is :-"+expected_OrangeHRMApplicationLoginPageText);
		
		String actual_OrangeHRMApplicationLoginPageText=orangeHRMLoginPageText.getText();
		Log.info("The actual Login Page Text is :-"+actual_OrangeHRMApplicationLoginPageText);
		
		if(actual_OrangeHRMApplicationLoginPageText.equals(expected_OrangeHRMApplicationLoginPageText))
		{
			Log.info("Successfully navigated to OrangeHRM Appliaction Login Page - PASS");
		}
		else
		{
			Log.info("Failed to navigated to OrangeHRM Appliaction Login Page - FAIL");
		}
					
	}
	
	public void loginPageLoginFunctionality(String userNameTestData,String passwordTestData)
	{
		userName.sendKeys(userNameTestData);
		password.sendKeys(passwordTestData);
		loginButton.click();
	}
	
}
