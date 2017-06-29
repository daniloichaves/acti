package br.com.jgle.acti.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.Banco;
import br.com.jgle.acti.entity.ContaBanco;

@Scope("page")
@Controller
public class ContaBancoController extends AbstractController<ContaBanco> {

	private static final long serialVersionUID = 1L;

	public ContaBancoController() {
		super(new ContaBanco());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ContaBancoController(AbstractController parent) {
		super(new ContaBanco(), parent);
	}

	public List<Banco> getBancos() {
		return parent.getGenericService().procurarTodos(Banco.class);
	}

}
