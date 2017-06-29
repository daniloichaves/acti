package br.com.jgle.acti.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Rota extends AbstractEntity {

	@Column(length = 20)
	private String origemCidade;
	@Column(length = 3)
	private String origemUF;

	@Column(length = 20)
	private String destinoCidade;
	@Column(length = 3)
	private String destinoUF;

	private Double porcDescMax;
	private Double distancia;
	private Integer diasLimite;
	private Integer diasPrev;
	private Double porcSeguroNF;
	private Double valorTaxaBoleto;

	private Double valorFixo;
	private Double valorFrete;
	private Double valorKm;
	private Double valorPegadio;
	private Double valorFreteMinimo;
	private Double valorCTRC;
	private Double porcAdval;
	private Double porcGris;
	private Double valorColeta;
	private Integer valorAteKm;
	private Double valorAdicKg;
	private Double valorUnidade;

	@ManyToOne
	private Unidade unidade;

	@SuppressWarnings("unchecked")
	public Rota newInstance() {
		return new Rota();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("origemCidade", textToSearch(textSearch));
		params.put("origemUF", textToSearch(textSearch));
		params.put("destinoCidade", textToSearch(textSearch));
		params.put("destinoUF", textToSearch(textSearch));

		return params;
	}

	public Map<String, String> getParametrosAdvancedSearch() {
		Map<String, String> params = (Map<String, String>) super
				.getParametrosAdvancedSearch();

		params.put("origemCidade", "Origem Cidade");
		params.put("origemUF", "Origem UF");

		params.put("destinoCidade", "Destino Cidade");
		params.put("destinoUF", "Destino UF");

		return params;
	}

	public String getOrigemCidade() {
		return origemCidade;
	}

	public void setOrigemCidade(String origemCidade) {
		this.origemCidade = origemCidade;
	}

	public String getOrigemUF() {
		return origemUF;
	}

	public void setOrigemUF(String origemUF) {
		this.origemUF = origemUF;
	}

	public String getDestinoCidade() {
		return destinoCidade;
	}

	public void setDestinoCidade(String destinoCidade) {
		this.destinoCidade = destinoCidade;
	}

	public String getDestinoUF() {
		return destinoUF;
	}

	public void setDestinoUF(String destinoUF) {
		this.destinoUF = destinoUF;
	}

	public Double getValorFixo() {
		return valorFixo;
	}

	public void setValorFixo(Double valorFixo) {
		this.valorFixo = valorFixo;
	}

	public Double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public Double getValorPegadio() {
		return valorPegadio;
	}

	public void setValorPegadio(Double valorPegadio) {
		this.valorPegadio = valorPegadio;
	}

	public Double getValorUnidade() {
		return valorUnidade;
	}

	public void setValorUnidade(Double valorUnidade) {
		this.valorUnidade = valorUnidade;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Double getPorcDescMax() {
		return porcDescMax;
	}

	public void setPorcDescMax(Double porcDescMax) {
		this.porcDescMax = porcDescMax;
	}

	public Integer getDiasLimite() {
		return diasLimite;
	}

	public void setDiasLimite(Integer diasLimite) {
		this.diasLimite = diasLimite;
	}

	public Integer getDiasPrev() {
		return diasPrev;
	}

	public void setDiasPrev(Integer diasPrev) {
		this.diasPrev = diasPrev;
	}

	public Double getPorcSeguroNF() {
		return porcSeguroNF;
	}

	public void setPorcSeguroNF(Double porcSeguroNF) {
		this.porcSeguroNF = porcSeguroNF;
	}

	public Double getValorTaxaBoleto() {
		return valorTaxaBoleto;
	}

	public void setValorTaxaBoleto(Double valorTaxaBoleto) {
		this.valorTaxaBoleto = valorTaxaBoleto;
	}

	public Double getValorKm() {
		return valorKm;
	}

	public void setValorKm(Double valorKm) {
		this.valorKm = valorKm;
	}

	public Double getValorFreteMinimo() {
		return valorFreteMinimo;
	}

	public void setValorFreteMinimo(Double valorFreteMinimo) {
		this.valorFreteMinimo = valorFreteMinimo;
	}

	public Double getValorCTRC() {
		return valorCTRC;
	}

	public void setValorCTRC(Double valorCTRC) {
		this.valorCTRC = valorCTRC;
	}

	public Double getPorcAdval() {
		return porcAdval;
	}

	public void setPorcAdval(Double porcAdval) {
		this.porcAdval = porcAdval;
	}

	public Double getPorcGris() {
		return porcGris;
	}

	public void setPorcGris(Double porcGris) {
		this.porcGris = porcGris;
	}

	public Double getValorColeta() {
		return valorColeta;
	}

	public void setValorColeta(Double valorColeta) {
		this.valorColeta = valorColeta;
	}

	public Integer getValorAteKm() {
		return valorAteKm;
	}

	public void setValorAteKm(Integer valorAteKm) {
		this.valorAteKm = valorAteKm;
	}

	public Double getValorAdicKg() {
		return valorAdicKg;
	}

	public void setValorAdicKg(Double valorAdicKg) {
		this.valorAdicKg = valorAdicKg;
	}
}
