package br.com.jgle.acti.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.StringTokenizer;

public class StringUtil {

	public static String escrever(String linha, int coluna, int tamanho, String texto) {
		String textoTratado = completarComBranco(texto, tamanho);

		String linhaRespota = inserirTexto(linha, coluna, tamanho, textoTratado);

		return linhaRespota;

	}

	public static String inserirTexto(String linha, int coluna, int tamanho, String texto) {
		if (linha.length() < coluna)
			linha = completarComBranco(linha, coluna + texto.length());

		StringBuilder sb = new StringBuilder(linha);

		System.out.println(sb.length());

		sb.replace(coluna, coluna + tamanho, "");

		sb.insert(coluna - 1, texto);

		return sb.toString();
	}

	public static String completarComBranco(String texto, int tamanho) {
		if (texto != null && tamanho < texto.length())
			return texto.substring(0, tamanho);

		if (texto != null && tamanho > texto.length()) {
			StringBuilder sb = new StringBuilder(texto);
			while (sb.length() < tamanho)
				sb.append(" ");
			return sb.toString();
		}

		return texto;
	}

	public static boolean isSubString(String string, String subString) {
		for (int i = 0; i < string.length(); i++) {
			if (string.regionMatches(i, subString, 0, subString.length())) {
				return true;
			}
		}
		return false;
	}

