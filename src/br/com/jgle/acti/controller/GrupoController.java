package br.com.jgle.acti.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.estoque.Grupo;

@Scope("page")
@Controller
public class GrupoController extends AbstractController<Grupo> {

	private static final long serialVersionUID = 1L;

	public GrupoController() {
		super(new Grupo());
	}

	public List<Grupo> getGrupos() {
		return genericService.procurarTodos(Grupo.class);
	}

}
