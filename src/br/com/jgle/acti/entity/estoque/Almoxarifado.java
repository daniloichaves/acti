package br.com.jgle.acti.entity.estoque;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.jgle.acti.entity.AbstractEntity;
import br.com.jgle.acti.entity.Endereco;
import br.com.jgle.acti.entity.Unidade;

@SuppressWarnings("serial")
@Entity
public class Almoxarifado extends AbstractEntity {

	@Column(length = 15)
	protected String codigo;
	@Column(length = 25)
	protected String nome;
	@Column(length = 50)
	protected String observacao;
	@ManyToOne
	protected Unidade unidade;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	protected Endereco endereco = new Endereco();

	@SuppressWarnings("unchecked")
	public Almoxarifado newInstance() {
		return new Almoxarifado();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("nome", textToSearch(textSearch));

		return params;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
