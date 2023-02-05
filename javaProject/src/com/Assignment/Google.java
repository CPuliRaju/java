package com.Assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./WebDriver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("Http://Google.com");
		
		//Navigating to GooGle Application HomePage
		String except_GooGleHomePageTitle="GooGle";
		
		//Client Requirement-The Title of Bing HomePage should be "Bing"
		System.out.println("The Title of GooGle HomePage isL"+except_GooGleHomePageTitle);
		
		//Client Requirement Saved into a Variable
		String actual_GooGleHomePageTitle=driver.getTitle();
		
		//Getting the Title of the Bing HomePage - Developed by the DEVELOPER
		System.out.println("The expect Title of GooGle HomePage is"+actual_GooGleHomePageTitle);
		if(actual_GooGleHomePageTitle.equals(actual_GooGleHomePageTitle))
		{
		System.out.println("Both the actual and expected Bing HomePage Title are the same-pass"); 
		} 
		else
		{
		System.out.println("Both the actual and expected GooGle HomePage Title are the same-Fail");
		}
		char uppercase=actual_GooGleHomePageTitle.charAt(0);
		
		if(uppercase=='G')
		{
		System.out.println("Google HomePage Title of the First letter is:"+uppercase);
		}
		else
		{
		System.out.println("Google HomePage Title of the First letter is lowercase");
		}
		driver.close();
		 
	}

}
