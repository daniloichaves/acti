package br.com.jgle.acti.util;

public class ValidadorUtil {

	public static int CARACTER_HIFEN = 45;
	public static int CARACTER_PONTO = 46;
	public static int CARACTER_UNDESCORE = 95;
	public static int CARACTER_ARROBA = 64;
	public static String CARACTERES_ESPECIAIS = "_.-@";

	public static final boolean validarEmail(String s) {
		boolean flag = false;
		int i = 0;
		String s1 = new String();
		String s2 = new String();
		if (s.indexOf((char) CARACTER_ARROBA) == -1)
			return false;
		if (s.indexOf((char) CARACTER_ARROBA) == 0)
			return false;
		i = s.indexOf((char) CARACTER_ARROBA);
		s1 = s.substring(0, i);
		s2 = s.substring(i + 1, s.length());
		if (_validarUsername(s1))
			flag = _validarDomain(s2);
		return flag;
	}

	private static boolean _isCaractereValido(int i) {
		if (i == CARACTER_ARROBA)
			return false;
		if (i == CARACTER_HIFEN)
			return true;
		if (i == CARACTER_PONTO)
			return true;
		if (i == CARACTER_UNDESCORE)
			return true;
		if (i < 48 || i > 122)
			return false;
		if (i >= 58 && i <= 64)
			return false;
		return i < 91 || i > 96;
	}

	private static boolean _validarDomain(String s) {
		if (!_validar(s))
			return false;
		if (s.indexOf("" + (char) CARACTER_PONTO) == -1 || s.indexOf("" + (char) CARACTER_PONTO) == 0
				|| s.indexOf("" + (char) CARACTER_PONTO) == s.length())
			return false;
		return !s.endsWith("" + (char) CARACTER_ARROBA) && !s.endsWith("" + (char) CARACTER_HIFEN) && !s.endsWith("" + (char) CARACTER_PONTO)
				&& !s.endsWith("" + (char) CARACTER_UNDESCORE);
	}

	private static boolean _validarUsername(String s) {
		return _validar(s);
	}

	private static boolean _validar(String s) {
		int i = 0;
		if (s.indexOf(' ') != -1)
			return false;
		for (; i < s.length(); i++) {
			if (!_isCaractereValido(s.charAt(i)))
				return false;
			if (CARACTERES_ESPECIAIS.indexOf(s.charAt(i)) != -1 && CARACTERES_ESPECIAIS.indexOf(s.charAt(i - 1)) != -1)
				return false;
		}

		return !s.startsWith("" + (char) CARACTER_ARROBA) && !s.startsWith("" + (char) CARACTER_HIFEN) && !s.startsWith("" + (char) CARACTER_PONTO)
				&& !s.startsWith("" + (char) CARACTER_UNDESCORE);
	}

}
