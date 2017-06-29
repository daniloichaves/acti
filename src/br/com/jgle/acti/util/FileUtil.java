package br.com.jgle.acti.util;

import java.util.Properties;

public class FileUtil {
	private static final Properties propertiesFile = new Properties();

	static {
		try {
			propertiesFile.load(FileUtil.class.getResourceAsStream("/meioemensagem.properties"));
		} catch (Exception ex) {
			throw new RuntimeException("meioemensagem.properties properties file not found.");
		}
	}

	public static String getPropertyValue(String propertyKey) {
		return propertiesFile.getProperty(propertyKey);
	}
	
	public static String getPropertyValue(String propertyFile, String propertyKey) {
		Properties propertiesFile = new Properties();
		try {
			propertiesFile.load(FileUtil.class.getResourceAsStream(propertyFile));
		} catch (Exception ex) {
			throw new RuntimeException(propertyFile + " properties file not found.");
		}
		return propertiesFile.getProperty(propertyKey);
	}
}
