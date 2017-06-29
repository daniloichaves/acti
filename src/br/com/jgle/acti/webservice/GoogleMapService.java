package br.com.jgle.acti.webservice;

/**
 *@Author 
 * Danilo Ischiavolini Chave
 * daniloichaves@gmail.com
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import br.com.jgle.acti.entity.Endereco;
import br.com.jgle.acti.util.XmlUtil;
import br.com.jgle.acti.webservice.vo.GoogleMap;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

/**
 * http://maps.google.com/maps/geo?q=av%20lauzane%20paulista,%20116&output=xml&
 * key=
 * ABQIAAAAVaKUxJFygcp4_Y8yeVuZfxSuwPZdYvfOqdJ1NGwchfMMEsbLXRTYWtgax9Rwzrj8hmIACOaXjSSCng
 * 
 * @author Danilo Ischiavolini Chaves
 * 
 */
@Service
public class GoogleMapService {

	/**
	 * view-source:http://maps.google.com/maps/geo?q=av%20lauzane%20paulista,%
	 * 20116&output=csv&key=
	 * ABQIAAAAVaKUxJFygcp4_Y8yeVuZfxSuwPZdYvfOqdJ1NGwchfMMEsbLXRTYWtgax9Rwzrj8hmIACOaXjSSCng
	 * 
	 * @param local
	 * @return
	 */
	public static String findCoordenates(String local) {
		try {

			 System.setProperty("http.proxyHost", "proxy.telesp.com.br");
			 System.setProperty("http.proxyPort", "8080");
			
			 Authenticator.setDefault(new Authenticator() {
			 protected PasswordAuthentication getPasswordAuthentication() {
			 return new PasswordAuthentication("telefonicasp\\e465965",
			 "XmJib#23".toCharArray());
			 }
			 });

			local = local.replaceAll(" ", "%20");

			String urlEnderco = "http://maps.google.com/maps/geo?q="
					+ local
					+ "&output=csv&key=ABQIAAAAVaKUxJFygcp4_Y8yeVuZfxSuwPZdYvfOqdJ1NGwchfMMEsbLXRTYWtgax9Rwzrj8hmIACOaXjSSCng";

			URL url = new URL(urlEnderco);

			HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(urlcon.getInputStream()));

			String line;
			StringBuilder content = new StringBuilder();
			// read from the urlconnection via the bufferedreader
			while ((line = bufferedReader.readLine()) != null) {
				content.append(line + "\n");
			}
			bufferedReader.close();

			String textoCoordenadas = content.toString().substring(6,
					content.toString().length());

			return textoCoordenadas.trim();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";

	}

	public static Endereco findEnderecoGoogleCep(String cep) {
		String cepFormat = "";
		if (cep != null && !cep.contains("-")) {
			StringBuilder sb = new StringBuilder(cep);
			sb.insert(5, '-');

			cepFormat = sb.toString();
		}
		return findEnderecoGoogle(cepFormat);
	}

