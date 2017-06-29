package br.com.jgle.acti.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("FORNECEDOR")
public class Fornecedor extends ClienteFornecedor {

	@Override
	public Fornecedor newInstance() {
		return new Fornecedor();
	}

}