	public static String readInputStream(InputStream inputStream) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		StringBuilder saida = new StringBuilder();
		String linha = reader.readLine();
		while (linha != null) {
			saida.append(linha);
			saida.append("\n");
			linha = reader.readLine();
		}
		reader.close();
		return saida.toString();
	}

	public static String substring(char charInicial, char charFinal, int offset, String texto) {
		StringBuffer resultado = new StringBuffer();
		boolean achou = false;
		for (int i = offset; i < texto.length(); i++) {
			char c = texto.charAt(i);
			if (c == charInicial && achou == false) {
				achou = true;
			} else {
				if (achou) {
					if (c == charFinal) {
						return resultado.toString();
					} else {
						resultado.append(c);
					}
				}
			}
		}
		return "";
	}

	public static boolean contains(String string, char c) {
		try {
			for (int i = 0; i < string.length(); i++) {
				if (string.charAt(i) == c) {
					return true;
				}
			}
		} catch (Exception ex) {
		}
		return false;
	}

	public static String firstLetterUpperCase(String string) {

		StringBuffer result = new StringBuffer();
		char c = string.charAt(0);
		c = Character.toUpperCase(c);
		result.append(c);
		result.append(string.substring(1, string.length()));

		return result.toString();
	}

	public static String firstLetterLowerCase(String string) {

		StringBuffer result = new StringBuffer();
		char c = string.charAt(0);
		c = Character.toLowerCase(c);
		result.append(c);
		result.append(string.substring(1, string.length()));

		return result.toString();
	}

	public static boolean contains(String string, String subString) {
		boolean ok = false;
		try {
			for (int i = 0; i < string.length(); i++) {
				if (string.charAt(i) == subString.charAt(0)) { // Achou o
					// primeiro
					// caractere,
					// agora é so
					// procurar o
					// resto
					for (int j = 0; j < subString.length(); j++) {
						char cString = string.charAt(i + j);
						char cSubString = subString.charAt(j);
						if (cString == cSubString) {
							ok = true;
						} else {
							ok = false;
							break;
						}
					}
					if (ok == true) {
						return true;
					}
				}
			}
		} catch (Exception ex) {
		}
		return ok;
	}

	public static String unformat(char chr, String pattern, String value) {
		StringBuffer unformatedText = new StringBuffer();
		int tam = pattern.length();
		if (value == null) {
			tam = 0;
		} else if (value.length() < tam) {
			tam = value.length();
		}

		for (int i = 0; i < tam; i++) {
			if (pattern.charAt(i) == chr) {
				unformatedText.append(value.charAt(i));
			}
		}

		return unformatedText.toString();
	}

	public static String format(char chr, String pattern, String value) {
		StringBuffer formatedText = new StringBuffer(pattern);
		// value = unformat(chr,pattern,value);
		int len = value.length();
		int j = 0;
		int i = 0;
		for (; i < formatedText.length(); i++) {
			if (len <= j) {
				break;
			}
			if (formatedText.charAt(i) == chr) {
				formatedText.setCharAt(i, value.charAt(0));

				value = value.substring(1);
				j++;
			}
		}
		if (len <= j) {
			return formatedText.toString().substring(0, i);
		}
		formatedText.append(value);
		return formatedText.toString();
	}

	/**
	 * Formatar um integer para nao apresentar o null
	 * 
	 * @param integer
	 * @return
	 */
	public static String format(Integer integer) {
		if (integer == null) {
			return "0";
		} else {
			return integer.intValue() + "";
		}
	}

	/**
	 * Insira a descrição do método aqui. Data de criação: (27/5/2003 14:03:53)
	 * 
	 * @return java.lang.String
	 * @param pattern
	 *            java.lang.String
	 * @param value
	 *            java.lang.String
	 */
	public static String formatNumber(String pattern, String value) {
		return format('#', pattern, value);
	}

	public static String formatText(String pattern, String value) {
		return format('X', pattern, value);
	}

	/**
	 * Formatar o texto para que todas as palavras da frase comecem com
	 * maiúsculo.
	 * 
	 * @param text
	 *            Frase a ser formatada
	 * @return
	 */
	public static String formatText(String text) {
		StringTokenizer st = new StringTokenizer(text);
		StringBuffer textoFormatado = new StringBuffer();
		while (st.hasMoreTokens()) {
			StringBuffer palavraNova = new StringBuffer();
			String palavra = st.nextToken();
			if (palavra.length() > 2) {
				palavraNova.append(Character.toUpperCase(palavra.charAt(0)));
				for (int i = 1; i < palavra.length(); i++) {
					palavraNova.append(Character.toLowerCase(palavra.charAt(i)));
				}
			} else {
				palavraNova.append(palavra);
			}
			textoFormatado.append(palavraNova + " ");
		}
		return textoFormatado.toString();
	}

	/**
	 * Para abreviar frases.
	 * 
	 * @param text
	 *            o texto inteiro
	 * @param length
	 *            - tamanho máximo do resultado
	 * @param etc
	 *            - caso queira colocar alguma coisa adicional como ...
	 * @return
	 */
	public static String resize(String text, Integer length, String etc) {
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(text);
		while (st.hasMoreTokens()) {
			String nextToken = st.nextToken();
			if (sb.length() + nextToken.length() < length) {
				sb.append(nextToken + " ");
			} else {
				return sb.append(etc).toString();
			}
		}
		return sb.toString();
	}

	public static String truncate(Object text, Integer length, char c) {
		StringBuffer sb = new StringBuffer();
		if (text != null) {
			String textToString = text.toString();
			for (int i = 0; i < textToString.length(); i++) {
				if (i < length) {
					sb.append(textToString.charAt(i));
				}
			}
			while (sb.length() < length) {
				sb.append(c);
			}
		}

		return sb.toString();
	}

	public static String removeAll(String string, String subString) {
		if (contains(string, subString)) {
			boolean ok = false;
			try {
				for (int i = 0; i < string.length(); i++) {
					if (string.charAt(i) == subString.charAt(0)) { // Achou o
						// primeiro
						// caractere
						// , agora é
						// so
						// procurar
						// o resto
						for (int j = 0; j < subString.length(); j++) {
							char cString = string.charAt(i + j);
							char cSubString = subString.charAt(j);
							if (cString == cSubString) {
								ok = true;
							} else {
								ok = false;
								break;
							}
						}
						if (ok == true) {
							String comeco = string.substring(0, i);
							String fim = "";
							try {
								fim = string.substring(i + subString.length(), string.length());
							} catch (Exception e) {
							}
							return comeco + fim;
						}
					}
				}
			} catch (Exception ex) {
			}
		}
		return string;
	}

	public static String removeAll(String string, char c) {
		StringBuffer sb = null;
		int index = string.indexOf(c);
		if (index != -1) {
			sb = new StringBuffer(string.substring(0, index));
			for (int i = index; i < string.length(); i++) {
				char a = string.charAt(i);
				if (a != c) {
					sb.append(a);
				}
			}
			return sb.toString();
		} else {
			return string;
		}
	}

	public static String generateRandomCode(int size) {
		StringBuffer resultado = new StringBuffer();
		for (int i = 0; i < size; i++) {
			if (i % 2 == 0) {
				resultado.append((int) (Math.random() * 9));
			} else {
				resultado.append((char) ('A' + (char) (Math.random() * 9)));
			}
		}
		return resultado.toString();
	}

	public static String generateRandomCode(int numberSize, Integer letterSize) {
		StringBuffer resultado = new StringBuffer();
		for (int i = 0; i < numberSize; i++) {
			resultado.append((int) (Math.random() * 9));
		}
		for (int i = 0; i < letterSize; i++) {
			resultado.append((char) ('A' + (char) (Math.random() * 23)));
		}
		return resultado.toString();
	}

	public static String valueOf(byte[] b) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			sb.append((char) b[i]);
		}
		return sb.toString();
	}

	/**
	 * Retorna o valor imprimivél do objeto arg, e String "" quando null
	 * 
	 * @param Object
	 *            arg
	 * @return String
	 * @author rubens
	 */
	public static String getPrintString(Object arg) {
		return (arg == null ? "" : arg.toString());
	}

	/**
	 * Substitui dodas as ocorrências de "substituir" por "substituto" em "val"
	 * 
	 * @param String
	 *            val, String substituir, String substituto
	 * @return String
	 * @author rubens
	 */
	public static String replaceAll(String val, String substituir, String substituto) {
		StringBuffer resultado = new StringBuffer();
		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			if (c == substituir.charAt(0)) {
				boolean ehIgual = false;
				for (int j = 0; j < substituir.length(); j++) {
					if (val.charAt(j + i) == substituir.charAt(j)) {
						ehIgual = true;
					} else {
						ehIgual = false;
						break;
					}
				}
				if (ehIgual) {
					i += substituir.length() - 1;
					resultado.append(substituto);
				} else {
					resultado.append(c);
				}
			} else {
				resultado.append(c);
			}
		}
		return resultado.toString();
	}

	/**
	 * Substitui a ultima ocorrência de "substituir" por "substituto" em "val"
	 * 
	 * @param String
	 *            val, String substituir, String substituto
	 * @return String
	 * @author rubens
	 */
	public static String replaceLast(String val, String substituir, String substituto) {

		StringBuffer resultado = new StringBuffer();

		// Pesquisar todas as ocorrencias de substituir em val
		int lastIndex = -1;
		if (val != null) {
			for (int i = 0; i < val.length(); i++) {
				int index = val.indexOf(substituir, i);
				if (index != -1) {
					lastIndex = index;
				}
			}
		}

		if (lastIndex != -1) {
			for (int i = 0; i < lastIndex; i++) {
				resultado.append(val.charAt(i));
			}
			for (int i = lastIndex; i < val.length(); i++) {
				char c = val.charAt(i);
				if (c == substituir.charAt(0)) {
					boolean ehIgual = false;
					for (int j = 0; j < substituir.length(); j++) {
						if (val.charAt(j + i) == substituir.charAt(j)) {
							ehIgual = true;
						} else {
							ehIgual = false;
							break;
						}
					}
					if (ehIgual) {
						i += substituir.length() - 1;
						resultado.append(substituto);
					} else {
						resultado.append(c);
					}
				} else {
					resultado.append(c);
				}
			}
			return resultado.toString();
		} else {
			return val;
		}
	}

	public static Integer toInt(String value) {
		try {
			if (value != null && !value.trim().equals("")) {
				return Integer.parseInt(value);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	public static String encodeForUrl(String img) throws UnsupportedEncodingException {
		StringBuffer url = new StringBuffer();
		String[] values = img.split("[/]");
		for (int i = 0; i < values.length; i++) {
			if (i > 2) {
				url.append(URLEncoder.encode(values[i], "LATIN1"));
			} else {
				url.append(values[i]);
			}
			if (i < values.length - 1) {
				url.append("/");
			}
		}

		img = StringUtil.replaceAll(url.toString(), "+", "%20");
		return img;
	}

	public static String replace(String str, char[] entrada, char[] saida) {
		StringBuffer buffer = new StringBuffer();
		if (str != null) {
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				for (int j = 0; j < entrada.length; j++) {
					if (c == entrada[j]) {
						c = saida[j];
						break;
					}
				}
				buffer.append(c);
			}
		}
		return buffer.toString();
	}

	public static String replaceKeys(String text, Map<String, String> valores) {
		StringBuilder builder = new StringBuilder(text);
		if (valores != null) {
			for (String chave : valores.keySet()) {
				int index = builder.indexOf(chave);
				if (index != -1) {
					builder.replace(index, index + chave.length(), valores.get(chave));
				}
			}
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		// System.out.println(replaceAll("O sdkjcnsdc ${key} ksjdnc skd${key}jc",
		// "${key}","123123"));
		// String stringAtual = "O sdkjcnsdc ksjdnc skd${key}jc";
		// System.out.println(stringAtual);
		// System.out.println(removeAll(stringAtual,'k'));

		// Produto produto = new Produto();
		// produto.setCodigo("sakjcnaskjc");
		// produto.setDescricao("descricao");
		// produto.setDetalhes("asdasdasdasdas");
		// produto.setEstoqueQuantidade1(10);
		// produto.setEstoqueQuantidade2(12);
		// produto.setId(100);
		// produto.setPesoKg(10.7);
		// produto.setPreco(12.78);
		// System.out.println(toTokenStringObject(produto,'|'));

		String teste = "517-boloqueijocoalho1.jpg.eps";
		teste = replaceLast(teste, ".eps", ".jpg");
		teste = replaceLast(teste, ".jpg", " copy.jpg");
		System.out.println(teste);
	}
}