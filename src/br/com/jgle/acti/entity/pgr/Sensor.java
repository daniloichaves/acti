package br.com.jgle.acti.entity.pgr;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.jgle.acti.entity.AbstractEntity;

@SuppressWarnings("serial")
@Entity
public class Sensor extends AbstractEntity {

	@Column(length = 150)
	protected String sensor;

	@SuppressWarnings("unchecked")
	public Sensor newInstance() {
		return new Sensor();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("sensor", textToSearch(textSearch));

		return params;
	}

	public String getSensor() {
		return sensor;
	}

	public void setSensor(String sensor) {
		this.sensor = sensor;
	}

}
