package br.com.jgle.teste;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TesteGoogle {
	public static void main2(String[] args) {
		int par = 0;
		int sete = 0;

		for (int i = 1483; i <= 3697; i++) {
			if (i % 2 == 0) {
				par++;
			}
			if (i % 7 == 0) {
				sete++;
			}
		}
		System.out.println(par);
		System.out.println(sete);
	}

	public static void main3(String[] args) {
		int fofinho = 0;
		int sete = 0;

		for (Integer i = 15389; i <= 29089; i++) {
			String numero = new String(i.toString());
			if (numero.contains("4") && !numero.contains("9")) {
				fofinho++;
			}
		}
		System.out.println(fofinho);
		System.out.println(sete);
	}

	public static void main(String[] args) throws IOException {
		File file = new File("c:\\texto.txt");
		String line = "";
		BufferedReader bf = new BufferedReader(new FileReader(file));
		int soma = 0;
		char anterior = '\0';

		while (bf.ready()) {
			line = bf.readLine();
			soma = 0;
			anterior = '\0';
			if (line.charAt(0) != line.charAt(line.length() - 1)) {
				for (char caracter : line.toCharArray()) {
					soma += new Integer(caracter);

					if (anterior == '\0')
						anterior = caracter;
					else if (anterior == caracter) {
						soma = 1;
						break;
					}
				}

				if (soma % 2 == 0)
					System.out.println(line + ", ");
			}
		}
	}
}
