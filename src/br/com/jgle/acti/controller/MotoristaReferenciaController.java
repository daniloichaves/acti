package br.com.jgle.acti.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.util.Composer;

import br.com.jgle.acti.entity.MotoristaReferencia;

@Scope("page")
@Controller
public class MotoristaReferenciaController extends AbstractController<MotoristaReferencia> implements Composer {

	private static final long serialVersionUID = 1L;

	public MotoristaReferenciaController() {
		super(new MotoristaReferencia());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MotoristaReferenciaController(AbstractController parent) {
		super(new MotoristaReferencia(), parent);
	}
}
