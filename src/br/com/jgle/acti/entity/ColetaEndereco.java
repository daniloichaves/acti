package br.com.jgle.acti.entity;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class ColetaEndereco extends Endereco {

	public static String TIPO_REMENTE = "REMETENTE";
	public static String TIPO_DESTINATARIO = "DESTINATARIO";

	@Column(length = 50)
	protected String nomeRazaoSocial;
	@Column(length = 15)
	protected String cpfCnpj;
	@Column(length = 10)
	protected String guia;
	@Column(length = 50)
	protected String contato;
	@Column(length = 15)
	protected String telefone;
	@Column(length = 10)
	protected String ramal;
	@Column(length = 35)
	protected String email;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "destinatario")
	protected Set<Coleta> destinatarios = new HashSet<Coleta>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "remetente")
	protected Set<Coleta> remetentes = new HashSet<Coleta>();

	public ColetaEndereco newInstance() {
		return new ColetaEndereco();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

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

	public Set<Coleta> getDestinatarios() {
		return destinatarios;
	}

	public void setDestinatarios(Set<Coleta> destinatarios) {
		this.destinatarios = destinatarios;
	}

	public Set<Coleta> getRemetentes() {
		return remetentes;
	}

	public void setRemetentes(Set<Coleta> remetentes) {
		this.remetentes = remetentes;
	}

	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}

	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getGuia() {
		return guia;
	}

	public void setGuia(String guia) {
		this.guia = guia;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
