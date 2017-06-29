package br.com.jgle.acti.entity.estoque;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.jgle.acti.entity.AbstractEntity;

@SuppressWarnings("serial")
@Entity
public class Grupo extends AbstractEntity {

	@Column(length = 40)
	protected String nome;
	@ManyToOne
	protected Grupo parent;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Grupo getGrupo() {
		return parent;
	}

	public void setGrupo(Grupo grupo) {
		this.parent = grupo;
	}

	@SuppressWarnings("unchecked")
	public Grupo newInstance() {
		return new Grupo();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("grupo", textToSearch(textSearch));

		return params;
	}

	public Grupo getParent() {
		return parent;
	}

	public void setParent(Grupo parent) {
		this.parent = parent;
	}

}
