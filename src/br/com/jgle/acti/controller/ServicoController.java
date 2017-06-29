package br.com.jgle.acti.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.Servico;

@Scope("page")
@Controller
public class ServicoController extends AbstractController<Servico> {

	private static final long serialVersionUID = 1L;

	public ServicoController() {
		super(new Servico());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServicoController(AbstractController parent) {
		super(new Servico(), parent);
	}

}