	public static Endereco findEnderecoGoogle(String local) {
		try {

			// System.setProperty("http.proxyHost", "proxy.telesp.com.br");
			// System.setProperty("http.proxyPort", "8080");
			//
			// Authenticator.setDefault(new Authenticator() {
			// protected PasswordAuthentication getPasswordAuthentication() {
			// return new PasswordAuthentication("telefonicasp\\e380857",
			// "Brasil11".toCharArray());
			// }
			// });

			String spec = "http://maps.google.com/maps/geo?q="
					+ local
					+ "&output=xml&key=ABQIAAAAVaKUxJFygcp4_Y8yeVuZfxSuwPZdYvfOqdJ1NGwchfMMEsbLXRTYWtgax9Rwzrj8hmIACOaXjSSCng";
			// spec = spec.replaceAll(" ", "%20");
			URL url = new URL(spec);
			HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(urlcon.getInputStream()));

			String line;
			StringBuilder content = new StringBuilder();
			// read from the urlconnection via the bufferedreader
			while ((line = bufferedReader.readLine()) != null) {
				content.append(line + "\n");
			}
			bufferedReader.close();
			String conteudo = content.toString();
			System.out.println(conteudo);

			Endereco endereco = new Endereco();

			String cidade = XmlUtil.extractValueFromFirstTagFromXml(conteudo,
					"LocalityName");
			endereco.setCidade(cidade);

			String bairro = XmlUtil.extractValueFromFirstTagFromXml(conteudo,
					"DependentLocalityName");
			endereco.setBairro(bairro);
			String address = XmlUtil.extractValueFromFirstTagFromXml(conteudo,
					"ThoroughfareName");
			endereco.setEndereco(address);

			String cep = XmlUtil.extractValueFromFirstTagFromXml(conteudo,
					"PostalCodeNumber");
			endereco.setCep(cep);

			String coordinates = XmlUtil.extractValueFromFirstTagFromXml(
					conteudo, "coordinates");

			if (coordinates != null && !coordinates.contains("0,0")) {
				String[] coord = coordinates.split(",");

				double lng = new Double(coord[1]);
				endereco.setLnt(lng);
				double lat = new Double(coord[0]);
				endereco.setLat(lat);
			}

			return endereco;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Deprecated
	/**
	 * view-source:http://maps.google.com/maps/geo?q=av%20lauzane%20paulista,%20116&output=xml&key=ABQIAAAAVaKUxJFygcp4_Y8yeVuZfxSuwPZdYvfOqdJ1NGwchfMMEsbLXRTYWtgax9Rwzrj8hmIACOaXjSSCng
	 * 
	 * N'ao esta funcionando
	 */
	public static GoogleMap getEnderecoXML(String endereco) throws Exception {

		JAXBContext jc = JAXBContext.newInstance(GoogleMap.class);

		// System.setProperty("http.proxyHost", "proxy.telesp.com.br");
		// System.setProperty("http.proxyPort", "8080");
		//
		// Authenticator.setDefault(new Authenticator() {
		// protected PasswordAuthentication getPasswordAuthentication() {
		// return new PasswordAuthentication("telefonicasp\\e380857",
		// "Brasil10".toCharArray());
		// }
		// });

		Unmarshaller u = jc.createUnmarshaller();

		URL url = new URL(
				"http://maps.google.com/maps/geo?q="
						+ endereco
						+ "&output=xml&key=ABQIAAAAVaKUxJFygcp4_Y8yeVuZfxSuwPZdYvfOqdJ1NGwchfMMEsbLXRTYWtgax9Rwzrj8hmIACOaXjSSCng");
		GoogleMap googleMap = null;
		try {
			googleMap = (GoogleMap) u.unmarshal(url);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Problema na conexão.");
		}

		return googleMap;

	}

	/**
	 * http://labs.micromata.de/display/jak/Examples
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// String findCoordenates = GoogleMapService
		// .findCoordenates("Av Lauzane Paulista, 116");
		//
		// System.out.println(findCoordenates);

		final Kml kml = new Kml();
		// kml.createAndSetPlacemark().withName("London, UK")
		// .withOpen(Boolean.TRUE).createAndSetPoint()
		// .addToCoordinates(-0.126236, 51.500152);
		// File file = new File("/HelloKml.kml");
		// kml.marshal(file);

		System.setProperty("http.proxyHost", "proxy.telesp.com.br");
		System.setProperty("http.proxyPort", "8080");

		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("telefonicasp\\e380857",
						"Brasil11".toCharArray());
			}
		});

		String spec = "http://maps.google.com/maps/geo?q="
				+ "av lauzane paulista, 116"
				+ "&output=xml&key=ABQIAAAAVaKUxJFygcp4_Y8yeVuZfxSuwPZdYvfOqdJ1NGwchfMMEsbLXRTYWtgax9Rwzrj8hmIACOaXjSSCng";
		spec = spec.replaceAll(" ", "%20");
		URL url = new URL(spec);
		HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();

		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(urlcon.getInputStream()));

		String line;
		StringBuilder content = new StringBuilder();
		// read from the urlconnection via the bufferedreader
		while ((line = bufferedReader.readLine()) != null) {
			content.append(line + "\n");
		}
		bufferedReader.close();

		System.out.println(content);

		System.out.println(url);
		InputStream openStream = url.openStream();
		String conteudo = content.toString();
		Kml unmarshal = kml.unmarshal(conteudo);
		Placemark placemark = (Placemark) kml.getFeature();

		System.out.println(placemark);

		String addresss = XmlUtil.extractValueFromFirstTagFromXml(conteudo,
				"ThoroughfareName");
		System.out.println(addresss);
	}
}
