package br.com.jgle.acti.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.spring.context.annotation.AppliedTo;

import br.com.jgle.acti.entity.Fornecedor;
import br.com.jgle.acti.entity.estoque.Pneu;

@Scope("page")
@Controller
@AppliedTo("entityWin")
public class PneuController extends AbstractController<Pneu> {

	public PneuController() {
		super(new Pneu());
	}

	private static final long serialVersionUID = 1L;

	public List<Fornecedor> getFornecedores() {
		return genericService.procurarTodos(Fornecedor.class);
	}

}
