package br.com.jgle.acti.entity;

import java.math.BigDecimal;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class ConhecimentoCalculoFreteUm extends AbstractEntity {

	protected BigDecimal fretePeso;
	protected BigDecimal freteValor;
	protected BigDecimal secCat;
	protected BigDecimal despacho;
	protected BigDecimal pedagio;
	protected BigDecimal adame;
	protected BigDecimal adValorem;
	protected BigDecimal irt;
	protected BigDecimal seguro;
	protected BigDecimal suframa;
	protected BigDecimal gris;
	protected BigDecimal tde;
	protected BigDecimal taxa1;
	protected BigDecimal taxa2;
	protected BigDecimal icms;
	protected BigDecimal outros;
	protected BigDecimal desconto;
	protected BigDecimal totalCTRC;

	@Column(length = 100)
	protected String formula;
	protected BigDecimal valorFormula = BigDecimal.ZERO;

	@SuppressWarnings("unchecked")
	public ConhecimentoCalculoFreteUm newInstance() {
		return new ConhecimentoCalculoFreteUm();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("porto", textToSearch(textSearch));
		params.put("navio", textToSearch(textSearch));
		params.put("armazem", textToSearch(textSearch));
		params.put("tipo", textToSearch(textSearch));
		params.put("despachanteAgencia", textToSearch(textSearch));

		return params;
	}

	public BigDecimal getFretePeso() {
		return fretePeso;
	}

	public void setFretePeso(BigDecimal fretePeso) {
		this.fretePeso = fretePeso;
	}

	public BigDecimal getFreteValor() {
		return freteValor;
	}

	public void setFreteValor(BigDecimal freteValor) {
		this.freteValor = freteValor;
	}

	public BigDecimal getSecCat() {
		return secCat;
	}

	public void setSecCat(BigDecimal secCat) {
		this.secCat = secCat;
	}

	public BigDecimal getDespacho() {
		return despacho;
	}

	public void setDespacho(BigDecimal despacho) {
		this.despacho = despacho;
	}

	public BigDecimal getPedagio() {
		return pedagio;
	}

	public void setPedagio(BigDecimal pedágio) {
		this.pedagio = pedágio;
	}

	public BigDecimal getAdame() {
		return adame;
	}

	public void setAdame(BigDecimal adame) {
		this.adame = adame;
	}

	public BigDecimal getAdValorem() {
		return adValorem;
	}

	public void setAdValorem(BigDecimal adValorem) {
		this.adValorem = adValorem;
	}

	public BigDecimal getIrt() {
		return irt;
	}

	public void setIrt(BigDecimal irt) {
		this.irt = irt;
	}

	public BigDecimal getSeguro() {
		return seguro;
	}

	public void setSeguro(BigDecimal seguro) {
		this.seguro = seguro;
	}

	public BigDecimal getSuframa() {
		return suframa;
	}

	public void setSuframa(BigDecimal suframa) {
		this.suframa = suframa;
	}

	public BigDecimal getGris() {
		return gris;
	}

	public void setGris(BigDecimal gris) {
		this.gris = gris;
	}

	public BigDecimal getTde() {
		return tde;
	}

	public void setTde(BigDecimal tde) {
		this.tde = tde;
	}

	public BigDecimal getTaxa1() {
		return taxa1;
	}

	public void setTaxa1(BigDecimal taxa1) {
		this.taxa1 = taxa1;
	}

	public BigDecimal getTaxa2() {
		return taxa2;
	}

	public void setTaxa2(BigDecimal taxa2) {
		this.taxa2 = taxa2;
	}

	public BigDecimal getIcms() {
		return icms;
	}

	public void setIcms(BigDecimal icms) {
		this.icms = icms;
	}

	public BigDecimal getOutros() {
		return outros;
	}

	public void setOutros(BigDecimal outros) {
		this.outros = outros;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getTotalCTRC() {
		return totalCTRC;
	}

	public void setTotalCTRC(BigDecimal totalCTRC) {
		this.totalCTRC = totalCTRC;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public BigDecimal getValorFormula() {
		return valorFormula;
	}

	public void setValorFormula(BigDecimal valorFormula) {
		this.valorFormula = valorFormula;
	}

}
