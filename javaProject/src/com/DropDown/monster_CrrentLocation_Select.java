package com.DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class monster_CrrentLocation_Select {

	public static void main(String[] args) {
		
        WebDriver driver;
		
		String applicationUrlAddress="http://my.monsterindia.com/sponsered_popup.html";
		System.setProperty("webdriver.chrome.driver", "./WebDriver/chromedriver.exe");
		
		driver= new ChromeDriver();
		
		driver.get(applicationUrlAddress);
		driver.manage().window().maximize();
		
		//Identifying current Location DropDown
		//Class="border_grey1"
		
	    By currentlocationLocator=By.className("border_grey1");	    
	    WebElement currentlocation =driver.findElement(currentlocationLocator);
	    
	    Select currentLocationSelection = new Select(currentlocation);
	    
	    //index starts from 0
	   currentLocationSelection.selectByIndex(6); 
	    
	    //value should be taken from the property of the Optional Value given by developer
	    currentLocationSelection.selectByValue("492");
	    
	    //visible text of the element should be considered
	    currentLocationSelection.selectByVisibleText("Gurgaon / Gurugram");
	    
	    //id="id_industry"
	   By industryLocator=By.id("id_industry");
	   WebElement industry =driver.findElement(industryLocator);
	  
	   Select industrySelection=new Select(industry);
	   industrySelection.selectByVisibleText("Other");
	   industrySelection.selectByValue("4");
	   industrySelection.selectByIndex(3);
	   
	   //DeSelecting the Selected Optional Values
	   
	   industrySelection.deselectAll();	    
	    
	   industrySelection.deselectByVisibleText("Banking/Accounting/Financial Services");
	   industrySelection.deselectByValue("65");
	   industrySelection.deselectByIndex(2);
	   
	   
	   driver.quit();
	    }
	

}
