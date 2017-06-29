package br.com.jgle.acti.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.Conhecimento;

@Scope("page")
@Controller
public class ManifestoConhecimentoController extends AbstractController<Conhecimento> {

	private static final long serialVersionUID = 1L;

	public ManifestoConhecimentoController() {
		super(new Conhecimento());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ManifestoConhecimentoController(AbstractController parent) {
		super(new Conhecimento(), parent);
	}

}
