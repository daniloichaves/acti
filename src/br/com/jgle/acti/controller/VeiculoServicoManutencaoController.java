package br.com.jgle.acti.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.spring.context.annotation.AppliedTo;

import br.com.jgle.acti.entity.Veiculo;
import br.com.jgle.acti.entity.VeiculoServicoManutencao;

@Scope("page")
@Controller
@AppliedTo("entityWin")
public class VeiculoServicoManutencaoController extends
		AbstractController<VeiculoServicoManutencao> {

	public VeiculoServicoManutencaoController() {
		super(new VeiculoServicoManutencao());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public VeiculoServicoManutencaoController(AbstractController parent) {
		super(new VeiculoServicoManutencao(), parent);
	}

	private static final long serialVersionUID = 1L;

	public List<Veiculo> getVeiculos() {
		return genericService.procurarTodos(Veiculo.class);
	}

}
