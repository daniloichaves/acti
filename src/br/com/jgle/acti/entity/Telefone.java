package br.com.jgle.acti.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Telefone extends AbstractEntity {

	public static String TIPO_CELULAR = "CELULAR";
	public static String TIPO_COMERCIAL = "COMERCIAL";

	@Column(length = 20)
	protected String tipo;
	@Column(length = 2)
	protected String ddd = new String("11");
	@Column(length = 2)
	protected String ddi = new String("55");
	@Column(length = 10)
	protected String numero;
	@Column(length = 10)
	protected String ramal;
	@Column(length = 20)
	protected String contato;

	@SuppressWarnings("unchecked")
	public Telefone newInstance() {
		return new Telefone();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("numero", textToSearch(textSearch));
		params.put("ramal", textToSearch(textSearch));
		params.put("contato", textToSearch(textSearch));

		return params;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
}
