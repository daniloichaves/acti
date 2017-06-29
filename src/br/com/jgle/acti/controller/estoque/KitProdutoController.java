package br.com.jgle.acti.controller.estoque;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Image;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import br.com.jgle.acti.controller.AbstractController;
import br.com.jgle.acti.entity.Unidade;
import br.com.jgle.acti.entity.estoque.Almoxarifado;
import br.com.jgle.acti.entity.estoque.Grupo;
import br.com.jgle.acti.entity.estoque.KitProduto;
import br.com.jgle.acti.entity.estoque.Produto;

@Scope("page")
@Controller
public class KitProdutoController extends AbstractController<KitProduto> {

	private static final long serialVersionUID = 1L;

	private List<Produto> produtosSelecionados;
	private Listbox left;
	private Listbox right;
	private Image addProject;
	private Image removeProject;

	public KitProdutoController() {
		super(new KitProduto());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$addProject(Event event) {
		Set items = left.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser adicionado!");
		} else {
			List al = new ArrayList(items);
			List<Produto> produtos = new ArrayList(getProdutos());
			List<Produto> produtosRemover = new ArrayList<Produto>();

			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				right.appendChild(li);

				Produto produto = produtos.get(i);
				selected.getProdutos().add(produto);
				produtosRemover.add(produto);
			}
			produtos.remove(produtosRemover);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$removeProject(Event event) {
		Set items = right.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser removido!");
		} else {
			List al = new ArrayList(items);
			List<Produto> kitProdutos = new ArrayList<Produto>(selected.getProdutos());
			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				left.appendChild(li);

				Produto produto = kitProdutos.get(i);
				getProdutos().add(produto);
				selected.getProdutos().remove(produto);
			}
			for (int i = 0; i < al.size(); i++) {
				Produto produto = kitProdutos.get(i);
				selected.getProdutos().remove(produto);

			}
		}
	}

	public List<Unidade> getUnidades() {
		return genericService.procurarTodos(Unidade.class);
	}

	public List<Grupo> getGrupos() {
		return genericService.procurarTodos(Grupo.class);
	}

	public List<Almoxarifado> getAlmoxarifados() {
		return genericService.procurarTodos(Almoxarifado.class);
	}

	public List<Produto> getProdutos() {
		List<Produto> procurarTodos = genericService.procurarTodos(Produto.class);
		procurarTodos.removeAll(selected.getProdutos());

		return procurarTodos;
	}

	public List<Produto> getProdutosSelecionados() {
		return produtosSelecionados;
	}

	public void setProdutosSelecionados(List<Produto> produtosSelecionados) {
		this.produtosSelecionados = produtosSelecionados;
	}

	public Image getRemoveProject() {
		return removeProject;
	}

	public void setRemoveProject(Image removeProject) {
		this.removeProject = removeProject;
	}

	public Image getAddProject() {
		return addProject;
	}

	public void setAddProject(Image addProject) {
		this.addProject = addProject;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Listbox getLeft() {
		return left;
	}

	public void setLeft(Listbox left) {
		this.left = left;
	}

	public Listbox getRight() {
		return right;
	}

	public void setRight(Listbox right) {
		this.right = right;
	}
}
