package br.com.jgle.acti.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.Unidade;
import br.com.jgle.acti.entity.estoque.Almoxarifado;

@Scope("page")
@Controller
public class AlmoxarifadoController extends AbstractController<Almoxarifado> {

	private static final long serialVersionUID = 1L;

	public AlmoxarifadoController() {
		super(new Almoxarifado());
	}

	public List<Unidade> getUnidades() {
		return genericService.procurarTodos(Unidade.class);
	}

}
