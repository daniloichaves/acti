package br.com.jgle.acti.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treecol;
import org.zkoss.zul.Treecols;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Treerow;

import br.com.jgle.acti.entity.AcessoMenu;
import br.com.jgle.acti.entity.Funcionario;
import br.com.jgle.acti.entity.Login;
import br.com.jgle.acti.entity.Unidade;
import br.com.jgle.acti.service.AcessoMenuService;
import br.com.jgle.acti.service.GenericService;

@SuppressWarnings("serial")
@Scope("page")
@Controller
public class AcessoMenuController extends GenericForwardComposer {

	@Resource
	protected GenericService genericService;

	@Resource
	protected AcessoMenuService acessoMenuService;

	protected Login login;

	protected Unidade unidade;

	protected Combobox loginBox;

	protected Component menuInclude;

	protected Tree menuTree;

	protected Button acessoMenuSaveButton;

	protected Button selecionarTodosButton;
	protected Button removerTodosButton;

	protected DataBinder binder;

	@SuppressWarnings("unchecked")
	public void onCreate$menuInclude(Event event) {
		System.out.println("Create$menuInclude");
		Tree tree = (Tree) menuInclude.getFellow("menuTree", true);

		tree.setMultiple(true);
		tree.setCheckmark(true);

		Treecols treecols = tree.getTreecols();
		Treecol treecol = (Treecol) treecols.getChildren().get(1);
		treecol.setWidth("80%");

		List<Treeitem> treeitems = tree.getTreechildren().getChildren();
		tratarTreeitem(treeitems);
	}

	public void onClick$acessoMenuSaveButton() throws InterruptedException {
		if (login == null) {
			Messagebox.show("Login precisa ser selecionado");
			return;
		}
		Set<AcessoMenu> checksAcessoMenus = getCheckAcessoMenu();
		login.setAcessoMenus(checksAcessoMenus);

		genericService.atualizar(login);
	}

	public void onClick$selecionarTodosButton() throws InterruptedException {
		if (login == null) {
			Messagebox.show("Login precisa ser selecionado");
			return;
		}

		List<AcessoMenu> checksAcessoMenus = genericService
				.procurarTodos(AcessoMenu.class);
		login.setAcessoMenus(new HashSet<AcessoMenu>(checksAcessoMenus));

		onSelect$loginBox();
	}

	@SuppressWarnings("unchecked")
	public void onClick$removerTodosButton() throws InterruptedException {
		if (login == null) {
			Messagebox.show("Login precisa ser selecionado");
			return;
		}

		login.setAcessoMenus(Collections.EMPTY_SET);

		onSelect$loginBox();
	}

	public void onCreate$loginBox() throws InterruptedException {
		onSelect$loginBox();
	}

	public void onSelect$loginBox() throws InterruptedException {
		if (login == null) {
			Messagebox.show("Login precisa ser selecionado");
			return;
		}
		Set<AcessoMenu> acessoMenus = login.getAcessoMenus();

		setCheckAcessoMenu(acessoMenus);
	}

	@SuppressWarnings("unchecked")
	public void setCheckAcessoMenu(Set<AcessoMenu> acessoMenus) {

		Tree tree = (Tree) menuInclude.getFellow("menuTree", true);
		List<Treeitem> treeitems = tree.getTreechildren().getChildren();

		setAcessoMenuTreeitem(treeitems, acessoMenus);

		binder.loadAll();
	}

