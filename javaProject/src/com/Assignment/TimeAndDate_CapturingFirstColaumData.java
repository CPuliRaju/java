package com.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TimeAndDate_CapturingFirstColaumData {

	WebDriver driver;
	String applicationurladdress="https://www.TimeAndDate.com/worldclock/";
	
	public void applicationlaunch()
	{
		System.setProperty("webdriver.chrome.driver", "./Webdriver/chromedriver.exe");
		
		driver =new ChromeDriver();
		driver.get(applicationurladdress);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void GetFirstRowOfAllCellValue()
	{
		/*
		Expresion of the xpath -absolute
		/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
		
		locator -xpath 
		selector-/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[1]
	*/
		for(int index=1;index<=36;index++)
		{
			By webElementCityNameLocator=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+index+"]/td[1]");
			WebElement CityName=driver.findElement(webElementCityNameLocator);
			String CityNameText=CityName.getText();
			System.out.println(CityNameText);
		}
	}
	public void applicationclose()
	{
		driver.quit();
	}
	public static void main(String[] args) {
		
		TimeAndDate_CapturingFirstColaumData getDate=new TimeAndDate_CapturingFirstColaumData();
		getDate.applicationlaunch();
		getDate.GetFirstRowOfAllCellValue();
		getDate.applicationclose();
	}
}
