package br.com.jgle.acti.entity.brasilrisk;

import java.util.HashSet;
import java.util.Set;

public class Paradas {
	
	protected Set<OrigemParada> parada = new HashSet<OrigemParada>();

	public Set<OrigemParada> getParada() {
		return parada;
	}

	public void setParada(Set<OrigemParada> parada) {
		this.parada = parada;
	}
}
