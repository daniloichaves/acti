package br.com.jgle.acti.webservice;

/*
 *@Author 
 * Eduardo Hiroshi Campos Tamaki
 * edhiroshi86@yahoo.com.br
 */

import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

@Service
public class CepService {

	public static Webservicecep getEndereco(String cep) throws Exception {

		JAXBContext jc = JAXBContext.newInstance(Webservicecep.class);

		Unmarshaller u = jc.createUnmarshaller();
		URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
		Webservicecep wCep = null;
		try {
			wCep = (Webservicecep) u.unmarshal(url);
		} catch (Exception e) {
			throw new Exception("Problema na conexão.");
		}

		return wCep;

	}
}
