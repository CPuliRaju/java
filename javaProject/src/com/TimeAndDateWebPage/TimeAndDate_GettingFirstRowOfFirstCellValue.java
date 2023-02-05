package com.TimeAndDateWebPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TimeAndDate_GettingFirstRowOfFirstCellValue {

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
	public void getfirstrowoffirstcellvalue()
	{
	/*
		Expresion of the xpath -absolute
		html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
		
		locator -xpath 
		selector-/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
	*/
		By webtablecityNameLocator=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]");
		WebElement cityNameElement=driver.findElement(webtablecityNameLocator);
		
		String cityName=cityNameElement.getText();
		System.out.println(cityName);
	}
	public void applicationclose()
	{
		driver.quit();
	}
	public static void main(String[] args) {
		
		TimeAndDate_GettingFirstRowOfFirstCellValue getDate=new TimeAndDate_GettingFirstRowOfFirstCellValue();
		getDate.applicationlaunch();
		getDate.getfirstrowoffirstcellvalue();
		getDate.applicationclose();
	}
}
