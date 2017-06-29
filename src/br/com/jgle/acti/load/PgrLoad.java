package br.com.jgle.acti.load;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import br.com.jgle.acti.entity.pgr.Adicional;
import br.com.jgle.acti.entity.pgr.Atuador;
import br.com.jgle.acti.entity.pgr.Estado;
import br.com.jgle.acti.entity.pgr.Rastreador;
import br.com.jgle.acti.entity.pgr.Sensor;
import br.com.jgle.acti.service.GenericService;

@Service
public class PgrLoad implements InitializingBean {

	@Resource
	protected GenericService genericService;

	@Override
	public void afterPropertiesSet() throws Exception {
		carregarRastreador();
		carregarSensores();
		carregarAtuador();
		carregarAdicional();
		carregarUf();
	}

	public void carregarUf() {

		br.com.caelum.stella.type.Estado[] estados = br.com.caelum.stella.type.Estado
				.values();

		List<Estado> all = genericService.procurarTodos(Estado.class);
		if (all == null || all.isEmpty())
			for (br.com.caelum.stella.type.Estado uf : estados) {
				Estado estado = new Estado();
				estado.setUf(uf.toString());
				genericService.inserir(estado);

			}
	}

	public void carregarRastreador() {

		List<String> rastreadores = new ArrayList<String>();
		rastreadores.add("AUTOCARGO");
		rastreadores.add("AUTOSAT");
		rastreadores.add("AUTOTRAC");
		rastreadores.add("CDATA");
		rastreadores.add("CIELO");
		rastreadores.add("CONTROLLOC");
		rastreadores.add("CONTROLSAT");
		rastreadores.add("ITURAN");
		rastreadores.add("JABURSAT");
		rastreadores.add("LOGIKOS");
		rastreadores.add("MÓVEL");
		rastreadores.add("PAMAJHON");
		rastreadores.add("PRISMASAT");
		rastreadores.add("RODOSIS");
		rastreadores.add("SASCAR");
		rastreadores.add("STI");

		List<Rastreador> all = genericService.procurarTodos(Rastreador.class);
		if (all == null || all.isEmpty())
			for (String name : rastreadores) {
				Rastreador rastreador = new Rastreador();
				rastreador.setRastreador(name);
				genericService.inserir(rastreador);

			}
	}

	public void carregarSensores() {

		List<String> sensores = new ArrayList<String>();
		sensores.add("Abertura de portas da cabine");
		sensores.add("Desengate de carreta (no caso de veículo articulado)");
		sensores.add("Vandalismo no equipamento");
		sensores.add("Ignição (liga/desliga)");
		sensores.add("Botão de pânico ou emergência");
		sensores.add("Abertura de Baú");

		List<Sensor> all = genericService.procurarTodos(Sensor.class);
		if (all == null || all.isEmpty())
			for (String name : sensores) {
				Sensor sensor = new Sensor();
				sensor.setSensor(name);
				genericService.inserir(sensor);

			}
	}

	public void carregarAtuador() {

		List<String> atuadores = new ArrayList<String>();
		atuadores.add("Bloqueador de combustível");
		atuadores.add("BT1 (Bloqueado inteligente) em (Omnilink)");
		atuadores.add("Sirene / Acionamentos de Setas");
		atuadores.add("Ignição (liga/desliga)");
		atuadores.add("Botão de pânico ou emergência");
		atuadores.add("Abertura de Baú");

		List<Atuador> all = genericService.procurarTodos(Atuador.class);
		if (all == null || all.isEmpty())
			for (String name : atuadores) {
				Atuador atuador = new Atuador();
				atuador.setAtuador(name);
				genericService.inserir(atuador);

			}
	}

	public void carregarAdicional() {

		List<String> adicionais = new ArrayList<String>();
		adicionais
				.add("Tela de janela coligada ao sensor de carona do veículo");
		adicionais
				.add("Protetor de acesso aos degraus de entrada das Portas Motorista e Passageiro");
		adicionais.add("Blindagem do OBC com sensor de violação");
		adicionais.add("Veículos com Fatores de Calibração configurados");

		List<Adicional> all = genericService.procurarTodos(Adicional.class);
		if (all == null || all.isEmpty())
			for (String name : adicionais) {
				Adicional adicional = new Adicional();
				adicional.setAdicional(name);
				genericService.inserir(adicional);

			}
	}

	public GenericService getGenericService() {
		return genericService;
	}

	public void setGenericService(GenericService genericService) {
		this.genericService = genericService;
	}

}
