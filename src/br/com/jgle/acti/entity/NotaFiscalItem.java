package br.com.jgle.acti.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class NotaFiscalItem extends AbstractEntity {

	@ManyToOne
	protected NotaFiscal notaFiscal;

	@Column(length = 20)
	protected String volume;
	@Column(length = 10)
	protected String unidadeMedida;
	@Column(length = 15)
	protected String especie;
	@Column(length = 25)
	protected String codigo; // numero
	@Column(length = 15)
	protected String peso;
	protected Double valor;
	@Column(length = 10)
	protected String narureza;

	@Column(length = 15)
	protected String pesoAfe;
	@Column(length = 15)
	protected String cubagem;
	@Column(length = 15)
	protected String comprimeto;
	@Column(length = 10)
	protected String largura;
	@Column(length = 10)
	protected String altura;

	@Column(length = 200)
	protected String observacao;

	@SuppressWarnings("unchecked")
	public NotaFiscalItem newInstance() {
		return new NotaFiscalItem();
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

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public String getPesoAfe() {
		return pesoAfe;
	}

	public String getCubagem() {
		return cubagem;
	}

	public String getNarureza() {
		return narureza;
	}

	public String getEspecie() {
		return especie;
	}

	public String getComprimeto() {
		return comprimeto;
	}

	public String getLargura() {
		return largura;
	}

	public String getAltura() {
		return altura;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public void setPesoAfe(String pesoAfe) {
		this.pesoAfe = pesoAfe;
	}

	public void setCubagem(String cubagem) {
		this.cubagem = cubagem;
	}

	public void setNarureza(String narureza) {
		this.narureza = narureza;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public void setComprimeto(String comprimeto) {
		this.comprimeto = comprimeto;
	}

	public void setLargura(String largura) {
		this.largura = largura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getNumero() {
		return codigo;
	}

	public void setNumero(String numero) {
		this.codigo = numero;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

}
