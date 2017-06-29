package br.com.jgle.acti.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.Telefone;

@Scope("page")
@Controller
public class TelefoneController extends AbstractController<Telefone> {

	private static final long serialVersionUID = 1L;

	public TelefoneController() {
		super(new Telefone());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelefoneController(AbstractController parent) {
		super(new Telefone(), parent);
	}

}
