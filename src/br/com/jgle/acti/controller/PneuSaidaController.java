package br.com.jgle.acti.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.spring.context.annotation.AppliedTo;

import br.com.jgle.acti.entity.Veiculo;
import br.com.jgle.acti.entity.estoque.Pneu;
import br.com.jgle.acti.entity.estoque.PneuSaida;

@Scope("page")
@Controller
@AppliedTo("entityWin")
public class PneuSaidaController extends AbstractController<PneuSaida> {

	public PneuSaidaController() {
		super(new PneuSaida());
	}

	private static final long serialVersionUID = 1L;

	public List<Pneu> getPneus() {
		return genericService.procurarTodos(Pneu.class);
	}

	public List<Veiculo> getVeiculos() {
		return genericService.procurarTodos(Veiculo.class);
	}

}
