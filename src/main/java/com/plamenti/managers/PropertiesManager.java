package com.plamenti.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

	public static String getPageProperty(String propertyName) {
		Properties config = loadProperties(Constants.PAGES_PROPERTIES_FILE_PATH);
		String property = config.getProperty(propertyName);

		return property.toString();
	}

	public static String getBrowserType() {
		Properties config = loadProperties(Constants.BROWSERS_PROPERTIES_FILE_PATH);
		String defaultBrowser = config.getProperty("default.browser");

		return defaultBrowser.toString();
	}

	private static Properties loadProperties(String url) {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(url));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return properties;
	}
}
