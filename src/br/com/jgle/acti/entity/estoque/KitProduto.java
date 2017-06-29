package br.com.jgle.acti.entity.estoque;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.com.jgle.acti.entity.AbstractEntity;
import br.com.jgle.acti.entity.Unidade;

@SuppressWarnings("serial")
@Entity
public class KitProduto extends AbstractEntity {

	@Column(length = 50)
	protected String codigo;
	@Column(length = 100)
	protected String descricao;
	@Column(length = 150)
	protected String referencia;
	@ManyToOne
	private Unidade unidade;
	@ManyToOne
	protected Almoxarifado almoxarifado;
	@ManyToMany(fetch = FetchType.EAGER)
	protected Set<Produto> produtos = new HashSet<Produto>();

	@SuppressWarnings("unchecked")
	public KitProduto newInstance() {
		return new KitProduto();
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
}
