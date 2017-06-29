package br.com.jgle.acti.entity;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class LoginMenu extends AbstractEntity {

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Login login;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private AcessoMenu acessoMenu;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Unidade unidade;

	@SuppressWarnings("unchecked")
	public LoginMenu newInstance() {
		return new LoginMenu();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("login", textToSearch(textSearch));
		params.put("nome", textToSearch(textSearch));

		return params;
	}

	public AcessoMenu getAcessoMenu() {
		return acessoMenu;
	}

	public void setAcessoMenu(AcessoMenu acessoMenu) {
		this.acessoMenu = acessoMenu;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
}
