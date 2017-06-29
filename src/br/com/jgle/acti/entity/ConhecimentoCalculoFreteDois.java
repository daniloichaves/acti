package br.com.jgle.acti.entity;

import java.math.BigDecimal;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class ConhecimentoCalculoFreteDois extends AbstractEntity {

	protected BigDecimal pesoFrete;
	protected BigDecimal freteValorUnit;
	protected BigDecimal pedagio;

	protected BigDecimal calcICMSFreteValorUnit;
	protected BigDecimal calcICMSFretePesoValor;
	protected BigDecimal calcICMSPorcentagem;
	protected BigDecimal calcICMSCalcSec;
	protected BigDecimal calcICMSDesp;
	protected BigDecimal calcICMSAdeme;
	protected BigDecimal calcICMSITR;
	protected BigDecimal calcICMSGRIS;
	protected BigDecimal calcICMSOutro;

	protected BigDecimal baseICMS;
	protected BigDecimal baseCalculo;
	protected BigDecimal baseAliquotaICMS;
	protected BigDecimal baseValorICMS;

	protected BigDecimal outros1;
	protected BigDecimal outros2;

	protected Integer outrosQtdExtra;
	protected BigDecimal outrosValExtra;
	protected BigDecimal outrosTotalExtra;

	@Column(length = 100)
	protected String formula;
	protected BigDecimal valorFormula = BigDecimal.ZERO;

	@SuppressWarnings("unchecked")
	public ConhecimentoCalculoFreteDois newInstance() {
		return new ConhecimentoCalculoFreteDois();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		// params.put("porto", textToSearch(textSearch));
		// params.put("navio", textToSearch(textSearch));
		// params.put("armazem", textToSearch(textSearch));
		// params.put("tipo", textToSearch(textSearch));
		// params.put("despachanteAgencia", textToSearch(textSearch));

		return params;
	}

	public BigDecimal getPesoFrete() {
		return pesoFrete;
	}

	public void setPesoFrete(BigDecimal pesoFrete) {
		this.pesoFrete = pesoFrete;
	}

	public BigDecimal getFreteValorUnit() {
		return freteValorUnit;
	}

	public void setFreteValorUnit(BigDecimal freteValorUnit) {
		this.freteValorUnit = freteValorUnit;
	}

	public BigDecimal getPedagio() {
		return pedagio;
	}

	public void setPedagio(BigDecimal pedagio) {
		this.pedagio = pedagio;
	}

	public BigDecimal getCalcICMSFreteValorUnit() {
		return calcICMSFreteValorUnit;
	}

	public void setCalcICMSFreteValorUnit(BigDecimal calcICMSFreteValorUnit) {
		this.calcICMSFreteValorUnit = calcICMSFreteValorUnit;
	}

	public BigDecimal getCalcICMSFretePesoValor() {
		return calcICMSFretePesoValor;
	}

	public void setCalcICMSFretePesoValor(BigDecimal calcICMSFretePesoValor) {
		this.calcICMSFretePesoValor = calcICMSFretePesoValor;
	}

	public BigDecimal getCalcICMSPorcentagem() {
		return calcICMSPorcentagem;
	}

	public void setCalcICMSPorcentagem(BigDecimal calcICMSPorcentagem) {
		this.calcICMSPorcentagem = calcICMSPorcentagem;
	}

	public BigDecimal getCalcICMSCalcSec() {
		return calcICMSCalcSec;
	}

	public void setCalcICMSCalcSec(BigDecimal calcICMSCalcSec) {
		this.calcICMSCalcSec = calcICMSCalcSec;
	}

	public BigDecimal getCalcICMSDesp() {
		return calcICMSDesp;
	}

	public void setCalcICMSDesp(BigDecimal calcICMSDesp) {
		this.calcICMSDesp = calcICMSDesp;
	}

	public BigDecimal getCalcICMSAdeme() {
		return calcICMSAdeme;
	}

	public void setCalcICMSAdeme(BigDecimal calcICMSAdeme) {
		this.calcICMSAdeme = calcICMSAdeme;
	}

	public BigDecimal getCalcICMSITR() {
		return calcICMSITR;
	}

	public void setCalcICMSITR(BigDecimal calcICMSITR) {
		this.calcICMSITR = calcICMSITR;
	}

	public BigDecimal getCalcICMSGRIS() {
		return calcICMSGRIS;
	}

	public void setCalcICMSGRIS(BigDecimal calcICMSGRIS) {
		this.calcICMSGRIS = calcICMSGRIS;
	}

	public BigDecimal getCalcICMSOutro() {
		return calcICMSOutro;
	}

	public void setCalcICMSOutro(BigDecimal calcICMSOutro) {
		this.calcICMSOutro = calcICMSOutro;
	}

	public BigDecimal getBaseICMS() {
		return baseICMS;
	}

	public void setBaseICMS(BigDecimal baseICMS) {
		this.baseICMS = baseICMS;
	}

	public BigDecimal getBaseCalculo() {
		return baseCalculo;
	}

	public void setBaseCalculo(BigDecimal baseCalculo) {
		this.baseCalculo = baseCalculo;
	}

	public BigDecimal getBaseAliquotaICMS() {
		return baseAliquotaICMS;
	}

	public void setBaseAliquotaICMS(BigDecimal baseAliquotaICMS) {
		this.baseAliquotaICMS = baseAliquotaICMS;
	}

	public BigDecimal getBaseValorICMS() {
		return baseValorICMS;
	}

	public void setBaseValorICMS(BigDecimal baseValorICMS) {
		this.baseValorICMS = baseValorICMS;
	}

	public BigDecimal getOutros1() {
		return outros1;
	}

	public void setOutros1(BigDecimal outros1) {
		this.outros1 = outros1;
	}

	public BigDecimal getOutros2() {
		return outros2;
	}

	public void setOutros2(BigDecimal outros2) {
		this.outros2 = outros2;
	}

	public Integer getOutrosQtdExtra() {
		return outrosQtdExtra;
	}

	public void setOutrosQtdExtra(Integer outrosQtdExtra) {
		this.outrosQtdExtra = outrosQtdExtra;
	}

	public BigDecimal getOutrosValExtra() {
		return outrosValExtra;
	}

	public void setOutrosValExtra(BigDecimal outrosValExtra) {
		this.outrosValExtra = outrosValExtra;
	}

	public BigDecimal getOutrosTotalExtra() {
		return outrosTotalExtra;
	}

	public void setOutrosTotalExtra(BigDecimal outrosTotalExtra) {
		this.outrosTotalExtra = outrosTotalExtra;
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
