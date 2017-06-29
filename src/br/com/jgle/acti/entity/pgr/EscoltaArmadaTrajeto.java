package br.com.jgle.acti.entity.pgr;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import br.com.jgle.acti.entity.AbstractEntity;
import br.com.jgle.acti.entity.Endereco;

@SuppressWarnings("serial")
@Entity
public class EscoltaArmadaTrajeto extends AbstractEntity {

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	protected Endereco pontoA = new Endereco();

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	protected Endereco pontoB = new Endereco();

	@Column(length = 150)
	protected String observacao;

	@SuppressWarnings("unchecked")
	public EscoltaArmadaTrajeto newInstance() {
		return new EscoltaArmadaTrajeto();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("pontoA.endereco", textToSearch(textSearch));
		params.put("pontoA.bairro", textToSearch(textSearch));
		params.put("pontoB.endereco", textToSearch(textSearch));
		params.put("pontoB.bairro", textToSearch(textSearch));
		params.put("observacao", textToSearch(textSearch));

		return params;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Endereco getPontoA() {
		return pontoA;
	}

	public Endereco getPontoB() {
		return pontoB;
	}

	public void setPontoA(Endereco pontoA) {
		this.pontoA = pontoA;
	}

	public void setPontoB(Endereco pontoB) {
		this.pontoB = pontoB;
	}
}
