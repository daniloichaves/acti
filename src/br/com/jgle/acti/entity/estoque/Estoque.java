package br.com.jgle.acti.entity.estoque;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.jgle.acti.entity.AbstractEntity;
import br.com.jgle.acti.entity.ClienteFornecedor;
import br.com.jgle.acti.entity.Funcionario;
import br.com.jgle.acti.entity.Unidade;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO", discriminatorType = DiscriminatorType.STRING, length = 20)
public abstract class Estoque extends AbstractEntity {

	@ManyToOne
	private Unidade unidade;

	@ManyToOne
	private Almoxarifado almoxarifado;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	protected Set<EstoqueItem> estoqueItems = new HashSet<EstoqueItem>();

	@ManyToOne
	protected Funcionario solicitante;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataEntrega;

	@Column(length = 200)
	protected String observacao;

	@Column(length = 200)
	protected String numeroNotaFical;

	@ManyToOne
	protected ClienteFornecedor fornecedor;

	@Column(length = 30)
	protected String situacao;

	// Dados para saida
	protected BigDecimal valorFrete = BigDecimal.ZERO;
	protected BigDecimal ICMS = BigDecimal.ZERO;
	protected BigDecimal totalIPI = BigDecimal.ZERO;

	// @SuppressWarnings("unchecked")
	// public Estoque newInstance() {
	// return new Estoque();
	// }

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("codigo", textToSearch(textSearch));
		params.put("descricao", textToSearch(textSearch));
		params.put("referencia", textToSearch(textSearch));

		return params;
	}

	@Transient
	public Double getValorTotal() {
		double total = 0d;
		for (EstoqueItem estoqueItem : estoqueItems) {
			total += estoqueItem.getValorTotalBruto().doubleValue();
		}
		return total;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Collection getList(AbstractEntity name) {
		if (name instanceof EstoqueItem) {
			return getEstoqueItems();
		}
		throw new NullPointerException();
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}

	public Set<EstoqueItem> getEstoqueItems() {
		return estoqueItems;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
	}

	public void setEstoqueItems(Set<EstoqueItem> estoqueItems) {
		this.estoqueItems = estoqueItems;
	}

	public Funcionario getSolicitante() {
		return solicitante;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setSolicitante(Funcionario solicitante) {
		this.solicitante = solicitante;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getNumeroNotaFical() {
		return numeroNotaFical;
	}

	public ClienteFornecedor getFornecedor() {
		return fornecedor;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setNumeroNotaFical(String numeroNotaFical) {
		this.numeroNotaFical = numeroNotaFical;
	}

	public void setFornecedor(ClienteFornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getValorFrete() {
		return valorFrete;
	}

	public BigDecimal getICMS() {
		return ICMS;
	}

	public BigDecimal getTotalIPI() {
		return totalIPI;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	public void setICMS(BigDecimal iCMS) {
		ICMS = iCMS;
	}

	public void setTotalIPI(BigDecimal totalIPI) {
		this.totalIPI = totalIPI;
	}
}
