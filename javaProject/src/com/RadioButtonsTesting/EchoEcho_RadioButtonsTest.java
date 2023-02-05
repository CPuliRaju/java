package com.RadioButtonsTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EchoEcho_RadioButtonsTest {

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
		
				
		   int group1RadioButtonsCount=group1RadioButtons.size();
		   System.out.println("The number of Radio Buttons in group1 are :-"+group1RadioButtonsCount);
		
		
		   //Testing the Radio Buttons
		   //Performing click operation on the Radio Buttons 
	        for (int indexclick=0;indexclick<group1RadioButtonsCount;indexclick++)
	    	
	    {
	    	//clicking on a Radio Buttons
	    	group1RadioButtons.get(indexclick).click();
	    	
	    	Thread.sleep(5000);
	    	
	    	//getting the status of each RadioButtton
	    	for(int indexclickedstatus=0;indexclickedstatus<group1RadioButtonsCount;indexclickedstatus++)
	    			    	{
	        System.out.println(group1RadioButtons.get(indexclickedstatus).getAttribute("value")
	    				        +" "+group1RadioButtons.get(indexclickedstatus).getAttribute("checked"));
	 
	 
	        }
	    	System.out.println();
	    	}
	    
	        }
		     public static void main(String[] args) throws InterruptedException {
			
			EchoEcho_RadioButtonsTest RadioButtonsTest=new EchoEcho_RadioButtonsTest();
			
		    
			RadioButtonsTest.ApplicationLaunch();
			RadioButtonsTest.RadioButtonsTest();
			RadioButtonsTest.applicationclose();
		}
		    public void applicationclose()
		{
			
		}
		
		
	}


