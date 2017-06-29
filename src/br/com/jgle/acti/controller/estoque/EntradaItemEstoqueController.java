package br.com.jgle.acti.controller.estoque;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Intbox;

import br.com.jgle.acti.controller.AbstractController;
import br.com.jgle.acti.entity.Unidade;
import br.com.jgle.acti.entity.estoque.Almoxarifado;
import br.com.jgle.acti.entity.estoque.EstoqueItem;
import br.com.jgle.acti.entity.estoque.Grupo;
import br.com.jgle.acti.entity.estoque.Produto;

@Scope("page")
@Controller
public class EntradaItemEstoqueController extends AbstractController<EstoqueItem> {

	private static final long serialVersionUID = 1L;

	protected Doublebox valorUnitarioBox;
	protected Intbox qtdBox;
	protected Doublebox totalBox;
	protected Doublebox descontoBox;

	public EntradaItemEstoqueController() {
		super(new EstoqueItem());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EntradaItemEstoqueController(AbstractController parent) {
		super(new EstoqueItem(), parent);
	}

	public List<Unidade> getUnidades() {
		return parent.getGenericService().procurarTodos(Unidade.class);
	}

	public List<Grupo> getGrupos() {
		return parent.getGenericService().procurarTodos(Grupo.class);
	}

	public List<Almoxarifado> getAlmoxarifados() {
		return parent.getGenericService().procurarTodos(Almoxarifado.class);
	}

	public List<Produto> getProdutos() {
		return parent.getGenericService().procurarTodos(Produto.class);
	}

	// Calcular valor Total Bruto
	public void alterarValorTotalBruto() {
		selected.setValorTotalBruto(selected.calcularValorTotalBruto());
		selected.setValorTotal(selected.calcularValorTotal());
	}

	public void onChange$valorUnitarioBox() {
		alterarValorTotalBruto();
	}

	public void onChange$qtdBox() {
		alterarValorTotalBruto();
	}

	public void onChange$descontoBox() {
		alterarValorTotalBruto();
	}

	// Gett's and Sett's
	public Doublebox getValorUnitarioBox() {
		return valorUnitarioBox;
	}

	public Intbox getQtdBox() {
		return qtdBox;
	}

	public Doublebox getTotalBox() {
		return totalBox;
	}

	public void setValorUnitarioBox(Doublebox valorUnitarioBox) {
		this.valorUnitarioBox = valorUnitarioBox;
	}

	public void setQtdBox(Intbox qtdBox) {
		this.qtdBox = qtdBox;
	}

	public void setTotalBox(Doublebox totalBox) {
		this.totalBox = totalBox;
	}

	public Doublebox getDescontoBox() {
		return descontoBox;
	}

	public void setDescontoBox(Doublebox descontoBox) {
		this.descontoBox = descontoBox;
	}

}
