package br.com.jgle.acti.entity.pgr;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.jgle.acti.entity.AbstractEntity;

@SuppressWarnings("serial")
@Entity
public class Estado extends AbstractEntity {

	@Column(length = 3)
	protected String uf;

	@Column(length = 50)
	protected String estado;

	@SuppressWarnings("unchecked")
	public Estado newInstance() {
		return new Estado();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("uf", textToSearch(textSearch));
		params.put("estado", textToSearch(textSearch));

		return params;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
