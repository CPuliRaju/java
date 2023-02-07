package com.Rediffmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RediffMailTest {

	public static void main(String[] args) throws InterruptedException {


		// Navigate to OrangeHRM Application //
		WebDriver driver;

		String applicationUrlAddress="https://register.rediff.com/register/register.php?FormName=user_details";
		System.setProperty("webdriver.chrome.driver", "./WebDriver/chromedriver.exe");

		driver= new ChromeDriver();

		driver.get(applicationUrlAddress);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

         //Xpath expression Creation 
		//<input type="text" onblur="fieldTrack(this);" name="namec01863b3" value="" style="width:185px;" maxlength="61">
		//                                            " name="nameabaa2004" 
        //											  " name="namec156bc1c"
		
		//By fullnameLocator=By.name("namec01863b3");
		//we observe the property value is dynamically changing 
		// '//'-search on complete webPage
		// '*'-search for the all the tags 
		
		//create the locator for the Xpath locator 
		//*[starts-with(@name,'name')]-Xpath expression created based on dynamic property value
		By fullnameLocator=By.xpath("//*[starts-with(@name,'name')]");
		WebElement fullname=driver.findElement(fullnameLocator);
		fullname.sendKeys("PuliRaju");
		
		//Automating Password 
		//<input type="password" name="passwdc156bc1c"  id="newpassw
		//                       name="passwdb0566651"  
		//  					 name="passwd85652b75"  
		
		// //input[starts-with(@name,'password')]
		By passwordLocator=By.xpath("//input[starts-with(@name,'passwd')]");
		WebElement password=driver.findElement(passwordLocator);
		password.sendKeys("Puli996632@");
		
		Thread.sleep(5000);
		
		//<input type="password"
		//<input type="password" 
		
		//Xpath expression  
		 
		
		
		
		
		


	}

}
