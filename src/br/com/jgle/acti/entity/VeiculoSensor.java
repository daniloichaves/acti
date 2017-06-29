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

import br.com.jgle.acti.entity.pgr.Sensor;

@SuppressWarnings("serial")
@Entity
public class VeiculoSensor extends AbstractEntity {

	// @Column(length = 50)
	// protected String empresa;
	@ManyToOne(cascade = CascadeType.ALL)
	protected Sensor sensor;
	@Column(length = 20)
	protected String status;
	@Column(length = 50)
	protected String numeroTerminal;
	@Temporal(TemporalType.DATE)
	protected Date dataValidade = new Date();

	@SuppressWarnings("unchecked")
	public VeiculoSensor newInstance() {
		return new VeiculoSensor();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("equipamentoRastreamento", textToSearch(textSearch));
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

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
}
