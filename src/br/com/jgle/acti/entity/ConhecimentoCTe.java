package br.com.jgle.acti.entity;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class ConhecimentoCTe extends AbstractEntity {

	@Column(length = 50)
	protected String numeroCTE;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataHoraEnvioCTE;
	@Column(length = 50)
	protected String protocoloEnvio;
	@Column(length = 50)
	protected String status;
	@Column(length = 50)
	protected String rejeicao;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataHoraAprovacao;
	@Column(length = 50)
	protected String protocoloAprovacao;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataHoraCancelamento;
	@Column(length = 50)
	protected String protocoloCancelamento;
	@Column(length = 200)
	protected String docXMLEnvio;
	@Column(length = 200)
	protected String docXMLAprovacao;
	@Column(length = 200)
	protected String docXMLCancelamento;
	@Column(length = 200)
	protected String docXMLOriginal;

	@SuppressWarnings("unchecked")
	public ConhecimentoCTe newInstance() {
		return new ConhecimentoCTe();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("numeroCTE", textToSearch(textSearch));
		params.put("status", textToSearch(textSearch));
		params.put("rejeicao", textToSearch(textSearch));
		params.put("protocoloAprovacao", textToSearch(textSearch));
		params.put("protocoloCancelamento", textToSearch(textSearch));

		return params;
	}

	public String getNumeroCTE() {
		return numeroCTE;
	}

	public void setNumeroCTE(String numeroCTE) {
		this.numeroCTE = numeroCTE;
	}

	public Date getDataHoraEnvioCTE() {
		return dataHoraEnvioCTE;
	}

	public void setDataHoraEnvioCTE(Date dataHoraEnvioCTE) {
		this.dataHoraEnvioCTE = dataHoraEnvioCTE;
	}

	public String getProtocoloEnvio() {
		return protocoloEnvio;
	}

	public void setProtocoloEnvio(String protocoloEnvio) {
		this.protocoloEnvio = protocoloEnvio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRejeicao() {
		return rejeicao;
	}

	public void setRejeicao(String rejeicao) {
		this.rejeicao = rejeicao;
	}

	public Date getDataHoraAprovacao() {
		return dataHoraAprovacao;
	}

	public void setDataHoraAprovacao(Date dataHoraAprovacao) {
		this.dataHoraAprovacao = dataHoraAprovacao;
	}

	public String getProtocoloAprovacao() {
		return protocoloAprovacao;
	}

	public void setProtocoloAprovacao(String protocoloAprovacao) {
		this.protocoloAprovacao = protocoloAprovacao;
	}

	public Date getDataHoraCancelamento() {
		return dataHoraCancelamento;
	}

	public void setDataHoraCancelamento(Date dataHoraCancelamento) {
		this.dataHoraCancelamento = dataHoraCancelamento;
	}

	public String getProtocoloCancelamento() {
		return protocoloCancelamento;
	}

	public void setProtocoloCancelamento(String protocoloCancelamento) {
		this.protocoloCancelamento = protocoloCancelamento;
	}

	public String getDocXMLEnvio() {
		return docXMLEnvio;
	}

	public void setDocXMLEnvio(String docXMLEnvio) {
		this.docXMLEnvio = docXMLEnvio;
	}

	public String getDocXMLAprovacao() {
		return docXMLAprovacao;
	}

	public void setDocXMLAprovacao(String docXMLAprovacao) {
		this.docXMLAprovacao = docXMLAprovacao;
	}

	public String getDocXMLCancelamento() {
		return docXMLCancelamento;
	}

	public void setDocXMLCancelamento(String docXMLCancelamento) {
		this.docXMLCancelamento = docXMLCancelamento;
	}

	public String getDocXMLOriginal() {
		return docXMLOriginal;
	}

	public void setDocXMLOriginal(String docXMLOriginal) {
		this.docXMLOriginal = docXMLOriginal;
	}

}
