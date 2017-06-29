package br.com.jgle.acti.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class VeiculoServicoManutencao extends AbstractEntity {

	@Column(length = 10)
	protected String nomeServico;
	@Column(length = 200)
	protected String descricao;
	@Temporal(TemporalType.DATE)
	protected Date dataExecucao = new Date();
	@Temporal(TemporalType.DATE)
	protected Date dataValidade = new Date();
	@Column(length = 50)
	protected String modelo;

	protected BigDecimal valor = BigDecimal.ZERO;

	@SuppressWarnings("unchecked")
	public VeiculoServicoManutencao newInstance() {
		return new VeiculoServicoManutencao();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("nomeServico", textToSearch(textSearch));
		params.put("descricao", textToSearch(textSearch));
		params.put("dataValidade", textToSearch(textSearch));

		return params;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataExecucao() {
		return dataExecucao;
	}

	public void setDataExecucao(Date dataExecucao) {
		this.dataExecucao = dataExecucao;
	}
}
