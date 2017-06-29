package br.com.jgle.acti.util;

import java.math.BigDecimal;

import org.nfunk.jep.JEP;

public class MathUtil {
	public static BigDecimal getBigDecimalExpression(String valor) {
		try {
			JEP jep = new JEP();
			jep.parseExpression(valor);
			double value = jep.getValue();

			return new BigDecimal(value);

		} catch (Exception e) {
			return BigDecimal.ZERO;
		}
	}
}
