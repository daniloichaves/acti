package br.com.jgle.teste.main;

import br.com.jgle.acti.util.PropertiesUtil;

public class PropertiesTest {

	public static void main(String[] args) {
		String propertyValue = PropertiesUtil.getPropertyValue("teste");

		System.out.println("resultado: " + propertyValue);
	}
}
