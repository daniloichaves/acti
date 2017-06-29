package br.com.jgle.acti.entity;

import java.util.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.jgle.acti.entity.pgr.Rastreador;

@SuppressWarnings("serial")
@Entity
public class VeiculoRastreador extends AbstractEntity {

	// @Column(length = 50)
	// protected String empresa;
	// @Column(length = 10)
	// protected String equipamentoRastreamento;
	@ManyToOne(cascade = CascadeType.ALL)
	protected Rastreador rastreador;
	@Column(length = 20)
	protected String status;
	@Column(length = 50)
	protected String numeroTerminal;
	@Temporal(TemporalType.DATE)
	protected Date dataValidade = new Date();

	@SuppressWarnings("unchecked")
	public VeiculoRastreador newInstance() {
		return new VeiculoRastreador();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("rastreador.rastreador", textToSearch(textSearch));
		params.put("status", textToSearch(textSearch));
		params.put("numeroTerminal", textToSearch(textSearch));
		params.put("dataValidade", textToSearch(textSearch));

		return params;
	}

	@Transient
	public String getEquipamentoStatusBrasilRisk() {
		if (getStatus() != null) {
			if ("FUNCIONANDO".equals(getStatus())) {
				return "F";
			} else if ("DEFEITO".equals(getStatus())) {
				return "D";
			}
		}
		return null;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNumeroTerminal() {
		return numeroTerminal;
	}

	public void setNumeroTerminal(String numeroTerminal) {
		this.numeroTerminal = numeroTerminal;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Rastreador getRastreador() {
		return rastreador;
	}

	public void setRastreador(Rastreador rastreador) {
		this.rastreador = rastreador;
	}
}
