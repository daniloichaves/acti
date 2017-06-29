package br.com.jgle.acti.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.ConhecimentoCalculoFreteUm;

@Scope("page")
@Controller
public class ConhecimentoCalculoFreteUmController extends AbstractController<ConhecimentoCalculoFreteUm> {

	private static final long serialVersionUID = 1L;

	public ConhecimentoCalculoFreteUmController() {
		super(new ConhecimentoCalculoFreteUm());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ConhecimentoCalculoFreteUmController(AbstractController parent) {
		super(new ConhecimentoCalculoFreteUm(), parent);
	}

}
