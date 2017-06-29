package br.com.jgle.acti.entity.estoque;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.jgle.acti.entity.AbstractEntity;
import br.com.jgle.acti.entity.Veiculo;

@SuppressWarnings("serial")
@Entity
public class PneuSaida extends AbstractEntity {

	@ManyToOne
	protected Pneu pneu;
	@ManyToOne
	protected Veiculo veiculo;

	protected Integer quantidade;

	protected Integer hodometro;

	@SuppressWarnings("unchecked")
	public PneuSaida newInstance() {
		return new PneuSaida();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("pneu.marca", textToSearch(textSearch));
		params.put("pneu.modelo", textToSearch(textSearch));
		params.put("veiculo.marca", textToSearch(textSearch));
		params.put("veiculo.modelo", textToSearch(textSearch));

		return params;
	}
	
	public Map<String, String> getParametrosAdvancedSearch() {
		Map<String, String> params = (Map<String, String>) super
				.getParametrosAdvancedSearch();

		params.put("pneu.marca", "Pneu Marca");
		params.put("pneu.modelo", "Pneu Modelo");
		
		params.put("veiculo.marca", "Veículo Marca");
		params.put("veiculo.modelo", "Veículo Modelo");

		return params;
	}

	public Pneu getPneu() {
		return pneu;
	}

	public void setPneu(Pneu pneu) {
		this.pneu = pneu;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getHodometro() {
		return hodometro;
	}

	public void setHodometro(Integer hodometro) {
		this.hodometro = hodometro;
	}
}
