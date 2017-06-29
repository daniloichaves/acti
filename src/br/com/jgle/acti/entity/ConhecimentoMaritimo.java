package br.com.jgle.acti.entity;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class ConhecimentoMaritimo extends AbstractEntity {

	@Column(length = 50)
	protected String porto;
	@Column(length = 50)
	protected String navio;
	@Column(length = 50)
	protected String armazem;
	@Column(length = 50)
	protected String baseDIDTA;
	@Column(length = 50)
	protected String tipo;
	@Column(length = 50)
	protected String processo;
	@Column(length = 50)
	protected String valoReferente;
	@Column(length = 50)
	protected String lacre;
	@Column(length = 50)
	protected String despachanteAgencia;
	@Column(length = 50)
	protected String numeroDI;
	@Temporal(TemporalType.DATE)
	protected Date dataDI;
	@Column(length = 50)
	protected String numeroDTA;
	@Temporal(TemporalType.DATE)
	protected Date dataDTA;
	@Column(length = 50)
	protected String numeroReservaNotaFiscal;
	@Temporal(TemporalType.DATE)
	protected Date dataReservaNotaFiscal;

	@SuppressWarnings("unchecked")
	public ConhecimentoMaritimo newInstance() {
		return new ConhecimentoMaritimo();
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

	public String getPorto() {
		return porto;
	}

	public void setPorto(String porto) {
		this.porto = porto;
	}

	public String getNavio() {
		return navio;
	}

	public void setNavio(String navio) {
		this.navio = navio;
	}

	public String getArmazem() {
		return armazem;
	}

	public void setArmazem(String armazem) {
		this.armazem = armazem;
	}

	public String getBaseDIDTA() {
		return baseDIDTA;
	}

	public void setBaseDIDTA(String baseDIDTA) {
		this.baseDIDTA = baseDIDTA;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public String getValoReferente() {
		return valoReferente;
	}

	public void setValoReferente(String valoReferente) {
		this.valoReferente = valoReferente;
	}

	public String getLacre() {
		return lacre;
	}

	public void setLacre(String lacre) {
		this.lacre = lacre;
	}

	public String getDespachanteAgencia() {
		return despachanteAgencia;
	}

	public void setDespachanteAgencia(String despachanteAgencia) {
		this.despachanteAgencia = despachanteAgencia;
	}

	public String getNumeroDI() {
		return numeroDI;
	}

	public void setNumeroDI(String numeroDI) {
		this.numeroDI = numeroDI;
	}

	public Date getDataDI() {
		return dataDI;
	}

	public void setDataDI(Date dataDI) {
		this.dataDI = dataDI;
	}

	public String getNumeroDTA() {
		return numeroDTA;
	}

	public void setNumeroDTA(String numeroDTA) {
		this.numeroDTA = numeroDTA;
	}

	public Date getDataDTA() {
		return dataDTA;
	}

	public void setDataDTA(Date dataDTA) {
		this.dataDTA = dataDTA;
	}

	public String getNumeroReservaNotaFiscal() {
		return numeroReservaNotaFiscal;
	}

	public void setNumeroReservaNotaFiscal(String numeroReservaNotaFiscal) {
		this.numeroReservaNotaFiscal = numeroReservaNotaFiscal;
	}

	public Date getDataReservaNotaFiscal() {
		return dataReservaNotaFiscal;
	}

	public void setDataReservaNotaFiscal(Date dataReservaNotaFiscal) {
		this.dataReservaNotaFiscal = dataReservaNotaFiscal;
	}

}
