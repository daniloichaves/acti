package br.com.jgle.acti.entity.estoque;

import java.math.BigDecimal;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.jgle.acti.entity.AbstractEntity;

@SuppressWarnings("serial")
@Entity
public class EstoqueItem extends AbstractEntity {

	@ManyToOne
	protected Produto produto;

	protected BigDecimal valorUnitario = BigDecimal.ZERO;
	protected Integer quantidade = 0;
	protected BigDecimal valorTotal = BigDecimal.ZERO;
	protected BigDecimal ipi = BigDecimal.ZERO;
	protected BigDecimal desconto = BigDecimal.ZERO;
	protected BigDecimal valorTotalBruto = BigDecimal.ZERO;

	@SuppressWarnings("unchecked")
	public EstoqueItem newInstance() {
		return new EstoqueItem();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("codigo", textToSearch(textSearch));
		params.put("descricao", textToSearch(textSearch));
		params.put("referencia", textToSearch(textSearch));

		return params;
	}

	public BigDecimal calcularValorTotalBruto() {
		BigDecimal multiply = calcularValorTotal();
		BigDecimal add = multiply.add(desconto);

		return add;
	}

	public BigDecimal calcularValorTotal() {
		BigDecimal multiply = valorUnitario.multiply(new BigDecimal(quantidade));

		return multiply;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public BigDecimal getIpi() {
		return ipi;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public BigDecimal getValorTotalBruto() {
		return valorTotalBruto;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setIpi(BigDecimal ipi) {
		this.ipi = ipi;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public void setValorTotalBruto(BigDecimal valorTotalBruto) {
		this.valorTotalBruto = valorTotalBruto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
