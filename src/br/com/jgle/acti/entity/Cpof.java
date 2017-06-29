package br.com.jgle.acti.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Cpof extends AbstractEntity {

	protected Integer codigo;
	@Column(length = 150)
	protected String descricao;
	@Column(length = 150)
	protected String observacao;

	// Aliquota
	protected Boolean isentoICMS = new Boolean(false);
	protected Double aliquotaPadrao = 12d;
	// protected Boolean todosAliquotaPadrao = new Boolean(false);

	protected Double aliquotaAC = 0d;
	protected Double aliquotaAL = 0d;
	protected Double aliquotaAP = 0d;
	protected Double aliquotaAM = 0d;
	protected Double aliquotaBA = 0d;
	protected Double aliquotaCE = 0d;
	protected Double aliquotaDF = 0d;
	protected Double aliquotaES = 0d;
	protected Double aliquotaGO = 0d;
	protected Double aliquotaMA = 0d;
	protected Double aliquotaMG = 0d;
	protected Double aliquotaMS = 0d;
	protected Double aliquotaMT = 0d;
	protected Double aliquotaPA = 0d;
	protected Double aliquotaPB = 0d;
	protected Double aliquotaPE = 0d;
	protected Double aliquotaPI = 0d;
	protected Double aliquotaPR = 0d;
	protected Double aliquotaRJ = 0d;
	protected Double aliquotaRN = 0d;
	protected Double aliquotaRO = 0d;
	protected Double aliquotaRR = 0d;
	protected Double aliquotaRS = 0d;
	protected Double aliquotaSE = 0d;
	protected Double aliquotaSC = 0d;
	protected Double aliquotaSP = 0d;
	protected Double aliquotaTO = 0d;

	@SuppressWarnings("unchecked")
	public Cpof newInstance() {
		return new Cpof();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("codigo", textToSearch(textSearch));
		params.put("descricao", textToSearch(textSearch));
		params.put("observacao", textToSearch(textSearch));

		return params;
	}

	public Map<String, String> getParametrosAdvancedSearch() {
		Map<String, String> params = (Map<String, String>) super
				.getParametrosAdvancedSearch();

		params.put("codigo", "Código");
		params.put("descricao", "Descrição");
		params.put("observacao", "Observação");

		return params;

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Boolean getIsentoICMS() {
		return isentoICMS;
	}

	public void setIsentoICMS(Boolean isentoICMS) {
		this.isentoICMS = isentoICMS;
	}

	public Double getAliquotaPadrao() {
		return aliquotaPadrao;
	}

	public void setAliquotaPadrao(Double aliquotaPadrao) {
		this.aliquotaPadrao = aliquotaPadrao;
	}

	public Double getAliquotaAC() {
		return aliquotaAC;
	}

	public void setAliquotaAC(Double aliquotaAC) {
		this.aliquotaAC = aliquotaAC;
	}

	public Double getAliquotaAL() {
		return aliquotaAL;
	}

	public void setAliquotaAL(Double aliquotaAL) {
		this.aliquotaAL = aliquotaAL;
	}

	public Double getAliquotaAP() {
		return aliquotaAP;
	}

	public void setAliquotaAP(Double aliquotaAP) {
		this.aliquotaAP = aliquotaAP;
	}

	public Double getAliquotaAM() {
		return aliquotaAM;
	}

	public void setAliquotaAM(Double aliquotaAM) {
		this.aliquotaAM = aliquotaAM;
	}

	public Double getAliquotaBA() {
		return aliquotaBA;
	}

	public void setAliquotaBA(Double aliquotaBA) {
		this.aliquotaBA = aliquotaBA;
	}

	public Double getAliquotaCE() {
		return aliquotaCE;
	}

	public void setAliquotaCE(Double aliquotaCE) {
		this.aliquotaCE = aliquotaCE;
	}

	public Double getAliquotaDF() {
		return aliquotaDF;
	}

	public void setAliquotaDF(Double aliquotaDF) {
		this.aliquotaDF = aliquotaDF;
	}

	public Double getAliquotaES() {
		return aliquotaES;
	}

	public void setAliquotaES(Double aliquotaES) {
		this.aliquotaES = aliquotaES;
	}

	public Double getAliquotaGO() {
		return aliquotaGO;
	}

	public void setAliquotaGO(Double aliquotaGO) {
		this.aliquotaGO = aliquotaGO;
	}

	public Double getAliquotaMA() {
		return aliquotaMA;
	}

	public void setAliquotaMA(Double aliquotaMA) {
		this.aliquotaMA = aliquotaMA;
	}

	public Double getAliquotaMG() {
		return aliquotaMG;
	}

	public void setAliquotaMG(Double aliquotaMG) {
		this.aliquotaMG = aliquotaMG;
	}

	public Double getAliquotaMS() {
		return aliquotaMS;
	}

	public void setAliquotaMS(Double aliquotaMS) {
		this.aliquotaMS = aliquotaMS;
	}

	public Double getAliquotaMT() {
		return aliquotaMT;
	}

	public void setAliquotaMT(Double aliquotaMT) {
		this.aliquotaMT = aliquotaMT;
	}

	public Double getAliquotaPA() {
		return aliquotaPA;
	}

	public void setAliquotaPA(Double aliquotaPA) {
		this.aliquotaPA = aliquotaPA;
	}

	public Double getAliquotaPB() {
		return aliquotaPB;
	}

	public void setAliquotaPB(Double aliquotaPB) {
		this.aliquotaPB = aliquotaPB;
	}

	public Double getAliquotaPE() {
		return aliquotaPE;
	}

	public void setAliquotaPE(Double aliquotaPE) {
		this.aliquotaPE = aliquotaPE;
	}

	public Double getAliquotaPI() {
		return aliquotaPI;
	}

	public void setAliquotaPI(Double aliquotaPI) {
		this.aliquotaPI = aliquotaPI;
	}

	public Double getAliquotaPR() {
		return aliquotaPR;
	}

	public void setAliquotaPR(Double aliquotaPR) {
		this.aliquotaPR = aliquotaPR;
	}

	public Double getAliquotaRJ() {
		return aliquotaRJ;
	}

	public void setAliquotaRJ(Double aliquotaRJ) {
		this.aliquotaRJ = aliquotaRJ;
	}

	public Double getAliquotaRN() {
		return aliquotaRN;
	}

	public void setAliquotaRN(Double aliquotaRN) {
		this.aliquotaRN = aliquotaRN;
	}

	public Double getAliquotaRO() {
		return aliquotaRO;
	}

	public void setAliquotaRO(Double aliquotaRO) {
		this.aliquotaRO = aliquotaRO;
	}

	public Double getAliquotaRR() {
		return aliquotaRR;
	}

	public void setAliquotaRR(Double aliquotaRR) {
		this.aliquotaRR = aliquotaRR;
	}

	public Double getAliquotaRS() {
		return aliquotaRS;
	}

	public void setAliquotaRS(Double aliquotaRS) {
		this.aliquotaRS = aliquotaRS;
	}

	public Double getAliquotaSE() {
		return aliquotaSE;
	}

	public void setAliquotaSE(Double aliquotaSE) {
		this.aliquotaSE = aliquotaSE;
	}

	public Double getAliquotaSC() {
		return aliquotaSC;
	}

	public void setAliquotaSC(Double aliquotaSC) {
		this.aliquotaSC = aliquotaSC;
	}

	public Double getAliquotaSP() {
		return aliquotaSP;
	}

	public void setAliquotaSP(Double aliquotaSP) {
		this.aliquotaSP = aliquotaSP;
	}

	public Double getAliquotaTO() {
		return aliquotaTO;
	}

	public void setAliquotaTO(Double aliquotaTO) {
		this.aliquotaTO = aliquotaTO;
	}
}
