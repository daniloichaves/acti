package br.com.jgle.acti.entity.pgr;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.jgle.acti.entity.AbstractEntity;

@SuppressWarnings("serial")
@Entity
public class Rastreador extends AbstractEntity {

	@Column(length = 150)
	protected String rastreador;

	@SuppressWarnings("unchecked")
	public Rastreador newInstance() {
		return new Rastreador();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("rastreador", textToSearch(textSearch));

		return params;
	}

	public String getRastreador() {
		return rastreador;
	}

	public void setRastreador(String rastreador) {
		this.rastreador = rastreador;
	}

}
