package com.Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.RadioButtonsTesting.EchoEcho_RadioButtonsTest;

public class EchoEcho_RadioButtonsClicked {

	WebDriver driver;
	String ApplicationUrlAddress="https://echoecho.com/htmlforms10.htm";
	
	public void ApplicationLaunch() 
	{
		
        System.setProperty("webdriver.chrome.driver", "./WebDriver/chromedriver.exe");	
		driver= new ChromeDriver();
		
		driver.get(ApplicationUrlAddress);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void RadioButtonsTest() throws InterruptedException
	{
		/*
		 <input type="radio" name="group1" value="Milk">
        <input type="radio" name="group1" value="Butter" checked="">
		 <input type="radio" name="group1" value="Cheese">

		<input type="radio" name="group2" value="Water">
		<input type="radio" name="group2" value="Beer">
		<input type="radio" name="group2" value="Wine" checked="">
	*/	
		By group1RadioButtonsLocator=By.name("group1");
		List<WebElement>group1RadioButtons=driver.findElements(group1RadioButtonsLocator);
		
		By group2RadioButtonsLocator=By.name("group2");
		List<WebElement>group2RadioButtons=driver.findElements(group2RadioButtonsLocator);
		
		int group1RadioButtonsCount=group1RadioButtons.size();
		System.out.println("The number of Radio Buttons in group1 are :-"+group1RadioButtonsCount);
		
		int group2RadioButtonsCount=group2RadioButtons.size();
		System.out.println("The number of Radio Buttons in group2 are :-"+group2RadioButtonsCount);
		
		//Testing the Radio Buttons
		   //Performing click operation on the Radio Buttons 
		 for (int indexclick=0;indexclick<group1RadioButtonsCount;indexclick++)
	    for (int indexclicked=0;indexclick<group2RadioButtonsCount;indexclick++)
	    	
	    {
	    	//clicking on a Radio Buttons
	    	group1RadioButtons.get(indexclick).click();
	    	group2RadioButtons.get(indexclick).click();
	    	
	    	Thread.sleep(5000);
	    	
	    	//getting the status of each RadioButtton
	    	for(int indexclickedstatus=0;indexclickedstatus<group1RadioButtonsCount;indexclickedstatus++)
	    	{
     System.out.println(group1RadioButtons.get(indexclickedstatus).getAttribute("value")
		        +" "+group1RadioButtons.get(indexclickedstatus).getAttribute("checked"));
	    	for(int indexclickedstatus1=0;indexclickedstatus1<group2RadioButtonsCount;indexclickedstatus1++)
	    	
	 System.out.println(group2RadioButtons.get(indexclickedstatus1).getAttribute("value")
	    				        +" "+group2RadioButtons.get(indexclickedstatus1).getAttribute("checked"));
	 
	 
	        }
	    	System.out.println();
	    	}
	    
	        }
		     public static void main(String[] args) throws InterruptedException {
			
		    	 EchoEcho_RadioButtonsClicked RadioButtonsClicked=new EchoEcho_RadioButtonsClicked();
			
		    
		    	 RadioButtonsClicked.ApplicationLaunch();
		    	 RadioButtonsClicked.RadioButtonsTest();
		    	 RadioButtonsClicked.applicationclose();
		}
		public void applicationclose()
		{
		 driver.quit();	
		}
		
	}
	
	

