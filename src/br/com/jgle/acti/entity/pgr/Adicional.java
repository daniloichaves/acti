package br.com.jgle.acti.entity.pgr;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.jgle.acti.entity.AbstractEntity;

@SuppressWarnings("serial")
@Entity
public class Adicional extends AbstractEntity {

	@Column(length = 150)
	protected String adicional;

	@SuppressWarnings("unchecked")
	public Adicional newInstance() {
		return new Adicional();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("grupo", textToSearch(textSearch));

		return params;
	}

	public String getAdicional() {
		return adicional;
	}

	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}

}
