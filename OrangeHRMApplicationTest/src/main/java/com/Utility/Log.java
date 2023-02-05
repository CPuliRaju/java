package com.Utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {

	
public static Logger log=Logger.getLogger("log");
	
	public static void info(String message) {
		
		PropertyConfigurator.configure("C:\\Users\\PULI RAJU\\eclipse-workspace\\OrangeHRMApplicationTest\\Log4j.properties");
		log.info(message);
    }
}

