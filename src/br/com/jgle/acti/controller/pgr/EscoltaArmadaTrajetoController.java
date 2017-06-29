package br.com.jgle.acti.controller.pgr;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.controller.AbstractController;
import br.com.jgle.acti.entity.pgr.EscoltaArmadaTrajeto;

@Scope("page")
@Controller
public class EscoltaArmadaTrajetoController extends AbstractController<EscoltaArmadaTrajeto> {

	private static final long serialVersionUID = 1L;

	public EscoltaArmadaTrajetoController() {
		super(new EscoltaArmadaTrajeto());

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EscoltaArmadaTrajetoController(AbstractController parent) {
		super(new EscoltaArmadaTrajeto(), parent);
	}

}
