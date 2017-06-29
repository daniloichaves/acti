package br.com.jgle.teste;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Categoria
 * 
 */
@Entity
@Table(name = "CATEGORIA")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	public Categoria() {
		super();
	}

	@Id
	private Long id;
	private String categoria;
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
