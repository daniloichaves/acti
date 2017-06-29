package br.com.jgle.acti.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@SuppressWarnings("serial")
@Entity
public class NotaFiscal extends AbstractEntity {

	protected BigDecimal peso = BigDecimal.ZERO;
	protected BigDecimal pesoAfe = BigDecimal.ZERO;
	@Column(length = 25)
	protected String cubagem;
	@Column(length = 25)
	protected String numeroNotaFical;
	@Column(length = 25)
	protected String serie;
	@Column(length = 30)
	protected String tipoProduto;

	protected Double valor;

	protected Integer volume;
	@Column(length = 25)
	protected String natureza;
	@Column(length = 25)
	protected String especie;
	@Column(length = 25)
	protected String codigo;
	@Column(length = 25)
	protected String etiquetaMarca;
	@Column(length = 25)
	protected String numeros; // não encontrado proposito
	@Column(length = 25)
	protected String modeloNotaFiscal;
	@Column(length = 10)
	protected String unidadeMedida;
	@Column(length = 150)
	protected String observacao;

	@ManyToMany(fetch = FetchType.EAGER)
	protected Set<NotaFiscalItem> notaFiscalItems = new HashSet<NotaFiscalItem>();

	@SuppressWarnings("unchecked")
	public NotaFiscal newInstance() {
		return new NotaFiscal();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("numero", textToSearch(textSearch));
		params.put("peso", textToSearch(textSearch));

		return params;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Set<NotaFiscalItem> getNotaFiscalItems() {
		return notaFiscalItems;
	}

	public void setNotaFiscalItems(Set<NotaFiscalItem> notaFiscalItems) {
		this.notaFiscalItems = notaFiscalItems;
	}

	public BigDecimal getPesoAfe() {
		return pesoAfe;
	}

	public String getCubagem() {
		return cubagem;
	}

	public String getNumeroNotaFical() {
		return numeroNotaFical;
	}

	public String getSerie() {
		return serie;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public String getNatureza() {
		return natureza;
	}

	public String getEspecie() {
		return especie;
	}

	public String getEtiquetaMarca() {
		return etiquetaMarca;
	}

	public String getNumeros() {
		return numeros;
	}

	public String getModeloNotaFiscal() {
		return modeloNotaFiscal;
	}

	public void setPesoAfe(BigDecimal pesoAfe) {
		this.pesoAfe = pesoAfe;
	}

	public void setCubagem(String cubagem) {
		this.cubagem = cubagem;
	}

	public void setNumeroNotaFical(String numeroNotaFical) {
		this.numeroNotaFical = numeroNotaFical;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public void setEtiquetaMarca(String etiquetaMarca) {
		this.etiquetaMarca = etiquetaMarca;
	}

	public void setNumeros(String numeros) {
		this.numeros = numeros;
	}

	public void setModeloNotaFiscal(String modeloNotaFiscal) {
		this.modeloNotaFiscal = modeloNotaFiscal;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
}
