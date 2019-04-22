package com.company.module.testFramework.helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {

	private static boolean root = false;

	public static Logger getLogger(Class cls) {
		setLog4JPropertiesPath();
		if (root) {
			return Logger.getLogger(cls);
		}
		root = true;
		return Logger.getLogger(cls);
	}

	public static void setLog4JPropertiesPath() {
		PropertyConfigurator.configure("src/test/resources/config/log4j.properties");
	}
}