	@SuppressWarnings("unchecked")
	public Set<AcessoMenu> getCheckAcessoMenu() {

		Tree tree = (Tree) menuInclude.getChildren().get(0);
		Set<Treeitem> selectedItems = tree.getSelectedItems();

		Set<AcessoMenu> acessoMenus = getAcessoMenuTreeitem(selectedItems);

		return acessoMenus;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setAcessoMenuTreeitem(List<Treeitem> treeitems,
			Set<AcessoMenu> acessoMenus) {

		for (Treeitem treeitem : treeitems) {
			System.out.println(treeitem.getLabel());
			List children = treeitem.getChildren();

			for (Object object : children) {

				if (object instanceof Treechildren) {
					Treechildren treechildren = (Treechildren) object;
					List<Treeitem> treeitems2 = treechildren.getChildren();

					setAcessoMenuTreeitem(treeitems2, acessoMenus);

				} else if (object instanceof Treerow) {

					Treerow treerow = (Treerow) object;
					Treecell treecell = (Treecell) treerow.getChildren().get(0);
					String titulo = treecell.getLabel();
					String idMenu = treecell.getId();

					System.out.println("treerow: " + idMenu + "Title: "
							+ titulo);

					Treeitem treeitemparent = (Treeitem) treerow.getParent();

					if (acessoMenus == null || acessoMenus.size() == 0) {
						treeitemparent.setSelected(false);
						break;
					}

					for (AcessoMenu acessoMenu : acessoMenus) {
						if (acessoMenu.getIdMenu().equalsIgnoreCase(idMenu)) {
							treeitemparent.setSelected(true);
							break;
						} else {
							treeitemparent.setSelected(false);
						}
					}
				}
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Set<AcessoMenu> getAcessoMenuTreeitem(Collection<Treeitem> treeitems) {
		Set<AcessoMenu> acessoMenus = new HashSet<AcessoMenu>();

		for (Treeitem treeitem : treeitems) {
			System.out.println(treeitem.getLabel());
			List children = treeitem.getChildren();

			for (Object object : children) {

				if (object instanceof Treechildren) {
					Treechildren treechildren = (Treechildren) object;
					List<Treeitem> treeitems2 = treechildren.getChildren();

					acessoMenus.addAll(getAcessoMenuTreeitem(treeitems2));

				} else if (object instanceof Treerow) {

					Treerow treerow = (Treerow) object;
					Treecell treecell = (Treecell) treerow.getChildren().get(0);
					String titulo = treecell.getLabel();
					String idMenu = treecell.getId();

					System.out.println("treerow: " + idMenu + "Title: "
							+ titulo);

					AcessoMenu acessoMenu = acessoMenuService
							.getAcessoMenu(idMenu);
					if (acessoMenu != null)
						acessoMenus.add(acessoMenu);
				}
			}
		}

		return acessoMenus;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void tratarTreeitem(List<Treeitem> treeitems) {
		for (Treeitem treeitem : treeitems) {
			System.out.println(treeitem.getLabel());
			List children = treeitem.getChildren();

			for (Object object : children) {
				if (object instanceof Treechildren) {
					Treechildren treechildren = (Treechildren) object;
					List<Treeitem> treeitems2 = treechildren.getChildren();
					tratarTreeitem(treeitems2);

				} else if (object instanceof Treerow) {

					Treerow treerow = (Treerow) object;
					Treecell treecell = (Treecell) treerow.getChildren().get(0);
					String idMenu = treecell.getId();

					// Caso não exita inseri na base
					if (!"".equals(idMenu)
							&& !acessoMenuService.existeAcessoMenu(idMenu)) {
						String titulo = treecell.getLabel();
						AcessoMenu acessoMenu = new AcessoMenu();
						acessoMenu.setIdMenu(idMenu);
						acessoMenu.setTitulo(titulo);
						genericService.atualizar(acessoMenu);
					}
				}
			}

		}
	}

	public List<Funcionario> getFuncionarios() {
		return genericService.procurarTodos(Funcionario.class);
	}

	public List<Login> getLogins() {
		return genericService.procurarTodos(Login.class);
	}

	public List<Unidade> getUnidades() {
		return genericService.procurarTodos(Unidade.class);
	}

	public GenericService getGenericService() {
		return genericService;
	}

	public void setGenericService(GenericService genericService) {
		this.genericService = genericService;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Tree getMenuTree() {
		return menuTree;
	}

	public void setMenuTree(Tree menuTree) {
		this.menuTree = menuTree;
	}

	public Component getMenuInclude() {
		return menuInclude;
	}

	public void setMenuInclude(Component menuInclude) {
		this.menuInclude = menuInclude;
	}

	public Button getAcessoMenuSaveButton() {
		return acessoMenuSaveButton;
	}

	public void setAcessoMenuSaveButton(Button acessoMenuSaveButton) {
		this.acessoMenuSaveButton = acessoMenuSaveButton;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public AcessoMenuService getAcessoMenuService() {
		return acessoMenuService;
	}

	public void setAcessoMenuService(AcessoMenuService acessoMenuService) {
		this.acessoMenuService = acessoMenuService;
	}

	public Combobox getLoginBox() {
		return loginBox;
	}

	public void setLoginBox(Combobox loginBox) {
		this.loginBox = loginBox;
	}

	public Button getSelecionarTodosButton() {
		return selecionarTodosButton;
	}

	public void setSelecionarTodosButton(Button selecionarTodosButton) {
		this.selecionarTodosButton = selecionarTodosButton;
	}

	public Button getRemoverTodosButton() {
		return removerTodosButton;
	}

	public void setRemoverTodosButton(Button removerTodosButton) {
		this.removerTodosButton = removerTodosButton;
	}

	public DataBinder getBinder() {
		return binder;
	}

	public void setBinder(DataBinder binder) {
		this.binder = binder;
	}
}
