package br.com.jgle.acti.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class TesteEntity extends AbstractEntity {

	@Column(length = 150)
	private String name;

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@SuppressWarnings("unchecked")
	public TesteEntity newInstance() {
		return new TesteEntity();
	}

}
