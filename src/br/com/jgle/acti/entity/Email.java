package br.com.jgle.acti.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Email extends AbstractEntity {

	@Column(length = 15)
	protected String tipo;
	@Column(length = 50)
	protected String email;
	@Column(length = 150)
	protected String observacao;

	@SuppressWarnings("unchecked")
	public Email newInstance() {
		return new Email();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("tipo", textToSearch(textSearch));
		params.put("email", textToSearch(textSearch));
		params.put("observacao", textToSearch(textSearch));

		return params;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
