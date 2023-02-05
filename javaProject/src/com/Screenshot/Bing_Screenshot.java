package com.Screenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bing_Screenshot {

	public static void main(String[] args) throws IOException {
	
        WebDriver driver;		
		String applicationUrlAddress="http://bing.com";
		
		System.setProperty("webdriver.chrome.driver", "./WebDriver/chromedriver.exe");		
		driver= new ChromeDriver();
		
		driver.get(applicationUrlAddress);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//TakesScreenshot - is an interface in Selenium WebDriver
		//OutputType - is an interface in Selenium WebDriver
		                                    //Type Casting
		File bingHomepageScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(bingHomepageScreenshot, new File("./ScreenShot/bing.png"));


	}

}
