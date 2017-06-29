package br.com.jgle.acti.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Banco extends AbstractEntity {

	protected Integer numero;
	@Column(length = 100)
	protected String banco;

	@SuppressWarnings("unchecked")
	public Banco newInstance() {
		return new Banco();
	}
	
	public Banco(Integer numero, String banco) {
		super();
		this.numero = numero;
		this.banco = banco;
	}
	

	public Banco() {
		super();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("banco", textToSearch(textSearch));

		return params;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
