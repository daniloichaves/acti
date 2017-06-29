package br.com.jgle.acti.entity.estoque;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.jgle.acti.entity.AbstractEntity;

@SuppressWarnings("serial")
@Entity
public class Produto extends AbstractEntity {

	@ManyToOne
	protected Almoxarifado almoxarifado;
	@Column(length = 20)
	protected String codigo;
	@Column(length = 50)
	protected String descricao;
	@Column(length = 30)
	protected String referencia;
	@Column(length = 40)
	protected String codigoBarra;
	@Column(length = 10)
	protected String unidadeMedida;
	@ManyToOne
	protected Grupo grupo;
	@Column(length = 20)
	protected String tipo;
	@Column(length = 25)
	protected String modelo;
	@Column(length = 30)
	protected String marca;
	protected Double valor;

	// Para gerenciamento do estoque
	protected Integer qtdEstoque;

	@SuppressWarnings("unchecked")
	public Produto newInstance() {
		return new Produto();
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

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
}
