package br.com.jgle.acti.controller.estoque;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.controller.AbstractController;
import br.com.jgle.acti.entity.Fornecedor;
import br.com.jgle.acti.entity.Funcionario;
import br.com.jgle.acti.entity.Unidade;
import br.com.jgle.acti.entity.estoque.Almoxarifado;
import br.com.jgle.acti.entity.estoque.EntradaEstoque;
import br.com.jgle.acti.entity.estoque.Grupo;

@Scope("page")
@Controller
public class EntradaEstoqueController extends AbstractController<EntradaEstoque> {

	private static final long serialVersionUID = 1L;
	protected EntradaItemEstoqueController entradaItemEstoqueController;

	public EntradaEstoqueController() {
		super(new EntradaEstoque());

		entradaItemEstoqueController = new EntradaItemEstoqueController(this);

		entradaItemEstoqueController.setGenericService(getGenericService());
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

	public EntradaItemEstoqueController getEntradaItemEstoqueController() {
		return entradaItemEstoqueController;
	}

	public void setEntradaItemEstoqueController(EntradaItemEstoqueController entradaItemEstoqueController) {
		this.entradaItemEstoqueController = entradaItemEstoqueController;
	}

}
