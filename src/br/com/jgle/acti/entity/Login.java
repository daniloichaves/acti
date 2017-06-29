package br.com.jgle.acti.entity;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Login extends AbstractEntity {

	@Column(length = 25)
	private String login;

	@Column(length = 20)
	private String senha;

	@Column(length = 50)
	private String nome;

	@Column(length = 30)
	private String email;

	@ManyToOne(fetch = FetchType.EAGER)
	private Unidade unidade;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	protected Set<AcessoMenu> acessoMenus = new HashSet<AcessoMenu>();

	@SuppressWarnings("unchecked")
	public Login newInstance() {
		return new Login();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("login", textToSearch(textSearch));
		params.put("nome", textToSearch(textSearch));
		params.put("email", textToSearch(textSearch));

		return params;
	}

	public Map<String, String> getParametrosAdvancedSearch() {
		Map<String, String> params = (Map<String, String>) super
				.getParametrosAdvancedSearch();

		params.put("login", "Login");
		params.put("nome", "Nome");
		params.put("email", "Email");

		return params;
	}

	public boolean hasAcesso(String idMenu) {
		for (AcessoMenu acessoMenu : acessoMenus) {
			if (acessoMenu.getIdMenu().equalsIgnoreCase(idMenu))
				return true;

		}
		return false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Login() {
		super();
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Set<AcessoMenu> getAcessoMenus() {
		return acessoMenus;
	}

	public void setAcessoMenus(Set<AcessoMenu> acessoMenus) {
		this.acessoMenus = acessoMenus;
	}

}
