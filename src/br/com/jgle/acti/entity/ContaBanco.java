package br.com.jgle.acti.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class ContaBanco extends AbstractEntity {

	@Column(length = 15)
	protected String tipo;
	@ManyToOne(fetch = FetchType.EAGER)
	protected Banco banco;
	// @Column(length = 30)
	// protected String banco;
	@Column
	protected Integer agencia;
	@Column
	protected String agenciaDigito;
	@Column(length = 15)
	protected Integer conta;
	@Column
	protected String contaDigito;
	@Column(length = 35)
	protected String depto;
	@Column(length = 50)
	protected String contato;
	@Column(length = 150)
	protected String observacao;
	@Column(length = 15)
	protected String tipoPessoa;
	@Column(length = 15)
	protected String cnpjcpf;

	@SuppressWarnings("unchecked")
	public ContaBanco newInstance() {
		return new ContaBanco();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("tipo", textToSearch(textSearch));
		params.put("banco", textToSearch(textSearch));
		params.put("agencia", textToSearch(textSearch));
		params.put("observacao", textToSearch(textSearch));

		return params;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCnpjcpf() {
		return cnpjcpf;
	}

	public void setCnpjcpf(String cnpjcpf) {
		this.cnpjcpf = cnpjcpf;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public String getAgenciaDigito() {
		if (agenciaDigito == null || "".equals(agenciaDigito))
			return "0";
		return agenciaDigito;
	}

	public void setAgenciaDigito(String agenciaDigito) {
		this.agenciaDigito = agenciaDigito;
	}

	public String getContaDigito() {
		if (contaDigito == null || "".equals(contaDigito))
			return "0";
		return contaDigito;
	}

	public void setContaDigito(String contaDigito) {
		this.contaDigito = contaDigito;
	}
}
