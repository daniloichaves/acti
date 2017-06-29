package br.com.jgle.acti.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.estoque.Almoxarifado;
import br.com.jgle.acti.entity.estoque.Grupo;
import br.com.jgle.acti.entity.estoque.Produto;

@Scope("page")
@Controller
public class ProdutoController extends AbstractController<Produto> {

	private static final long serialVersionUID = 1L;

	public ProdutoController() {
		super(new Produto());
	}

	public List<Grupo> getGrupos() {
		return genericService.procurarTodos(Grupo.class);
	}

	public List<Almoxarifado> getAlmoxarifados() {
		return genericService.procurarTodos(Almoxarifado.class);
	}

}
