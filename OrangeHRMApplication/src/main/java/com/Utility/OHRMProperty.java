package com.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class OHRMProperty {

	public static Properties loadproperty() throws IOException {
		
		FileInputStream OHRMApplicationpropertyFile=new FileInputStream("./src/main/java/com/Config/OHRM.properties");
		Properties property =new Properties();
		property.load(OHRMApplicationpropertyFile);
		return property;
		
	}
	
	
}
