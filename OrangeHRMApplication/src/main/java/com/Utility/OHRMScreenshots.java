package com.Utility;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class OHRMScreenshots {

	
	public static  void TakeScreenShot(WebDriver driver,String imageName) throws IOException {
		
		TakesScreenshot takescreenshot=(TakesScreenshot)driver; 
		File errorScreenShot=takescreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(errorScreenShot,new File("./OHRMApplicationErrorScreenShots/"+imageName+"png"));
			
	}
}

