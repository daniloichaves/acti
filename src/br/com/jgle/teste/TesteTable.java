package br.com.jgle.teste;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: TesteTable
 *
 */
@Entity

public class TesteTable implements Serializable {

	
	private String name;   
	@Id
	private Integer id;
	private static final long serialVersionUID = 1L;

	public TesteTable() {
		super();
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
   
}
