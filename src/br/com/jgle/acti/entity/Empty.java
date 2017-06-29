package br.com.jgle.acti.entity;

import java.util.Map;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Empty extends AbstractEntity {

	@SuppressWarnings("unchecked")
	public Empty newInstance() {
		return new Empty();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("nome", textToSearch(textSearch));

		return params;
	}

}
