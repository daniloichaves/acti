package br.com.jgle.acti.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.Rota;
import br.com.jgle.acti.entity.Unidade;

@Scope("page")
@Controller
public class RotaController extends AbstractController<Rota> {

	public RotaController() {
		super(new Rota());
	}

	private static final long serialVersionUID = 1L;

	public List<Unidade> getUnidades() {
		return genericService.procurarTodos(Unidade.class);
	}

}
