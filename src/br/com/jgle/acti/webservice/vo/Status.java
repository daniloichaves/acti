package br.com.jgle.acti.webservice.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Status {

	private String code;
	private String request;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

}
