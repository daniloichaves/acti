package br.com.jgle.acti.entity.pgr;

import java.math.BigDecimal;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.jgle.acti.entity.AbstractEntity;
import br.com.jgle.acti.entity.estoque.Grupo;

@SuppressWarnings("serial")
@Entity
public class GrupoMercadoria extends AbstractEntity {

	@ManyToOne
	protected Grupo grupo;

	protected BigDecimal limiteMaximo = BigDecimal.ZERO;

	@Column(length = 150)
	protected String observacao;

	@SuppressWarnings("unchecked")
	public GrupoMercadoria newInstance() {
		return new GrupoMercadoria();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("limiteMaximo", textToSearch(textSearch));

		params.put("observacao", textToSearch(textSearch));

		return params;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public BigDecimal getLimiteMaximo() {
		return limiteMaximo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public void setLimiteMaximo(BigDecimal limiteMaximo) {
		this.limiteMaximo = limiteMaximo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
