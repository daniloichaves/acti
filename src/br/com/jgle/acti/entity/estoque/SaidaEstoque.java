package br.com.jgle.acti.entity.estoque;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("SAIDA")
public class SaidaEstoque extends Estoque {

	@SuppressWarnings("unchecked")
	public Estoque newInstance() {
		return new SaidaEstoque();
	}

}
