package br.com.jgle.acti.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("CLIENTE")
public class Cliente extends ClienteFornecedor {

	@Override
	public Cliente newInstance() {
		return new Cliente();
	}

}
