package br.com.jgle.acti.entity;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Endereco extends AbstractEntity {
	public static String TIPO_GERAL = "GERAL";
	public static String TIPO_ENTREGA = "ENTREGA";
	public static String TIPO_COLETA = "COLETA";
	public static String TIPO_COBRANCA = "COBRANÇA";

	@Column(length = 15)
	protected String tipo;
	@Column(length = 10)
	protected String cep;
	@Column(length = 250)
	protected String endereco;
	@Column(length = 30)
	protected String bairro;
	@Column(length = 20)
	protected String cidade;
	@Column(length = 3)
	protected String uf;

	@Column(length = 20)
	protected String estado;
	@Column(length = 10)
	protected String numero;

	@Column(length = 150)
	protected String pontoReferencia;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataHoraColeta;

	protected Double lat;
	protected Double lnt;

	@Transient
	public String getEnderecoBusca() {
		StringBuilder sb = new StringBuilder();

		sb.append(endereco != null ? endereco : "");
		sb.append(" , ");
		sb.append(numero != null ? numero : "");
		sb.append(" - ");
		sb.append(bairro != null ? bairro : "");
		sb.append(" , ");
		sb.append(cidade != null ? cidade : "");
		sb.append(" , ");
		sb.append(getCepFormat() != null ? getCepFormat() : "");
		sb.append(" - ");
		sb.append("Brasil");

		return sb.toString();

	}

	@Transient
	public String getCepFormat() {
		if (cep != null && !cep.contains("-")) {
			StringBuilder sb = new StringBuilder(cep);
			sb.insert(5, '-');

			return sb.toString();
		}

		return cep;
	}

	@SuppressWarnings("unchecked")
	public Endereco newInstance() {
		return new Endereco();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("tipo", textToSearch(textSearch));
		params.put("endereco", textToSearch(textSearch));
		params.put("estado", textToSearch(textSearch));
		params.put("cidade", textToSearch(textSearch));
		params.put("uf", textToSearch(textSearch));

		return params;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	public Date getDataHoraColeta() {
		return dataHoraColeta;
	}

	public void setDataHoraColeta(Date dataHoraColeta) {
		this.dataHoraColeta = dataHoraColeta;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLnt() {
		return lnt;
	}

	public void setLnt(Double lnt) {
		this.lnt = lnt;
	}
}
