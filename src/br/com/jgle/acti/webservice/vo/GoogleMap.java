package br.com.jgle.acti.webservice.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GoogleMap {

	private String name;
	private Status status;
	private Placemark placemark;
	private String cidade;
	private String bairro;
	private String tipo_logradouro;
	private String logradouro;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Placemark getPlacemark() {
		return placemark;
	}

	public void setPlacemark(Placemark placemark) {
		this.placemark = placemark;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTipo_logradouro() {
		return tipo_logradouro;
	}

	public void setTipo_logradouro(String tipo_logradouro) {
		this.tipo_logradouro = tipo_logradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

}
