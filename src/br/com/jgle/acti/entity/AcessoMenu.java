package br.com.jgle.acti.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@SuppressWarnings("serial")
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "titulo"))
public class AcessoMenu extends AbstractEntity {

	@Column(length = 25)
	private String idMenu;

	@Column(length = 50)
	private String titulo;

	@SuppressWarnings("unchecked")
	public AcessoMenu newInstance() {
		return new AcessoMenu();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("idMenu", textToSearch(textSearch));
		params.put("titulo", textToSearch(textSearch));

		return params;
	}

	public String getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
