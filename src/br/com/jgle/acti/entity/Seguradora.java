package br.com.jgle.acti.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Seguradora extends AbstractEntity {

	@Column(length = 50)
	protected String agenciaSeguradora;
	@Column(length = 50)
	protected String numeroApolice;
	@Column(length = 50)
	protected String numeroAverbacao;
	@Column(length = 50)
	protected String atendente;
	@Column(length = 50)
	protected String liberacao;

	@SuppressWarnings("unchecked")
	public Seguradora newInstance() {
		return new Seguradora();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("porto", textToSearch(textSearch));
		params.put("navio", textToSearch(textSearch));
		params.put("armazem", textToSearch(textSearch));
		params.put("tipo", textToSearch(textSearch));
		params.put("despachanteAgencia", textToSearch(textSearch));

		return params;
	}

	public String getAgenciaSeguradora() {
		return agenciaSeguradora;
	}

	public void setAgenciaSeguradora(String agenciaSeguradora) {
		this.agenciaSeguradora = agenciaSeguradora;
	}

	public String getNumeroApolice() {
		return numeroApolice;
	}

	public void setNumeroApolice(String numeroApolice) {
		this.numeroApolice = numeroApolice;
	}

	public String getNumeroAverbacao() {
		return numeroAverbacao;
	}

	public void setNumeroAverbacao(String numeroAverbacao) {
		this.numeroAverbacao = numeroAverbacao;
	}

	public String getAtendente() {
		return atendente;
	}

	public void setAtendente(String atendente) {
		this.atendente = atendente;
	}

	public String getLiberacao() {
		return liberacao;
	}

	public void setLiberacao(String liberacao) {
		this.liberacao = liberacao;
	}
}
