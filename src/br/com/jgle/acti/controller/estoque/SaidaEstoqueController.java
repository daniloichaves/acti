package br.com.jgle.acti.controller.estoque;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.controller.AbstractController;
import br.com.jgle.acti.entity.Fornecedor;
import br.com.jgle.acti.entity.Funcionario;
import br.com.jgle.acti.entity.Unidade;
import br.com.jgle.acti.entity.estoque.Almoxarifado;
import br.com.jgle.acti.entity.estoque.Grupo;
import br.com.jgle.acti.entity.estoque.SaidaEstoque;

@Scope("page")
@Controller
public class SaidaEstoqueController extends AbstractController<SaidaEstoque> {

	private static final long serialVersionUID = 1L;
	protected SaidaItemEstoqueController saidaItemEstoqueController;

	public SaidaEstoqueController() {
		super(new SaidaEstoque());

		saidaItemEstoqueController = new SaidaItemEstoqueController(this);

		saidaItemEstoqueController.setGenericService(getGenericService());
	}

	public List<Unidade> getUnidades() {
		return genericService.procurarTodos(Unidade.class);
	}

	public List<Funcionario> getFuncionarios() {
		return genericService.procurarTodos(Funcionario.class);
	}

	public List<Fornecedor> getFornecedores() {
		return genericService.procurarTodos(Fornecedor.class);
	}

	public List<Grupo> getGrupos() {
		return genericService.procurarTodos(Grupo.class);
	}

	public List<Almoxarifado> getAlmoxarifados() {
		return genericService.procurarTodos(Almoxarifado.class);
	}

	public SaidaItemEstoqueController getEntradaItemEstoqueController() {
		return saidaItemEstoqueController;
	}

	public void setEntradaItemEstoqueController(SaidaItemEstoqueController entradaItemEstoqueController) {
		this.saidaItemEstoqueController = entradaItemEstoqueController;
	}

	public SaidaItemEstoqueController getSaidaItemEstoqueController() {
		return saidaItemEstoqueController;
	}

	public void setSaidaItemEstoqueController(SaidaItemEstoqueController saidaItemEstoqueController) {
		this.saidaItemEstoqueController = saidaItemEstoqueController;
	}
}
