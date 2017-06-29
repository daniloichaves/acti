package br.com.jgle.acti.entity.estoque;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.jgle.acti.entity.AbstractEntity;
import br.com.jgle.acti.entity.ClienteFornecedor;

@SuppressWarnings("serial")
@Entity
public class Pneu extends AbstractEntity {

	protected String aquisicao;
	protected String tamanho;
	protected String marca;
	protected String referencia;
	protected Integer vidaUtil;
	protected String numSerieFabricante;
	protected String modelo;
	protected Integer hodometro;

	@ManyToOne
	protected ClienteFornecedor fornecedor;
	protected Integer quantidade = 0;
	protected Double valorUnitario = new Double(0);
	protected Double desconto = new Double(0);
	protected Double valorTotal = new Double(0);

	protected String situacao;

	@SuppressWarnings("unchecked")
	public Pneu newInstance() {
		return new Pneu();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("aquisicao", textToSearch(textSearch));
		params.put("marca", textToSearch(textSearch));
		params.put("modelo", textToSearch(textSearch));

		return params;
	}
	
	public Map<String, String> getParametrosAdvancedSearch() {
		Map<String, String> params = (Map<String, String>) super
				.getParametrosAdvancedSearch();

		params.put("aquisicao", "Aquisição");
		params.put("marca", "Marca");
		params.put("modelo", "Modelo");

		return params;
	}

	public String getAquisicao() {
		return aquisicao;
	}

	public void setAquisicao(String aquisicao) {
		this.aquisicao = aquisicao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getNumSerieFabricante() {
		return numSerieFabricante;
	}

	public void setNumSerieFabricante(String numSerieFabricante) {
		this.numSerieFabricante = numSerieFabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getHodometro() {
		return hodometro;
	}

	public void setHodometro(Integer hodometro) {
		this.hodometro = hodometro;
	}

	public ClienteFornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(ClienteFornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Integer getVidaUtil() {
		return vidaUtil;
	}

	public void setVidaUtil(Integer vidaUtil) {
		this.vidaUtil = vidaUtil;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
}
