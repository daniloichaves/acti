package br.com.jgle.acti.webservice.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Thoroughfare {

	private String thoroughfareName;

	public String getThoroughfareName() {
		return thoroughfareName;
	}

	public void setThoroughfareName(String thoroughfareName) {
		this.thoroughfareName = thoroughfareName;
	}

}
