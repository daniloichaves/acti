package br.com.jgle.acti.entity;

import java.math.BigDecimal;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class ConhecimentoCalculoFreteCarta extends AbstractEntity {

	protected BigDecimal freteBruto;
	protected BigDecimal freteValorUnit;
	protected BigDecimal pesoFrete;
	protected BigDecimal totalMotorista;

	protected BigDecimal pedagio;
	protected BigDecimal estadia;
	protected BigDecimal ajudante;
	protected BigDecimal outros;

	protected BigDecimal sestSenat;
	protected BigDecimal INSS;
	protected BigDecimal desconto;
	protected BigDecimal pedagio2;
	protected BigDecimal adiantamento;
	protected BigDecimal impostoRenda;
	protected BigDecimal faltaMercadoria;
	protected BigDecimal seguro;

	protected String observacao;
	protected BigDecimal freteLiquido;

	@Column(length = 100)
	protected String formula;
	protected BigDecimal valorFormula = BigDecimal.ZERO;

	@SuppressWarnings("unchecked")
	public ConhecimentoCalculoFreteCarta newInstance() {
		return new ConhecimentoCalculoFreteCarta();
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

	public BigDecimal getFreteBruto() {
		return freteBruto;
	}

	public void setFreteBruto(BigDecimal freteBruto) {
		this.freteBruto = freteBruto;
	}

	public BigDecimal getFreteValorUnit() {
		return freteValorUnit;
	}

	public void setFreteValorUnit(BigDecimal freteValorUnit) {
		this.freteValorUnit = freteValorUnit;
	}

	public BigDecimal getPesoFrete() {
		return pesoFrete;
	}

	public void setPesoFrete(BigDecimal pesoFrete) {
		this.pesoFrete = pesoFrete;
	}

	public BigDecimal getTotalMotorista() {
		return totalMotorista;
	}

	public void setTotalMotorista(BigDecimal totalMotorista) {
		this.totalMotorista = totalMotorista;
	}

	public BigDecimal getPedagio() {
		return pedagio;
	}

	public void setPedagio(BigDecimal pedagio) {
		this.pedagio = pedagio;
	}

	public BigDecimal getEstadia() {
		return estadia;
	}

	public void setEstadia(BigDecimal estadia) {
		this.estadia = estadia;
	}

	public BigDecimal getAjudante() {
		return ajudante;
	}

	public void setAjudante(BigDecimal ajudante) {
		this.ajudante = ajudante;
	}

	public BigDecimal getOutros() {
		return outros;
	}

	public void setOutros(BigDecimal outros) {
		this.outros = outros;
	}

	public BigDecimal getSestSenat() {
		return sestSenat;
	}

	public void setSestSenat(BigDecimal sestSenat) {
		this.sestSenat = sestSenat;
	}

	public BigDecimal getINSS() {
		return INSS;
	}

	public void setINSS(BigDecimal iNSS) {
		INSS = iNSS;
	}

	public BigDecimal getPedagio2() {
		return pedagio2;
	}

	public void setPedagio2(BigDecimal pedagio2) {
		this.pedagio2 = pedagio2;
	}

	public BigDecimal getAdiantamento() {
		return adiantamento;
	}

	public void setAdiantamento(BigDecimal adiantamento) {
		this.adiantamento = adiantamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getFreteLiquido() {
		return freteLiquido;
	}

	public void setFreteLiquido(BigDecimal freteLiquido) {
		this.freteLiquido = freteLiquido;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getImpostoRenda() {
		return impostoRenda;
	}

	public void setImpostoRenda(BigDecimal impostoRenda) {
		this.impostoRenda = impostoRenda;
	}

	public BigDecimal getFaltaMercadoria() {
		return faltaMercadoria;
	}

	public void setFaltaMercadoria(BigDecimal faltaMercadoria) {
		this.faltaMercadoria = faltaMercadoria;
	}

	public BigDecimal getSeguro() {
		return seguro;
	}

	public void setSeguro(BigDecimal seguro) {
		this.seguro = seguro;
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
