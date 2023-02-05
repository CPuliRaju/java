package com.Assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateOFTSRTC_HeaderBlockLinks {

	public static void main(String[] args) {
		
		
		WebDriver driver;
		String applicationUrlAddress="https://www.tsrtconline.in/oprs-web/";
		System.setProperty("webdriver.chrome.driver", "./Webdriver/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get(applicationUrlAddress);
		
		//Maximize the Browser
		driver.manage().window().maximize();
		
	}

}
