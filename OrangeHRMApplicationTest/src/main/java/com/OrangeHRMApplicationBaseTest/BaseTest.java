package com.OrangeHRMApplicationBaseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

	
	public static WebDriver driver;
	@BeforeMethod
	public void applicationLaunch()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PULI RAJU\\eclipse-workspace\\OrangeHRMApplicationTest\\Webdriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void Applicationclose()
	{
		driver.quit();
	}
}
