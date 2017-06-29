package br.com.jgle.acti.entity.pgr;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.jgle.acti.entity.AbstractEntity;

@SuppressWarnings("serial")
@Entity
public class Atuador extends AbstractEntity {

	@Column(length = 150)
	protected String atuador;

	@SuppressWarnings("unchecked")
	public Atuador newInstance() {
		return new Atuador();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("grupo", textToSearch(textSearch));

		return params;
	}

	public String getAtuador() {
		return atuador;
	}

	public void setAtuador(String atuador) {
		this.atuador = atuador;
	}
}
