package com.WebTable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	WebDriver driver;
	String applicationurladdress="https://www.TimeAndDate.com/worldclock";
	
	public void Applicationlaunch()
	{
		System.setProperty("webdriver.chrome.driver","./Webdriver/chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get(applicationurladdress);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void Applicationclose()
	{
		driver.quit();
	}
	public static void main(String[] args) {
		BaseTest test1=new BaseTest();
		test1.Applicationlaunch();
		test1.Applicationclose();
	}
}
