package br.com.jgle.acti.util;

import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtil {

	private static final String CONFIG_FILE_LOCATION = "/acti.cfg.properties";
	protected static Logger log = Logger.getLogger(PropertiesUtil.class);

	private static final Properties propertiesFile = new Properties();

	static {
		try {
			propertiesFile.load(ArquivoUtil.getResourceAsStream(CONFIG_FILE_LOCATION));
		} catch (Exception ex) {
			throw new RuntimeException(CONFIG_FILE_LOCATION + " properties file not found.");
		}
	}

	public static String getPropertyValue(String propertyKey) {
		return propertiesFile.getProperty(propertyKey);
	}

	public static String getPropertyValue(String propertyFile, String propertyKey) {
		Properties propertiesFile = new Properties();
		try {
			propertiesFile.load(ArquivoUtil.getResourceAsStream(propertyFile));
		} catch (Exception ex) {
			throw new RuntimeException(propertyFile + " properties file not found.");
		}
		return propertiesFile.getProperty(propertyKey);
	}

}
